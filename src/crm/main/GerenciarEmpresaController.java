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
 * FXML Controller da tela de gerenciar empresa
 *
 * @author arthur
 */
public class GerenciarEmpresaController implements Initializable {
    
    /**
     * Dao de empresa
     */
    private final EmpresaDAO empresaDAO = new EmpresaDAO();
    
    /**
     * DAO de contato
     */
    private final ContatoDAO contatoDAO = new ContatoDAO();

    /**
     * Lista de empresas
     */
    private ObservableList listaEmpresas;
    
    /**
     * Lista de contatos
     */
    private ObservableList listaContatos;
    
    /**
     * Lista de setores para o combobox
     */
    private ObservableList setoresOpcoes;
    
    /**
     * Empresa selecionada na tabela
     */
    private Empresa empresaSelecionada;
    
    /**
     * Contato selecionado na tabela
     */
    private Contato contatoSelecionado;
    
    /**
     * Campo da razão social da empresa
     */
    @FXML
    private TextField razaoSocialField;
    
    /**
     * Campo do nome fantasia da empresa
     */
    @FXML
    private TextField nomeFantasiaField;
    
    /**
     * Campo da cidade da empresa
     */
    @FXML
    private TextField cidadeField;
    
    /**
     * Campo do site da empresa
     */
    @FXML
    private TextField siteField;
    
    /**
     * Combo box do setor da empresa
     */
    @FXML
    private ComboBox<Setor> setorCombo;
    
    /**
     * Campo de nome do contato
     */
    @FXML
    private TextField contatoNomeField;
    
    /**
     * Campo de cargo do contato
     */
    @FXML
    private TextField contatoCargoField;
    
    /**
     * Botão de adicionar contato
     */
    @FXML
    private Button buttonAddContato;
    
    /**
     * Tabela de contatos
     */
    @FXML
    private TableView<?> contatosTable;
    
    /**
     * Botão de cadastrar empresa
     */
    @FXML
    private Button buttonCadastrar;
    
    /**
     * Coluna de nome da tabela de contatos
     */
    @FXML
    private TableColumn<?, ?> contatosTableNome;
    
    /**
     * Coluna de cargo da tabela de contatos
     */
    @FXML
    private TableColumn<?, ?> contatosTableCargo;
    
    /**
     * Output de informações
     */
    @FXML
    private Label status;
    
    /**
     * Tabela de empresas
     */
    @FXML
    private TableView<?> empresasTable;
    
    /**
     * Coluna de nome da tabela de empresas
     */
    @FXML
    private TableColumn<?, ?> empresasTableNome;
    
    /**
     * Coluna de cidade da tabela de empresas
     */
    @FXML
    private TableColumn<?, ?> empresasTableCidade;
    
    /**
     * Coluna de site na tabela de empresas
     */
    @FXML
    private TableColumn<?, ?> empresasTableSite;
    
    /**
     * Botão de atualizar empresa
     */
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

    /**
     * Adiciona um novo contato a lista de contatos da empresa
     * 
     * @param event 
     */
    @FXML
    private void addContato(ActionEvent event) {
        Contato contato = new Contato();
        contato.setNome(contatoNomeField.getText());
        contato.setCargo(contatoCargoField.getText());
        listaContatos.add(contato);
        status.setText("Adicionado contato " + contato.getNome() + ".");
    }

    /**
     * Carrega no formulário os valores do contato selecionado
     * 
     * @param event 
     */
    @FXML
    private void carregarContato(ActionEvent event) {
        contatoSelecionado = (Contato) contatosTable.getSelectionModel().getSelectedItem();
        contatoNomeField.setText(contatoSelecionado.getNome());
        contatoCargoField.setText(contatoSelecionado.getCargo());
        status.setText("Carregado contato " + contatoSelecionado.getNome() + ".");
    }

    /**
     * Exclui o contato selecionado
     * 
     * @param event 
     */
    @FXML
    private void excluirContato(ActionEvent event) {
        contatoSelecionado = (Contato) contatosTable.getSelectionModel().getSelectedItem();
        if(contatoDAO.delete(contatoSelecionado)) {
            listaContatos.remove(contatoSelecionado);
            status.setText("Removido contato " + contatoSelecionado.getNome() + ".");
        } else {
            status.setText("Não foi possível remover contato " + contatoSelecionado.getNome() + ".");
        }
    }
    
    /**
     * Atualiza os valores do contato carregado
     * 
     * @param event 
     */
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

    /**
     * Exclui a empresa selecionada
     * 
     * @param event 
     */
    @FXML
    private void excluirEmpresa(ActionEvent event) {
        empresaSelecionada = (Empresa) empresasTable.getSelectionModel().getSelectedItem();
        if(empresaDAO.delete(empresaSelecionada)){
            listaEmpresas.remove(empresaSelecionada);
            status.setText("Removida empresa " + empresaSelecionada.getNomeFantasia() + "!");
            empresaSelecionada = null;
        } else {
            status.setText("Não foi possível excluir " + empresaSelecionada.getNomeFantasia() + ".");
        }
    }

    /**
     * Carrega no formulário os valores da empresa selecionada
     * 
     * @param event 
     */
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
        for (Contato contato : empresaSelecionada.getContatos()) {
            listaContatos.add(contato);
        }
        status.setText("Carregada empresa " + empresaSelecionada.getNomeFantasia() + "!");
    }

    /**
     * Cadastra uma nova empresa baseada nos valores do formulário
     * 
     * @param event 
     */
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

    /**
     * Atualiza os valores da empresa carregada
     * 
     * @param event 
     */
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
            listaEmpresas.remove(empresaSelecionada);
            listaEmpresas.add(empresaSelecionada);
        }else{
            status.setText("Não foi possível atualizar a empresa.");
        }
        
        buttonAtualizar.setDisable(false);
        buttonCadastrar.setDisable(false);
    }

    /**
     * Envia para a tela de gerenciar interações
     * 
     * @param event 
     */
    @FXML
    private void gotoGerenciarInteracoes(ActionEvent event) {
        Crm.trocaTela("GerenciarInteracoes.fxml");
    }
    
    /**
     * Envia para a tela de gerenciar setores
     * 
     * @param event 
     */
    @FXML
    private void gotoGerenciarSetores(ActionEvent event) {
        Crm.trocaTela("GerenciarSetores.fxml");
    }
    
}
