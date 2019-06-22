/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author arthur
 */
public class Conexao {

    private String usuario = "TADS_BD06";
    private String senha = "1234";
    private String servidor = "oracle.canoas.ifrs.edu.br";
    private int porta = 1521;

    private Connection conexao = null;

    public Conexao() {
    }//inicia com os valores padrões

    public Conexao(
            String usuario,
            String senha) {
        this.senha = senha;
        this.usuario = usuario;
    }

    public Connection getConexao() {
        if (conexao == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conexao = DriverManager.getConnection(
                        "jdbc:oracle:thin:@" + this.servidor + ":" + this.porta + ":XE",
                        this.usuario,
                        this.senha);

            } catch (ClassNotFoundException e) {
                System.out.println("Importe o pacote do DB!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return conexao;
    }

    public void desconecta() {
        try {
            conexao.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
