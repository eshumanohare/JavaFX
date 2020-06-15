package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {

	Stage window;
	Scene scene1, scene2;
	TableView<Product> table;
	TextField name, price, quantity;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		ConfirmBox ob = new ConfirmBox();
		window.setOnCloseRequest(e -> {
			ob.display("Chose", "Do you want to quit?"); 
			if(ob.result == false)
				e.consume();           // e.consume consumes the root of the stack from where the initial calling started
		});
	
		TableColumn<Product, String> nameColumn = new TableColumn<>("Item"); 
		nameColumn.setMinWidth(250);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("item"));
		
		TableColumn<Product, String> priceColumn = new TableColumn<>("Price"); 
		priceColumn.setMinWidth(250);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity"); 
		quantityColumn.setMinWidth(250);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		
		// name input 
		name = new TextField();
		name.setPromptText("Name");
		name.setMinWidth(100);
		
		// price column
		price = new TextField();
		price.setPromptText("Price");
		price.setMinWidth(100);
		
		quantity = new TextField();
		quantity.setPromptText("Quantity");
		quantity.setMinWidth(100);
		
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addbutton());
		//addButton.setPadding(new Insets(10,10,10,10));
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deletebutton());
		//deleteButton.setPadding(new Insets(10,10,10,10));
		
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(name,price,quantity, addButton, deleteButton);
		
		table = new TableView<Product>();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
		
		window.setTitle("Thsdksd");
		VBox layout = new VBox();
		layout.setPadding(new Insets(20,20,20,20));
		layout.setSpacing(10);
		layout.getChildren().addAll(table,hbox);
		
		scene1 = new Scene(layout,300,250);
		window.setScene(scene1);
		window.setMinWidth(1200);
		window.setMinHeight(800);
		window.show();
	}
	
	private void addbutton() {
		Product product = new Product(name.getText(), Double.parseDouble(price.getText()), Integer.parseInt(quantity.getText()));
		table.getItems().add(product);	
		name.clear();
		price.clear();
		quantity.clear();
	}
	private void deletebutton() {
		ObservableList<Product> allprod = table.getItems();   // all the current items in table 
		ObservableList<Product> selectedItems = table.getSelectionModel().getSelectedItems();
		selectedItems.forEach(allprod :: remove);
	}
	
	private ObservableList<Product> getProduct(){
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("Laptop", 40000, 20));
		products.add(new Product("Cycle", 10000, 10));
		products.add(new Product("Books", 6000, 13));
		products.add(new Product("Bed", 50000, 10));
		products.add(new Product("SSD", 14000, 1));		
		
		return products;
	}
	
}
