/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.main.classes;

/**
 *
 * @author Pichau
 */
public class Empresa {
    
    private String razaoSocial;
    private String nomeFantasia;
    private String cidade;
    private String site;
    private Setor setor;

    public Empresa() {
    }

    public Empresa(String razaoSocial, String nomeFantasia, String cidade, String site, Setor setor) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cidade = cidade;
        this.site = site;
        this.setor = setor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
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
