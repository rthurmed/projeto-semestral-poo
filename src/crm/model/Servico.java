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
public class Servico {
    
    private int id;
    private String descricao;
    private Date dataFim;
    private Date dataInicio;

    /**
     *
     */
    public Servico() {
    }

    /**
     *
     * @param descricao
     * @param dataFim
     * @param dataInicio
     */
    public Servico(String descricao, Date dataFim, Date dataInicio) {
        this.descricao = descricao;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
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
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     *
     * @param dataFim
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    /**
     *
     * @return
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     *
     * @param dataInicio
     */
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
