/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.main;

import crm.dao.SetorDAO;
import crm.model.Setor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller da tela de gerenciar setores
 *
 * @author arthur
 */
public class GerenciarSetoresController implements Initializable {

    /**
     * DAO de Setor
     */
    private final SetorDAO setorDao = new SetorDAO();
    
    /**
     * Lista de setores
     */
    private ObservableList setores;
    
    /**
     * Setor selecionado na lista
     */
    private Setor setorSelecionado;
    
    /**
     * Tabela de setores
     */
    @FXML
    private TableView<?> setoresTable;
    
    /**
     * Coluna de codigo da tabela de setores
     */
    @FXML
    private TableColumn<?, ?> setorTableCodigo;
    
    /**
     * Coluna de descrição da tabela de setores
     */
    @FXML
    private TableColumn<?, ?> setorTableDescricao;
    
    /**
     * Campo de código do setor
     */
    @FXML
    private TextField codigoField;
    
    /**
     * Campo de descrição do setor
     */
    @FXML
    private TextField descricaoField;
    
    /**
     * Output de informações
     */
    @FXML
    private Label status;
    
    /**
     * Botão de cadastrar setor
     */
    @FXML
    private Button buttonCadastrar;
    
    /**
     * Botão de atualizar setor
     */
    @FXML
    private Button buttonAtualizar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setores = setoresTable.getItems();
        setorTableCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        setorTableDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        for (Setor setor : setorDao.getAll()) {
            setores.add(setor);
        }
    }    

    /**
     * Exclui o setor selecionado
     * 
     * @param event 
     */
    @FXML
    private void excluirSetor(ActionEvent event) {
        setorSelecionado = (Setor) setoresTable.getSelectionModel().getSelectedItem();
        if(setorDao.delete(setorSelecionado)){
            setores.remove(setorSelecionado);
            status.setText("Setor " + setorSelecionado + " excluído com sucesso!");
            setorSelecionado = null;
        } else {
            status.setText("Não foi possível excluir o setor " + setorSelecionado.getDescricao() + ".");
        }
    }

    /**
     * Carrega no formulário os valores do setor selecionado
     * 
     * @param event 
     */
    @FXML
    private void carregarSetor(ActionEvent event) {
        setorSelecionado = (Setor) setoresTable.getSelectionModel().getSelectedItem();
        codigoField.setText(setorSelecionado.getCodigo());
        descricaoField.setText(setorSelecionado.getDescricao());
        status.setText("Setor " + setorSelecionado + " carregado com sucesso!");
    }

    /**
     * Cadastra um novo setor baseado nos valores do formulário
     * 
     * @param event 
     */
    @FXML
    private void cadastrarSetor(ActionEvent event) {
        buttonAtualizar.setDisable(true);
        buttonCadastrar.setDisable(true);
        
        Setor setor = new Setor();
        setor.setCodigo(codigoField.getText());
        setor.setDescricao(descricaoField.getText());
        if(setorDao.save(setor)){
            status.setText("Setor " + setor.getDescricao() + " cadastrado com sucesso!");
            setores.add(setor);
        } else {
            status.setText("Não foi possível cadastrar o setor " + setor.getDescricao() + ".");
        }
        
        buttonAtualizar.setDisable(false);
        buttonCadastrar.setDisable(false);        
    }

    /**
     * Atualiza os valores do setor carregado
     * 
     * @param event 
     */
    @FXML
    private void atualizarSetor(ActionEvent event) {
        if(setorSelecionado == null) {
            status.setText("Carregue um setor antes de atualizar.");
            return;
        }
        buttonAtualizar.setDisable(true);
        buttonCadastrar.setDisable(true);
        
        setorSelecionado.setCodigo(codigoField.getText());
        setorSelecionado.setDescricao(descricaoField.getText());
        if(setorDao.update(setorSelecionado)){
            status.setText("Setor " + setorSelecionado.getDescricao() + " atualizado com sucesso!");
        } else {
            status.setText("Não foi possível atualizar o setor " + setorSelecionado.getDescricao() + ".");
        }
        
        buttonAtualizar.setDisable(false);
        buttonCadastrar.setDisable(false);
    }
    
    /**
     * Envia para a tela de gerenciar empresas
     * 
     * @param event 
     */
    @FXML
    private void gotoGerenciarEmpresas(ActionEvent event) {
        Crm.trocaTela("GerenciarEmpresa.fxml");
    }
    
}
