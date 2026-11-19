import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracao {
    private static Configuracao instance;

    private String regiao;
    private double orcamentoMaximo;

    private Configuracao() {
        Properties props = new Properties();

        String[] caminhos = {"config.properties", "../config.properties", "questao1/config.properties"};
        boolean lido = false;
        for (String caminho : caminhos) {
            try (FileInputStream arquivo = new FileInputStream(caminho)) {
                props.load(arquivo);
                lido = true;
                break;
            } catch (IOException e) {

            }
        }
        if (!lido) {
            throw new IllegalStateException("Arquivo config.properties nao encontrado");
        }
        this.regiao = props.getProperty("regiao.padrao");
        this.orcamentoMaximo = Double.parseDouble(props.getProperty("orcamento.mensal.maximo"));
    }

    public static synchronized Configuracao getInstance() {
        if (Configuracao.instance == null) {
            Configuracao.instance = new Configuracao();
        }
        return Configuracao.instance;
    }

    public String getRegiao() {
        return regiao;
    }

    public double getOrcamentoMaximo() {
        return orcamentoMaximo;
    }
}
