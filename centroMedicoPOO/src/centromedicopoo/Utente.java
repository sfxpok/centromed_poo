/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centromedicopoo;

/**
 *
 * @author r
 */
public class Utente extends Individuo {
    
    // Variáveis de instância
    
    private int numeroUtente;
    private int consultasSemana;
    private double descontoAcumulado;
    private double dinheiroGasto;
    private boolean temSeguro;
    
    // Construtor
    
    public Utente(String nome, int idade, int numeroUtente, int consultasSemana, double descontoAcumulado, double dinheiroGasto, boolean temSeguro) {
        super(nome, idade);
        this.numeroUtente = numeroUtente;
        this.consultasSemana = consultasSemana;
        this.descontoAcumulado = descontoAcumulado;
        this.dinheiroGasto = dinheiroGasto;
        this.temSeguro = temSeguro;
    }
    
    public Utente() {
        
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
    
    /////////////////////////////////////////////
    
}
