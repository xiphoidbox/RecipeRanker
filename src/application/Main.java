import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            //this creates the scene and makes Scene1.fxml the first file to be open
            Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            //prompts the user when they try to exit the program. altf4/top right x button.
            stage.setOnCloseRequest(event -> {
                event.consume();
                logout(stage);
            });

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    //This asks the user if he is sure he wants to quit.
    public void logout(Stage stage){

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit the application!");

        if (alert.showAndWait().get() == ButtonType.OK){
            System.out.println("You have successfully exited the application");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}