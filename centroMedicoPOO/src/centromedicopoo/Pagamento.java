package centromedicopoo;

public class Pagamento extends Utente {

    private double valorTotal;

    public Pagamento(String nome, boolean temSeguro, double descontoAcumulado, double valorTotal) {
        super(nome, temSeguro, descontoAcumulado);
        this.valorTotal = valorTotal;
    }

    public Pagamento() {

    }

    // public static int pagamentoUtente(int paga) { }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal() {
        this.valorTotal = valorTotal;
    }

}
