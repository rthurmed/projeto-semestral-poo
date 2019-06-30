/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.model;

/**
 *
 * @author Arthur
 */
public class Contato {
    
    private int id;
    private String nome;
    private String cargo;

    /**
     *
     */
    public Contato() {
    }

    /**
     *
     * @param nome
     * @param cargo
     */
    public Contato(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
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

    @Override
    public String toString() {
        return "Nome: " + nome + "; " 
                + "Cargo: " + cargo + "; ";
    }
    
}
