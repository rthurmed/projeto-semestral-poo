/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.dao;

import crm.db.Conexao;
import crm.main.classes.Contato;
import crm.main.classes.Empresa;
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
public class EmpresaDAO extends AbstractDAO<Empresa>{

    @Override
    public Empresa getOne(int id) {
        Empresa empresa = new Empresa();
        
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "SELECT razaoSocial, nomeFantasia, cidade, site, setor_id FROM empresa WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                empresa.setId(id);
                empresa.setRazaoSocial(rs.getString("razaoSocial"));
                empresa.setNomeFantasia(rs.getString("nomeFantasia"));
                empresa.setCidade(rs.getString("cidade"));
                empresa.setSite(rs.getString("site"));
                empresa.setSetor(new SetorDAO().getOne(rs.getInt("setor_id")));
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        
        return empresa;
    }

    @Override
    public boolean save(Empresa objeto) {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "INSERT INTO empresa(id, razaoSocial, nomeFantasia, cidade, site, setor_id)"
                + "VALUES (seq_empresa.nextval, ?, ?, ?, ?, ?)";
        
        String colunasGeradas[] = {"id"};
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, colunasGeradas);
            ps.setString(1, objeto.getRazaoSocial());
            ps.setString(2, objeto.getNomeFantasia());
            ps.setString(3, objeto.getCidade());
            ps.setString(4, objeto.getSite());
            ps.setInt(5, objeto.getSetor().getId());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            int id = 0;
            if (rs.next()) {
                id = rs.getInt("id");
            }
            objeto.setId(id);
            
            System.out.println("Empresa " + objeto.getRazaoSocial() + " cadastrada!");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }

    @Override
    public boolean update(Empresa objeto) {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "UPDATE empresa SET razaoSocial = ?, nomeFantasia = ?, cidade = ?, site = ?, setor_id = ? "
                + "WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, objeto.getRazaoSocial());
            ps.setString(2, objeto.getNomeFantasia());
            ps.setString(3, objeto.getCidade());
            ps.setString(4, objeto.getSite());
            ps.setInt(5, objeto.getSetor().getId());
            ps.setInt(6, objeto.getId());
            ps.executeUpdate();
            
            System.out.println("Empresa " + objeto.getRazaoSocial() + " atualizada!");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }

    @Override
    public boolean delete(Empresa objeto) {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "DELETE FROM empresa WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, objeto.getId());
            ps.execute();
            
            System.out.println("Empresa " + objeto.getRazaoSocial() + " deletada!");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }

    @Override
    public ArrayList<Empresa> getAll() {
        ArrayList<Empresa> empresas = new ArrayList();
        
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "SELECT id, razaoSocial, nomeFantasia, cidade, site, setor_id FROM setor";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(rs.getInt("id"));
                empresa.setRazaoSocial(rs.getString("razaoSocial"));
                empresa.setNomeFantasia(rs.getString("nomeFantasia"));
                empresa.setCidade(rs.getString("cidade"));
                empresa.setSite(rs.getString("site"));
                empresa.setSetor(new SetorDAO().getOne(rs.getInt("setor_id")));
                empresas.add(empresa);
            }
                
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        
        return empresas;
    }
    
    public ArrayList<Contato> getContatosFrom(Empresa objeto) {
        ArrayList<Contato> contatos = new ArrayList();
        
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "SELECT id, nome, cargo FROM contato WHERE empresa_id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, objeto.getId());
            
            ResultSet rs = ps.executeQuery(sql);
            
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("codigo"));
                contato.setCargo(rs.getString("descricao"));
                contato.setEmpresa(new EmpresaDAO().getOne(rs.getInt("empresa_id")));
                contatos.add(contato);
            }
            
            objeto.setContatos(contatos);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        
        return contatos;
    }
    
}
