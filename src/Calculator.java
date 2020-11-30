
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

	public static void main(String[] args) {
		
		launch(args);

	}
	TextField tf = new TextField();
	String saved= null;
	int j = 0;
	public void start(Stage arg0) throws Exception {
		
		
		VBox vb = new VBox();
		
		int colId = 0;
		int rowId = 0;
		
		
		tf.setMinSize(430, 50);
		
		/////////////////////////
		GridPane Sign = new GridPane();
		Button add = new Button("+");
		Button sub = new Button("-");
		Button mul = new Button("*");
		Sign.add(add, 0, 0);
		Sign.add(mul, 0, 1);
		Sign.add(sub, 0, 2);
		///////////////////////
		GridPane Sign2 = new GridPane();
		Button div = new Button("/");
		Button clear = new Button("C");
		Button equals = new Button("=");
		Sign2.add(div, 0, 0);
		Sign2.add(clear, 0, 1);
		Sign2.add(equals, 0, 2);
		///////////////////////
		Button zero = new Button("0");
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		//////////////////////////
		SignsConfig(add);
		SignsConfig(sub);
		SignsConfig(div);
		SignsConfig(mul);
		SignsConfig(clear);
		SignsConfig(equals);
		//////////////////////////
		NumpadConfig(zero);
		NumpadConfig(one);
		NumpadConfig(two);
		NumpadConfig(three);
		NumpadConfig(four);
		NumpadConfig(five);
		NumpadConfig(six);
		NumpadConfig(seven);
		NumpadConfig(eight);
		NumpadConfig(nine);
		//////////////////////////
		
		GridPane numpadPane = new GridPane();
		
		//////////////////////////
		numpadPane.add(one,0, 0);
		numpadPane.add(two,1, 0);
		numpadPane.add(three,2, 0);
		numpadPane.add(four,0, 1);
		numpadPane.add(five,1, 1);
		numpadPane.add(six,2, 1);
		numpadPane.add(seven,0, 2);
		numpadPane.add(eight,1, 2);
		numpadPane.add(nine,2, 2);	
		numpadPane.add(zero,3, 2);
		numpadPane.add(Sign, 3, 0);
		numpadPane.add(Sign2, 3, 1);
		///////////////////////////
		onclick(zero);
		onclick(one);
		onclick(two);
		onclick(three);
		onclick(four);
		onclick(five);
		onclick(six);
		onclick(seven);
		onclick(eight);
		onclick(nine);
		clear(clear);
		equal(equals);
	
		//////////////////////////
		onSignClick(add);
		onSignClick(sub);
		onSignClick(div);
		onSignClick(mul);
	
		
		vb.getChildren().addAll(tf,numpadPane);
		Stage stage = new Stage();
		stage.setTitle("Calculator");
		Scene scene = new Scene(vb,430,375);
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	
	private void equal(Button equals) {
		// TODO Auto-generated method stub
		equals.setOnAction(e->{
		if (j==1) {
			String[] calcu =  tf.getText().split("\\" + saved);
			int num1 = Integer.parseInt(calcu[0]);
			int num2 = Integer.parseInt(calcu[1]);
		    String operator = saved;

		    int result;

		    switch (operator) {
		      case "+":
		        result = num1 + num2;
		        break;

		      case "-":
		        result = num1 - num2;
		        break;

		      case "*":
		        result = num1 * num2;
		        break;

		      case "/":
		        result = num1 / num2;
		        break;

		     
		      default:
		        return;
		    }

		    tf.setText(Integer.toString(result) );
		    j = 0;
		    saved =null;
		  }
		});
	}


	private void NumpadConfig(Button b) {
		
		b.setMinSize(110, 100);
	
		
	}
	
	private void SignsConfig(Button S) {
			
			S.setMinSize(110, 32.5);
			
			S.setMinSize(110, 32.5);
			
			
			
	}

	
	private void onclick(Button b) {
		b.setOnAction(e->{
			
			tf.setText(tf.getText() + b.getText());
			
		});
	}
	
	
	private void onSignClick(Button b) {
		b.setOnAction(e->{
			
			if (saved == null) {
				
				tf.setText(tf.getText() + b.getText());
				saved =  b.getText();
				
			}
			else if (j==1) {
				String[] calcu =  tf.getText().split("\\" + saved);
				int num1 = Integer.parseInt(calcu[0]);
				int num2 = Integer.parseInt(calcu[1]);

			    
			   
			    
			    String operator = saved;

			    int result;

			    switch (operator) {
			      case "+":
			        result = num1 + num2;
			        break;

			      case "-":
			        result = num1 - num2;
			        break;

			      case "*":
			        result = num1 * num2;
			        break;

			      case "/":
			        result = num1 / num2;
			        break;

			     
			      default:
			        return;
			    }

			    tf.setText(Integer.toString(result) + b.getText());
			    j = 0;
			    saved = b.getText();
			  }
			;
			
			j++;
		});
		
	}
	
	
	
	private void clear(Button b) {

		b.setOnAction(e->{
			
			
			
			tf.setText("");
			j=0;
			saved=null;
			
			
		}
		);
		
	}
}
