public class FabricaAzure implements iFabricaNuvem {

    private int sequenciaMaquina = 0;
    private int sequenciaArmazenamento = 0;
    private int sequenciaFila = 0;

    @Override
    public String getNome() {
        return "AZURE";
    }

    @Override
    public double getCustoHoraMaquina() {
        return 0.12;
    }

    @Override
    public double getCustoGbArmazenamento() {
        return 0.02;
    }

    @Override
    public double getCustoFila() {
        return 0.50;
    }

    @Override
    public iMaquinaVirtual criarMaquinaVirtual() {
        sequenciaMaquina++;
        return new MaquinaVirtualAzure(sequenciaMaquina);
    }

    @Override
    public iArmazenamento criarArmazenamento(int gb) {
        sequenciaArmazenamento++;
        return new ArmazenamentoAzure(sequenciaArmazenamento, gb);
    }

    @Override
    public iFila criarFila() {
        sequenciaFila++;
        return new FilaAzure(sequenciaFila);
    }
}
