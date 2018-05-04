/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centromedicopoo;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author r
 */
public class CentroMedico extends CentroMedicoPOO {

    private static List<Utente> utentes = new ArrayList<Utente>(10); // ALTERA O LIMITE MAIS TARDE
    private static List<Medico> medicos = new ArrayList<Medico>(10);

    public static void adicionarUtente() {
        
        Scanner entradaDados = new Scanner(System.in, "Cp1252");
        
        Utente utenteTeste = new Utente();
        
        System.out.print("\nNome: ");
        utenteTeste.setNome(entradaDados.nextLine());
        
        System.out.print("\nIdade: ");
        utenteTeste.setIdade(entradaDados.nextInt());

        utentes.add(utenteTeste); // Utente adicionado à lista de utentes

        /// TESTES ///
        System.out.print(utenteTeste.getNome());
        System.out.print(utenteTeste.getIdade());
        
    }

    public static void adicionarMedico() {

        Scanner entradaDados = new Scanner(System.in,"Cp1252");

        Medico medicoTeste = new Medico();

        System.out.print("\nNome: ");
        medicoTeste.setNome(entradaDados.nextLine());

        System.out.print("\nIdade: ");
        medicoTeste.setIdade(entradaDados.nextInt());

        medicos.add(medicoTeste); // Médico adicionado à lista de médicos

        /// TESTES ///
        System.out.print(medicoTeste.getNome());
        System.out.print(medicoTeste.getIdade());

    }
    
}
