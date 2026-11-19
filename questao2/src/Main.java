public class Main {
    public static void main(String[] args) {

        Lote quadro = new Lote("Quadro Abstrato", "Arte", 1000.00, 2000.00, new ComissaoArte());
        Lote notebook = new Lote("Notebook Gamer", "Eletronicos", 3000.00, 6000.00, new ComissaoEletronicos());

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        quadro.adicionarInteressado(ana);
        quadro.adicionarInteressado(bruno);
        quadro.adicionarInteressado(carla);
        quadro.adicionarInteressado(painel);
        quadro.adicionarInteressado(auditor);

        notebook.adicionarInteressado(bruno);
        notebook.adicionarInteressado(carla);
        notebook.adicionarInteressado(painel);
        notebook.adicionarInteressado(auditor);

        System.out.println("##### Leilao do lote: Quadro Abstrato #####");
        quadro.darLance(ana, 1050.00);
        quadro.darLance(bruno, 1060.00);
        System.out.println("Carla deixa de acompanhar o Quadro Abstrato.");
        quadro.removerInteressado(carla);
        quadro.darLance(bruno, 1200.00);
        quadro.darLance(ana, 2300.00);

        System.out.println("\n##### Leilao do lote: Notebook Gamer #####");
        notebook.darLance(bruno, 3200.00);
        notebook.darLance(carla, 3300.00);

        System.out.println("\n##### Campanha: troca da regra de comissao #####");
        System.out.println("Regra atual do Quadro Abstrato: " + quadro.getRegraComissao().getNome());
        quadro.setRegraComissao(new ComissaoEletronicos());
        System.out.println("Nova regra do Quadro Abstrato : " + quadro.getRegraComissao().getNome());

        System.out.println("\n##### Encerramentos #####");
        quadro.encerrar();
        notebook.encerrar();
        quadro.darLance(carla, 2500.00);

        System.out.println();
        AcertoVendedor.imprimir(quadro);
        AcertoVendedor.imprimir(notebook);

        System.out.println("\n##### Fatura do comprador do Quadro Abstrato #####");
        iItemFatura fatura = new VendaLote(quadro.getNome(), quadro.getValorVenda());
        fatura = new SeguroTransporte(fatura);
        fatura = new CertificadoAutenticidade(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EmbalagemEspecial(fatura);
        Fatura.imprimir(fatura);

        System.out.println("\n##### Fatura sem servicos adicionais (mesmo codigo de impressao) #####");
        Fatura.imprimir(new VendaLote(quadro.getNome(), quadro.getValorVenda()));
    }
}
