package coffeeleve.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLTelaPrincipalController implements Initializable {

    @FXML
    private AnchorPane anpMain;
    @FXML
    private Button btnCadastrarCliente;
    @FXML
    private Button btnCadastrarFornecedor;
    @FXML
    private Button btnCadastrarProduto;
    @FXML
    private Button btnVendas;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }    

    @FXML
    private void cadastrarCliente(ActionEvent event) {
        
    try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/coffeeleve/views/FXMLCadastrarCliente.fxml"));
        
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("CADASTRAR CLIENTE");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }
        
    }

    @FXML
    private void cadastrarFornecedor(ActionEvent event) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/coffeeleve/views/FXMLCadastrarFornecedor.fxml"));
        
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("CADASTRAR FORNECEDOR");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }
        
    }

    @FXML
    private void cadastrarProduto(ActionEvent event) {
         try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/coffeeleve/views/FXMLCadastrarProduto.fxml"));
        
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("CADASTRAR PRODUTO");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }
    }

    @FXML
    private void vendas(ActionEvent event) {
    }
    
}
