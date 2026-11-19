public class ArmazenamentoAzure implements iArmazenamento {
    private String id;
    private int gb;

    public ArmazenamentoAzure(int numero, int gb) {
        this.id = "blob://" + numero;
        this.gb = gb;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getGb() {
        return gb;
    }
}
