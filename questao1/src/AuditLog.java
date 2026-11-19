import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AuditLog {
    private static AuditLog instance;

    private List<String> registros = new ArrayList<>();

    private AuditLog() {
    }

    public static synchronized AuditLog getInstance() {
        if (AuditLog.instance == null) {
            AuditLog.instance = new AuditLog();
        }
        return AuditLog.instance;
    }

    public synchronized void registrar(String ambiente, String provedor, String resultado) {
        registros.add(LocalDateTime.now() + " | ambiente=" + ambiente
                + " | provedor=" + provedor + " | resultado=" + resultado);
    }

    public synchronized List<String> getRegistros() {
        return new ArrayList<>(registros);
    }
}
