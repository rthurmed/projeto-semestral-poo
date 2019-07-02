/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.dao;

import crm.db.Conexao;
import crm.model.Setor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * DAO para a classe Setor
 *
 * @author arthur
 */
public class SetorDAO extends AbstractDAO<Setor>{

    /**
     * Obtém um setor a partir do ID
     * 
     * @param id
     * @return objeto de setor
     */
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
                setor.setId(id);
                setor.setCodigo(rs.getString("codigo"));
                setor.setDescricao(rs.getString("descricao"));
            }
                
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            return null;
        }
        
        return setor;
    }

    /**
     * Insere no banco de dados o setor recebido
     * 
     * @param objeto
     * @return confirmação de que a operação foi realizada com sucesso
     */
    @Override
    public boolean save(Setor objeto) {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "INSERT INTO setor(id, codigo, descricao)"
                + "VALUES (seq_setor.nextval, ?, ?)";
        
        String colunasGeradas[] = {"id"};
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, colunasGeradas);
            ps.setString(1, objeto.getCodigo());
            ps.setString(2, objeto.getDescricao());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            objeto.setId(id);
            
            System.out.println("Setor " + objeto.getCodigo() + " cadastrado!");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }

    /**
     * Atualiza os valores de um setor no banco de dados
     * 
     * @param objeto
     * @return confirmação de que a operação foi realizada com sucesso
     */
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
    
    /**
     * Remove um setor do banco de dados
     * 
     * @param objeto
     * @return confirmação de que a operação foi realizada com sucesso
     */
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

    /**
     * Obtém todos setores do banco de dados
     * 
     * @return lista de todos setores
     */
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
