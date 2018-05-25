package centromedicopoo;

public class Pagamento extends Utente {

    //private double descontoConsultas = 1;     // Desconto das consultas, comprendido entre 0.0 e 1.0
    //private double descontoExames = 1;        // Desconto dos exames, comprendido entre 0.0 e 1.0
    //private double custoConsulta = 0;         // Custo final da Consulta
    //private double custoExame = 0;         // Custo final da Consulta

    // private double valorTotal;
    private double custoConsulta;
    private double custoExame;

    public Pagamento(String nome, double descontoConsultas, double descontoExames, double valorTotal) {
        super(nome, descontoConsultas, descontoExames);
        // this.valorTotal = valorTotal;
    }

    public Pagamento() {

    }

    /**
     * Verifica se um utente tem seguro
     * @param utentePaga utente que vai pagar
     */

    public void verificaSeguro(Utente utentePaga){
        // Método que verifica se o Utente tem, ou não, seguro

        if (utentePaga.getTemSeguro()){
            utentePaga.setDescontoConsultas(utentePaga.getDescontoConsultas() - 0.4);
            utentePaga.setDescontoExames(utentePaga.getDescontoExames() - 0.2);
        }
    }

    /**
     * Verifica se o utente tem acima de 65 anos
     * @param utentePaga utente que vai pagar
     */

    public void verificaIdoso(Utente utentePaga){
        // Método que verifica se o Utente é idoso (65 anos ou mais)

        if (utentePaga.getIdade() >= 65){
            utentePaga.setDescontoConsultas(0.1);
            utentePaga.setDescontoExames(0.1);
        }
    }

    /**
     * Verifica se o utente angariou alguém
     * @param utentePaga utente que vai pagar
     */

    public void verificaUtentesAngariados(Utente utentePaga){
        // Método que verifica se o Utente angariou novos utentes

        if (utentePaga.getUtentesAngariados()){
            utentePaga.setDescontoConsultas(utentePaga.getDescontoConsultas() - 0.05);
            utentePaga.setDescontoExames(utentePaga.getDescontoExames() - 0.05);
        }
    }

    /**
     * Calcula quanto é que o utente vai pagar para uma consulta de diagnósticos e
     * uma consulta de diagnósticos mais o exame (caso o mesmo peça)
     * @param utentePaga utente que vai realizar o pagamento
     * @param precoConsulta preço da consulta
     * @param precoExame preço do exame
     */

    public void calculaCustos(Utente utentePaga, int precoConsulta, int precoExame){
        // Calcula o custo da *CONSULTA*
        // e do *EXAME (CONSULTA + EXAME + RESULTADO)*

        // Método que executa as verificações (métodos acima descritos),
        // e calcula o custo "final" da consulta

        utentePaga.setDescontoConsultas(1);
        utentePaga.setDescontoExames(1);

        /* Executa as verificações */
        verificaSeguro(utentePaga);
        verificaIdoso(utentePaga);
        verificaUtentesAngariados(utentePaga);
        /* ----------------------- */

        custoConsulta = precoConsulta * utentePaga.getDescontoConsultas(); // diagnóstico só
        custoExame = (precoExame * utentePaga.getDescontoExames()) + custoConsulta; // diagnóstico, exame e resultados
    }

    /**
     * Débito de crédito se o utente não pediu exame quando fez a consulta
     * de diagnósticos
     * @param utentePaga utente que vai pagar
     */

    public void debitaCredito(Utente utentePaga) {
        // Retira o dinheiro da *Consulta*

        // Método que debita (retira) o crédito ou custo da consulta

        utentePaga.setCreditoCM(utentePaga.getCreditoCM() - custoConsulta);
    }

    /**
     * Débito de crédito se o utente pediu exame quando fez a consulta
     * de diagnósticos
     * @param utentePaga utente que vai pagar
     */

    public void debitaCreditoTresFases(Utente utentePaga){
        // Retira o dinheiro da *Consulta + Exame + Resultados*,

        // Método que debita (retira) o crédito ou custo da consulta (resultado)
        utentePaga.setCreditoCM(utentePaga.getCreditoCM() - custoExame);

    }

}
