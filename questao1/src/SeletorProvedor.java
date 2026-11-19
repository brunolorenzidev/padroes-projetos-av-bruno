public class SeletorProvedor {
    public static iFabricaNuvem escolher(String provedor) {
        switch (provedor) {
            case "AWS":
                return new FabricaAws();
            case "AZURE":
                return new FabricaAzure();
            default:
                throw new IllegalArgumentException("Provedor desconhecido: " + provedor);
        }
    }
}
