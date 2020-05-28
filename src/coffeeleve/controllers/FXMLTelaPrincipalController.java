/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeleve.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

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
