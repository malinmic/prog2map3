package no.ntnu.idatt2001.mmedvard.controllers.factories;

import no.ntnu.idatt2001.mmedvard.controllers.MainController;
import no.ntnu.idatt2001.mmedvard.models.PostalCodeRegistry;
import no.ntnu.idatt2001.mmedvard.PostalCodeApplication;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import java.io.IOException;


/**
 * Class representing the menu bar
 */
public class MenuBarFactory {

    private static final String VERSION = "0.0.1";


    public static MenuBar create(MainController mainController, PostalCodeRegistry postalCodeRegistry, PostalCodeApplication app){

        //---------- FILE MENU ------------
        Menu fileMenu = new Menu("File");


        //---------- File > Import
        MenuItem fileImport = new MenuItem("Import from .txt file..");
        fileImport.setOnAction(event -> {
            try {
                mainController.importFromFile(event, postalCodeRegistry, app);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });


        //---------- File > Exit
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(mainController::exit);



        fileMenu.getItems().add(fileImport);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(exit);



        //--------- HELP MENU ------------
        Menu helpMenu = new Menu("Help");


        //--------- Help > About
        MenuItem about = new MenuItem("About...");
        about.setOnAction(event -> mainController.aboutDialog(VERSION));


        helpMenu.getItems().add(about);


        //--------- MAIN MENU BAR -----------
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);


        return menuBar;
    }

}
