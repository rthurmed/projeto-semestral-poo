/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.main;

import crm.dao.ContatoDAO;
import crm.dao.EmpresaDAO;
import crm.dao.SetorDAO;
import crm.model.Contato;
import crm.model.Empresa;
import crm.model.Setor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author arthur
 */
public class GerenciarEmpresaController implements Initializable {
    
    private EmpresaDAO empresaDAO = new EmpresaDAO();
    
    private ContatoDAO contatoDAO = new ContatoDAO();

    private ObservableList listaEmpresas;
    
    private ObservableList listaContatos;
    
    private ObservableList setoresOpcoes;
    
    private Empresa empresaSelecionada;
    
    private Contato contatoSelecionado;
    
    @FXML
    private TextField razaoSocialField;
    @FXML
    private TextField nomeFantasiaField;
    @FXML
    private TextField cidadeField;
    @FXML
    private TextField siteField;
    @FXML
    private ComboBox<Setor> setorCombo;
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
    private TableColumn<?, ?> contatosTableNome;
    @FXML
    private TableColumn<?, ?> contatosTableCargo;
    @FXML
    private Label status;
    @FXML
    private TableView<?> empresasTable;
    @FXML
    private TableColumn<?, ?> empresasTableNome;
    @FXML
    private TableColumn<?, ?> empresasTableCidade;
    @FXML
    private TableColumn<?, ?> empresasTableSite;
    @FXML
    private Button buttonAtualizar;

    /**
     * Initializes the controller class.
     * 
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setoresOpcoes = setorCombo.getItems();
        for (Setor setor : new SetorDAO().getAll()) {
            setoresOpcoes.add(setor);
        }
        
        contatosTableNome.setCellValueFactory(new PropertyValueFactory("nome"));
        contatosTableCargo.setCellValueFactory(new PropertyValueFactory("cargo"));
        listaContatos = contatosTable.getItems();
        
        empresasTableNome.setCellValueFactory(new PropertyValueFactory("nomeFantasia"));
        empresasTableCidade.setCellValueFactory(new PropertyValueFactory("cidade"));
        empresasTableSite.setCellValueFactory(new PropertyValueFactory("site"));
        
        listaEmpresas = empresasTable.getItems();
        for (Empresa empresa : empresaDAO.getAll()) {
            listaEmpresas.add(empresa);
        }
    }    

    @FXML
    private void addContato(ActionEvent event) {
        Contato contato = new Contato();
        contato.setNome(contatoNomeField.getText());
        contato.setCargo(contatoCargoField.getText());
        listaContatos.add(contato);
        status.setText("Adicionado contato " + contato.getNome() + ".");
    }


    @FXML
    private void carregarContato(ActionEvent event) {
        contatoSelecionado = (Contato) contatosTable.getSelectionModel().getSelectedItem();
        contatoNomeField.setText(contatoSelecionado.getNome());
        contatoCargoField.setText(contatoSelecionado.getCargo());
        status.setText("Carregado contato " + contatoSelecionado.getNome() + ".");
    }

    @FXML
    private void excluirContato(ActionEvent event) {
        contatoSelecionado = (Contato) contatosTable.getSelectionModel().getSelectedItem();
        contatoDAO.delete(contatoSelecionado);
        listaContatos.remove(contatoSelecionado);
        status.setText("Removido contato " + contatoSelecionado.getNome() + ".");
    }
    
    @FXML
    private void atualizarContato(ActionEvent event) {
        contatoSelecionado = (Contato) contatosTable.getSelectionModel().getSelectedItem();        
        listaContatos.remove(contatoSelecionado);
        Contato contato = new Contato();
        contato.setNome(contatoNomeField.getText());
        contato.setCargo(contatoCargoField.getText());
        listaContatos.add(contato);
        status.setText("Atualizado contato " + contato.getNome() + ".");
    }

    @FXML
    private void gotoGerenciarInteracoes(ActionEvent event) {
        Crm.trocaTela("GerenciarInteracoes.fxml");
    }

    @FXML
    private void excluirEmpresa(ActionEvent event) {
        empresaSelecionada = (Empresa) empresasTable.getSelectionModel().getSelectedItem();
        empresaDAO.delete(empresaSelecionada);
        listaEmpresas.remove(empresaSelecionada);
        status.setText("Removida empresa " + empresaSelecionada.getNomeFantasia() + ".");
    }

    @FXML
    private void carregarEmpresa(ActionEvent event) {
        empresaSelecionada = (Empresa) empresasTable.getSelectionModel().getSelectedItem();
        razaoSocialField.setText(empresaSelecionada.getRazaoSocial());
        nomeFantasiaField.setText(empresaSelecionada.getNomeFantasia());
        cidadeField.setText(empresaSelecionada.getCidade());
        siteField.setText(empresaSelecionada.getSite());
        setorCombo.getSelectionModel().select(empresaSelecionada.getSetor());
        listaContatos.clear();
        empresaDAO.getContatosFrom(empresaSelecionada);
        System.out.println(empresaSelecionada.getContatos());
        for (Contato contato : empresaSelecionada.getContatos()) {
            listaContatos.add(contato);
        }
        status.setText("Carregada empresa " + empresaSelecionada.getNomeFantasia() + "!");
    }

    @FXML
    private void cadastrarNovaEmpresa(ActionEvent event) {
        buttonAtualizar.setDisable(true);
        buttonCadastrar.setDisable(true);
        
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial(razaoSocialField.getText());
        empresa.setNomeFantasia(nomeFantasiaField.getText());
        empresa.setCidade(cidadeField.getText());
        empresa.setSite(siteField.getText());
        empresa.setSetor(setorCombo.getSelectionModel().getSelectedItem());
        
        for (Object contato : listaContatos) {
            empresa.addContato((Contato) contato);
        }
        
        if(empresaDAO.save(empresa)) {
            listaEmpresas.add(empresa);
            status.setText("Cadastrada nova empresa " + empresa.getNomeFantasia() + "!");
            empresaSelecionada = empresa;
        }else{
            status.setText("Não foi possível cadastrar um nova empresa.");
        }
        
        buttonAtualizar.setDisable(false);
        buttonCadastrar.setDisable(false);
    }

    @FXML
    private void atualizarEmpresa(ActionEvent event) {
        if (empresaSelecionada == null) {
            status.setText("Carregue uma empresa antes de atualizar.");
            return;
        }
        buttonAtualizar.setDisable(true);
        buttonCadastrar.setDisable(true);
        
        empresaSelecionada.setRazaoSocial(razaoSocialField.getText());
        empresaSelecionada.setNomeFantasia(nomeFantasiaField.getText());
        empresaSelecionada.setCidade(cidadeField.getText());
        empresaSelecionada.setSite(siteField.getText());
        empresaSelecionada.setSetor(setorCombo.getSelectionModel().getSelectedItem());
        
        empresaSelecionada.getContatos().clear();
        for (Object contato : listaContatos) {
            empresaSelecionada.addContato((Contato) contato);
        }
        
        if(empresaDAO.update(empresaSelecionada)) {            
            status.setText("Atualizada empresa " + empresaSelecionada.getNomeFantasia() + "!");
        }else{
            status.setText("Não foi possível atualizar a empresa.");
        }
        
        buttonAtualizar.setDisable(false);
        buttonCadastrar.setDisable(false);
    }
    
}
