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
public abstract class Interacao {
    
    private int id;
    private Date dia;
    private Date dataRetorno;
    private boolean efetiva;
    private Contato contato;

    /**
     *
     */
    public Interacao() {
    }

    /**
     *
     * @param dia
     * @param dataRetorno
     * @param efetiva
     * @param contato
     */
    public Interacao(Date dia, Date dataRetorno, boolean efetiva, Contato contato) {
        this.dia = dia;
        this.dataRetorno = dataRetorno;
        this.efetiva = efetiva;
        this.contato = contato;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Date getDia() {
        return dia;
    }

    /**
     *
     * @param dia
     */
    public void setDia(Date dia) {
        this.dia = dia;
    }

    /**
     *
     * @return
     */
    public Date getDataRetorno() {
        return dataRetorno;
    }

    /**
     *
     * @param dataRetorno
     */
    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    /**
     *
     * @return
     */
    public boolean isEfetiva() {
        return efetiva;
    }

    /**
     *
     * @param efetiva
     */
    public void setEfetiva(boolean efetiva) {
        this.efetiva = efetiva;
    }

    /**
     *
     * @return
     */
    public Contato getContato() {
        return contato;
    }

    /**
     *
     * @param contato
     */
    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Dia: " + dia.toString() + "; "
                + "Data Retorno: " + dataRetorno.toString() + "; "
                + "Efetiva: " + efetiva + "; " 
                + "Contato: " + contato.toString() + "; ";
    }
    
}
