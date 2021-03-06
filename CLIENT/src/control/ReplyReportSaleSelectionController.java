package control;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import Entity.Car;
import Entity.FuelType;
import Entity.Request;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class ReplyReportSaleSelectionController implements Initializable {
		private ClientController client;
		@FXML
		private TextField saleID;
		@FXML
		private Button next_btn;
		@FXML
		private Button cancel_btn;
		@FXML
		private Button homepagebutton;
		
		private int sale_id;

		@FXML
		private void onNextClick(ActionEvent event){
			try {
				String SaleID = saleID.getText();
				if(SaleID.length()==0) {
					client.displayAlert(false, "All fields must be filled!");
					return;
				}
			
				sale_id = Integer.parseInt(SaleID);
				//Car car = new Car(Integer.parseInt(customer_ID), Integer.parseInt(car_ID), fueltype);
				//	Update car 
				client.sendToServer(car);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}

	
		@FXML
		private void onCancelClick(ActionEvent event){
			try {
				client.getMainPage().start(client.getMainStage());
			} catch (Exception e) {
				client.displayAlert(false, null);
				e.printStackTrace();
			}
		}
		
		@FXML
		private void onHomePageClick(ActionEvent event) throws Exception {
			client.getMainPage().start(client.getMainStage());
			client.setClientIF(client.getMainPage());
		}
		
		public ReplyReportSaleSelectionController(ClientController client) {
			this.client=client;
		}



		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {

		}
		
		
		
		
		public void getObjectFromUI(Object msg) {
			//NEW METHOD !!!!!!!!!!!
			@SuppressWarnings("unchecked")
			List<List<Object>> list = (List<List<Object>>)msg;
		}
	}
