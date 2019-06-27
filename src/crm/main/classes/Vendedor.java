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
public class Vendedor {

    private int id;
    private String nome;
    private String email;
    private ArrayList<Interacao> interacoes = new ArrayList<>();

    /**
     *
     */
    public Vendedor() {
    }

    /**
     *
     * @param nome
     * @param email
     */
    public Vendedor(String nome, String email) {
        this.nome = nome;
        this.email = email;
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
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public ArrayList<Interacao> getInteracoes() {
        return interacoes;
    }

    /**
     *
     * @param interacoes
     */
    public void setInteracoes(ArrayList<Interacao> interacoes) {
        this.interacoes = interacoes;
    }

    @Override
    public String toString() {
        String interacoesString = "";
        for (Interacao interacao : interacoes) {
            interacoesString += interacao.toString();
        }
        return "Nome: " + nome + "; " 
                + "E-mail: " + email + "; " 
                + "Interações: " + interacoesString + "; ";
    }
    
}
