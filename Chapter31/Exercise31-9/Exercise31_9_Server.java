//package exercise_31_9;

/* Author: Renee Linford
 * Date: 11-19-19
 * ADS Exercise 31-9: Chat - Server & Client
 * "Server"
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

public class Exercise31_9_Server extends Application {

	// Declare textareas and input/output streams.
	private TextArea taChat = new TextArea();
	private TextArea taServer = new TextArea();
	DataInputStream inputFromClient;
	DataOutputStream outputToClient;

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		taChat.setWrapText(true);
		taServer.setWrapText(true);
		taChat.setEditable(false);

		// Create chat panes.
		BorderPane pane1 = new BorderPane();
		pane1.setTop(new Label("History"));
		pane1.setCenter(new ScrollPane(taChat));
		BorderPane pane2 = new BorderPane();
		pane2.setTop(new Label("New Message"));
		pane2.setCenter(new ScrollPane(taServer));

		VBox vBox = new VBox(5);
		vBox.getChildren().addAll(pane1, pane2);

		// Create a scene and place it in the stage
		Scene scene = new Scene(vBox, 500, 400);
		primaryStage.setTitle("Exercise31_9_Server"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		// New Thread will recieve messages.
		new Thread (() -> { 
			try {
				// Create a server socket.
				ServerSocket serverSocket = new ServerSocket(8000);

				// Listen for a connection request.
				Socket socket = serverSocket.accept();
				Platform.runLater(() -> taChat.appendText("Chat started at " + new Date() + '\n'));

				// Initialize data input and output streams.
				inputFromClient = new DataInputStream(socket.getInputStream());
				outputToClient = new DataOutputStream(socket.getOutputStream());

				while (true) {
					// Read input from Server.
					String inputText = (String) inputFromClient.readUTF();

					// Add text to Chat pane.
					taChat.appendText(inputText);
				}
			}
			catch(IOException ex) { // Catch IO exception.
				ex.printStackTrace();
			}
		}).start(); // End of thread.

		// Listener for ENTER key.  Will send messages onKeyPressed.
		taServer.setOnKeyPressed( e -> {
			try {
				if (e.getCode() == KeyCode.ENTER) {

					// Write string to file.
					taChat.appendText("Server: " + taServer.getText().trim() + '\n');
					outputToClient.writeUTF("Server: " + taServer.getText().trim() + '\n');

					// Clear text from server pane.
					taServer.clear();
					taServer.requestFocus();
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
