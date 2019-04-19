/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm;

import java.util.Date;

/**
 *
 * @author Arthur
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Setor setor = new Setor("METAL", "Setor metalúrgico");
        Vendedor vendedor = new Vendedor("Arthur", "arthur@medeiros.com");
        Gerente gerente = new Gerente("Marcio", "marcio@bigolin.com");
        Servico servico = new Servico("Desenvolvimento de isso e aquilo", new Date(2019, 5, 1), new Date(2019, 10, 31));
        Empresa empresa = new Empresa("Razão Social", "Nome Fantasia", "Canoas", "empresa.com", setor);
        ClienteAtual clienteAtual = new ClienteAtual("Empresa 1", "Empresa one", "Canoas", "empresa1.com", setor);
        Contato contato = new Contato("Bruno", "Gerente Comercial", empresa);
        Ligacao ligacao = new Ligacao(1111111111, true, new Date(2019, 4, 13), new Date(2019, 4, 20), true, contato);
        Email email = new Email("pedro@rodrigues.com", new Date(2019, 3, 13), new Date(2019, 4, 21), true, contato);
        Reuniao reuniao = new Reuniao(11, new Date(2019, 4, 13), new Date(2019, 4, 23), true, contato);
        System.out.println("Setor: " + setor.toString());
        System.out.println("Vendedor: " + vendedor.toString());
        System.out.println("Gerente: " + gerente.toString());
        System.out.println("Serviço: " + servico.toString());
        System.out.println("Empresa: " + empresa.toString());
        System.out.println("Cliente Atual: " + clienteAtual.toString());
        System.out.println("Contato: " + contato.toString());
        System.out.println("Ligação: " + ligacao.toString());
        System.out.println("Email: " + email.toString());
        System.out.println("Reunião: " + reuniao.toString());
    }
    
}
