package coffeeleve.controllers;

import coffeeleve.dao.ProdutoDao;
import coffeeleve.models.Produto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class FXMLCadastrarProdutoController implements Initializable {

    @FXML
    private AnchorPane anpMain;
    @FXML
    private TextField txfDescricaoProduto;
    @FXML
    private TextField txfPrecoCusto;
    @FXML
    private TextField txfPrecoVenda;
    @FXML
    private TextField txfUnidade;
    @FXML
    private TableView<Produto> tbUser;
    @FXML
    private TableColumn<Produto, String> tbcId;
    @FXML
    private TextField txfPesquisar;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnListar;
    @FXML
    private Button btnDeletar;
    @FXML
    private TableColumn<Produto, String> tbcDescricaoProduto;
    @FXML
    private TableColumn<Produto, String> tbcPrecoCusto;
    @FXML
    private TableColumn<Produto, String> tbcPrecoVenda;
    @FXML
    private TableColumn<Produto, String> tbcUnidade;

    private ProdutoDao dao = new ProdutoDao();
    private ObservableList<Produto> obsList = FXCollections.observableArrayList();
    private Produto selected;
   


   private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert dialogoErro = new Alert(alertType);
        dialogoErro.setTitle(title);
        dialogoErro.setHeaderText(title);
        dialogoErro.setContentText(message);
        dialogoErro.showAndWait();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbUser.setOnMouseClicked((event) -> {
             if (tbUser.getSelectionModel().getSelectedItem() == null)
                return;
            
            selected = (Produto) tbUser.getSelectionModel().getSelectedItem();

            txfDescricaoProduto.setText(selected.getDescricaoproduto());
            txfPrecoCusto.setText(selected.getPrecocusto());
            txfPrecoVenda.setText(selected.getPrecovenda());
            txfUnidade.setText(selected.getUnidade());
       });
    }    

    @FXML
    private void salvarProduto(ActionEvent event) {
        Produto produto = new Produto();
        produto.setDescricaoproduto(txfDescricaoProduto.getText());
        produto.setPrecocusto(txfPrecoCusto.getText());
        produto.setPrecovenda(txfPrecoVenda.getText());
        produto.setUnidade(txfUnidade.getText());
        
        if (dao.save(produto)) {
           txfDescricaoProduto.setText("");
           txfPrecoCusto.setText("");
           txfPrecoVenda.setText("");
           txfUnidade.setText("");
                               
            showAlert(Alert.AlertType.CONFIRMATION, "Salvo!", "Produto Salvo!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Erro!", "Produto não salvo!");
        }
        
    }

    @FXML
    private void alterarProduto(ActionEvent event) {
        Produto produto = new Produto();
        produto.setDescricaoproduto(txfDescricaoProduto.getText());
        produto.setPrecocusto(txfPrecoCusto.getText());
        produto.setPrecovenda(txfPrecoVenda.getText());
        produto.setUnidade(txfUnidade.getText());
        
        if (dao.update(produto)) {
           txfDescricaoProduto.setText("");
           txfPrecoCusto.setText("");
           txfPrecoVenda.setText("");
           txfUnidade.setText("");
                     
            obsList.clear();
            obsList = FXCollections.observableArrayList(dao.listClient());
            tbUser.setItems(obsList);
            tbUser.refresh();
            showAlert(Alert.AlertType.CONFIRMATION, "Alterou!", "Produto Alterado!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Erro!", "Produto não foi alterado!");
        }
    }

    @FXML
    private void listarProduto(ActionEvent event) {
        tbcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcDescricaoProduto.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getDescricaoproduto()));
        tbcPrecoCusto.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getPrecocusto()));
        tbcPrecoVenda.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getPrecovenda()));
        tbcUnidade.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getUnidade()));
      
        if (txfPesquisar.getText().isEmpty()) {
            obsList.clear();
            obsList = FXCollections.observableArrayList(dao.listClient());
            tbUser.getItems().clear();
            tbUser.setItems(obsList);
            tbUser.refresh();
        } else {
            obsList = FXCollections.observableArrayList(dao.searchClient(txfPesquisar.getText().trim()));
            tbUser.setItems(obsList);
            tbUser.refresh();
                   
        }
    }

    @FXML
    private void deletarProduto(ActionEvent event) {
         if (dao.delete(selected)) {
             txfDescricaoProduto.setText("");
           txfPrecoCusto.setText("");
           txfPrecoVenda.setText("");
           txfUnidade.setText("");
            
            
            tbUser.getItems().remove(selected);
            obsList.remove(selected);
            tbUser.refresh();

            showAlert(Alert.AlertType.CONFIRMATION, "Deletou!", "Produto Deletou!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Erro!", "Produto não deletou!");
        }
    }
    
}
