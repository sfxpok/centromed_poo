package centromedicopoo;

public class Avaliacao {

    private int nota;

    public Avaliacao(int nota) {
        this.nota = nota;
    }

    public Avaliacao() {
        nota = 0;
    }

    public static double calculaMedia(int nota, int avaliacoes) {
        return nota/avaliacoes;
    }

}
