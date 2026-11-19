public class MaquinaVirtualAzure implements iMaquinaVirtual {
    private String id;

    public MaquinaVirtualAzure(int numero) {
        this.id = "vm-" + numero;
    }

    @Override
    public String getId() {
        return id;
    }
}
