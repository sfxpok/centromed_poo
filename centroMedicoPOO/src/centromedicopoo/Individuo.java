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
public class Individuo {
    
    // Variáveis de instância
    
    private String nome;
    private int idade;
    
    // Construtor
    
    public Individuo(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Individuo(String nome) {
        this.nome = nome;
    }
    
    public Individuo() {
        this.nome = "";
        this.idade = 0;
    }
    
    ///////////// Getters e setters /////////////
    
    public String getNome() {
        return nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }

    // public String toString() { }

    /////////////////////////////////////////////
    
}
