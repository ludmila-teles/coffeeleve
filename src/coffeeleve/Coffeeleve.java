package coffeeleve;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Coffeeleve extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       
        Parent root = FXMLLoader.load(getClass().getResource("/coffeeleve/views/FXMLTelaPrincipal.fxml"));
                
        Scene scene = new Scene(root);
        stage.setTitle("COFFEE LEVE - TELA PRINCIPAL");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
