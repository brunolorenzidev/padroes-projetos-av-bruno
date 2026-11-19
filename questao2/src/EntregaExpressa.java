public class EntregaExpressa extends absServicoDecorator {
    public EntregaExpressa(iItemFatura item) {
        super(item);
    }

    @Override
    protected String getNomeServico() {
        return "Entrega expressa";
    }

    @Override
    protected double getCustoServico() {
        return 450.00;
    }
}
