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

    /**
     * Devolve a nota atribuída a um médico
     * @return nota atribuída a um médico
     */

    public double getNota() {
        return nota;
    }

    /**
     * Define uma nota a um médico
     * @param nota nota dada ao médico
     */

    public void setNota(double nota) {
        this.nota = nota;
    }

}
