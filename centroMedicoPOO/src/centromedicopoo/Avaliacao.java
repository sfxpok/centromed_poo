package centromedicopoo;

public class Avaliacao {

    private double nota;

    ////////////////////////// *** Construtores *** //////////////////////////

    public Avaliacao(double nota) {
        this.nota = nota;
    }

    public Avaliacao() {
        nota = 0;
    }

    ////////////////////////// *** Getters e setters *** //////////////////////////

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

}
