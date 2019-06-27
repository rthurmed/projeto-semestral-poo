/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.main.classes;

/**
 *
 * @author Arthur
 */
public class Contato {
    
    private int id;
    private String nome;
    private String cargo;
    private Empresa empresa;

    /**
     *
     */
    public Contato() {
    }

    /**
     *
     * @param nome
     * @param cargo
     * @param empresa
     */
    public Contato(String nome, String cargo, Empresa empresa) {
        this.nome = nome;
        this.cargo = cargo;
        this.empresa = empresa;
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
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getCargo() {
        return cargo;
    }

    /**
     *
     * @param cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     *
     * @return
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     *
     * @param empresa
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "; " 
                + "Cargo: " + cargo + "; " 
                + "Empresa: " + empresa.toString() + "; ";
    }
    
}
