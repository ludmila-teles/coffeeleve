package coffeeleve.controllers;

import coffeeleve.dao.FornecedorDao;
import coffeeleve.models.Fornecedor;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class FXMLCadastrarFornecedorController implements Initializable{

    private Label label;
    @FXML
    private AnchorPane anpMain;
    @FXML
    private TextField txfRazaoSocial;
    @FXML
    private TextField txfNomeFantasia;
    @FXML
    private TextField txfCnpj;
    @FXML
    private TextField txfTelefone;
    @FXML
    private TextField txfEmail;
    @FXML
    private TableView<Fornecedor> tbUser;
    @FXML
    private TableColumn<Fornecedor, String> tbcId;
    @FXML
    private TableColumn<Fornecedor, String> tbcNomeFantasia;
    @FXML
    private TableColumn<Fornecedor, String> tbcCnpj;
    @FXML
    private TableColumn<Fornecedor, String> tbcTel;
    @FXML
    private TableColumn<Fornecedor, String> tbcEmail;
    @FXML
    private TextField txfPesquisar;
    @FXML
    private TableColumn<Fornecedor, String> tbcRazaoSocial;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnListar;
    @FXML
    private Button btnDeletar;

    private FornecedorDao dao = new FornecedorDao();
    private ObservableList<Fornecedor> obsList = FXCollections.observableArrayList();
    private Fornecedor selected;
    
//     private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//
//        Fornecedor fornecedor = new Fornecedor();
//        fornecedor.setRazaosocial("Coffee Leve");
//        fornecedor.setNomefantasia("Coffee Leve");
//        dao.save(fornecedor);
//
//        label.setText("Hello World!");
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        Stage stage = (Stage) anpMain.getScene().getWindow();
//        stage.setResizable(false);

        tbUser.setOnMouseClicked((event) -> {
            selected = tbUser.getSelectionModel().getSelectedItem();

            txfRazaoSocial.setText(selected.getRazaosocial());
            txfNomeFantasia.setText(selected.getNomefantasia());
            txfCnpj.setText(selected.getCnpj());
            txfTelefone.setText(selected.getTel());
            txfEmail.setText(selected.getEmail());
        });
    }
    
    @FXML
    private void salvarFornecedor(ActionEvent event) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setRazaosocial(txfRazaoSocial.getText());
        fornecedor.setNomefantasia(txfNomeFantasia.getText());
        fornecedor.setCnpj(txfCnpj.getText());
        fornecedor.setTel(txfTelefone.getText());
        fornecedor.setEmail(txfEmail.getText());

        if (dao.save(fornecedor)) {
            txfRazaoSocial.setText("");
            txfNomeFantasia.setText("");
            txfCnpj.setText("");
            txfTelefone.setText("");
            txfEmail.setText("");
                      
            showAlert(Alert.AlertType.CONFIRMATION, "Salvo!", "Fornecedor Salvo!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Erro!", "Fornecedor não salvo!");
        }
        
    }

    @FXML
    private void alterarFornecedor(ActionEvent event) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(selected.getId());
        fornecedor.setRazaosocial(txfRazaoSocial.getText());
        fornecedor.setNomefantasia(txfNomeFantasia.getText());
        fornecedor.setCnpj(txfCnpj.getText());
        fornecedor.setTel(txfTelefone.getText());
        fornecedor.setEmail(txfEmail.getText());
        
        if (dao.update(fornecedor)) {
            txfRazaoSocial.setText("");
            txfNomeFantasia.setText("");
            txfCnpj.setText("");
            txfTelefone.setText("");
            txfEmail.setText("");
         
            
            obsList.clear();
            obsList = FXCollections.observableArrayList(dao.listClient());
            tbUser.setItems(obsList);
            tbUser.refresh();
            showAlert(Alert.AlertType.CONFIRMATION, "Alterou!", "Fornecedor Alterado!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Erro!", "Fornecedor não foi alterado!");
        }
    }


    @FXML
    private void deletarFornecedor(ActionEvent event) {
        if (dao.delete(selected)) {
            txfRazaoSocial.setText("");
            txfNomeFantasia.setText("");
            txfCnpj.setText("");
            txfTelefone.setText("");
            txfEmail.setText("");
            
            
            tbUser.getItems().remove(selected);
            obsList.remove(selected);
            tbUser.refresh();

            showAlert(Alert.AlertType.CONFIRMATION, "Deletou!", "Fornecedor Deletou!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Erro!", "Fornecedor não deletou!");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert dialogoErro = new Alert(alertType);
        dialogoErro.setTitle(title);
        dialogoErro.setHeaderText(title);
        dialogoErro.setContentText(message);
        dialogoErro.showAndWait();
    }
    
    @FXML
    private void listarFornecedor(ActionEvent event) {
        tbcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcRazaoSocial.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getRazaosocial()));
        tbcNomeFantasia.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getNomefantasia()));
        tbcCnpj.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getCnpj()));
        tbcTel.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getTel()));
        tbcEmail.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEmail()));

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
    
}
