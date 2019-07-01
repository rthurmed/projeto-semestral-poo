/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.model;

/**
 * Representação de um membro de uma empresa. Um contato vai ser sempre referenciado em uma Interação
 * 
 * @author Arthur
 */
public class Contato {
    
    /**
     * ID do contato no banco de dados. Quando o contato não foi cadastrado seu valor é 0.
     */
    private int id;
    
    /**
     * Nome da pessoa contatada
     */
    private String nome;
    
    /**
     * Cargo da pessoa contatada
     */
    private String cargo;

    /**
     * Constrói um objeto de contato
     */
    public Contato() {
    }

    /**
     * Constrói um objeto de contato a partir dos parâmetros
     *  
     * @param nome
     * @param cargo
     */
    public Contato(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    /**
     * Retorna o ID do contato
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Altera o ID do contato
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome do contato
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do contato
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o cargo do contato
     * 
     * @return cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Altera o cargo do contato
     * 
     * @param cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Produz um string com todos atributos
     * 
     * @return string
     */
    @Override
    public String toString() {
        return "Nome: " + nome + "; " 
                + "Cargo: " + cargo + "; ";
    }
    
}
