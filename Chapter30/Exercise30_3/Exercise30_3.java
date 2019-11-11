package exercise_30_3;

/* Author: Renee Linford
 * Date: 11-11-19
 * ADS Exercise 30-3: Raise flags using thread
 */

import javafx.animation.PathTransition; 
import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;

public class Exercise30_3 extends Application {
	// Rewrite Listing 15.13 using a thread to animate a flag being raised.
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {

		// Create a pane
		Pane pane = new Pane();

		// Add new imageView.
		ImageView imageView = new ImageView("exercise_30_3/image/us.gif");		

		// New runnable thread with RaiseImage class.
		new Thread(new Runnable() {

			@Override // Override the run() method for new thread
			public void run() {

				try {
					// Create a path transition
					PathTransition pt = new PathTransition(Duration.millis(10000),
							new Line(100, 200, 100, 0), imageView); 
					pt.setCycleCount(5);
					pt.play(); // Start animation

					Thread.sleep(200);
				}
				catch (InterruptedException ex) {
				}
			}
		}).start();

		// Add new thread to pane.
		pane.getChildren().add(imageView);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 200); 
		primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

