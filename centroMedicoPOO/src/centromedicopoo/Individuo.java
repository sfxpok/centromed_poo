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

    /**
     * Devolve o nome de um indivíduo
     * @return nome de um indivíduo
     */

    public String getNome() {
        return nome;
    }

    /**
     * Devolve a idade de um indivíduo
     * @return idade de um indivíduo
     */
    
    public int getIdade() {
        return idade;
    }

    /**
     * Atribui um nome a um indivíduo
     * @param nome nome de um indivíduo
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Atribui uma idade a um indivíduo
     * @param idade idade de um indivíduo
     */

    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Devolve informação relevante do Individuo
     * @return conjunto de dados relevantes da classe
     */

    public String toString() {
        String info;
        info = "Nome: " + nome + " || ";
        info += "Idade: " + idade + " || ";
        return info;
    } 
    
}
