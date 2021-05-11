package no.ntnu.idatt2001.mmedvard;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Collection;
import java.util.stream.Collectors;

public class PostalCodeApplication extends Application{

    private TableView<PostalCode> postalCodeTableView = new TableView<>();
    private MainController mainController;
    private PostalCodeRegistry postalCodeRegistry;
    private ObservableList<PostalCode> postalCodeRegistryWrapper;
    private ObservableList<PostalCode> data = FXCollections.observableArrayList();

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

        /*
        VBox topContainer = new VBox();
        topContainer.getChildren().add(mainMenu);
        topContainer.getChildren().add(hBox);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(this.postalCodeTableView);
        borderPane.setTop(topContainer);

        Scene scene = SceneFactory.create(borderPane);
        primaryStage.setScene(scene);

        primaryStage.show();


         */


        String file = "src\\main\\resources\\Postnummerregister-ansi.txt";
        BufferedReader bufferedReader = null;
        String lineReader = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while((lineReader = bufferedReader.readLine()) != null){

                String[] data = lineReader.split("\t");

                for(String s : data){
                    PostalCode postalCode = new PostalCode(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim());
                    postalCodeRegistry.addPostalCode(postalCode);
                    postalCodeTableView.setItems(getPostalCodeRegistryWrapper());

                }

            }
        } catch (Exception exception){
            exception.printStackTrace();
        }










        FilteredList<PostalCode> filteredList = new FilteredList<>(data, p -> true);
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
                    filteredList.setPredicate(p -> p.getMunicipalityNumber().toLowerCase().contains(newValue.toLowerCase().trim()));
                    break;

                case "Municipality name":
                    filteredList.setPredicate(p -> p.getMunicipalityName().toLowerCase().contains(newValue.toLowerCase().trim()));
                    break;

                case "Category":
                    filteredList.setPredicate(p -> p.getCategory().toLowerCase().contains(newValue.toLowerCase().trim()));
                    break;

                default:
                    this.postalCodeTableView.setItems(getPostalCodeRegistryWrapper());
                    break;
            }
        });

        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs,oldValue,newValue) -> {
            if(newValue != null) {
                searchBox.setText("");
            }
        });

        HBox hBox = new HBox(choiceBox,searchBox);
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
        postalCodeColumn.setMinWidth(200);
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        //2. column: post office
        TableColumn<PostalCode,String> postOfficeColumn = new TableColumn<>("Post Office");
        postOfficeColumn.setMinWidth(200);
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postOffice"));

        //3. column: municipality number
        TableColumn<PostalCode, String> municipalityNumberColumn = new TableColumn<>("Municipality number");
        municipalityNumberColumn.setMinWidth(200);
        municipalityNumberColumn.setCellValueFactory(new PropertyValueFactory<>("municipalityNumber"));

        //4. column: municipality name
        TableColumn<PostalCode, String> municipalityNameColumn = new TableColumn<>("Municipality name");
        municipalityNameColumn.setMinWidth(200);
        municipalityNameColumn.setCellValueFactory(new PropertyValueFactory<>("municipalityName"));

        //5. column: category
        TableColumn<PostalCode, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setMinWidth(200);
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        postalCodeTableView = new TableView<>();
        ObservableList<PostalCode> observableListOfPostalCodes = this.postalCodeRegistryWrapper;
        postalCodeTableView.setItems(observableListOfPostalCodes);

        postalCodeTableView.getColumns().addAll(postalCodeColumn,postOfficeColumn,municipalityNumberColumn,municipalityNameColumn,categoryColumn);

        postalCodeTableView.setItems(FXCollections.observableArrayList(this.postalCodeRegistry.getPostalCodeArrayList()));

        //postalCodeTableView.getItems().add(new PostalCode("8800", "Sandnessjøen","10","Alstahaug","G"));

    }













    @Override
    public void stop() throws Exception {
        super.stop();
    }


    public TableView<PostalCode> getPostalCodeTableView(){
        return this.postalCodeTableView;
    }
}
