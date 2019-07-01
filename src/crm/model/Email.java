/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.model;

import java.util.Date;

/**
 * Representação de uma troca de e-mails realizada com um cliente.
 * 
 * @author Arthur
 */
public class Email extends Interacao{
    
    /**
     * O endereço de e-mail contatado
     */
    private String destinatario;

    /**
     * Constrói um objeto de e-mail
     */
    public Email() {
    }

    /**
     * Constrói um objeto de e-mail a partir dos parâmetros
     * 
     * @param destinatario
     * @param dia
     * @param dataRetorno
     * @param efetiva
     * @param contato
     */
    public Email(String destinatario, Date dia, Date dataRetorno, boolean efetiva, Contato contato) {
        super(dia, dataRetorno, efetiva, contato);
        this.destinatario = destinatario;
    }

    /**
     * Retorna o destinatário do e-mail
     * 
     * @return destinatario
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * Altera o destinatário do e-mail
     * 
     * @param destinatario
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Produz um string com todos atributos
     * 
     * @return string
     */
    @Override
    public String toString() {
        return super.toString() + "Destinatário: " + destinatario + "; ";
    }
    
}
