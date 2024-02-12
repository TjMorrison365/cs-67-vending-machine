/* 
 * Name: TJ Morrison
 * Date: 11/27/2022
 * Description: Creates customer interaction window based on VendingMachine.java
 * Sources Cited: NA
 */

package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class VendingMachineGUI extends Application {
	
	//Initialize global variables for VendingMachineGUI class
	VendingMachine iVend = new VendingMachine(2,1,5);
	String keypadInput = "";
	String confirmedInput = "";
	String coinsInserted = "0";
	
	Label productCodeLabel = new Label("SNACK CODES || Snickers $1.00 : 0 | Twix $1.15 : 1 | Reeses $1.30 : 2");
	Label confirmedInputLabel = new Label ("Current Confirmed Selection: " + confirmedInput);
	Label keypadInputLabel = new Label("Try using the keypad!");
	Label coinBoxLabel = new Label("Type the amount of coins you would like to insert (No pennies!):");
	Label currentCoinsLabel = new Label("Coins Inserted: " + coinsInserted);

	TextField coinInput = new TextField();
	
	
	@Override
	public void start(Stage primaryStage) {
		
		
		//****
		// START - On Button Press Actions
		//****
		class ButtonCoinInsertHandler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) { // On button press
				try {
					iVend.insertCents(Integer.parseInt(coinInput.getText()));
					coinsInserted = Integer.toString(Integer.parseInt(coinsInserted) + Integer.parseInt(coinInput.getText()));
					currentCoinsLabel.setText("Coins Inserted: " + coinsInserted);
					coinBoxLabel.setText("Type the amount of coins you would like to insert (No pennies!):");
				}
				catch (ImproperCoinsException e) {
					coinBoxLabel.setText(e.getMessage() + " We can't accept Pennies!");
				}
			}
		}
		
		class ButtonCoinReturnHandler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				iVend.returnUnspentCents();
				coinsInserted = "0";
				currentCoinsLabel.setText("Coins Inserted: " + coinsInserted);
				coinBoxLabel.setText("Type the amount of coins you would like to insert (No pennies!):");
			}
		}
		
		class Button1Handler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				keypadInput = "1";
				keypadInputLabel.setText("Current Input: " + keypadInput);
			}
		}
		class Button2Handler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				keypadInput = "2";
				keypadInputLabel.setText("Current Input: " + keypadInput);
			}
		}
		class Button3Handler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				keypadInput = "3";
				keypadInputLabel.setText("Current Input: " + keypadInput);
			}
		}
		class Button4Handler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				keypadInput = "4";
				keypadInputLabel.setText("Current Input: " + keypadInput);
			}
		}
		class Button5Handler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				keypadInput = "5";
				keypadInputLabel.setText("Current Input: " + keypadInput);
			}
		}
		class Button6Handler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				keypadInput = "6";
				keypadInputLabel.setText("Current Input: " + keypadInput);
			}
		}
		class Button7Handler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				keypadInput = "7";
				keypadInputLabel.setText("Current Input: " + keypadInput);
			}
		}
		class Button8Handler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				keypadInput = "8";
				keypadInputLabel.setText("Current Input: " + keypadInput);
			}
		}
		class Button9Handler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				keypadInput = "9";
				keypadInputLabel.setText("Current Input: " + keypadInput);
			}
		}
		class ButtonClrHandler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				keypadInput = "";
				keypadInputLabel.setText("Current Input: " + keypadInput);
			}
		}
		class Button0Handler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				keypadInput = "0";
				keypadInputLabel.setText("Current Input: " + keypadInput);
			}
		}
		class ButtonOkHandler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				try {
					iVend.makeSelection(Integer.parseInt(keypadInput));
					confirmedInput = keypadInput;
					keypadInput = "";
					keypadInputLabel.setText("Current Input: " + keypadInput);
					confirmedInputLabel.setText("Current Confirmed Selection: " + confirmedInput);
				}
				catch (ImproperSelectionException e) {
					keypadInputLabel.setText(e.getMessage() + " Try looking at the snack codes again!");
				}
			}
		}
		class ButtonPurchaseHandler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				try {
					coinsInserted = Integer.toString(iVend.purchaseSelection());
					keypadInputLabel.setText("You just bought a snack from selection " + confirmedInput + ", and got " + coinsInserted + " cents back!");
					confirmedInputLabel.setText("Current Confirmed Selection: " + confirmedInput);
					keypadInput = "";
					confirmedInput = "";
					coinsInserted = "0";
					currentCoinsLabel.setText("Coins Inserted: " + coinsInserted);
				}
				catch (ImproperPurchaseException e) {
					keypadInputLabel.setText(e.getMessage());
				}
			}
		}
		class ButtonProfitsHandler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent event) {
				keypadInputLabel.setText("There is currently " + iVend.getProfits() + " cents in this machines' vault!");
			}
		}
		
		//****
		// END - On Button Press Actions
		//****
		
		//****
		// START - Initialize & Set Buttons
		//****
		Button buttonCoinInsert = new Button("Insert"); // Text in button
		buttonCoinInsert.setOnAction(new ButtonCoinInsertHandler()); // Set action of button
		buttonCoinInsert.setPrefSize(70, 30); // Size of button
		
		Button buttonCoinReturn = new Button("Return");
		buttonCoinReturn.setOnAction(new ButtonCoinReturnHandler());
		buttonCoinReturn.setPrefSize(70, 30);
		
		HBox coinSection = new HBox(10, buttonCoinInsert, coinInput, buttonCoinReturn);
		coinSection.setAlignment(Pos.CENTER);
		
		
		Button button1 = new Button("1");
		button1.setOnAction(new Button1Handler());
		button1.setPrefSize(40, 30);
		
		Button button2 = new Button("2");
		button2.setOnAction(new Button2Handler());
		button2.setPrefSize(40, 30);
		
		Button button3 = new Button("3");
		button3.setOnAction(new Button3Handler());
		button3.setPrefSize(40, 30);
		
		Button button4 = new Button("4");
		button4.setOnAction(new Button4Handler());
		button4.setPrefSize(40, 30);
		
		Button button5 = new Button("5");
		button5.setOnAction(new Button5Handler());
		button5.setPrefSize(40, 30);
		
		Button button6 = new Button("6");
		button6.setOnAction(new Button6Handler());
		button6.setPrefSize(40, 30);
		
		Button button7 = new Button("7");
		button7.setOnAction(new Button7Handler());
		button7.setPrefSize(40, 30);
		
		Button button8 = new Button("8");
		button8.setOnAction(new Button8Handler());
		button8.setPrefSize(40, 30);
		
		Button button9 = new Button("9");
		button9.setOnAction(new Button9Handler());
		button9.setPrefSize(40, 30);
		
		Button buttonClr = new Button("CLR");
		buttonClr.setOnAction(new ButtonClrHandler());
		buttonClr.setPrefSize(40, 30);
		
		Button button0 = new Button("0");
		button0.setOnAction(new Button0Handler());
		button0.setPrefSize(40, 30);
		
		Button buttonOk = new Button("OK");
		buttonOk.setOnAction(new ButtonOkHandler());
		buttonOk.setPrefSize(40, 30);
		
		Button buttonPurchase = new Button("Purchase");
		buttonPurchase.setOnAction(new ButtonPurchaseHandler());
		buttonPurchase.setPrefSize(130, 30);
		
		Button buttonProfits = new Button("Profits");
		buttonProfits.setOnAction(new ButtonProfitsHandler());
		buttonProfits.setPrefSize(130, 50);
		//****
		// END - Initialize & Set Buttons
		//****
		
		//Set Stage Elements
		GridPane pane = new GridPane();
		pane.setHgap(5);
		pane.setVgap(5);
		pane.add(button1, 1, 1);
		pane.add(button2, 2, 1);
		pane.add(button3, 3, 1);
		pane.add(button4, 1, 2);
		pane.add(button5, 2, 2);
		pane.add(button6, 3, 2);
		pane.add(button7, 1, 3);
		pane.add(button8, 2, 3);
		pane.add(button9, 3, 3);
		pane.add(buttonClr, 1, 4);
		pane.add(button0, 2, 4);
		pane.add(buttonOk, 3, 4);
		pane.setAlignment(Pos.CENTER);
		
		VBox vbox = new VBox(5, productCodeLabel, coinBoxLabel, coinSection, currentCoinsLabel, confirmedInputLabel, keypadInputLabel, pane, buttonPurchase, buttonProfits);
		Scene scene = new Scene(vbox, 600, 500);
		vbox.setAlignment(Pos.CENTER);
		primaryStage.setScene(scene);
		primaryStage.setTitle("iVend Machine");
		primaryStage.show();
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
