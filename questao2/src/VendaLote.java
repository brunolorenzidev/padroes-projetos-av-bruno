public class VendaLote implements iItemFatura {
    private String nomeLote;
    private double valorVenda;

    public VendaLote(String nomeLote, double valorVenda) {
        this.nomeLote = nomeLote;
        this.valorVenda = valorVenda;
    }

    @Override
    public String descricao() {
        return String.format("Lote: %s\nValor de venda: R$ %.2f", nomeLote, valorVenda);
    }

    @Override
    public double custo() {
        return valorVenda;
    }

    @Override
    public double valorVenda() {
        return valorVenda;
    }
}
