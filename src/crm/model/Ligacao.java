/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.model;

import java.util.Date;

/**
 * Representação de uma ligação telefônica realizada com um cliente.
 * 
 * @author Arthur
 */
public class Ligacao extends Interacao{
    
    /**
     * Número telefônico telefonado
     */
    private int numero;
    
    /**
     * A ligação foi atendida?
     */
    private boolean atendida;

    /**
     * Constrói um objeto de ligação
     */
    public Ligacao() {
    }

    /**
     * Constrói um objeto de ligação a partir dos parâmetros
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
     * Retorna o numero de telefone ligado à ligação
     * 
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Altera o o numero de telefone ligado à ligação
     * 
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Retorna verdadeiro se a ligação foi atendida
     * 
     * @return atendida
     */
    public boolean isAtendida() {
        return atendida;
    }

    /**
     * Altera o valor da propriedade atendida
     * 
     * @param atendida
     */
    public void setAtendida(boolean atendida) {
        this.atendida = atendida;
    }

    /**
     * Produz um string com todos atributos
     * 
     * @return string
     */
    @Override
    public String toString() {
        return super.toString() 
                + "Número: " + numero + "; " 
                + "Atendida: " + atendida + "; ";
    }
    
}
