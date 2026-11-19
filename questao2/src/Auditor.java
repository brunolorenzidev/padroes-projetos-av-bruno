import java.util.ArrayList;
import java.util.List;

public class Auditor implements iInteressado {
    private List<String> registros = new ArrayList<>();

    @Override
    public String getNome() {
        return "Auditor";
    }

    @Override
    public void atualizar(Lote lote, Lance lance) {
        String registro = String.format("%s | lote '%s' | %s | R$ %.2f",
                lance.getDataHora(), lote.getNome(), lance.getAutor().getNome(), lance.getValor());
        registros.add(registro);
        System.out.println("   [Auditor] " + registro);
    }

    public List<String> getRegistros() {
        return new ArrayList<>(registros);
    }
}
