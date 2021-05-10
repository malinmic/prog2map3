package no.ntnu.idatt2001.mmedvard.controllers.factories;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import no.ntnu.idatt2001.mmedvard.PostalCodeApplication;
import no.ntnu.idatt2001.mmedvard.controllers.MainController;
import no.ntnu.idatt2001.mmedvard.models.PostalCodeRegistry;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ToolBarFactory {

    public static ToolBar create(MainController mainController, PostalCodeRegistry postalCodeRegistry, PostalCodeApplication app) throws FileNotFoundException{

        //TOOL BAR
        ToolBar toolBar = new ToolBar();

        //IMPORT BUTTON
        Image importImg = new Image(new FileInputStream(PostalCodeApplication.class.getClassLoader().getResource("ImportIcon.jpg").getFile()),16,16,true,true);
        Button importButton = new Button("Import", new ImageView(importImg));

        // TODO: 11.05.2021
        importButton.setOnAction(event -> mainController.importFromFile(event, postalCodeRegistry,app));

        //SEARCH BUTTON
        Image searchImg = new Image(new FileInputStream(PostalCodeApplication.class.getClassLoader().getResource("SearchIcon.jpg").getFile()),16,16,true,true);
        Button searchButton = new Button("Search", new ImageView(searchImg));

        // TODO: 11.05.2021
        String searchString = "";
        searchButton.setOnAction(event -> mainController.searchByPostalCode(searchString));

        toolBar.getItems().addAll(importButton,searchButton);
        return toolBar;
    }
}
