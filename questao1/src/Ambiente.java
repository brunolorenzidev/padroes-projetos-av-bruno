import java.util.ArrayList;
import java.util.List;

public class Ambiente {
    private String nome;
    private String provedor;
    private String regiao;
    private List<iMaquinaVirtual> maquinas;
    private iArmazenamento armazenamento;
    private iFila fila;
    private double custoMensal;

    public Ambiente(String nome, String provedor, String regiao, List<iMaquinaVirtual> maquinas,
                    iArmazenamento armazenamento, iFila fila, double custoMensal) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = new ArrayList<>(maquinas);
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensal = custoMensal;
    }

    public String getNome() {
        return nome;
    }

    public String getProvedor() {
        return provedor;
    }

    public double getCustoMensal() {
        return custoMensal;
    }

    public String resumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Ambiente provisionado ===\n");
        sb.append("Ambiente : ").append(nome).append("\n");
        sb.append("Provedor : ").append(provedor).append("\n");
        sb.append("Regiao   : ").append(regiao).append("\n");
        for (iMaquinaVirtual m : maquinas) {
            sb.append("Maquina virtual : ").append(m.getId()).append("\n");
        }
        sb.append("Armazenamento   : ").append(armazenamento.getId())
          .append(" (").append(armazenamento.getGb()).append(" GB)\n");
        sb.append("Fila            : ").append(fila.getId()).append("\n");
        sb.append(String.format("Custo mensal estimado: R$ %.2f", custoMensal)).append("\n");
        return sb.toString();
    }
}
