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
public class Servico {
    
    private String descricao;
    private Date dataFim;
    private Date dataInicio;

    public Servico() {
    }

    public Servico(String descricao, Date dataFim, Date dataInicio) {
        this.descricao = descricao;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao + "; " 
                + "Data Inicio: " + dataInicio.toString() + "; " 
                + "Data Fim: " + dataFim.toString() + "; ";
    }
    
}
