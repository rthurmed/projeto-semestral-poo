/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.main.app;

import crm.main.classes.Contato;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author arthur
 */
public class CadastrarEmpresaController implements Initializable {

    private ObservableList listaContatos;
    
    @FXML
    private TextField razaoSocialField;
    @FXML
    private TextField nomeFantasiaField;
    @FXML
    private TextField cidadeField;
    @FXML
    private TextField siteField;
    @FXML
    private ComboBox<?> setorCombo;
    @FXML
    private TextField contatoNomeField;
    @FXML
    private TextField contatoCargoField;
    @FXML
    private Button buttonAddContato;
    @FXML
    private TableView<?> contatosTable;
    @FXML
    private Button buttonCadastrar;
    @FXML
    private Button buttonCancelar;
    @FXML
    private TableColumn<?, ?> contatosTableNome;
    @FXML
    private TableColumn<?, ?> contatosTableCargo;
    @FXML
    private Label status;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaContatos = contatosTable.getItems();
        
        contatosTableNome.setCellValueFactory(new PropertyValueFactory("nome"));
        contatosTableCargo.setCellValueFactory(new PropertyValueFactory("cargo"));
    }    

    @FXML
    private void addContato(ActionEvent event) {
        Contato contato = new Contato();
        contato.setNome(contatoNomeField.getText());
        contato.setCargo(contatoCargoField.getText());
        listaContatos.add(contato);
    }

    @FXML
    private void cadastrar(ActionEvent event) {
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }
    
}
