public class ComissaoArte implements iRegraComissao {
    @Override
    public String getNome() {
        return "Arte (20% do valor)";
    }

    @Override
    public double calcular(double valorVenda) {
        return valorVenda * 0.20;
    }
}
