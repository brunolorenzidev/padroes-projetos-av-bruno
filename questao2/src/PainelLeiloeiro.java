public class PainelLeiloeiro implements iInteressado {
    @Override
    public String getNome() {
        return "Painel do leiloeiro";
    }

    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.println(String.format("   [Painel do leiloeiro] Lote '%s': maior lance R$ %.2f | total de lances: %d",
                lote.getNome(), lote.getLanceAtual(), lote.getTotalLances()));
    }
}
