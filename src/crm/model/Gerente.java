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
public class Gerente extends Vendedor{

    /**
     *
     */
    public Gerente() {
    }

    /**
     *
     * @param nome
     * @param email
     */
    public Gerente(String nome, String email) {
        super(nome, email);
    }
    
    /**
     *
     * @return
     */
    public String gerarRelatorio() {
        return "relatorio";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
