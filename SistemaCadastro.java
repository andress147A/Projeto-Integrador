import java.util.Scanner;

public class SistemaCadastro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();
        int opcao;

        do {            
			System.out.println("==========CADASTRO===========");
            System.out.println("1. Adicionar Ingrediente");
            System.out.println("2. Adicionar Despesa");
            System.out.println("3. Buscar Produto por ID");
            System.out.println("4. Exibir Todos os Produtos");
            System.out.println("5. Ordenar Ingredientes por Nome");
            System.out.println("6. Buscar Ingrediente por Nome");
            System.out.println("7. Sair");
            System.out.println("==========   X   ===========");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    try {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Custo: ");
                        double custo = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Unidade de Medida: ");
                        String unidadeMedida = scanner.nextLine();

                        gerenciador.adicionarProduto(new Ingrediente(id, nome, custo, unidadeMedida));
                        System.out.println("Ingrediente adicionado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Custo: ");
                        double custo = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Descrição: ");
                        String descricao = scanner.nextLine();

                        gerenciador.adicionarProduto(new Despesa(id, nome, custo, descricao));
                        System.out.println("Despesa adicionada com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do produto: ");
                    int idBusca = scanner.nextInt();
                    try {
                        Produto produto = gerenciador.buscarProduto(idBusca);
                        produto.exibirInformacoes();
                    } catch (CadastroException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    gerenciador.exibirTodosProdutos();
                    break;

                case 5:
                    gerenciador.ordenarIngredientesPorNome();
                    break;

                case 6:
                    System.out.print("Digite o nome do ingrediente: ");
                    String nomeBusca = scanner.nextLine();
                    try {
                        Produto ingrediente = gerenciador.buscarIngredientePorNome(nomeBusca);
                        ingrediente.exibirInformacoes();
                    } catch (CadastroException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 7);

        scanner.close();
    }
}
