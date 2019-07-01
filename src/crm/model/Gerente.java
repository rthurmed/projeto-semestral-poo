/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.model;

/**
 * Representação de um usuário do sistema. Pode realizar todas atividades que um 
 * vendedor, gerenciar vendedores e gerar um relatório de interações.
 * 
 * @author Arthur
 */
public class Gerente extends Vendedor{

    /**
     * Constrói um objeto de gerente
     */
    public Gerente() {
    }

    /**
     * Constrói um objeto de gerente a partir dos parâmetros
     * 
     * @param nome
     * @param email
     */
    public Gerente(String nome, String email) {
        super(nome, email);
    }
    
    /**
     * Gera um relatório baseado nas interações dos vendedores
     * 
     * @return string
     */
    public String gerarRelatorio() {
        return "relatorio";
    }

    /**
     * Produz um string com todos atributos
     * 
     * @return string
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
