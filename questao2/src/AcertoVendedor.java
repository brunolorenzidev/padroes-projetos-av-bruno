public class AcertoVendedor {
    public static void imprimir(Lote lote) {
        System.out.println("=== Acerto do vendedor: " + lote.getNome() + " ===");
        if (!lote.isVendido()) {
            System.out.println("Lote nao vendido: nao ha valor a repassar.");
            return;
        }
        double comissao = lote.calcularComissao();
        System.out.println(String.format("Valor de venda: R$ %.2f", lote.getValorVenda()));
        System.out.println(String.format("Comissao cobrada (%s): R$ %.2f", lote.getRegraComissao().getNome(), comissao));
        System.out.println(String.format("Valor liquido a repassar: R$ %.2f", lote.getValorVenda() - comissao));
    }
}
