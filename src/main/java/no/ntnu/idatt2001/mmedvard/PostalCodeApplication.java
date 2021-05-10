package no.ntnu.idatt2001.mmedvard;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import no.ntnu.idatt2001.mmedvard.controllers.MainController;
import no.ntnu.idatt2001.mmedvard.models.PostalCode;
import no.ntnu.idatt2001.mmedvard.models.PostalCodeRegistry;
import no.ntnu.idatt2001.mmedvard.controllers.factories.*;
import java.io.FileNotFoundException;

public class PostalCodeApplication extends Application{

    private TableView<PostalCode> postalCodeTableView = new TableView<>();
    private MainController mainController;
    private PostalCodeRegistry postalCodeRegistry;
    private ObservableList<PostalCode> postalCodeRegistryWrapper;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();

        this.mainController = new MainController();
        this.postalCodeRegistry = new PostalCodeRegistry();
        this.postalCodeRegistryWrapper = getPostalCodeRegistryWrapper();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Postal Code Registry");
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
        createTable();
        MenuBar mainMenu = MenuBarFactory.create(mainController, postalCodeRegistry,this);
        ToolBar toolBar = ToolBarFactory.create(mainController,postalCodeRegistry,this);

        VBox topContainer = new VBox();
        topContainer.getChildren().add(mainMenu);
        topContainer.getChildren().add(toolBar);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(this.postalCodeTableView);
        borderPane.setTop(topContainer);

        Scene scene = SceneFactory.create(borderPane);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public void updateObservableList(){
        this.postalCodeTableView.setItems(getPostalCodeRegistryWrapper());
        this.postalCodeTableView.refresh();
    }

    public ObservableList<PostalCode> getPostalCodeRegistryWrapper(){
        if(this.postalCodeRegistry == null){
            postalCodeRegistryWrapper = null;
        }else{
            postalCodeRegistryWrapper = FXCollections.observableArrayList(this.postalCodeRegistry.getPostalCodeArrayList());
        }
        return postalCodeRegistryWrapper;
    }


    /**
     * method to create table with postal codes
     */
    private void createTable(){
        //1. column: postal code
        TableColumn<PostalCode,String> postalCodeColumn = new TableColumn<>("Postal Code");
        postalCodeColumn.setMinWidth(100);
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        //2. column: post office
        TableColumn<PostalCode,String> postOfficeColumn = new TableColumn<>("Post Office");
        postOfficeColumn.setMinWidth(100);
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postOffice"));

        //3. column: municipality number
        TableColumn<PostalCode, String> municipalityNumberColumn = new TableColumn<>("Municipality number");
        municipalityNumberColumn.setMinWidth(100);
        municipalityNumberColumn.setCellValueFactory(new PropertyValueFactory<>("municipalityNumber"));

        //4. column: municipality name
        TableColumn<PostalCode, String> municipalityNameColumn = new TableColumn<>("Municipality name");
        municipalityNameColumn.setMinWidth(100);
        municipalityNameColumn.setCellValueFactory(new PropertyValueFactory<>("municipalityName"));

        //5. column: category
        TableColumn<PostalCode, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setMinWidth(100);
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        postalCodeTableView = new TableView<>();
        ObservableList<PostalCode> observableListOfPostalCodes = this.postalCodeRegistryWrapper;
        postalCodeTableView.setItems(observableListOfPostalCodes);

        postalCodeTableView.getColumns().addAll(postalCodeColumn,postOfficeColumn,municipalityNumberColumn,municipalityNameColumn,categoryColumn);

        postalCodeTableView.setItems(FXCollections.observableArrayList(this.postalCodeRegistry.getPostalCodeArrayList()));

        postalCodeTableView.getItems().add(new PostalCode("8800", "Sandnessjøen","10","Alstahaug","G"));

    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }


    public TableView<PostalCode> getPostalCodeTableView(){
        return this.postalCodeTableView;
    }
}
