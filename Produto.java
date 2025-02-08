public abstract class Produto {
    private int id;
    private String nome;
    private double custo;

    public Produto(int id, String nome, double custo) {
        this.id = id;
        this.nome = nome;
        this.custo = custo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getCusto() {
        return custo;
    }

    public abstract void exibirInformacoes();
}
