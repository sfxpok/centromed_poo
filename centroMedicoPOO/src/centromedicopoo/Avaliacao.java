package centromedicopoo;

public class Avaliacao {

    private double nota;

    public Avaliacao(double nota) {
        this.nota = nota;
    }

    public Avaliacao() {
        nota = 0;
    }

    public static double calculaMedia(double nota, int avaliacoes) {
        return nota/avaliacoes;
    }

}
