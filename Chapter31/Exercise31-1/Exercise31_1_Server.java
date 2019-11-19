package exercise_31_1;

/* Author: Renee Linford
 * Date: 11-12-19
 * ADS Exercise 31-1: Loan Server
 */

import java.io.*;
import java.net.*;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Date;
import java.text.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

public class Exercise31_1_Server extends Application {
	/* The server creates a Loan object to compute monthly payment and total payment, and sends those numbers back to the client.
	 * The server can communicate with multiple clients concurrently using the multiple threads.
	 */

	// Text area for displaying contents
	private TextArea ta = new TextArea();

	// Object output streams.
	private ObjectOutputStream outputToFile;
	private ObjectInputStream inputFromClient;

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		ta.setWrapText(true);

		// Create a scene and place it in the stage
		Scene scene = new Scene(new ScrollPane(ta), 400, 200);
		primaryStage.setTitle("Exercise31_1_Server"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		new Thread(() -> connectToClient()).start();
	}

	public void connectToClient() {
		try {
			// Create a server socket
			ServerSocket serverSocket = new ServerSocket(8000);
			Platform.runLater(() ->
			ta.appendText("Exercise31_1_Server started at " + new Date() + '\n'));

			// Create an object output stream.
			outputToFile = new ObjectOutputStream(new FileOutputStream("student.dat", true));

			while (true) {
				Socket socket = serverSocket.accept();

				// Create an input stream from the socket
				inputFromClient = new ObjectInputStream(socket.getInputStream());

				// Display the client number
				Platform.runLater( () -> {ta.appendText("\nConnected to a client " +
						" at " + new Date() + '\n');});

				// Read input and display from Client
				Loan loan = (Loan) inputFromClient.readObject();

				// Write to the file
				outputToFile.writeObject(loan);
				DecimalFormat df = new DecimalFormat("########0.00"); // DecimalFormat to 2 decimal places.
				ta.appendText("Annual Interest Rate: " + df.format(loan.getAnnualInterestRate()) +
						"\nNumber of Years: " + loan.getNumberOfYears() +
						"\nLoan Amount: $" + df.format(loan.getLoanAmount()) +
						"\nMonthly Payment: $" + df.format(loan.getMonthlyPayment()) + 
						"\nTotal Payment: $" + df.format(loan.getTotalPayment()));
			}
		}
		catch(IOException ex) {
			System.err.println(ex);
			//ex.printStackTrace();
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				inputFromClient.close();
				outputToFile.close();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}