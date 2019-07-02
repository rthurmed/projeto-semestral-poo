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
 * DAO para a classe Empresa
 * 
 * @author arthur
 */
public class EmpresaDAO extends AbstractDAO<Empresa>{

    /**
     * Obtém uma empresa a partir do ID
     * 
     * @param id
     * @return objeto de empresa
     */
    @Override
    public Empresa getOne(int id) {
        Empresa empresa = new Empresa();
        
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "SELECT razao_social, nome_fantasia, cidade, site, setor_id FROM empresa WHERE id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                empresa.setId(id);
                empresa.setRazaoSocial(rs.getString("razao_social"));
                empresa.setNomeFantasia(rs.getString("nome_fantasia"));
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

    /**
     * Insere no banco de dados a empresa recebida
     * 
     * @param objeto
     * @return confirmação de que a operação foi realizada com sucesso
     */
    @Override
    public boolean save(Empresa objeto) {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "INSERT INTO empresa(id, razao_social, nome_fantasia, cidade, site, setor_id)"
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
                id = rs.getInt(1);
            }
            objeto.setId(id);
            
            ContatoDAO contatoDAO = new ContatoDAO();
            for (Contato contato : objeto.getContatos()) {
                contatoDAO.save(contato, objeto);
            }
            
            System.out.println("Empresa " + objeto.getRazaoSocial() + " cadastrada!");
        } catch (SQLException e) {
            e.printStackTrace();
//            System.out.println(e);
            return false;
        }
        
        return true;
    }

    /**
     * Atualiza os valores de uma empresa no banco de dados
     * 
     * @param objeto
     * @return confirmação de que a operação foi realizada com sucesso
     */
    @Override
    public boolean update(Empresa objeto) {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "UPDATE empresa SET razao_social = ?, nome_fantasia = ?, cidade = ?, site = ?, setor_id = ? "
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
            
            ContatoDAO contatoDAO = new ContatoDAO();
            for (Contato contato : objeto.getContatos()) {
                if (contato.getId() != 0) { // testa para saber se o contato já foi cadastrado no banco
                    contatoDAO.update(contato, objeto);
                } else {
                    contatoDAO.save(contato, objeto);
                }
            }
            
            System.out.println("Empresa " + objeto.getRazaoSocial() + " atualizada!");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }

    /**
     * Remove uma empresa do banco de dados
     * 
     * @param objeto
     * @return confirmação de que a operação foi realizada com sucesso
     */
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

    /**
     * Obtém todas empresa do banco de dados
     * 
     * @return lista de todas empresas
     */
    @Override
    public ArrayList<Empresa> getAll() {
        ArrayList<Empresa> empresas = new ArrayList();
        
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "SELECT id, razao_social, nome_fantasia, cidade, site, setor_id FROM empresa";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(rs.getInt("id"));
                empresa.setRazaoSocial(rs.getString("razao_social"));
                empresa.setNomeFantasia(rs.getString("nome_fantasia"));
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
    
    /**
     * Obtém todos contatos de uma empresa
     * 
     * @param objeto
     * @return lista de contatos
     */
    public ArrayList<Contato> getContatosFrom(Empresa objeto) {
        ArrayList<Contato> contatos = new ArrayList();
        
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        
        String sql = "SELECT id, nome, cargo FROM contato WHERE empresa_id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, objeto.getId());
            
            ResultSet rs = ps.executeQuery();
            
            objeto.getContatos().clear();
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setCargo(rs.getString("cargo"));
                objeto.addContato(contato);
                contatos.add(contato);
            }

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        
        return contatos;
    }
    
}
