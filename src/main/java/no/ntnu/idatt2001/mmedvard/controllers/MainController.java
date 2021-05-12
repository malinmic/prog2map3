package no.ntnu.idatt2001.mmedvard.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import no.ntnu.idatt2001.mmedvard.PostalCodeApplication;
import no.ntnu.idatt2001.mmedvard.models.FileManager;
import no.ntnu.idatt2001.mmedvard.models.PostalCode;
import no.ntnu.idatt2001.mmedvard.models.PostalCodeRegistry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController {

    PostalCodeRegistry postalCodeRegistry = new PostalCodeRegistry();

    ObservableList<PostalCode> obserableListPost = FXCollections.observableArrayList(this.postalCodeRegistry.getPostalCodeArrayList());


    public void exit(javafx.event.ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setContentText("Do you want to exit?");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK){
            Platform.exit();
        }
    }

    public void aboutDialog(String version){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Postal Code Registry \nv" + version);
        alert.setContentText("A Postal code registry Application created by \n" + "© mmedvard\n" + "2021");
        alert.showAndWait();
    }


    public void importFromFile(ActionEvent event, PostalCodeRegistry postalCodeRegistry, PostalCodeApplication parent) throws IOException {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(new Stage());

        if (file == null) {
            return;
        }

        ArrayList<PostalCode> post;
        try {
            post = FileManager.importFromFile(file);
        }catch (Exception e) {
            return;
        }

        post.forEach(postalCodeRegistry::addPostalCode);
        parent.updateObservableList();
    }



    /*

    public FilteredList<PostalCode> filteredListMethod(KeyEvent event, PostalCodeRegistry postalCodeRegistry, PostalCodeApplication parent) throws Exception{


        filteredObservableList.addAll(postalCodeRegistryWrapper);

        TextField searchBox = new TextField();
        searchBox.setPromptText("Search");

        FilteredList<PostalCode> filteredList = new FilteredList<>(postalCodeRegistryWrapper, p -> true);

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



     */

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


    /*
            });


        });





        SortedList<PostalCode> sortedList = new SortedList<>(filteredList);

        sortedList.comparatorProperty().bind(postalCodeTableView.comparatorProperty());

        postalCodeTableView.setItems(sortedList);

        //return postalCodeTableView;
    }



     */


    /*

    // TODO: 11.05.2021 replace both search methods with one search method for all columns

    public PostalCode searchByPostalCode(String searchingFor){

        /*
        String result = null;

        ArrayList<PostalCode> postalCodes = new ArrayList<>();

        boolean match = postalCodes.stream().anyMatch(s -> postalCodes.contains(searchingFor));

        *

        for (PostalCode postDetails : postalCodes){
            if(postDetails.getPostalCode().equals(searchingFor)){
                return postDetails;
            }else if()





            return null;

        }


        //PostalCodeDialog postalCodeDialogCode = new PostalCodeDialog();

        //Optional<PostalCode> result = postalCodeDialogCode.showAndWait();

        /*
        if(result.isPresent()){
            PostalCode post = result.get();
            postalCodeRegistry.getPostalCodeArrayList();
            app.updateObservableList();
        }



        return null;
    }



    /*
    public void searchByPostalName(PostalCodeApplication app){

        //PostalCodeDialog postalCodeDialogName = new PostalCodeDialog();

        //Optional<PostalCode> result = postalCodeDialogName.showAndWait();

        if(result.isPresent()){
            PostalCode post = result.get();
            postalCodeRegistry.getPostalCodeArrayList();
            app.updateObservableList();
        }
    }

     */

    /*

    public void importFromFile(ActionEvent event, PostalCodeRegistry postalCodeRegistry, PostalCodeApplication parent){
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(new Stage());

        if(file == null){
            return;
        }
        /*
        if(!fileIsCSV(file.getName())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wrong file type!");
            alert.setHeaderText("File type not supported. Please select a .csv file.");
            alert.showAndWait();
            return;
        }


        ArrayList<PostalCode> postalCodeList;
        try{
            postalCodeList = FileManager.importFromFile(file);
        }catch (Exception exception){
            return;
        }
        postalCodeList.forEach(postalCodeRegistry :: addPostalCode);
        parent.updateObservableList();
    }

    /*
    private boolean fileIsCSV(String name){
        String[] s = name.split("\\.");
        return s[s.length-1].equals("csv");
    }



     */

}
