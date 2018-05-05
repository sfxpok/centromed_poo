/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centromedicopoo;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author r
 */
public class CentroMedico extends CentroMedicoPOO {

    private static List<Utente> utentes = new ArrayList<Utente>(10); // ALTERA O LIMITE MAIS TARDE
    private static List<Medico> medicos = new ArrayList<Medico>(10);

    public static void menuPrincipal() {

    }

    public static void adicionarUtente() {

        String nome;
        int idade;
        String temSeguro;
        int numeroUtente;

        Scanner entradaDados = new Scanner(System.in, "Cp1252");
        Random geradorAleatorio = new Random();
        
        Utente utenteTeste = new Utente();
        
        System.out.print("Nome: " + "\n");
        nome = entradaDados.nextLine();
        // utenteTeste.setNome(entradaDados.nextLine());
        
        System.out.print("Idade: " + "\n");
        idade = entradaDados.nextInt();
        // utenteTeste.setIdade(entradaDados.nextInt());

        numeroUtente = geradorAleatorio.nextInt(100000);

        System.out.print("O utente tem seguro? S/N: " + "\n");
        temSeguro = entradaDados.nextLine();
        temSeguro = entradaDados.nextLine();

        /// CORRIGIR A COMPARAÇÃO DO TEMSEGURO ### BUG ### ///

        if (temSeguro == "S") {
            utenteTeste.setTemSeguro(true);
            // ATRIBUI DESCONTO
        }
        else if (temSeguro == "N") {
            utenteTeste.setTemSeguro(false);
        }
        else {
            System.out.println("Valor inválido. Inserção de dados interrompida.");
            // SAI DESTE MÉTODO AQUI E VOLTA AO MENU PRINCIPAL
        }

        /////////////////////////////////////////////

        utenteTeste.setNome(nome);
        utenteTeste.setIdade(idade);
        utenteTeste.setNumeroUtente(numeroUtente);

        utentes.add(utenteTeste); // Utente adicionado à lista de utentes

        /// TESTES ///
        // System.out.print(utenteTeste.getNome());
        // System.out.print(utenteTeste.getIdade());
        
    }

    public static void adicionarMedico() {

        String nome;
        int idade;
        int numeroMedico;

        Scanner entradaDados = new Scanner(System.in,"Cp1252");
        Random geradorAleatorio = new Random();

        Medico medicoTeste = new Medico();

        System.out.println("Nome: " + "\n");
        nome = entradaDados.nextLine();
        // medicoTeste.setNome(entradaDados.nextLine());

        System.out.println("Idade: " + "\n");
        idade = entradaDados.nextInt();
        // medicoTeste.setIdade(entradaDados.nextInt());

        numeroMedico = geradorAleatorio.nextInt(100000) + 100000;

        // System.out.println("Especialidade: " + "\n");
        // CRIA UM ARRAY COM ESPECIALIDADES

        medicoTeste.setNome(nome);
        medicoTeste.setIdade(idade);
        medicoTeste.setNumeroMedico(numeroMedico);

        medicos.add(medicoTeste); // Médico adicionado à lista de médicos

        /// TESTES ///
        // System.out.print(medicoTeste.getNome());
        // System.out.print(medicoTeste.getIdade());

    }

    public static void menulistarUtentes() {

        System.out.println("----- MENU DE LISTAGEM DE UTENTES -----\n"
                +"1 - Listar todos os utentes (nome, idade e número de utente)\n"
                +"2 - Listar os utentes que um médico consultará num dado dia\n"
                +"3 - Listar o valor total pago por cada utente\n"
                +"4 - Voltar atrás\n");
    }

    public static void listarInfoUtentes() {

        for(int i = 0; i < utentes.size(); i++) {

            System.out.println("NÚMERO DE UTENTE: " + utentes.get(i).getNumeroUtente());
            System.out.println("Nome: " + utentes.get(i).getNome());
            System.out.println("Idade: " + utentes.get(i).getIdade());

            if (utentes.get(i).getTemSeguro())
                System.out.println("O utente tem seguro.");
            else
                System.out.println("O utente não tem seguro.");

            System.out.println("////////////////////////////////////");

        }

    }

    public static void listarPagamentosUtentes() {
        //
    }

    public static void listarMedicos() {

        for(int i = 0; i < medicos.size(); i++) {

            System.out.println("NÚMERO DE MÉDICO: " + medicos.get(i).getNumeroMedico());
            System.out.println("Nome: " + medicos.get(i).getNome());
            System.out.println("Idade: " + medicos.get(i).getIdade());

            System.out.println("////////////////////////////////////");

        }

    }
    
}
