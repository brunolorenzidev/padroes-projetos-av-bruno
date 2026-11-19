import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Solicitacao> solicitacoes = new ArrayList<>();
        solicitacoes.add(new Solicitacao("ambiente-web", "AWS", 2, 100));
        solicitacoes.add(new Solicitacao("ambiente-dados", "AZURE", 3, 200));
        solicitacoes.add(new Solicitacao("ambiente-teste", "AWS", 1, 50));

        solicitacoes.add(new Solicitacao("ambiente-gigante", "AZURE", 10, 500));

        List<Thread> threads = new ArrayList<>();
        for (Solicitacao s : solicitacoes) {
            Thread t = new Thread(new ProvisionamentoTarefa(s));
            threads.add(t);
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("=== Historico de auditoria ===");
        for (String registro : AuditLog.getInstance().getRegistros()) {
            System.out.println(registro);
        }
    }
}
