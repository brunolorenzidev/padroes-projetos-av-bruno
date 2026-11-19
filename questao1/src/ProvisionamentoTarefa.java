public class ProvisionamentoTarefa implements Runnable {
    private Solicitacao solicitacao;

    public ProvisionamentoTarefa(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    @Override
    public void run() {
        iFabricaNuvem fabrica = SeletorProvedor.escolher(solicitacao.getProvedor());
        Provisionador provisionador = new Provisionador(fabrica);
        provisionador.provisionar(solicitacao);
    }
}
