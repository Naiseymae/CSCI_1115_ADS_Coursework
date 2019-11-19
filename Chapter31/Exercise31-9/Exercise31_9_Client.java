
/* Author: Renee Linford
 * Date: 11-19-19
 * ADS Exercise 31-9: Chat - Server & Client
 * "Client"
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import java.net.*;
import java.io.*;
import java.util.*;

public class Exercise31_9_Client extends Application {

	// Declare textareas and input/output streams.
	private TextArea taChat = new TextArea();
	private TextArea taClient = new TextArea();
	DataInputStream inputFromServer = null;
	DataOutputStream outputToServer = null;

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {

		// Host name or ip.
		String host = "localhost";

		// Text areas to display chat
		taChat.setWrapText(true);
		taClient.setWrapText(true);
		taChat.setEditable(false);

		BorderPane pane1 = new BorderPane();
		pane1.setTop(new Label("History"));
		pane1.setCenter(new ScrollPane(taChat));
		BorderPane pane2 = new BorderPane();
		pane2.setTop(new Label("New Message"));
		pane2.setCenter(new ScrollPane(taClient));

		VBox vBox = new VBox(5);
		vBox.getChildren().addAll(pane1, pane2);

		// Create a scene and place it in the stage
		Scene scene = new Scene(vBox, 500, 400);
		primaryStage.setTitle("Exercise31_9_Client"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		// New Thread will recieve messages.
		try {
			// Establish connection with the server.
			Socket socket = new Socket(host, 8000);

			// Initialize data input and output streams.
			inputFromServer = new DataInputStream(socket.getInputStream());
			outputToServer = new DataOutputStream(socket.getOutputStream());

			new Thread (() -> {
				try {
					// Note when chat starts.
					taChat.appendText("Chat started at " + new Date() + '\n');

					while (true) {
						// Read input from Server.
						String inputText = (String) inputFromServer.readUTF();

						// Add text to History pane.
						taChat.appendText(inputText);
					}
				}
				catch(IOException ex) { // Catch IO exception.
					ex.printStackTrace();
				}
			}).start(); // End of thread.
		}
		catch(IOException ex) { // Catch IO exception.
			ex.printStackTrace();
		}

		// Listener for ENTER key.  Will send messages onKeyPressed.
		taClient.setOnKeyPressed( e -> {
			try {
				if (e.getCode() == KeyCode.ENTER) {

					// Write string to file.
					outputToServer.writeUTF("Client: " + taClient.getText().trim() + '\n');
					taChat.appendText("Client: " + taClient.getText().trim() + '\n');

					// Clear text from server pane.
					taClient.clear();
					taClient.requestFocus();
				}
			}
			catch(IOException ex) { // Catch IO exception.
				ex.printStackTrace();
			}
		});
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
