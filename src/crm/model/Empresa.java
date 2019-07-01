/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.model;

import java.util.ArrayList;

/**
 * Representação de uma empresa que os vendedores tenham interagido com.
 * 
 * @author Arthur
 */
public class Empresa {
    
    /**
     * ID da empresa no banco de dados. Quando a empresa não foi cadastrada seu valor é 0.
     */
    private int id;
    
    /**
     * Razão social da empresa
     */
    private String razaoSocial;
    
    /**
     * Nome popular da empresa
     */
    private String nomeFantasia;
    
    /**
     * Cidade da sede ou filial contatada
     */
    private String cidade;
    
    /**
     * Endereço web da empresa
     */
    private String site;
    
    /**
     * Setor a qual a empresa é classificada
     */
    private Setor setor;
    
    /**
     * Lista de todos contatos relacionados à empresa
     */
    private ArrayList<Contato> contatos = new ArrayList();

    /**
     * Constrói um objeto de empresa
     */
    public Empresa() {
    }

    /**
     * Constrói um objeto de empresa a partir dos parâmetros
     * 
     * @param razaoSocial
     * @param nomeFantasia
     * @param cidade
     * @param site
     * @param setor
     */
    public Empresa(String razaoSocial, String nomeFantasia, String cidade, String site, Setor setor) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cidade = cidade;
        this.site = site;
        this.setor = setor;
    }

    /**
     * Retorna o ID da empresa
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Altera o ID da empresa
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna a razão social da empresa
     * 
     * @return razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * Altera a razão social da empresa
     * 
     * @param razaoSocial
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * Retorna o nome fantasia da empresa
     * 
     * @return nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * Altera o nome fantasia da empresa
     * 
     * @param nomeFantasia
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * Retorna a cidade da empresa
     * 
     * @return cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Altera a cidade da empresa
     * 
     * @param cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Retorna site da empresa
     * 
     * @return site
     */
    public String getSite() {
        return site;
    }

    /**
     * Altera site da empresa
     * 
     * @param site
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * Retorna setor da empresa
     * 
     * @return setor
     */
    public Setor getSetor() {
        return setor;
    }

    /**
     * Altera o setor da empresa
     * 
     * @param setor
     */
    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    /**
     * Retorna uma lista com todos contatos da empresa
     * 
     * @return
     */
    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    /**
     * Altera toda lista de contatos
     * 
     * @param contatos
     */
    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }
    
    /**
     * Adiciona um contato à lista de contatos
     * 
     * @param contato
     */
    public void addContato(Contato contato) {
        this.contatos.add(contato);
    }

    /**
     * Produz um string com todos atributos
     * 
     * @return string
     */
    @Override
    public String toString() {
        return "Razão Social: " + razaoSocial + "; "
                + "Nome Fantasia: " + nomeFantasia + "; "
                + "Cidade: " + cidade + "; " 
                + "Site: " + site + "; "
                + "Setor: " + setor.toString() + "; ";
    }
    
}
