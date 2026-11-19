import java.time.LocalDateTime;

public class Lance {
    private iInteressado autor;
    private double valor;
    private LocalDateTime dataHora;

    public Lance(iInteressado autor, double valor) {
        this.autor = autor;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }

    public iInteressado getAutor() {
        return autor;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
