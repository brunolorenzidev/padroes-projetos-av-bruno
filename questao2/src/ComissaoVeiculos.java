public class ComissaoVeiculos implements iRegraComissao {
    @Override
    public String getNome() {
        return "Veiculos (8% do valor, limite de R$ 5000,00)";
    }

    @Override
    public double calcular(double valorVenda) {
        return Math.min(valorVenda * 0.08, 5000.00);
    }
}
