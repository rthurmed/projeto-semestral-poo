/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.dao;

import java.util.ArrayList;

/**
 *
 * @author arthur
 * @param <T>
 */
public abstract class AbstractDAO<T> {

    /**
     * Obtem um item especifico do tipo T
     * 
     * @param id
     * @return T objeto
     */
    public abstract T getOne(int id);
    
    /**
     * Salva o objeto no banco
     * 
     * @param objeto
     * @return resultado
     */
    public abstract boolean save(T objeto);
    
    /**
     * Atualiza os valores do objeto no banco
     * 
     * @param objeto
     * @return resultado
     */
    public abstract boolean update(T objeto);
    
    /**
     * Deleta o objeto do banco
     * 
     * @param objeto
     * @return resultado
     */
    public abstract boolean delete(T objeto);
    
    /**
     * Obtem todos valores do banco
     * 
     * @return listaDeT
     */
    public abstract ArrayList<T> getAll();
}
