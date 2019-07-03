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
     * Lista de todas ligações realizadas
     */
    private ArrayList<Ligacao> ligacoes = new ArrayList<>();
    
    /**
     * Lista de todos emails enviados
     */
    private ArrayList<Email> emails = new ArrayList<>();
    
    /**
     * Lista de todas reuniões realizadas
     */
    private ArrayList<Reuniao> reunioes = new ArrayList<>();

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
     * Retorno uma lista com todas ligações do vendedor
     * 
     * @return interacoes
     */
    public ArrayList<Ligacao> getLigacoes() {
        return ligacoes;
    }

    /**
     * Altera toda lista de ligações
     * 
     * @param ligacoes
     */
    public void setLigacoes(ArrayList<Ligacao> ligacoes) {
        this.ligacoes = ligacoes;
    }
    
    /**
     * Adiciona uma ligação à lista de ligações
     * 
     * @param ligacao 
     */
    public void addLigacao(Ligacao ligacao) {
        this.ligacoes.add(ligacao);
    }

    /**
     * Retorno uma lista com todos emails do vendedor
     * 
     * @return emails
     */
    public ArrayList<Email> getEmails() {
        return emails;
    }

    /**
     * Altera toda lista de emails
     * 
     * @param emails
     */
    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }
    
    /**
     * Adiciona um email à lista de emails
     *
     * @param email
     */
    public void addEmail(Email email) {
        this.emails.add(email);
    }

    /**
     * Retorna uma lista com todas reuniões do vendedor
     *
     * @return reunioes
     */
    public ArrayList<Reuniao> getReunioes() {
        return reunioes;
    }

    /**
     * Altera toda lista de reuniões
     *
     * @param reunioes
     */
    public void setReunioes(ArrayList<Reuniao> reunioes) {
        this.reunioes = reunioes;
    }
    
    /**
     * Adiciona uma reunião à lista de reuniões
     *
     * @param reuniao
     */
    public void addReuniao(Reuniao reuniao) {
        this.reunioes.add(reuniao);
    }

    /**
     * Produz um string com todos atributos
     * 
     * @return string
     */
    @Override
    public String toString() {
        String ligacoesString = "";
        String emailsString = "";
        String reunioesString = "";
        for (Ligacao ligacao : ligacoes) {
            ligacoesString += ligacao.toString();
        }
        for (Email email1 : emails) {
            emailsString += email1.toString();
        }
        for (Reuniao reuniao : reunioes) {
            reunioesString += reuniao.toString();
        }
        return "Nome: " + nome + "; " 
                + "E-mail: " + email + "; " 
                + "Interações: " 
                + "Ligações: " + ligacoesString + ", " 
                + "Email: " + emailsString + ", "
                + "Reuniões: " + reunioesString + ";";
    }
    
}
