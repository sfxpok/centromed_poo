package centromedicopoo;

import java.util.Date;

public class Consulta {

    Date data;
    boolean flagDiagnostico;
    boolean flagResultados;

    public Consulta(Date data, boolean flagDiagnostico, boolean flagResultados) {
        this.data = data;
        this.flagDiagnostico = flagDiagnostico;
        this.flagResultados = flagResultados;
    }

    public Consulta() {

    }

}
