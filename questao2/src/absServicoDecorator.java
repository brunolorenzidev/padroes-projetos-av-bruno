public abstract class absServicoDecorator implements iItemFatura {
    protected iItemFatura item;

    public absServicoDecorator(iItemFatura item) {
        this.item = item;
    }

    protected abstract String getNomeServico();

    protected abstract double getCustoServico();

    @Override
    public String descricao() {
        return item.descricao() + String.format("\n  + %s: R$ %.2f", getNomeServico(), getCustoServico());
    }

    @Override
    public double custo() {
        return item.custo() + getCustoServico();
    }

    @Override
    public double valorVenda() {
        return item.valorVenda();
    }
}
