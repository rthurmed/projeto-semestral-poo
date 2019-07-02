/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * [Não implementada]
 * FXML Controller da tela gerenciar interações
 *
 * @author arthur
 */
public class GerenciarInteracoesController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Envia para a tela de gerenciar empresa
     * 
     * @param event 
     */
    @FXML
    private void gotoGerenciarEmpresa(ActionEvent event) {
        Crm.trocaTela("GerenciarEmpresa.fxml");
    }
    
}
