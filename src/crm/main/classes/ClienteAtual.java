/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.main.classes;

import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class ClienteAtual extends Empresa{
    
    private ArrayList<Servico> servicos = new ArrayList<>();

    public ClienteAtual() {
    }

    public ClienteAtual(String razaoSocial, String nomeFantasia, String cidade, String site, Setor setor) {
        super(razaoSocial, nomeFantasia, cidade, site, setor);
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public String toString() {
        String servicosString = "";
        for (Servico servico : servicos) {
            servicosString += servico.toString();
        }
        return super.toString() + "Serviços: " + servicosString + "; ";
    }
}