/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.model;

import java.util.Date;

/**
 *
 * @author Arthur
 */
public class Email extends Interacao{
    
    private String destinatario;

    /**
     *
     */
    public Email() {
    }

    /**
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
     *
     * @return
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     *
     * @param destinatario
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return super.toString() + "Destinatário: " + destinatario + "; ";
    }
    
}
