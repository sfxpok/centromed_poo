/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centromedicopoo;

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

        // MENU DE SELECÇÃO POR FAZER
        // CentroMedico.terminalPrompt();

        CentroMedico.adicionarUtente();
        CentroMedico.adicionarMedico();

        CentroMedico.listarUtentes();
        CentroMedico.listarMedicos();
    }
    
}
