//package group;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//public class MainApp extends Application {
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    /**
//     * Creates the scene with the FXMLLoader from a fxml file and displays it on the stage.
//     *
//     * @param stage The primary stage where the scenes will be shown.
//     * @throws Exception Throws all occurring exceptions.
//     */
//    @Override
//    public void start(Stage stage) throws Exception {
//        // Create the root by initializing the FXML loader with the fxml file
//        Parent root = FXMLLoader.load(getClass().getResource("/scenes/base_scene.fxml"));
//
//        // Set stage title and size
//        stage.setTitle("Hello JavaFX!");
//        stage.setScene(new Scene(root, 300, 150));
//
//        // Show the stage
//        stage.show();
//    }
//}
