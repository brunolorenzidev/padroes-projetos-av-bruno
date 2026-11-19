public class FabricaAws implements iFabricaNuvem {

    private int sequenciaMaquina = 0;
    private int sequenciaArmazenamento = 0;
    private int sequenciaFila = 0;

    @Override
    public String getNome() {
        return "AWS";
    }

    @Override
    public double getCustoHoraMaquina() {
        return 0.10;
    }

    @Override
    public double getCustoGbArmazenamento() {
        return 0.023;
    }

    @Override
    public double getCustoFila() {
        return 0.40;
    }

    @Override
    public iMaquinaVirtual criarMaquinaVirtual() {
        sequenciaMaquina++;
        return new MaquinaVirtualAws(sequenciaMaquina);
    }

    @Override
    public iArmazenamento criarArmazenamento(int gb) {
        sequenciaArmazenamento++;
        return new ArmazenamentoAws(sequenciaArmazenamento, gb);
    }

    @Override
    public iFila criarFila() {
        sequenciaFila++;
        return new FilaAws(sequenciaFila);
    }
}
