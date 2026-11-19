public class FilaAws implements iFila {
    private String id;

    public FilaAws(int numero) {
        this.id = "sqs-" + numero;
    }

    @Override
    public String getId() {
        return id;
    }
}
