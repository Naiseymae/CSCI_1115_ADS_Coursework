
// ADS Exercise 31-1: Loan Server
// Client.java: The client sends the input to the server and receives
// result back from the server

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.beans.*;
import java.io.*;
import java.net.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.lang.Double;
import java.text.*;

public class Exercise31_1_Client extends Application {

	// Text field for receiving radius.
	private TextField tfAnnualInterestRate = new TextField();
	private TextField tfNumOfYears = new TextField();
	private TextField tfLoanAmount = new TextField();
	private Button btSubmit= new Button("Submit");

	// Text area to display contents.
	private TextArea ta = new TextArea();

	// Host name or ip.
	String host = "localhost";

	@Override // Override the start method in the Application class.
	public void start(Stage primaryStage) {
		ta.setWrapText(true);

		GridPane gridPane = new GridPane();
		gridPane.add(new Label("Annual Interest Rate"), 0, 0);
		gridPane.add(new Label("Number Of Years"), 0, 1);
		gridPane.add(new Label("Loan Amount"), 0, 2);
		gridPane.add(tfAnnualInterestRate, 1, 0);
		gridPane.add(tfNumOfYears, 1, 1);
		gridPane.add(tfLoanAmount, 1, 2);
		gridPane.add(btSubmit, 2, 1);

		tfAnnualInterestRate.setAlignment(Pos.BASELINE_RIGHT);
		tfNumOfYears.setAlignment(Pos.BASELINE_RIGHT);
		tfLoanAmount.setAlignment(Pos.BASELINE_RIGHT);

		tfLoanAmount.setPrefColumnCount(5);
		tfNumOfYears.setPrefColumnCount(5);
		tfLoanAmount.setPrefColumnCount(5);

		BorderPane pane = new BorderPane();
		pane.setCenter(new ScrollPane(ta));
		pane.setTop(gridPane);

		// Listener for submit button
		btSubmit.setOnAction(new ButtonListener());

		// Create a scene and place it in the stage.
		Scene scene = new Scene(pane, 400, 250);
		primaryStage.setTitle("Exercise31_1_Client"); // Set the stage title.
		primaryStage.setScene(scene); // Place the scene in the stage.
		primaryStage.show(); // Display the stage.
	}

	/** Handle button action */
	private class ButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {

			try {
				// Establish connection with the server.
				Socket socket = new Socket(host, 8000);

				// Create an output stream to the server.
				ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());

				// Get text fields.
				double annualInterestRate = Double.parseDouble(tfAnnualInterestRate.getText());
				int numberOfYears = Integer.parseInt(tfNumOfYears.getText());
				double loanAmount = Double.parseDouble(tfLoanAmount.getText());

				// Create a loan object and send to the server.
				Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
				toServer.writeObject(loan);

				// Display loan info in text area.
				double monthlyPayment = loan.getMonthlyPayment();
				double totalPayment = loan.getTotalPayment();
				DecimalFormat df = new DecimalFormat("########0.00"); // DecimalFormat to 2 decimal places.
				ta.setText("Annual Interest Rate: " + df.format(loan.getAnnualInterestRate()) +
						"\nNumber of Years: " + loan.getNumberOfYears() +
						"\nLoan Amount: $" + df.format(loan.getLoanAmount()) +
						"\nMonthly Payment: $" + df.format(monthlyPayment) + 
						"\nTotal Payment: $" + df.format(totalPayment));

			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
