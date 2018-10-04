package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	Queue<Job> jobQueue = new LinkedList<Job>();
	ArrayList<Memory> memoryArray = new ArrayList<Memory>();
	ArrayList<Job> jobArray = new ArrayList<Job>();
	
	public Main() {
		this.jobQueue = readJobTextFile("C:\\Users\\Zulfikri\\Desktop\\data.txt");
		this.memoryArray = readMemoryTextFile("C:\\Users\\Zulfikri\\Desktop\\memory.txt");
		this.jobArray = new ArrayList<Job>(this.jobQueue);
	}

	
	
	@Override
	public void start(Stage primaryStage) {
//		Queue<Job> jobQueue = new LinkedList<>();
//		ArrayList<Memory> memoryArray = new ArrayList<Memory>();
//		memoryArray = readMemoryTextFile("C:\\Users\\Zulfikri\\Desktop\\memory.txt");
//		jobQueue = readJobTextFile("C:\\Users\\Zulfikri\\Desktop\\data.txt");
//		ArrayList<Job> jobArray = new ArrayList<Job>(jobQueue);
		// JAVAFX GUI
		try {
			Group root = new Group();
			FlowPane flowpane = new FlowPane();
			VBox jobListBox = new VBox();
			Scene scene = new Scene(root,1300,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Job j = new Job();
			j = jobQueue.poll();
						
//			Button button = new Button();
//			button.setText("Click Me!!");
//			button.setOnAction(new EventHandler<ActionEvent>() {
//				
//				@Override
//				public void handle(ActionEvent event) {
//					System.out.println("Helllo world!!");
//				}
//			});
			
			// DRAW MEMORY BLOCKS
		    flowpane.setHgap(5); 
		    flowpane.setVgap(3);
		    flowpane.setMinWidth(900);
//		    flowpane.setMaxWidth(1000);
			flowpane.setLayoutX(400);
			flowpane.setLayoutY(150);

			jobListBox.setLayoutX(50);
			jobListBox.setLayoutY(80);
			jobListBox.setVisible(true);
			jobListBox.setSpacing(10);
			
			this.memoryArray.forEach(memory -> flowpane.getChildren().add(memory.draw()));
			this.jobArray.forEach(job -> jobListBox.getChildren().add(job.draw()));
			
			Button button = new Button();
			button.setText("Click Me!!");
			button.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
  					memoryArray.get(0).setNum(1234);
  					root = drawScene();
				}
			});
						
			//cccc
			root.getChildren().addAll(flowpane, jobListBox, button);
			
			
			primaryStage.setTitle("Helloooooo!!");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Group drawScene() {
		Group root = new Group();
		// JAVAFX GUI
		try {
			
			FlowPane flowpane = new FlowPane();
			VBox jobListBox = new VBox();
			Scene scene = new Scene(root,1300,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
		    flowpane.setHgap(5); 
		    flowpane.setVgap(3);
		    flowpane.setMinWidth(900);
			flowpane.setLayoutX(400);
			flowpane.setLayoutY(150);
	
			jobListBox.setLayoutX(50);
			jobListBox.setLayoutY(80);
			jobListBox.setVisible(true);
			jobListBox.setSpacing(10);
			
			this.memoryArray.forEach(memory -> flowpane.getChildren().add(memory.draw()));
			this.jobArray.forEach(job -> jobListBox.getChildren().add(job.draw()));
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return root;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public static Queue<Job> readJobTextFile(String filePath) {
		Queue<Job> jobQueue = new LinkedList<>();
		
		try {
			File file = new File(filePath);
			BufferedReader reader = null;

			reader = new BufferedReader(new FileReader(file));
			String text = null;
			
			text = reader.readLine();
			int total = Integer.parseInt(text);
			for(int i = 1; i <= total; i++) {
				text = reader.readLine();
				String[] nums = text.split(" ");
				Job job = new Job(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2]), Integer.parseInt(nums[3]));
				jobQueue.add(job);
			}
			
			reader.close();
		} catch(Exception e) {
			System.out.println("Job text file not found.");
		}
		return jobQueue;
	}
	
	public static ArrayList<Memory> readMemoryTextFile(String filePath) {
		ArrayList<Memory> memoryArray = new ArrayList<Memory>();
		try {
			File file = new File(filePath);
			BufferedReader reader = null;
	
			reader = new BufferedReader(new FileReader(file));
			String text = null;
			
			text = reader.readLine();
			int total = Integer.parseInt(text);
			for(int i = 1; i <= total; i++) {
				text = reader.readLine();
				Memory m = new Memory(i, Integer.parseInt(text));
				memoryArray.add(m);
			}
			
			reader.close();
		} catch(Exception e) {
			System.out.println("Memory file not found");
		}
		System.out.println(memoryArray.size() + " memory loaded.");
		return memoryArray;
	}
}
