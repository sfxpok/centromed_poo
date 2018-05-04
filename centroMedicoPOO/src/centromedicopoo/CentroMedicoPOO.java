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
public class CentroMedicoPOO {

    // List utentes = new ArrayList();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        adicionarUtente();
    }
    
    public static void adicionarUtente() {
        
        Scanner entradaDados = new Scanner(System.in, "Cp1252");
        
        Utente utenteTeste = new Utente();
        
        System.out.print("\nNome: ");
        utenteTeste.setNome(entradaDados.nextLine());
        
        System.out.print("\nIdade: ");
        utenteTeste.setIdade(entradaDados.nextInt());
        
        /// TESTES ///
        System.out.print(utenteTeste.getNome());
        System.out.print(utenteTeste.getIdade());
        
    }
    
}
