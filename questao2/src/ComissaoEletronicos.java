public class ComissaoEletronicos implements iRegraComissao {
    @Override
    public String getNome() {
        return "Eletronicos (12% do valor, minimo de R$ 50,00)";
    }

    @Override
    public double calcular(double valorVenda) {
        return Math.max(valorVenda * 0.12, 50.00);
    }
}
