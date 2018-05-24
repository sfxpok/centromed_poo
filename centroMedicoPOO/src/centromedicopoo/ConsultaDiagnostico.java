package centromedicopoo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ConsultaDiagnostico extends Consulta {
    
    private int numeroConsulta;
    private int numeroUtente;
    private int numeroMedico;
    private String data;
    //private boolean solicitaExame;
   // private ArrayList<Utente> utentes;
   // private ArrayList<Medico> medicos;

    ////////////////////////// *** Construtores *** //////////////////////////

    public ConsultaDiagnostico(int numeroUtente, int numeroMedico, String data) {
        this.numeroUtente = numeroUtente;
        this.numeroMedico = numeroMedico;
        this.data = data;
        //numeroConsulta++;
    }
    public ConsultaDiagnostico () {
        
    }

    public String toString(){
        String info;
        info = super.toString();
        info += " Consulta de diagnóstico." + "\n\n";
        return info;
    }

}
