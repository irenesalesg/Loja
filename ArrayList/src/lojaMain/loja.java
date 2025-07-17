package lojaMain;
import java.util.Scanner;
import classes.produto;
import java.util.List;
import java.util.ArrayList;

public class loja {

    private static final Scanner sc = new Scanner(System.in);

    public static int imprimirMenu() {
        System.out.println("-----------------------------------------------"); 
        System.out.println("1 – adicionar produto"); 
        System.out.println("2 – remover produto"); 
        System.out.println("3 – atualizar dados de um produto"); 
        System.out.println("4 – pesquisar produto por código"); 
        System.out.println("5 – listar todos os produtos cadastrados"); 
        System.out.println("6 – calcular o valor total do estoque"); 
        System.out.println("7 – sair"); 
        System.out.println("-----------------------------------------------"); 

        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }
    
    public static void main(String[] args) {
        List<produto> listaProdutos = new ArrayList<>();
        
        int opcao;
        do {
            opcao = imprimirMenu();
            
            switch(opcao) {
                case 1: //"1 – adicionar produto"
                    produto p1 = new produto();
                    p1.preencher(sc);
                    listaProdutos.add(p1);
                    break;
                    
                case 2://"2 – remover produto"
                    System.out.println("Informe o código:");
                    int codRemover = sc.nextInt();
                    sc.nextLine();
                    
                    listaProdutos.removeIf(prod -> prod.getCodigo() == codRemover);
                    break;
                    
                case 3://"3 – atualizar dados de um produto"
                    System.out.println("Digite o código do produto que deseja atualizar:");
                    int codigoBusca = sc.nextInt();
                    sc.nextLine();
                    
                    for (int i = 0; i < listaProdutos.size(); i++) {
                        if (listaProdutos.get(i).getCodigo() == codigoBusca) {
                            produto produtoAtualizado = new produto();
                            produtoAtualizado.preencher(sc);
                            
                            listaProdutos.set(i, produtoAtualizado);
                            
                            System.out.println("Produto atualizado com sucesso!");
                        }
                    }
                    break;
                    
                case 4://"4 – pesquisar produto por código"
                    System.out.println("Informe o código:");
                    int codPesquisar = sc.nextInt();
                    sc.nextLine();
                    
                    listaProdutos.stream()
                               .filter(prod -> prod.getCodigo() == codPesquisar)
                               .forEach(produto::imprimir);
                    break;
                    
                case 5://"5 – listar todos os produtos cadastrados"
                    System.out.println("\nCÓDIGO | NOME");
                    for (produto p : listaProdutos) {
                        System.out.println(p.getCodigo() + " | " + p.getNome());
                    }
                	break;
                    
                case 6://"6 – calcular o valor total do estoque"
                    if (listaProdutos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado!");
                    } else {
                        double total = 0.0;
                        for (produto p : listaProdutos) {
                            total += p.getValorUnit() * p.getQntEstoque();
                        }
                        System.out.println("Valor total do estoque: R$ " + String.format("%.2f", total));
                    }
                    break;
               
                case 7:
                    System.out.println("Encerrando...");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 7);
        
    }

}