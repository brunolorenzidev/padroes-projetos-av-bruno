public class SeguroTransporte extends absServicoDecorator {
    public SeguroTransporte(iItemFatura item) {
        super(item);
    }

    @Override
    protected String getNomeServico() {
        return "Seguro de transporte";
    }

    @Override
    protected double getCustoServico() {
        return valorVenda() * 0.015;
    }
}
