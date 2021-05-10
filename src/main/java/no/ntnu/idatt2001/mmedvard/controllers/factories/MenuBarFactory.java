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

public class MenuBarFactory {

    private static final String VERSION = "0.0.1";

    public static MenuBar create(MainController mainController, PostalCodeRegistry postalCodeRegistry, PostalCodeApplication app){

        //---------- FILE MENU ------------
        Menu search = new Menu("Search");
        MenuItem searchPostalCode = new MenuItem("Search for postal code");
        searchPostalCode.setOnAction(event -> mainController.searchByPostalCode(postalCodeRegistry, app));
    }

}
