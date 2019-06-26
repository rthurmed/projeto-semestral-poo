/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.main.app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author arthur
 */
public class GerenciarInteracoesController implements Initializable {

    @FXML
    private TableView<?> ligacoesTable;
    @FXML
    private TableView<?> emailsTable;
    @FXML
    private TableView<?> reunioesTable;
    @FXML
    private TableView<?> contatosTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gotoEditarInteracao(ActionEvent event) {
    }

    @FXML
    private void gotoEditarContato(ActionEvent event) {
    }
    
}
