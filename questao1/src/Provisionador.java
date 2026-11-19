import java.util.ArrayList;
import java.util.List;

public class Provisionador {
    private static final int HORAS_MES = 730;

    private iFabricaNuvem fabrica;

    public Provisionador(iFabricaNuvem fabrica) {
        this.fabrica = fabrica;
    }

    public double estimarCusto(Solicitacao s) {
        return s.getQuantidadeMaquinas() * fabrica.getCustoHoraMaquina() * HORAS_MES
                + s.getQuantidadeGb() * fabrica.getCustoGbArmazenamento()
                + fabrica.getCustoFila();
    }

    public Ambiente provisionar(Solicitacao s) {
        Configuracao config = Configuracao.getInstance();
        AuditLog log = AuditLog.getInstance();
        double custo = estimarCusto(s);

        if (custo > config.getOrcamentoMaximo()) {
            log.registrar(s.getNomeAmbiente(), fabrica.getNome(), String.format(
                    "RECUSADO (custo estimado R$ %.2f acima do orcamento de R$ %.2f)",
                    custo, config.getOrcamentoMaximo()));
            System.out.println(String.format("Ambiente %s (%s) RECUSADO: custo estimado R$ %.2f acima do orcamento de R$ %.2f",
                    s.getNomeAmbiente(), fabrica.getNome(), custo, config.getOrcamentoMaximo()));
            return null;
        }

        List<iMaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 0; i < s.getQuantidadeMaquinas(); i++) {
            maquinas.add(fabrica.criarMaquinaVirtual());
        }
        iArmazenamento armazenamento = fabrica.criarArmazenamento(s.getQuantidadeGb());
        iFila fila = fabrica.criarFila();

        Ambiente ambiente = new Ambiente(s.getNomeAmbiente(), fabrica.getNome(), config.getRegiao(),
                maquinas, armazenamento, fila, custo);
        log.registrar(s.getNomeAmbiente(), fabrica.getNome(), "ACEITO");
        System.out.println(ambiente.resumo());
        return ambiente;
    }
}
