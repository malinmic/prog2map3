package no.ntnu.idatt2001.mmedvard.controllers;

import no.ntnu.idatt2001.mmedvard.PostalCodeApplication;
import no.ntnu.idatt2001.mmedvard.models.PostalCode;
import no.ntnu.idatt2001.mmedvard.models.PostalCodeRegistry;

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


    public void searchByPostalCode(PostalCodeApplication app){

        //PostalCodeDialog postalCodeDialogCode = new PostalCodeDialog();

        //Optional<PostalCode> result = postalCodeDialogCode.showAndWait();

        if(result.isPresent()){
            PostalCode post = result.get();
            postalCodeRegistry.getPostalCodeArrayList();
            app.updateObservableList();
        }
    }

    public void searchByPostalName(PostalCodeApplication app){

        //PostalCodeDialog postalCodeDialogName = new PostalCodeDialog();

        //Optional<PostalCode> result = postalCodeDialogName.showAndWait();

        if(result.isPresent()){
            PostalCode post = result.get();
            postalCodeRegistry.getPostalCodeArrayList();
            app.updateObservableList();
        }
    }
}
