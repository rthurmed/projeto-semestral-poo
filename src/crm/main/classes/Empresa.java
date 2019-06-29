/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.main.classes;

import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class Empresa {
    
    private int id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cidade;
    private String site;
    private Setor setor;
    private ArrayList<Contato> contatos = new ArrayList();

    /**
     *
     */
    public Empresa() {
    }

    /**
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
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     *
     * @param razaoSocial
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     *
     * @return
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     *
     * @param nomeFantasia
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     *
     * @return
     */
    public String getCidade() {
        return cidade;
    }

    /**
     *
     * @param cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     *
     * @return
     */
    public String getSite() {
        return site;
    }

    /**
     *
     * @param site
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     *
     * @return
     */
    public Setor getSetor() {
        return setor;
    }

    /**
     *
     * @param setor
     */
    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    /**
     *
     * @return
     */
    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    /**
     *
     * @param contatos
     */
    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }
    
    /**
     *
     * @param contato
     */
    public void addContato(Contato contato) {
        this.contatos.add(contato);
    }

    @Override
    public String toString() {
        return "Razão Social: " + razaoSocial + "; "
                + "Nome Fantasia: " + nomeFantasia + "; "
                + "Cidade: " + cidade + "; " 
                + "Site: " + site + "; "
                + "Setor: " + setor.toString() + "; ";
    }
    
}
