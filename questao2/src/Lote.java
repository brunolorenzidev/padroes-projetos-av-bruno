import java.util.ArrayList;
import java.util.List;

public class Lote {
    private String nome;
    private String categoria;
    private double precoInicial;
    private double precoReserva;
    private double lanceAtual;
    private boolean aberto = true;
    private boolean vendido = false;
    private iInteressado comprador;
    private double valorVenda;
    private iRegraComissao regraComissao;
    private List<iInteressado> interessados = new ArrayList<>();
    private List<Lance> lances = new ArrayList<>();

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, iRegraComissao regraComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = regraComissao;
    }

    public void adicionarInteressado(iInteressado interessado) {
        interessados.add(interessado);
    }

    public void removerInteressado(iInteressado interessado) {
        interessados.remove(interessado);
    }

    private void notificarInteressados(Lance lance) {
        for (iInteressado interessado : new ArrayList<>(interessados)) {
            if (interessado != lance.getAutor()) {
                interessado.atualizar(this, lance);
            }
        }
    }

    public boolean darLance(iInteressado autor, double valor) {
        if (!aberto) {
            System.out.println(String.format("Lance de %s (R$ %.2f) RECUSADO: o lote '%s' esta encerrado.",
                    autor.getNome(), valor, nome));
            return false;
        }
        double minimo = lanceAtual * 1.05;
        if (valor < minimo - 0.000001) {
            System.out.println(String.format("Lance de %s (R$ %.2f) RECUSADO no lote '%s': precisa ser pelo menos 5%% maior que o lance atual (minimo R$ %.2f).",
                    autor.getNome(), valor, nome, minimo));
            return false;
        }
        Lance lance = new Lance(autor, valor);
        lances.add(lance);
        lanceAtual = valor;
        System.out.println(String.format("Lance de %s (R$ %.2f) ACEITO no lote '%s'.",
                autor.getNome(), valor, nome));
        notificarInteressados(lance);
        return true;
    }

    public void encerrar() {
        aberto = false;
        if (!lances.isEmpty() && lanceAtual >= precoReserva) {
            vendido = true;
            valorVenda = lanceAtual;
            comprador = lances.get(lances.size() - 1).getAutor();
            System.out.println(String.format("Lote '%s' encerrado: VENDIDO para %s por R$ %.2f.",
                    nome, comprador.getNome(), valorVenda));
        } else {
            System.out.println(String.format("Lote '%s' encerrado: NAO VENDIDO (maior lance R$ %.2f, reserva R$ %.2f).",
                    nome, lanceAtual, precoReserva));
        }
    }

    public void setRegraComissao(iRegraComissao novaRegra) {
        if (!aberto) {
            System.out.println("Nao e possivel trocar a regra de comissao de um lote encerrado.");
            return;
        }
        this.regraComissao = novaRegra;
    }

    public iRegraComissao getRegraComissao() {
        return regraComissao;
    }

    public double calcularComissao() {
        return regraComissao.calcular(valorVenda);
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecoInicial() {
        return precoInicial;
    }

    public double getPrecoReserva() {
        return precoReserva;
    }

    public double getLanceAtual() {
        return lanceAtual;
    }

    public int getTotalLances() {
        return lances.size();
    }

    public boolean isAberto() {
        return aberto;
    }

    public boolean isVendido() {
        return vendido;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public iInteressado getComprador() {
        return comprador;
    }
}
