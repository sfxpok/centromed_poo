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

    // Construtores

    public Medico(String nome, int idade, int numeroMedico, String especialidade, double avaliacaoMedia, int consultasDia) {
        super(nome, idade);
        this.numeroMedico = numeroMedico;
        this.especialidade = especialidade;
        this.avaliacaoMedia = avaliacaoMedia;
        this.consultasDia = consultasDia;
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

    // public String toString() { }

}
