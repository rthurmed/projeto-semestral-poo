/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.model;

import java.util.Date;

/**
 * Representação de um serviço contratado por um cliente
 * 
 * @author Arthur
 */
public class Servico {
    
    /**
     * ID do serviço no banco de dados. Quando o serviço não foi cadastrado seu valor é 0.
     */
    private int id;
    
    /**
     * Explicação geral do serviço contratado
     */
    private String descricao;
    
    /**
     * Data esperada de conclusão do serviço
     */
    private Date dataFim;
    
    /**
     * Data de início da prestação do serviço
     */
    private Date dataInicio;

    /**
     * Constrói um objeto de serviço
     */
    public Servico() {
    }

    /**
     * Constrói um objeto de serviço a partir dos parâmetros
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
     * Retorna o ID do serviço
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Altera o ID do serviço
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retorna a descrição do serviço
     * 
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Altera a descrição do serviço
     * 
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a data de conclusão do serviço
     * 
     * @return dataFim
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     * Altera a data de conclusão do serviço
     * 
     * @param dataFim
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * Retorna a data de início do serviço
     * 
     * @return dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * Altera a data de início do serviço
     * 
     * @param dataInicio
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * Produz um string com todos atributos
     * 
     * @return string
     */
    @Override
    public String toString() {
        return "Descrição: " + descricao + "; " 
                + "Data Inicio: " + dataInicio.toString() + "; " 
                + "Data Fim: " + dataFim.toString() + "; ";
    }
    
}
