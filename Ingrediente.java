public class Ingrediente extends Produto {
    private String unidadeMedida;

    public Ingrediente(int id, String nome, double custo, String unidadeMedida) {
        super(id, nome, custo);
        this.unidadeMedida = unidadeMedida;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Ingrediente ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Custo: R$" + getCusto());
        System.out.println("Unidade de Medida: " + unidadeMedida);
    }
}
