package centromedicopoo;

import java.util.Date;

public class Consulta extends Individuo {

    private Utente utenteTesteConsulta;
    private Medico medicoTesteConsulta;
    private Date data;
    private boolean flagDiagnostico;
    private boolean flagResultados;

    public Consulta(Utente utenteTesteConsulta, Medico medicoTesteConsulta, Date data, boolean flagDiagnostico, boolean flagResultados) {
        this.utenteTesteConsulta = utenteTesteConsulta;
        this.medicoTesteConsulta = medicoTesteConsulta;
        this.data = data;
        this.flagDiagnostico = flagDiagnostico;
        this.flagResultados = flagResultados;
    }

    public Consulta() {

    }

}
