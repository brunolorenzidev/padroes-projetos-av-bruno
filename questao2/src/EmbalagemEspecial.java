public class EmbalagemEspecial extends absServicoDecorator {
    public EmbalagemEspecial(iItemFatura item) {
        super(item);
    }

    @Override
    protected String getNomeServico() {
        return "Embalagem especial";
    }

    @Override
    protected double getCustoServico() {
        return 180.00;
    }
}
