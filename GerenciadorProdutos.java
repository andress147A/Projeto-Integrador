import java.util.ArrayList;

public class GerenciadorProdutos {
    private ArrayList<Produto> produtos;

    public GerenciadorProdutos() {
        produtos = new ArrayList<>();
    }

    // Adicionar produto ao sistema
    public void adicionarProduto(Produto produto) throws CadastroException {
        for (Produto p : produtos) {
            if (p.getId() == produto.getId()) {
                throw new CadastroException("Produto com ID já existente.");
            }
        }
        produtos.add(produto);
    }

    // Buscar produto por ID
    public Produto buscarProduto(int id) throws CadastroException {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new CadastroException("Produto não encontrado.");
    }

    // Exibir todos os produtos
    public void exibirTodosProdutos() {
        for (Produto p : produtos) {
            p.exibirInformacoes();
            System.out.println("-------------------");
        }
    }

    // Filtrar apenas os ingredientes
    private ArrayList<Ingrediente> getIngredientes() {
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        for (Produto p : produtos) {
            if (p instanceof Ingrediente) {
                ingredientes.add((Ingrediente) p);
            }
        }
        return ingredientes;
    }

    // Ordenar ingredientes usando Merge Sort
    public void ordenarIngredientesPorNome() {
        ArrayList<Ingrediente> ingredientes = getIngredientes();
        mergeSort(ingredientes, 0, ingredientes.size() - 1);
        System.out.println("Ingredientes ordenados com sucesso!");
    }

    // Merge Sort principal
    private void mergeSort(ArrayList<Ingrediente> ingredientes, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(ingredientes, left, mid);
            mergeSort(ingredientes, mid + 1, right);

            merge(ingredientes, left, mid, right);
        }
    }

    // Merge para combinar subarrays
    private void merge(ArrayList<Ingrediente> ingredientes, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Ingrediente[] leftArray = new Ingrediente[n1];
        Ingrediente[] rightArray = new Ingrediente[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = ingredientes.get(left + i);
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = ingredientes.get(mid + 1 + j);
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i].getNome().compareToIgnoreCase(rightArray[j].getNome()) <= 0) {
                ingredientes.set(k, leftArray[i]);
                i++;
            } else {
                ingredientes.set(k, rightArray[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            ingredientes.set(k, leftArray[i]);
            i++;
            k++;
        }

        while (j < n2) {
            ingredientes.set(k, rightArray[j]);
            j++;
            k++;
        }
    }

    // Busca binária para ingredientes (apenas após ordenação)
    public Ingrediente buscarIngredientePorNome(String nome) throws CadastroException {
        ArrayList<Ingrediente> ingredientes = getIngredientes();
        mergeSort(ingredientes, 0, ingredientes.size() - 1); // Ordenar antes de buscar

        int left = 0, right = ingredientes.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Ingrediente midIngrediente = ingredientes.get(mid);

            if (midIngrediente.getNome().equalsIgnoreCase(nome)) {
                return midIngrediente;
            } else if (midIngrediente.getNome().compareToIgnoreCase(nome) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        throw new CadastroException("Ingrediente com o nome '" + nome + "' não encontrado.");
    }
}
