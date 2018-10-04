package application;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Memory {
	int number;
	int size;
	boolean available = false;
	
	public Memory() {
		
	}
	
	public Memory(int n, int s) {
		number = n;
		size = s;
		available = true;		
	}
	
	public void processJob(Job job) {
		available = false;
	}
	
	public void jobFinish() {
		available = true;
	}
	
	public StackPane draw() {
		StackPane s = new StackPane();
		Rectangle rect = new Rectangle();
		Text t = new Text();
		t.setText("" + size + "\n" + (available ? "Free" : "Busy"));
		
		rect.setWidth(size * 0.04);
		rect.setHeight(80);
		rect.setFill(Color.WHITESMOKE);
		rect.setStyle("-fx-stroke-width: 0.5; -fx-stroke: black;");
		
		s.getChildren().addAll(rect, t);
		return s;
	}
	
	public void setNum(int v) {
		this.number = v;
	}

}
