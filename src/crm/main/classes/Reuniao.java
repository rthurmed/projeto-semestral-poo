/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.main.classes;

import java.util.Date;

/**
 *
 * @author Arthur
 */
public class Reuniao extends Interacao{
    
    private int horario;

    public Reuniao() {
    }

    public Reuniao(int horario, Date dia, Date dataRetorno, boolean efetiva, Contato contato) {
        super(dia, dataRetorno, efetiva, contato);
        this.horario = horario;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Horário: " + horario + "; ";
    }
    
}
