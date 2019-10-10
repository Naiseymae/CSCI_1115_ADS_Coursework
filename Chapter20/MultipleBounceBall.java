
/* Author: Renee Linford
* Date: 10-10-19
* ADS Exercise 20-9: Remove the largest ball first.
*  MultipleBounceBall class
*/

import javafx.animation.*;
import javafx.application.*;
import javafx.beans.property.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.util.*;
import java.util.*;


public class MultipleBounceBall extends Application {
	@Override // Override the start method in the Application class

	public void start(Stage primaryStage) {

		MultipleBallPane ballPane = new MultipleBallPane();
		ballPane.setStyle("-fx-border-color: yellow");
		Button btAdd = new Button("+");
		Button btSubtract = new Button("-");
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(btAdd, btSubtract);
		hBox.setAlignment(Pos.CENTER);

		// Add or remove a ball
		btAdd.setOnAction(e -> ballPane.add());
		btSubtract.setOnAction(e -> ballPane.subtract());

		// Pause and resume animation
		ballPane.setOnMousePressed(e -> ballPane.pause());
		ballPane.setOnMouseReleased(e -> ballPane.play());

		// Use a scroll bar to control animation speed
		ScrollBar sbSpeed = new ScrollBar();
		sbSpeed.setMax(20);
		sbSpeed.setValue(10);
		ballPane.rateProperty().bind(sbSpeed.valueProperty());
		BorderPane pane = new BorderPane();
		pane.setCenter(ballPane);
		pane.setTop(sbSpeed);
		pane.setBottom(hBox);

		// Create a scene and place the pane in the stage
		Scene scene = new Scene(pane, 750, 550);
		primaryStage.setTitle("MultipleBounceBall"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private class MultipleBallPane extends Pane {

		private Timeline animation;
		
		public MultipleBallPane() {
			// Create an animation for moving the ball
			animation = new Timeline(
					new KeyFrame(Duration.millis(50), e -> moveBall()));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play(); // Start animation
		}

		public void add() {
			// Apply random color to new ball.
			Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
			// Apply random int to radius property to get random ball size.
			Ball newBall = new Ball(40, 40, (int)(Math.random() * 38) + 1, color);
			getChildren().add(newBall);
			//ballList.add(newBall); 		
		}

		public void subtract() {
			if (getChildren().size() > 0) { // Subtract a ball if a ball is present.
				Ball ball = (Ball)(getChildren().get(0)); // Start with first ball.

				// For each ball node in pane, compare radii.
				for (Node node: getChildren()) {
					if (((Ball)node).getRadius() > ball.getRadius()) {
						ball = (Ball)node; // Larger object will be assigned to "ball"
					}
				}
				getChildren().remove(ball); // Remove largest ball object.
			}
		}

		public void play() {
			animation.play();
		}

		public void pause() {
			animation.pause();
		}	

		public void increaseSpeed() {
			animation.setRate(animation.getRate() + 0.1);
		}

		public void decreaseSpeed() {
			animation.setRate(
					animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
		}

		public DoubleProperty rateProperty() {
			return animation.rateProperty();
		}

		protected void moveBall() {

			for (Node node: this.getChildren()) {
				Ball ball = (Ball)node;

				// Check boundaries
				if (ball.getCenterX() < ball.getRadius() ||
						ball.getCenterX() > getWidth() - ball.getRadius()) {
					ball.dx *= -1; // Change ball move direction
				}
				if (ball.getCenterY() < ball.getRadius() ||
						ball.getCenterY() > getHeight() - ball.getRadius()) {
					ball.dy *= -1; // Change ball move direction
				}
				// Adjust ball position
				ball.setCenterX(ball.dx + ball.getCenterX());
				ball.setCenterY(ball.dy + ball.getCenterY());
			}
		}
	}

	class Ball extends Circle {

		private double dx = 1, dy = 1;
		Ball(double x, double y, double radius, Color color) {
			super(x, y, radius);
			setFill(color); // Set ball color
		}

	}

	/**
	 *  The main method is only needed for the IDE with limited
	 *  JavaFX support. Not needed for running from the command line.
	 */

	public static void main(String[] args) {
		launch(args);
	}
}

