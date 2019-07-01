/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.model;

import java.util.ArrayList;

/**
 * Representação de uma empresa que já contratou algum tipo de serviço, se tornando assim um cliente
 * 
 * @author Arthur
 */
public class ClienteAtual extends Empresa{
    
    /**
     * Lista de todos serviços contratados pela empresa
     */
    private ArrayList<Servico> servicos = new ArrayList<>();

    /**
     * Constrói um objeto de cliente atual
     */
    public ClienteAtual() {
    }

    /**
     * Constrói um objeto de cliente atual a partir dos parâmetros
     * 
     * @param razaoSocial
     * @param nomeFantasia
     * @param cidade
     * @param site
     * @param setor
     */
    public ClienteAtual(String razaoSocial, String nomeFantasia, String cidade, String site, Setor setor) {
        super(razaoSocial, nomeFantasia, cidade, site, setor);
    }

    /**
     * Retorna a lista de serviços contratados
     * 
     * @return servicos
     */
    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    /**
     * Altera toda lista de serviços
     * 
     * @param servicos
     */
    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }
    
    /**
     * Adiciona um serviço à lista de serviços
     * 
     * @param servico 
     */
    public void addServico(Servico servico) {
        this.servicos.add(servico);
    }

    /**
     * Produz um string com todos atributos
     * 
     * @return string
     */
    @Override
    public String toString() {
        String servicosString = "";
        for (Servico servico : servicos) {
            servicosString += servico.toString();
        }
        return super.toString() + "Serviços: " + servicosString + "; ";
    }
}
