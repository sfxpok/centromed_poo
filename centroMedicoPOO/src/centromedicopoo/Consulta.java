package centromedicopoo;

import java.util.Date;

public class Consulta {

    private Utente utenteTesteConsulta;
    private Medico medicoTesteConsulta;
    private int dia;
    private boolean flagDiagnostico;
    private boolean flagResultados;

    private int numeroUtente;
    private int numeroMedico;

//    public Consulta(Utente utenteTesteConsulta, Medico medicoTesteConsulta, int dia, boolean flagDiagnostico, boolean flagResultados) {
//        this.utenteTesteConsulta = utenteTesteConsulta;
//        this.medicoTesteConsulta = medicoTesteConsulta;
//        this.dia = dia;
//        this.flagDiagnostico = flagDiagnostico;
//        this.flagResultados = flagResultados;
//    }

    public Consulta(int numeroUtente, int numeroMedico, int dia, boolean flagDiagnostico, boolean flagResultados) {
        this.numeroUtente = numeroUtente;
        this.numeroMedico = numeroMedico;
        this.dia = dia;
        this.flagDiagnostico = flagDiagnostico;
        this.flagResultados = flagResultados;
    }

    public Consulta() {

    }

    public int getNumeroUtente() {
        return numeroUtente;
    }

    public int getNumeroMedico() {
        return numeroMedico;
    }

//    public Utente getUtenteTesteConsulta() {
//        return utenteTesteConsulta;
//    }
//
//    public Medico getMedicoTesteConsulta() {
//        return medicoTesteConsulta;
//    }

    public int getDia() {
        return dia;
    }

    public boolean getFlagDiagnostico() {
        return flagDiagnostico;
    }

    public boolean getFlagResultado() {
        return flagResultados;
    }

    public void setNumeroUtente(int numeroUtente) {
        this.numeroUtente = numeroUtente;
    }

    public void setNumeroMedico(int numeroMedico) {
        this.numeroMedico = numeroMedico;
    }

//    public void setUtenteTesteConsulta(Utente utenteTesteConsulta) {
//        this.utenteTesteConsulta = utenteTesteConsulta;
//    }
//
//    public void setMedicoTesteConsulta(Medico medicoTesteConsulta) {
//        this.medicoTesteConsulta = medicoTesteConsulta;
//    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setFlagDiagnostico(boolean flagDiagnostico) {
        this.flagDiagnostico = flagDiagnostico;
    }

    public void setFlagResultados(boolean flagResultados) {
        this.flagResultados = flagResultados;
    }
}
