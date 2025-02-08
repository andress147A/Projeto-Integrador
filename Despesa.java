public class Despesa extends Produto {
    private String descricao;

    public Despesa(int id, String nome, double custo, String descricao) {
        super(id, nome, custo);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Despesa ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Custo: R$" + getCusto());
        System.out.println("Descrição: " + descricao);
    }
}
