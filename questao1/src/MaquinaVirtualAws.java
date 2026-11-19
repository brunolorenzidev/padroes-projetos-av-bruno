public class MaquinaVirtualAws implements iMaquinaVirtual {
    private String id;

    public MaquinaVirtualAws(int numero) {
        this.id = "i-" + numero;
    }

    @Override
    public String getId() {
        return id;
    }
}
