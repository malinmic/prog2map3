package no.ntnu.idatt2001.mmedvard.controllers;

import no.ntnu.idatt2001.mmedvard.models.PostalCodeRegistry;
import no.ntnu.idatt2001.mmedvard.PostalCodeApplication;
import no.ntnu.idatt2001.mmedvard.models.FileManager;
import no.ntnu.idatt2001.mmedvard.models.PostalCode;
import javafx.scene.control.ButtonType;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.stage.Stage;
import java.io.File;


/**
 * Class containing methods for buttons in menu bar
 */
public class MainController {


    /**
     * Opens confirmation dialog window to confirm exit of program
     * @param event event
     */
    public void exit(javafx.event.ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setContentText("Do you want to exit?");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK){
            Platform.exit();
        }
    }


    /**
     * Opens About dialog window with information about the Application
     * @param version verison of the application
     */
    public void aboutDialog(String version){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Postal Code Registry \nv" + version);
        alert.setContentText("A Postal code registry Application created by \n" + "© mmedvard\n" + "2021");
        alert.showAndWait();
    }


    /**
     * onAction for import from file button
     * @param event event
     * @param postalCodeRegistry postal code registry
     * @param parent parent
     * @throws IOException exception
     */
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

}
