package centromedicopoo;

public class Individuo {
    
    private String nome;
    private int idade;

    ////////////////////////// *** Construtores *** //////////////////////////
    
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

    ////////////////////////// *** Getters e setters *** //////////////////////////
    
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
    
}
