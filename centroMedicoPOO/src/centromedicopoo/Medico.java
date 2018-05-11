/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centromedicopoo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author r
 */
public class Medico extends Individuo {
    
    // Variáveis de instância
    
    private int numeroMedico;
    private String especialidade;
    private double avaliacaoMedia;
    private int consultasDia;

    private int numAvaliacoes;
    private double somaNotas;

    // Construtores

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

    static String[] especialidades = {"Pediatra","Cardiologia","Neurologia","Radiologia","Urologia"};


    public int getNumeroMedico() {
        return numeroMedico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public double getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    public int getConsultasDia() {
        return consultasDia;
    }

    public void setNumeroMedico(int numeroMedico) {
        this.numeroMedico = numeroMedico;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setAvaliacaoMedia(double avaliacaoMedia) {
        this.avaliacaoMedia = avaliacaoMedia;
    }

    public void setConsultasDia(int consultasDia) {
        this.consultasDia = consultasDia;
    }

    /////////////////////////////// CLASSES NOVAS ///////////////////////////////

    public int getNumAvaliacoes() { return numAvaliacoes; }
    public void setNumAvaliacoes(int numAvaliacoes) { this.numAvaliacoes = numAvaliacoes; }

    public double getSomaNotas() { return somaNotas; }
    public void setSomaNotas(double somaNotas) { this.somaNotas = somaNotas; }

    /////////////////////////////////////////////////////////////////////////////

    // public String toString() { }

}
