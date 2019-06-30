/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.dao;

import crm.db.Conexao;
import crm.model.Contato;
import crm.model.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * DAO para a classe Contato
 *  
 * @author arthur
 */
public class ContatoDAO extends AbstractDAO<Contato>{

    @Override
    public Contato getOne(int id) {
        Contato contato = new Contato();
        
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "SELECT nome, cargo, empresa_id FROM contato WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                contato.setId(id);
                contato.setNome(rs.getString("nome"));
                contato.setCargo(rs.getString("cargo"));
            }
                
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        
        return contato;
    }

    @Override
    public boolean save(Contato objeto) {
        System.out.println("Usar a outra");
        return false;
    }
    
    public boolean save(Contato objeto, Empresa empresa) {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "INSERT INTO contato(id, nome, cargo, empresa_id)"
                + "VALUES (seq_contato.nextval, ?, ?, ?)";
        
        String colunasGeradas[] = {"id"};
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, colunasGeradas);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getCargo());
            ps.setInt(3, empresa.getId());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            objeto.setId(id);
            
            System.out.println("Contato " + objeto.getNome() + " cadastrado!");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }

    @Override
    public boolean update(Contato objeto) {
        System.out.println("Colocar empresa nos parametros");
        return false;
    };
    
    public boolean update(Contato objeto, Empresa empresa) {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "UPDATE contato SET nome = ?, cargo = ?, empresa_id = ? WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getCargo());
            ps.setInt(3, empresa.getId());
            ps.setInt(4, objeto.getId());
            ps.executeUpdate();
            
            System.out.println("Contato " + objeto.getNome() + " atualizado!");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    @Override
    public boolean delete(Contato objeto) {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "DELETE FROM contato WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, objeto.getId());
            ps.execute();
            
            System.out.println("Contato " + objeto.getNome() + " deletado!");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }

    @Override
    public ArrayList<Contato> getAll() {
        ArrayList<Contato> contatos = new ArrayList();
        
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "SELECT id, nome, cargo, empresa_id FROM contato";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setCargo(rs.getString("cargo"));
                contatos.add(contato);
            }
                
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        
        return contatos;
    }
    
    public Empresa getEmpresa(Contato contato) {
        Empresa empresa = new Empresa();
        
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "SELECT empresa_id FROM contato WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, contato.getId());
            
            ResultSet rs = ps.executeQuery();
            
            int empresaId = 0;
            if (rs.next()) {
                empresaId = rs.getInt("empresa_id");
            }
            empresa = new EmpresaDAO().getOne(empresaId);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        
        return empresa;
    }
    
}
