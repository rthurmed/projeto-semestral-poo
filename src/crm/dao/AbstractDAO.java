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
    public abstract T getOne();
    
    public abstract void save(T objeto);
    
    public abstract int update(T objeto);
    
    public abstract ArrayList<T> getAll();
}
