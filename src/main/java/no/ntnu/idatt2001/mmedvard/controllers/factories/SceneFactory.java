package no.ntnu.idatt2001.mmedvard.controllers.factories;

import no.ntnu.idatt2001.mmedvard.PostalCodeApplication;
import javafx.scene.Parent;
import javafx.scene.Scene;


/**
 * Scene factory
 */
public class SceneFactory {

    public static Scene create(Parent parent){

        Scene scene = new Scene(parent);

        scene.getStylesheets().add(PostalCodeApplication.class.getClassLoader().getResource("style.css").toExternalForm());

        return scene;
    }
}
