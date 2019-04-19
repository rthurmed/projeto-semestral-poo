/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm;

import java.util.Date;

/**
 *
 * @author Pichau
 */
public abstract class Interacao {
    
    private Date dia;
    private Date dataRetorno;
    private boolean efetiva;
    private Contato contato;

    public Interacao() {
    }

    public Interacao(Date dia, Date dataRetorno, boolean efetiva, Contato contato) {
        this.dia = dia;
        this.dataRetorno = dataRetorno;
        this.efetiva = efetiva;
        this.contato = contato;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public boolean isEfetiva() {
        return efetiva;
    }

    public void setEfetiva(boolean efetiva) {
        this.efetiva = efetiva;
    }

    public Contato getContato() {
        return contato;
    }

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
