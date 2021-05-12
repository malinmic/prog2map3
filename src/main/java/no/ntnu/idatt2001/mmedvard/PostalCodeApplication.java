package no.ntnu.idatt2001.mmedvard;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.idatt2001.mmedvard.controllers.MainController;
import no.ntnu.idatt2001.mmedvard.models.PostalCode;
import no.ntnu.idatt2001.mmedvard.models.PostalCodeRegistry;
import no.ntnu.idatt2001.mmedvard.controllers.factories.*;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Predicate;

public class PostalCodeApplication extends Application{

    private TableView<PostalCode> postalCodeTableView = new TableView<>();
    private MainController mainController;
    private PostalCodeRegistry postalCodeRegistry;
    private ObservableList<PostalCode> postalCodeRegistryWrapper;
    private ObservableList<PostalCode> filteredObservableList = FXCollections.observableArrayList();

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
        fillTable();
        MenuBar mainMenu = MenuBarFactory.create(mainController, postalCodeRegistry,this);
        ToolBar toolBar = ToolBarFactory.create(mainController,postalCodeRegistry,this);







/*

        filteredObservableList.addAll(postalCodeRegistryWrapper);

        FilteredList<PostalCode> filteredList = new FilteredList<>(filteredObservableList, p -> true);
        postalCodeTableView.setItems(filteredList);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Postal Code", "Post Office", "Municipality number", "Municipality name", "Category");
        choiceBox.setValue("Postal Code");

        TextField searchBox = new TextField();
        searchBox.setPromptText("Search..");
        searchBox.textProperty().addListener((obs, oldValue, newValue) -> {
            switch (choiceBox.getValue()){
                case "Postal Code":
                    filteredList.setPredicate(p -> p.getPostalCode().toLowerCase().contains(newValue.toLowerCase().trim()));
                    break;

                case "Post Office":
                    filteredList.setPredicate(p -> p.getPostOffice().toLowerCase().contains(newValue.toLowerCase().trim()));
                    break;


                case "Municipality number":
                    //filteredList.setPredicate(p -> p.getMunicipalityNumber().toLowerCase().contains(newValue.toLowerCase().trim()));
                    break;

                case "Municipality name":
                    //filteredList.setPredicate(p -> p.getMunicipalityName().toLowerCase().contains(newValue.toLowerCase().trim()));
                    break;

                case "Category":
                    filteredList.setPredicate(p -> p.getCategory().toLowerCase().contains(newValue.toLowerCase().trim()));
                    break;



                default:
                    try {
                        this.postalCodeTableView.setItems(getPostalCodeRegistryWrapper());
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                    break;
            }
        });

        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs,oldValue,newValue) -> {
            if(newValue != null) {
                searchBox.setText("");
            }
        });


 */



        TextField searchBox = new TextField();
        searchBox.setOnKeyPressed(event -> searchMethod());


        HBox hBox = new HBox(searchBox);
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









        /*
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(label)


         */






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
        postalCodeColumn.setMinWidth(150);
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<PostalCode,String>("postalCode"));

        //2. column: post office
        TableColumn<PostalCode,String> postOfficeColumn = new TableColumn<>("Office");
        postOfficeColumn.setMinWidth(150);
        postOfficeColumn.setCellValueFactory(new PropertyValueFactory<PostalCode,String>("postOffice"));


        //3. column: municipality number
        TableColumn<PostalCode, String> municipalityNumberColumn = new TableColumn<>("Municipality number");
        municipalityNumberColumn.setMinWidth(150);
        municipalityNumberColumn.setCellValueFactory(new PropertyValueFactory<PostalCode,String>("municipalityNumber"));

        //4. column: municipality name
        TableColumn<PostalCode, String> municipalityNameColumn = new TableColumn<>("Municipality name");
        municipalityNameColumn.setMinWidth(150);
        municipalityNameColumn.setCellValueFactory(new PropertyValueFactory<PostalCode,String>("municipalityName"));

        //5. column: category
        TableColumn<PostalCode, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setMinWidth(150);
        categoryColumn.setCellValueFactory(new PropertyValueFactory<PostalCode,String>("category"));




        postalCodeTableView = new TableView<>();
        ObservableList<PostalCode> observableListOfPostalCodes = this.postalCodeRegistryWrapper;


        postalCodeTableView.setItems(observableListOfPostalCodes);
        postalCodeTableView.getColumns().addAll(postalCodeColumn,postOfficeColumn,municipalityNumberColumn,municipalityNameColumn,categoryColumn);
        postalCodeTableView.setItems(FXCollections.observableArrayList(this.postalCodeRegistry.getPostalCodeArrayList()));


        //postalCodeTableView.getItems().add(new PostalCode("8800", "Sandnessjøen","10","Alstahaug","G"));



    }


    private TableView<PostalCode> searchMethod(){

        filteredObservableList.addAll(postalCodeRegistryWrapper);

        TextField searchBox = new TextField();
        searchBox.setPromptText("Search");

        FilteredList<PostalCode> filteredList = new FilteredList<>(filteredObservableList, p -> true);

        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(post -> {
                if(newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCase = newValue.toLowerCase();

                if(post.getPostalCode().toLowerCase().contains(lowerCase)) {
                    return true;
                }else if(post.getPostOffice().toLowerCase().contains(lowerCase)){
                    return true;
                }else{
                    return false;
                }



                /*
                if(post.getPostalCode().toLowerCase().contains(lowerCase) ||
                post.getPostOffice().toLowerCase().contains(lowerCase) ||
                post.getMunicipalityNumber().toLowerCase().contains(lowerCase) ||
                post.getMunicipalityName().toLowerCase().contains(lowerCase) ||
                post.getCategory().toLowerCase().contains(lowerCase)) {
                    return true;
                }
                return false;



                 */
            });


        });

        SortedList<PostalCode> sortedList = new SortedList<>(filteredList);

        sortedList.comparatorProperty().bind(postalCodeTableView.comparatorProperty());

        postalCodeTableView.setItems(sortedList);

        return postalCodeTableView;


    }




    private void fillTable(){
        postalCodeTableView.setItems(FXCollections.observableArrayList(this.postalCodeRegistry.getPostalCodeArrayList()));

    }




    @Override
    public void stop() throws Exception {
        super.stop();
    }


    public TableView<PostalCode> getPostalCodeTableView(){
        return this.postalCodeTableView;
    }
}
