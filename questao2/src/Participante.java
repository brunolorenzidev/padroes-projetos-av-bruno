public class Participante implements iInteressado {
    private String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.println(String.format("   [%s] Lote '%s' recebeu novo lance: R$ %.2f",
                nome, lote.getNome(), lance.getValor()));
    }
}
