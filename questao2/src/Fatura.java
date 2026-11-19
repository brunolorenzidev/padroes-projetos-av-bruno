public class Fatura {
    public static void imprimir(iItemFatura item) {
        System.out.println("=== Fatura do comprador ===");
        System.out.println(item.descricao());
        System.out.println(String.format("TOTAL A PAGAR: R$ %.2f", item.custo()));
    }
}
