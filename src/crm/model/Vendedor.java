/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.model;

import java.util.ArrayList;

/**
 * Representação de um usuário do sistema. Principal utilizador. É o usuário responsavel por 
 * gerenciar as informações presentes no sistema. Deve registrar suas interações.
 * Pode:
 * <ul> 
 *  <li>Gerenciar interações</li>
 *  <li>Gerenciar empresas</li>
 *  <li>Transormar empresas em clientes atuais</li>
 *  <li>Gerenciar contatos</li>
 *  <li>Gerenciar serviços</li>
 * </ul>
 * 
 * @author Arthur
 */
public class Vendedor {

    /**
     * ID do vendedor no banco de dados. Quando o vendedor não foi cadastrado seu valor é 0.
     */
    private int id;
    
    /**
     * Nome do usuário. Usado para diferenciar melhor quem realizou qual interação
     */
    private String nome;
    
    /**
     * Email usado para realização do login
     */
    private String email;
    
    /**
     * Lista de todas interações realizadas
     */
    private ArrayList<Interacao> interacoes = new ArrayList<>();

    /**
     * Constrói um objeto de vendedor
     */
    public Vendedor() {
    }

    /**
     * Constrói um objeto de vendedor a partir dos parâmetros
     * 
     * @param nome
     * @param email
     */
    public Vendedor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    /**
     * Retorna o ID do vendedor
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Altera o ID do vendedor
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome do vendedor
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do vendedor
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o email do vendedor
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Alterna o email do vendedor
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorno uma lista com todas interações do vendedor
     * 
     * @return interacoes
     */
    public ArrayList<Interacao> getInteracoes() {
        return interacoes;
    }

    /**
     * Altera toda lista de interações
     * 
     * @param interacoes
     */
    public void setInteracoes(ArrayList<Interacao> interacoes) {
        this.interacoes = interacoes;
    }
    
    /**
     * Adiciona uma interação à lista de interações
     * 
     * @param interacao 
     */
    public void addInteracao(Interacao interacao) {
        this.interacoes.add(interacao);
    }

    /**
     * Produz um string com todos atributos
     * 
     * @return string
     */
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
