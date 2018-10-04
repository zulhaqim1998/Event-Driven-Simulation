package application;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Job {
	int number;
	int arrivalTime;
	int processingTime;
	int jobSize;
	
	public Job() {
		
	}
	
	public Job(int num, int arrival, int processing, int size) {
		number = num;
		arrivalTime = arrival;
		processingTime = processing;
		jobSize = size;
		
		System.out.println("Job " + num + " saved.");
	}
	
	public StackPane draw() {
		StackPane s = new StackPane();
		Rectangle rect = new Rectangle();
		Text t = new Text();
		t.setText("Job-" + number + "\n" + jobSize);
		
		rect.setWidth(jobSize * 0.04);
		rect.setHeight(80);
		rect.setFill(Color.BISQUE);
		rect.setStyle("-fx-stroke-width: 0.5; -fx-stroke: black;");
		
		s.getChildren().addAll(rect, t);
		return s;
	}
}
