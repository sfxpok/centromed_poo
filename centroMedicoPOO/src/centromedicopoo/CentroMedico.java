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

    public static void adicionarUtente() {
        
        Scanner entradaDados = new Scanner(System.in, "Cp1252");
        Random geradorAleatorio = new Random();
        
        Utente utenteTeste = new Utente();
        
        System.out.print("Nome: " + "\n");
        utenteTeste.setNome(entradaDados.nextLine());
        
        System.out.print("Idade: " + "\n");
        utenteTeste.setIdade(entradaDados.nextInt());

        // atribui um número aleatório ao utente aqui

        utenteTeste.setNumeroUtente(geradorAleatorio.nextInt(100000));

        utentes.add(utenteTeste); // Utente adicionado à lista de utentes

        /// TESTES ///
        // System.out.print(utenteTeste.getNome());
        // System.out.print(utenteTeste.getIdade());
        
    }

    public static void adicionarMedico() {

        Scanner entradaDados = new Scanner(System.in,"Cp1252");
        Random geradorAleatorio = new Random();

        Medico medicoTeste = new Medico();

        System.out.println("Nome: " + "\n");
        medicoTeste.setNome(entradaDados.nextLine());

        System.out.println("Idade: " + "\n");
        medicoTeste.setIdade(entradaDados.nextInt());

        medicoTeste.setNumeroMedico(geradorAleatorio.nextInt(100000) + 100000);

        medicos.add(medicoTeste); // Médico adicionado à lista de médicos

        /// TESTES ///
        // zSystem.out.print(medicoTeste.getNome());
        // System.out.print(medicoTeste.getIdade());

    }

    public static void listarUtentes() {

        for(int i = 0; i < utentes.size(); i++) {

            System.out.println("NÚMERO DE UTENTE: " + utentes.get(i).getNumeroUtente());
            System.out.println("Nome: " + utentes.get(i).getNome());
            System.out.println("Idade: " + utentes.get(i).getIdade());

            System.out.println("////////////////////////////////////");

        }

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
