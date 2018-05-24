package centromedicopoo;

public class Pagamento extends Utente {

    private double descontoConsultas = 1;     // Desconto das consultas, comprendido entre 0.0 e 1.0
    private double descontoExames = 1;        // Desconto dos exames, comprendido entre 0.0 e 1.0
    private double custoConsulta = 0;         // Custo final da Consulta
    private double custoExame = 0;         // Custo final da Consulta

    private double valorTotal;

    public Pagamento(String nome, boolean temSeguro, double descontoConsultas, double descontoExames, double valorTotal) {
        // super(nome, temSeguro);
        this.descontoConsultas = descontoConsultas;
        this.descontoExames = descontoExames;
        this.valorTotal = valorTotal;
    }

    public Pagamento() {

    }

//    public void verificaSeguro() {
//
//        if (Utente.seguro == true){
//            descontoConsultas = descontoConsultas - 0.4;
//            descontoExames = descontoExames - 0.2;
//        }
//
//    }
//
//    public void verificaIdoso() {
//
//        if (Utente.idade >= 65){
//            descontoConsultas = 0.1;
//            descontoExames = 0.1;
//        }
//
//    }
//
//    public void verificaUtentesAngariados() {
//
//        if (Utente.utentesAngariados == true){
//            descontoConsultas = descontoConsultas - 0.05;
//            descontoExames = descontoExames - 0.05;
//        }
//
//    }

    //////////////////// ALTERAR PARA AS CONSULTAS ////////////////////

//    public void debitaCredito(){
//        // TESTE: Retira o dinheiro da *Consulta*, falta a questão dos dias
//
//        // Método que debita (retira) o crédito ou custo da consulta
//
//        Utente.creditoCM = Utente.creditoCM - custoConsulta;
//    }
//
//    public void debitaCredito3Fases(){
//        // TESTE: Retira o dinheiro da *Consulta + Exame + Resultados*,
//        // falta a questão dos dias
//
//        // Método que debita (retira) o crédito ou custo da consulta (resultado)
//        if (Dia.numeroDia - Dia.diaExame >= 7){
//            Utente.creditoCM = Utente.creditoCM - custoExame;
//        }
//        else{
//            int aux = Dia.diaExame +7;
//            System.out.println("Ainda não é possível efetuar o pagamento do Exame");
//            System.out.println("Apenas a partir do dia " + aux + " !");
//        }
//    }

    //////////////////// //////////////////// //////////////////// ////////////////////

}
