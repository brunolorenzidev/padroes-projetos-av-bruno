public class ComissaoImoveis implements iRegraComissao {
    @Override
    public String getNome() {
        return "Imoveis (3% do valor + R$ 1500,00)";
    }

    @Override
    public double calcular(double valorVenda) {
        return valorVenda * 0.03 + 1500.00;
    }
}
