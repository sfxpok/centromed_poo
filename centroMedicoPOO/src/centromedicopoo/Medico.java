package centromedicopoo;

public class Medico extends Individuo {

    private int numeroMedico;
    private String especialidade;
    private double avaliacaoMedia;
    private int consultasDia;

    private int numAvaliacoes;
    private double somaNotas;
    
    private int consultas_dia;
    private final int MAX_CONSULTAS_DIA = 5;

    static String[] especialidades = {"Pediatria","Cardiologia","Neurologia","Radiologia","Urologia"};

    ////////////////////////// *** Construtores *** //////////////////////////

    public Medico(String nome, int idade, int numeroMedico, String especialidade, double avaliacaoMedia, int consultasDia, int numAvaliacoes, double somaNotas) {
        super(nome, idade);
        this.numeroMedico = numeroMedico;
        this.especialidade = especialidade;
        this.avaliacaoMedia = avaliacaoMedia;
        this.consultasDia = consultasDia;
        this.numAvaliacoes = numAvaliacoes;
        this.somaNotas = somaNotas;
    }

    public Medico(String nome, int idade, int numeroMedico, String especialidade) {
        super(nome, idade);
        this.numeroMedico = numeroMedico;
        this.especialidade = especialidade;
    }

    public Medico() {

    }

    ////////////////////////// *** Getters e setters *** //////////////////////////

    /**
     * Devolve o número do médico
     * @return número do médico
     */

    public int getNumeroMedico() {
        return numeroMedico;
    }

    /**
     * Devolve a especialidade de um médico
     * @return especialidade do médico
     */

    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * Devolve a avaliação média de um médico
     * @return avaliação média de um médico
     */

    public double getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    /**
     * Devolve o número de consultas que o médico vai realizar no dia atual
     * @return número de consultas que o médico vai realizar no dia atual
     */

    public int getConsultasDia() {
        return consultasDia;
    }

    /**
     * Devolve o número de avaliações que o médico recebeu
     * @return número de avaliações que o médico recebeu
     */

    public int getNumAvaliacoes() { return numAvaliacoes; }

    /**
     * Devolve a soma total de notas que o médico recebeu
     * @return soma total de notas que o médico recebeu
     */
    
    public double getSomaNotas() { return somaNotas; }

    /**
     * Atribui um número único ao médico
     * @param numeroMedico número único do médico
     */

    public void setNumeroMedico(int numeroMedico) {
        this.numeroMedico = numeroMedico;
    }

    /**
     * Atribui uma especialidade ao médico
     * @param especialidade especialidade do médico
     */

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * Atribui a avaliação média ao médico
     * @param avaliacaoMedia avaliação média do médico
     */

    public void setAvaliacaoMedia(double avaliacaoMedia) {
        this.avaliacaoMedia = avaliacaoMedia;
    }

    /**
     * Atribui o número de consultas que o médico vai fazer no dia atual
     * @param consultasDia número de consultas que o médico vai fazer no dia atual
     */

    public void setConsultasDia(int consultasDia) {
        this.consultasDia = consultasDia;
    }

    /**
     * Atribui a soma total das notas que o médico recebeu
     * @param somaNotas soma total das notas que o médico recebeu
     */

    public void setSomaNotas(double somaNotas) { this.somaNotas = somaNotas; }

    /**
     * Atribui o número de avaliações que o médico recebeu
     * @param numAvaliacoes número de avaliações que o médico recebeu
     */
    
    //metodo que devolve true caso o medico queira solicitar um exame
   /* public boolean solicitaExame(String realizar_exame){
        if(realizar_exame == "S" || realizar_exame == "s"){
            return true;
        }else{
            return false;
        }
    }*/

    /**
     * Atribui o número de avaliações a um médico
     * @param numAvaliacoes número de avaliações realizadass
     */

    public void setNumAvaliacoes(int numAvaliacoes) { this.numAvaliacoes = numAvaliacoes; }

    /**
     * Devolve informação relevante do Medico
     * @return conjunto de dados do Medico
     */

    public String toString() {
        String info;
        info = super.toString() + " ";
        info += "Numero: " + numeroMedico + " || ";
        info += "Especialidade: " + especialidade;
        return info;
    }
        
}
