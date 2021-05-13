package no.ntnu.idatt2001.mmedvard;

import no.ntnu.idatt2001.mmedvard.controllers.MainController;
import no.ntnu.idatt2001.mmedvard.models.PostalCodeRegistry;
import no.ntnu.idatt2001.mmedvard.controllers.factories.*;
import javafx.scene.control.cell.PropertyValueFactory;
import no.ntnu.idatt2001.mmedvard.models.PostalCode;
import javafx.beans.InvalidationListener;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.*;


public class PostalCodeApplication extends Application{

    private TableView<PostalCode> postalCodeTableView = new TableView<>();
    private MainController mainController;
    private PostalCodeRegistry postalCodeRegistry;
    private ObservableList<PostalCode> postalCodeRegistryWrapper = FXCollections.observableArrayList();


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






        TextField txtField = new TextField();
        txtField.setPromptText("Type here to search");
        txtField.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable o) {

                if(txtField.textProperty().get().isEmpty()){
                    postalCodeTableView.setItems(postalCodeRegistryWrapper);
                    return;
                }

                ObservableList<PostalCode> tableItems = FXCollections.observableArrayList();

                ObservableList<TableColumn<PostalCode,?>> cols = postalCodeTableView.getColumns();

                for(int i = 0; i < postalCodeRegistryWrapper.size(); i++){

                    for(int j = 0; j < cols.size(); j++) {
                        TableColumn col = cols.get(j);

                        String cellValue = col.getCellData(postalCodeRegistryWrapper.get(i)).toString();

                        cellValue = cellValue.toLowerCase();

                        if(cellValue.contains(txtField.textProperty().get().toLowerCase())){

                            tableItems.add(postalCodeRegistryWrapper.get(i));

                            break;
                        }
                    }
                }

                postalCodeTableView.setItems(tableItems);
            }
        });







        HBox hBox = new HBox(txtField);
        hBox.setAlignment(Pos.TOP_LEFT);


        VBox topContainer = new VBox();
        topContainer.getChildren().add(mainMenu);
        topContainer.getChildren().add(hBox);


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(this.postalCodeTableView);
        borderPane.setTop(topContainer);


        Scene scene = SceneFactory.create(borderPane);
        primaryStage.setScene(scene);


        primaryStage.show();

    }


    public void updateObservableList() throws IOException {
        this.postalCodeTableView.setItems(getPostalCodeRegistryWrapper());
        this.postalCodeTableView.refresh();
    }



    public ObservableList<PostalCode> getPostalCodeRegistryWrapper() throws IOException {
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
    private void createTable() throws IOException {

        //1. column: postal code
        TableColumn<PostalCode,String> postalCodeColumn = new TableColumn<>("Postal Code");
        postalCodeColumn.setMinWidth(100);
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<PostalCode,String>("postalCode"));

        //2. column: post office
        TableColumn<PostalCode,String> postOfficeColumn = new TableColumn<>("Office");
        postOfficeColumn.setMinWidth(200);
        postOfficeColumn.setCellValueFactory(new PropertyValueFactory<PostalCode,String>("postOffice"));

        //3. column: municipality number
        TableColumn<PostalCode, String> municipalityNumberColumn = new TableColumn<>("Municipality number");
        municipalityNumberColumn.setMinWidth(200);
        municipalityNumberColumn.setCellValueFactory(new PropertyValueFactory<PostalCode,String>("municipalityNumber"));

        //4. column: municipality name
        TableColumn<PostalCode, String> municipalityNameColumn = new TableColumn<>("Municipality name");
        municipalityNameColumn.setMinWidth(200);
        municipalityNameColumn.setCellValueFactory(new PropertyValueFactory<PostalCode,String>("municipalityName"));

        //5. column: category
        TableColumn<PostalCode, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setMinWidth(100);
        categoryColumn.setCellValueFactory(new PropertyValueFactory<PostalCode,String>("category"));


        //Setting columns into the tableview and populating it with a list of postal codes details
        postalCodeTableView = new TableView<>();
        ObservableList<PostalCode> observableListOfPostalCodes = this.postalCodeRegistryWrapper;
        postalCodeTableView.setItems(observableListOfPostalCodes);
        postalCodeTableView.getColumns().addAll(postalCodeColumn,postOfficeColumn,municipalityNumberColumn,municipalityNameColumn,categoryColumn);
        postalCodeTableView.setItems(FXCollections.observableArrayList(this.postalCodeRegistry.getPostalCodeArrayList()));

    }




    /**
     *
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        super.stop();
    }


    /**
     *
     * @return
     */
    public TableView<PostalCode> getPostalCodeTableView(){
        return this.postalCodeTableView;
    }
}
