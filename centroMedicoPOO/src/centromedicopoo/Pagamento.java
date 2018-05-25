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

    public void verificaSeguro(Utente utentePaga){
        // Método que verifica se o Utente tem, ou não, seguro

        if (utentePaga.getTemSeguro()){
            utentePaga.setDescontoConsultas(utentePaga.getDescontoConsultas() - 0.4);
            utentePaga.setDescontoExames(utentePaga.getDescontoExames() - 0.2);
        }
    }

    public void verificaIdoso(Utente utentePaga){
        // Método que verifica se o Utente é idoso (65 anos ou mais)

        if (utentePaga.getIdade() >= 65){
            utentePaga.setDescontoConsultas(0.1);
            utentePaga.setDescontoExames(0.1);
        }
    }


    public void calculaCustos(Utente utentePaga, int precoConsulta, int precoExame){
        // TESTE: Calcula o custo da *CONSULTA*
        // e do *EXAME (CONSULTA + EXAME + RESULTADO)*

        // Método que executa as verificações (métodos acima descritos),
        // e calcula o custo "final" da consulta

        utentePaga.setDescontoConsultas(1);
        utentePaga.setDescontoExames(1);

        /* Executa as verificações */
        verificaSeguro(utentePaga);
        verificaIdoso(utentePaga);
        //verificaUtentesAngariados();
        /* ----------------------- */

        custoConsulta = precoConsulta * utentePaga.getDescontoConsultas(); // diagnóstico só
        custoExame = (precoExame * utentePaga.getDescontoExames()) + custoConsulta; // diagnóstico, exame e resultados
    }

    //////////////////// ALTERAR PARA AS CONSULTAS ////////////////////

    public void debitaCredito(Utente utentePaga) {
        // TESTE: Retira o dinheiro da *Consulta*, falta a questão dos dias

        // Método que debita (retira) o crédito ou custo da consulta

        utentePaga.setCreditoCM(utentePaga.getCreditoCM() - custoConsulta);
    }
//
    public void debitaCreditoTresFases(Utente utentePaga){
        // TESTE: Retira o dinheiro da *Consulta + Exame + Resultados*,
        // falta a questão dos dias

        // Método que debita (retira) o crédito ou custo da consulta (resultado)
        utentePaga.setCreditoCM(utentePaga.getCreditoCM() - custoExame);

    }

    //////////////////// //////////////////// //////////////////// ////////////////////

}
