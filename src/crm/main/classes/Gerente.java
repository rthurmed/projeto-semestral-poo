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
public class Gerente extends Vendedor{

    public Gerente() {
    }

    public Gerente(String nome, String email) {
        super(nome, email);
    }
    
    public String gerarRelatorio() {
        return "relatorio";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}