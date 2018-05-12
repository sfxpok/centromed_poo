package centromedicopoo;

import java.util.ArrayList;
import java.util.List;

public class Utente extends Individuo {
    
    // Variáveis de instância
    
    private int numeroUtente;
    private int consultasSemana;
    private double descontoAcumulado;
    private double dinheiroGasto;
    private boolean temSeguro;

    private List<Consulta> testeConsultasLista = new ArrayList<>();

    // Construtor
    
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

    ///////////// Getters e setters /////////////
    
    public int getNumeroUtente() {
        return numeroUtente;
    }
    
    public int getConsultasSemana() {
        return consultasSemana;
    }
    
    public double getDescontoAcumulado() {
        return descontoAcumulado;
    }
    
    public double getDinheiroGasto() {
        return dinheiroGasto;
    }
    
    public boolean getTemSeguro() {
        return temSeguro;
    }

    public List<Consulta> getTesteConsultasLista() {
        return new ArrayList<Consulta>(this.testeConsultasLista);
    }
    
    public void setNumeroUtente(int numeroUtente) {
        this.numeroUtente = numeroUtente;
    }
    
    public void setConsultasSemana(int consultasSemana) {
        this.consultasSemana = consultasSemana;
    }
    
    public void setDescontoAcumulado(double descontoAcumulado) {
        this.descontoAcumulado = descontoAcumulado;
    }
    
    public void setDinheiroGasto(double dinheiroGasto) {
        this.dinheiroGasto = dinheiroGasto;
    }
    
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
    
    /////////////////////////////////////////////
    
}
