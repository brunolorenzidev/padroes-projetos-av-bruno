public class Solicitacao {
    private String nomeAmbiente;
    private String provedor;
    private int quantidadeMaquinas;
    private int quantidadeGb;

    public Solicitacao(String nomeAmbiente, String provedor, int quantidadeMaquinas, int quantidadeGb) {
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.quantidadeMaquinas = quantidadeMaquinas;
        this.quantidadeGb = quantidadeGb;
    }

    public String getNomeAmbiente() {
        return nomeAmbiente;
    }

    public String getProvedor() {
        return provedor;
    }

    public int getQuantidadeMaquinas() {
        return quantidadeMaquinas;
    }

    public int getQuantidadeGb() {
        return quantidadeGb;
    }
}
