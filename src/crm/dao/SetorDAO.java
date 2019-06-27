/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.dao;

import crm.db.Conexao;
import crm.main.classes.Setor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author arthur
 */
public class SetorDAO extends AbstractDAO<Setor>{

    @Override
    public Setor getOne(int id) {
        Setor setor = new Setor();
        
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "SELECT codigo, descricao FROM setor WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                setor.setId(rs.getInt("id"));
                setor.setCodigo(rs.getString("codigo"));
                setor.setDescricao(rs.getString("descricao"));
            }
                
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        
        return setor;
    }

    @Override
    public boolean save(Setor objeto) {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "INSERT INTO setor(id, codigo, descricao)"
                + "VALUES (seq_setor.nextval, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, objeto.getCodigo());
            ps.setString(2, objeto.getDescricao());
            ps.execute();
            
            System.out.println("Setor " + objeto.getCodigo() + " cadastrado!");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }

    @Override
    public boolean update(Setor objeto) {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "UPDATE setor SET codigo = ?, descricao = ? WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, objeto.getCodigo());
            ps.setString(2, objeto.getDescricao());
            ps.setInt(3, objeto.getId());
            ps.executeUpdate();
            
            System.out.println("Setor " + objeto.getCodigo() + " atualizado!");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    @Override
    public boolean delete(Setor objeto) {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "DELETE FROM setor WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, objeto.getId());
            ps.execute();
            
            System.out.println("Setor " + objeto.getCodigo() + " deletado!");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }

    @Override
    public ArrayList<Setor> getAll() {
        ArrayList<Setor> setores = new ArrayList();
        
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "SELECT id, codigo, descricao FROM setor";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Setor setor = new Setor();
                setor.setId(rs.getInt("id"));
                setor.setCodigo(rs.getString("codigo"));
                setor.setDescricao(rs.getString("descricao"));
                setores.add(setor);
            }
                
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        
        return setores;
    }
    
}
