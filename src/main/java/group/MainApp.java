package group;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Creates the scene with the FXMLLoader from a fxml file and displays it on the stage.
     *
     * @param stage The primary stage where the scenes will be shown.
     * @throws Exception Throws all occurring exceptions.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Create the root by initializing the FXML loader with the fxml file
        Parent root = FXMLLoader.load(getClass().getResource("/scenes/base_scene.fxml"));

        // Set stage title and size
        stage.setTitle("Hello JavaFX!");
        stage.setScene(new Scene(root, 300, 150));

        // Show the stage
        stage.show();
    }

//    /**
//     * Creates the scene with the FXMLLoader from a fxml file, executes custom initializations for the controller and
//     * displays the scene on the stage.
//     *
//     * @param stage The primary stage where the scenes will be shown.
//     * @throws Exception Throws all occurring exceptions.
//     */
//    @Override
//    public void start(Stage stage) throws Exception {
//        // Create FXML loader and load the fxml file
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/base_scene.fxml"));
//
//        // Create the root object from the loader
//        Parent root = loader.load();
//
//        // Get the connected controller
//        BaseSceneController controller = loader.getController();
//
//        // Call custom initialize function
//        controller.initializeController("Different Text, same Exit!");
//
//        // Set stage title and size
//        stage.setTitle("Hello JavaFX!");
//        stage.setScene(new Scene(root, 300, 150));
//
//        // Show the stage
//        stage.show();
//    }
}
