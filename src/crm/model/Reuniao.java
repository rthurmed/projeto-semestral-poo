/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.model;

import java.util.Date;

/**
 * Representação de uma reunião realiza com um cliente
 * 
 * @author Arthur
 */
public class Reuniao extends Interacao{
    
    /**
     * Horário de início da reunião 
     */
    private int horario;

    /**
     * Constrói um objeto de reunião
     */
    public Reuniao() {
    }

    /**
     * Constrói um objeto de reunião a partir dos parâmetros
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
     * Retorna o horário da reunião
     * 
     * @return horario
     */
    public int getHorario() {
        return horario;
    }

    /**
     * Altera o horário da reunião
     * 
     * @param horario
     */
    public void setHorario(int horario) {
        this.horario = horario;
    }

    /**
     * Produz um string com todos atributos
     * 
     * @return string
     */
    @Override
    public String toString() {
        return super.toString()
                + "Horário: " + horario + "; ";
    }
    
}
