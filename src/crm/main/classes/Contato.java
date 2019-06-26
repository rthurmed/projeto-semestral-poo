/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.main.classes;

/**
 *
 * @author Arthur
 */
public class Contato {
    
    private int id;
    private String nome;
    private String cargo;
    private Empresa empresa;

    public Contato() {
    }

    public Contato(String nome, String cargo, Empresa empresa) {
        this.nome = nome;
        this.cargo = cargo;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "; " 
                + "Cargo: " + cargo + "; " 
                + "Empresa: " + empresa.toString() + "; ";
    }
    
}
