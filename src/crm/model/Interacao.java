/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.model;

import java.util.Date;

/**
 * Representação abstrata de uma interação realizada por um vendedor. Essa 
 * classe é abstrata logo não possue DAO ou sequer tabela no banco de dados.
 * 
 * @author Arthur
 */
public abstract class Interacao {
    
    /**
     * ID da interação no banco de dados (altera a tabela dependendo qual classe implementa). Quando a interação não foi cadastrada seu valor é 0.
     */
    private int id;
    
    /**
     * Data da realização
     */
    private Date dia;
    
    /**
     * Data que deve ser realizada a próxima interação
     */
    private Date dataRetorno;
    
    /**
     * A interação foi efetiva?
     */
    private boolean efetiva;
    
    /**
     * Contato com quem a interação foi realizada
     */
    private Contato contato;

    /**
     * Constrói um objeto de interação
     */
    public Interacao() {
    }

    /**
     * Constrói um objeto de interação a partir dos parâmetros
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
     * Retorna o ID da interação
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Altera o ID da interação
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna a data da realização da interação
     * 
     * @return dia
     */
    public Date getDia() {
        return dia;
    }

    /**
     * Altera a data da realização da interação
     * 
     * @param dia
     */
    public void setDia(Date dia) {
        this.dia = dia;
    }

    /**
     * Retorna a data da próxima interação
     * 
     * @return dataRetorno
     */
    public Date getDataRetorno() {
        return dataRetorno;
    }

    /**
     * Altera a data da próxima interação
     * 
     * @param dataRetorno
     */
    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    /**
     * Retorna verdadeiro se a interação foi efetiva
     * 
     * @return efetiva
     */
    public boolean isEfetiva() {
        return efetiva;
    }

    /**
     * Altera o valor da propriedade efetiva
     * 
     * @param efetiva
     */
    public void setEfetiva(boolean efetiva) {
        this.efetiva = efetiva;
    }

    /**
     * Retorna o contato com quem foi realizada a interação
     *  
     * @return contato
     */
    public Contato getContato() {
        return contato;
    }

    /**
     * Altera o contato com quem foi realizada a interação
     * 
     * @param contato
     */
    public void setContato(Contato contato) {
        this.contato = contato;
    }

    /**
     * Produz um string com todos atributos
     * 
     * @return string
     */
    @Override
    public String toString() {
        return "Dia: " + dia.toString() + "; "
                + "Data Retorno: " + dataRetorno.toString() + "; "
                + "Efetiva: " + efetiva + "; " 
                + "Contato: " + contato.toString() + "; ";
    }
    
}
