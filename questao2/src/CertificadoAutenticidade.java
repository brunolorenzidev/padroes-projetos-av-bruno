public class CertificadoAutenticidade extends absServicoDecorator {
    public CertificadoAutenticidade(iItemFatura item) {
        super(item);
    }

    @Override
    protected String getNomeServico() {
        return "Certificado de autenticidade";
    }

    @Override
    protected double getCustoServico() {
        return 300.00;
    }
}
