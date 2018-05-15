package centromedicopoo;

import java.util.ArrayList;
import java.util.List;

public class Utente extends Individuo {
    
    private int numeroUtente;
    private int consultasSemana;
    private double descontoAcumulado;
    private double dinheiroGasto;
    private boolean temSeguro;

    private List<Consulta> testeConsultasLista = new ArrayList<>();

    ////////////////////////// *** Construtores *** //////////////////////////

    public Utente(String nome, int idade, int numeroUtente, int consultasSemana, double descontoAcumulado, double dinheiroGasto, boolean temSeguro, List<Consulta> testeConsultasLista) {
        super(nome, idade);
        this.numeroUtente = numeroUtente;
        this.consultasSemana = consultasSemana;
        this.descontoAcumulado = descontoAcumulado;
        this.dinheiroGasto = dinheiroGasto;
        this.temSeguro = temSeguro;
        this.testeConsultasLista = testeConsultasLista;
    }
    
    public Utente() {
        
    }

    public Utente(String nome, int idade, int numeroUtente, boolean temSeguro) {
        super(nome, idade);
        this.numeroUtente = numeroUtente;
        this.temSeguro = temSeguro;
    }

    public Utente(String nome, boolean temSeguro, double descontoAcumulado) {
        super(nome);
        this.temSeguro = temSeguro;
        this.descontoAcumulado = descontoAcumulado;
    }

    public Utente(int numeroUtente) {
        this.numeroUtente = numeroUtente;
    }

    ////////////////////////// *** Getters e setters *** //////////////////////////

    /**
     * Devolve o número do utente
     * @return número do utente
     */

    public int getNumeroUtente() {
        return numeroUtente;
    }

    /**
     * Devolve o número de consultas que o utente tem na semana atual
     * @return número de consultas que o utente tem na semana atual
     */

    public int getConsultasSemana() {
        return consultasSemana;
    }

    /**
     * Devolve o desconto que o utente tem nas consultas
     * @return desconto que o utente tem nas consultas
     */

    public double getDescontoAcumulado() {
        return descontoAcumulado;
    }


    /**
     * Devolve o dinheiro gasto pelo utente no centro médico
     * @return dinheiro gasto pelo utente no centro médico
     */

    public double getDinheiroGasto() {
        return dinheiroGasto;
    }

    /**
     * Devolve um booleano se o utente tem seguro ou não
     * @return booleano se o utente tem seguro ou não
     */

    public boolean getTemSeguro() {
        return temSeguro;
    }

    public List<Consulta> getTesteConsultasLista() {
        return new ArrayList<Consulta>(this.testeConsultasLista);
    }

    /**
     * Atribui um número único ao utente
     * @param numeroUtente número único do utente
     */

    public void setNumeroUtente(int numeroUtente) {
        this.numeroUtente = numeroUtente;
    }

    /**
     * Atribui o número de consultas que o utente vai fazer na semana atual
     * @param consultasSemana número de consultas que o utente vai fazer na semana atual
     */

    public void setConsultasSemana(int consultasSemana) {
        this.consultasSemana = consultasSemana;
    }

    /**
     * Atribui um desconto ao utente nas consultas
     * @param descontoAcumulado desconto do utente nas consultas
     */

    public void setDescontoAcumulado(double descontoAcumulado) {
        this.descontoAcumulado = descontoAcumulado;
    }

    /**
     * Atribui o dinheiro gasto pelo utente
     * @param dinheiroGasto dinheiro gasto pelo utente
     */

    public void setDinheiroGasto(double dinheiroGasto) {
        this.dinheiroGasto = dinheiroGasto;
    }

    /**
     * Atribui um booleano se o utente tem (ou não) seguro
     * @param temSeguro boolean se o utente tem (ou não) seguro
     */

    public void setTemSeguro(boolean temSeguro) {
        this.temSeguro = temSeguro;
    }

//    public void setTesteConsultasLista(int numeroUtente) {
//        this.numeroUtente = numeroUtente;
//    }

    public void setTesteConsultasLista(List<Consulta> list) {
        this.testeConsultasLista = new ArrayList<Consulta>(list);
    }

    // public String toString() { }

}
