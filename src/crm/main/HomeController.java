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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller da tela inicial
 * 
 * @author Arthur
 */
public class HomeController implements Initializable {
    
    /**
     * Titulo da tela
     */
    @FXML
    private Label label;
    
    /**
     * Botão de login
     */
    @FXML
    private Button button;
    
    /**
     * Campo do e-mail
     */
    @FXML
    private TextField emailField;
    
    /**
     * Campo de senha
     */
    @FXML
    private PasswordField passField;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Loga no sistema e envia para a tela de gerenciar interações
     * 
     * @param event 
     */
    @FXML
    private void logar(ActionEvent event) {
        Crm.trocaTela("GerenciarInteracoes.fxml");
    }
    
}
