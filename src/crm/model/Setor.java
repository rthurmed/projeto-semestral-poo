/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.model;

/**
 * Representação de um setor a qual uma empresa pode ser classificada
 * 
 * @author Arthur
 */
public class Setor {
    
    /**
     * ID do setor no banco de dados. Quando o setor não foi cadastrado seu valor é 0.
     */
    private int id;
    
    /**
     * Código representativo do setor
     */
    private String codigo;
    
    /**
     * Descrição de que tipo de atividade é realizada por empresas desse setor
     */
    private String descricao;

    /**
     * Constrói um objeto de setor
     */
    public Setor() {
    }

    /**
     * Constrói um objeto de setor a partir dos parâmetros
     * 
     * @param codigo
     * @param descricao
     */
    public Setor(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Retorna o ID do setor
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Altera o ID do setor
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o código do setor
     * 
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Altera o código do setor
     * 
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna a descrição do setor
     * 
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Altera a descrição do setor
     * 
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Produz um string com todos atributos
     * 
     * @return string
     */
    @Override
    public String toString() {
        return getDescricao();
    }
    
}
