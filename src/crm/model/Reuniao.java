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
public class Reuniao extends Interacao{
    
    private int horario;

    /**
     *
     */
    public Reuniao() {
    }

    /**
     *
     * @param horario
     * @param dia
     * @param dataRetorno
     * @param efetiva
     * @param contato
     */
    public Reuniao(int horario, Date dia, Date dataRetorno, boolean efetiva, Contato contato) {
        super(dia, dataRetorno, efetiva, contato);
        this.horario = horario;
    }

    /**
     *
     * @return
     */
    public int getHorario() {
        return horario;
    }

    /**
     *
     * @param horario
     */
    public void setHorario(int horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Horário: " + horario + "; ";
    }
    
}
