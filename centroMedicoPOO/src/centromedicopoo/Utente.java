package centromedicopoo;

public class Utente extends Individuo {
    
    private int numeroUtente;
    private int consultasSemana;
    private double descontoConsultas;
    private double descontoExames;
    private double dinheiroGasto;
    private boolean temSeguro;
    private String data;
    private double creditoCM;
    private boolean utentesAngariados;
    
    private final int CONSULTAS_SEMANA = 4;
   
    ////////////////////////// *** Construtores *** //////////////////////////

    public Utente(String nome, int idade, int numeroUtente, int consultasSemana, double descontoConsultas, double descontoExames, double dinheiroGasto, boolean temSeguro, double creditoCM, boolean utentesAngariados) {
        super(nome, idade);
        this.numeroUtente = numeroUtente;
        this.consultasSemana = consultasSemana;
        this.descontoConsultas = descontoConsultas;
        this.descontoExames = descontoExames;
        this.dinheiroGasto = dinheiroGasto;
        this.temSeguro = temSeguro;
        this.creditoCM = creditoCM;
        this.utentesAngariados = utentesAngariados;
    }
    
    public Utente() {
        
    }

    public Utente(String nome, int idade, int numeroUtente, boolean temSeguro) {
        super(nome, idade);
        this.numeroUtente = numeroUtente;
        this.temSeguro = temSeguro;
    }

    public Utente(String nome, double descontoConsultas, double descontoExames) {
        super(nome);
        this.descontoConsultas = descontoConsultas;
        this.descontoExames = descontoExames;
    }
    
    public Utente(String nome, int numeroUtente, String data){
        super(nome);
        this.numeroUtente = numeroUtente;
        this.data = data;
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

    public double getDescontoConsultas() {
        return descontoConsultas;
    }

    /**
     * Devolve o desconto que o utente tem nos exames
     * @return desconto que o utente tem nos exames
     */

    public double getDescontoExames() {
        return descontoExames;
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

    /**
     * Devolve o crédito de um utente
     * @return crédito total que um utente tem
     */

    public double getCreditoCM() {
        return creditoCM;
    }

    /**
     * Devolve se o utente angariou, ou não, utentes
     * @return booleano se o utente angariou utentes
     */

    public boolean getUtentesAngariados() {
        return utentesAngariados;
    }

    /*public List<Consulta> getTesteConsultasLista() {
        return new ArrayList<Consulta>(this.testeConsultasLista);
    }*/

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
     * @param descontoConsultas desconto do utente nas consultas
     */

    public void setDescontoConsultas(double descontoConsultas) {
        this.descontoConsultas = descontoConsultas;
    }

    /**
     * Atribui desconto que o utente recebe nos exames
     * @param descontoExames desconto do utente nos exames
     */

    public void setDescontoExames(double descontoExames) {
        this.descontoExames = descontoExames;
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

    /**
     * Atribui crédito a um utente
     * @param creditoCM crédito que um utente vai passar a ter
     */

    public void setCreditoCM(double creditoCM) {
        this.creditoCM = creditoCM;
    }

    /**
     * Atribui um booleano se o utente angariou, ou não, utentes
     * @param utentesAngariados booleano se o utente angariou utentes
     */

    public void setUtentesAngariados(boolean utentesAngariados) {
        this.utentesAngariados = utentesAngariados;
    }

    /**
     * Devolve informação relevante do Utente
     * @return conjunto de dados de utentes
     */

    public String toString() {
        String info;
        info = super.toString();
        info += "Numero: " + numeroUtente + " || ";
        info += "Seguro: " + temSeguro + "||";
        info += "Crédito: " + creditoCM + "||";
        info += "Angariou utentes: " + utentesAngariados + "\n";
        return info;
    }

}
