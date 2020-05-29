package coffeeleve.controllers;

import java.net.URL;
import java.sql.SQLException;
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
import javafx.stage.Stage;
import coffeeleve.models.Cliente;
import coffeeleve.dao.ClienteDao;


public class FXMLCadastrarClienteController implements Initializable {

    private Label label;
    @FXML
    private TextField txfNome;
    @FXML
    private TextField txfSobrenome;
    @FXML
    private TextField txfCpf;
    @FXML
    private TextField txfPhone;
    @FXML
    private TableView<Cliente> tbUser;
    @FXML
    private TableColumn<Cliente, String> tbcId;
    @FXML
    private TableColumn<Cliente, String> tbcNome;
    @FXML
    private TableColumn<Cliente, String> tbcSobreNome;
    @FXML
    private TableColumn<Cliente, String> tbcCpf;
    @FXML
    private TableColumn<Cliente, String> tbcTel;
    @FXML
    private Button button;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private AnchorPane anpMain;
    @FXML
    private TextField txfProcura;

    private ClienteDao dao = new ClienteDao();
    private ObservableList<Cliente> obsList = FXCollections.observableArrayList();
    private Cliente selected;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");

        Cliente cliente = new Cliente();
        cliente.setNome("Ludmila");
        cliente.setSobrenome("Teles");
        dao.save(cliente);

        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        Stage stage = (Stage) anpMain.getScene().getWindow();
//        stage.setResizable(false);

        tbUser.setOnMouseClicked((event) -> {
            selected = tbUser.getSelectionModel().getSelectedItem();

            txfNome.setText(selected.getNome());
            txfSobrenome.setText(selected.getSobrenome());
            txfCpf.setText(selected.getCpf());
            txfPhone.setText(selected.getTelefone());
        });
    }

    @FXML
    private void salvarCliente(ActionEvent event) {
        Cliente cliente = new Cliente();
        cliente.setNome(txfNome.getText());
        cliente.setSobrenome(txfSobrenome.getText());
        cliente.setCpf(txfCpf.getText());
        cliente.setTelefone(txfPhone.getText());

        if (dao.save(cliente)) {
            txfNome.setText("");
            txfSobrenome.setText("");
            txfCpf.setText("");
            txfPhone.setText("");
                      
            showAlert(Alert.AlertType.CONFIRMATION, "Salvo!", "Cliente Salvo!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Erro!", "Cliente não salvo!");
        }

    }

    @FXML
        private void alterarCliente(ActionEvent event) {
        Cliente cliente = new Cliente();
        cliente.setId(selected.getId());
        cliente.setNome(txfNome.getText());
        cliente.setSobrenome(txfSobrenome.getText());
        cliente.setCpf(txfCpf.getText());
        cliente.setTelefone(txfPhone.getText());
        
        if (dao.update(cliente)) {
            txfNome.setText("");
            txfSobrenome.setText("");
            txfCpf.setText("");
            txfPhone.setText("");
            
            obsList.clear();
            obsList = FXCollections.observableArrayList(dao.listClient());
            tbUser.setItems(obsList);
            tbUser.refresh();
            showAlert(Alert.AlertType.CONFIRMATION, "Alterou!", "Cliente Alterado!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Erro!", "Cliente não foi alterado!");
        }
    }

    @FXML
    private void procurarCliente(ActionEvent event) {
//        if(!obsList.isEmpty() || obsList!=null)
//                obsList.clear();
//        
        
        tbcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcNome.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getNome()));
        tbcSobreNome.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getSobrenome()));
        tbcCpf.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getCpf()));
        tbcTel.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getTelefone()));

        if (txfProcura.getText().isEmpty()) {
            obsList.clear();
            obsList = FXCollections.observableArrayList(dao.listClient());
            tbUser.getItems().clear();
            tbUser.setItems(obsList);
            tbUser.refresh();
        } else {
            obsList = FXCollections.observableArrayList(dao.searchClient(txfProcura.getText().trim()));
            tbUser.setItems(obsList);
            tbUser.refresh();
                   
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
    private void deleteCliente(ActionEvent event) {
        if (dao.delete(selected)) {
            txfNome.setText("");
            txfSobrenome.setText("");
            txfCpf.setText("");
            txfPhone.setText("");
            
            
            tbUser.getItems().remove(selected);
            obsList.remove(selected);
            tbUser.refresh();

            showAlert(Alert.AlertType.CONFIRMATION, "Deletou!", "Cliente Deletou!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Erro!", "Cliente não deletou!");
        }
    }

}
