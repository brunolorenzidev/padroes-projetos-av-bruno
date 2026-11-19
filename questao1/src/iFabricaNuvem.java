public interface iFabricaNuvem {
    String getNome();

    double getCustoHoraMaquina();
    double getCustoGbArmazenamento();
    double getCustoFila();

    iMaquinaVirtual criarMaquinaVirtual();
    iArmazenamento criarArmazenamento(int gb);
    iFila criarFila();
}
