public class FilaAzure implements iFila {
    private String id;

    public FilaAzure(int numero) {
        this.id = "sb-" + numero;
    }

    @Override
    public String getId() {
        return id;
    }
}
