/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 * FXML Controller class
 *
 * @author Ludmila
 */
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cadastrarCliente(ActionEvent event) {
        
    try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/coffeeleve/views/FXMLCadastrarCliente.fxml"));
        /* 
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
         */
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = new Stage();
        stage.setTitle("CADASTRAR CLIENTE");
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }
        
    }

    @FXML
    private void cadastrarFornecedor(ActionEvent event) {
    }

    @FXML
    private void cadastrarProduto(ActionEvent event) {
    }

    @FXML
    private void vendas(ActionEvent event) {
    }
    
}
