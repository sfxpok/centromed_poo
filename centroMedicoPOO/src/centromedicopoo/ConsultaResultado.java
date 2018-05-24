package centromedicopoo;

public class ConsultaResultado extends Consulta {

    // private Utente utenteTesteConsulta;
    // private Medico medicoTesteConsulta;
    private int dia;
    private boolean flagDiagnostico;
    private boolean flagResultados;

    private int numeroUtente;
    private int numeroMedico;
    private int numeroConsulta;
    private String data;

//    public Consulta(Utente utenteTesteConsulta, Medico medicoTesteConsulta, int dia, boolean flagDiagnostico, boolean flagResultados) {
//        this.utenteTesteConsulta = utenteTesteConsulta;
//        this.medicoTesteConsulta = medicoTesteConsulta;
//        this.dia = dia;
//        this.flagDiagnostico = flagDiagnostico;
//        this.flagResultados = flagResultados;
//    }

    ////////////////////////// *** Construtores *** //////////////////////////

    public ConsultaResultado(int numeroUtente, int numeroMedico, int dia, boolean flagDiagnostico, boolean flagResultados) {
        this.numeroUtente = numeroUtente;
        this.numeroMedico = numeroMedico;
        this.dia = dia;
        this.flagDiagnostico = flagDiagnostico;
        this.flagResultados = flagResultados;
    }

    public ConsultaResultado() {

    }
    
    public String toString(){
        String info;
        info = super.toString();
        info += " Consulta de resultado." + "\n\n";
        return info;
    }
    
}
