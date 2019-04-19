/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm;

import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class Vendedor {

    private String nome;
    private String email;
    private ArrayList<Interacao> interacoes = new ArrayList<>();

    public Vendedor() {
    }

    public Vendedor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Interacao> getInteracoes() {
        return interacoes;
    }

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
