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
public class Ligacao extends Interacao{
    
    private int numero;
    private boolean atendida;

    /**
     * 
     */
    public Ligacao() {
    }

    /**
     * 
     * @param numero
     * @param atendida
     * @param dia
     * @param dataRetorno
     * @param efetiva
     * @param contato
     */
    public Ligacao(int numero, boolean atendida, Date dia, Date dataRetorno, boolean efetiva, Contato contato) {
        super(dia, dataRetorno, efetiva, contato);
        this.numero = numero;
        this.atendida = atendida;
    }

    /**
     *
     * @return
     */
    public int getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public boolean isAtendida() {
        return atendida;
    }

    /**
     *
     * @param atendida
     */
    public void setAtendida(boolean atendida) {
        this.atendida = atendida;
    }

    @Override
    public String toString() {
        return super.toString() 
                + "Número: " + numero + "; " 
                + "Atendida: " + atendida + "; ";
    }
    
}
