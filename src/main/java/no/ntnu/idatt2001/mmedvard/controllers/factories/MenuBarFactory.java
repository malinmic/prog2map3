package no.ntnu.idatt2001.mmedvard.controllers.factories;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import no.ntnu.idatt2001.mmedvard.PostalCodeApplication;
import no.ntnu.idatt2001.mmedvard.controllers.MainController;
import no.ntnu.idatt2001.mmedvard.models.PostalCode;
import no.ntnu.idatt2001.mmedvard.models.PostalCodeRegistry;

import java.io.IOException;

public class MenuBarFactory {

    private static final String VERSION = "0.0.1";

    public static MenuBar create(MainController mainController, PostalCodeRegistry postalCodeRegistry, PostalCodeApplication app){

        String searchString = "";


        //---------- FILE MENU ------------
        Menu fileMenu = new Menu("File");

        MenuItem search = new MenuItem("Search...");
        //search.setOnAction(event -> mainController.searchByPostalCode(searchString));

        MenuItem fileImport = new MenuItem("Import from CSV..");
        fileImport.setOnAction(event -> {
            try {
                mainController.importFromFile(event, postalCodeRegistry, app);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(event -> mainController.exit(event));

        fileMenu.getItems().add(fileImport);
        fileMenu.getItems().add(search);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(exit);


        //--------- HELP MENU ------------
        Menu helpMenu = new Menu("Help");

        MenuItem about = new MenuItem("About...");
        about.setOnAction(event -> mainController.aboutDialog(VERSION));

        helpMenu.getItems().add(about);


        //--------- MAIN MENU BAR -----------
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;


    }

}
