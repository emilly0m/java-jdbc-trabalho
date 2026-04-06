import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FuncionarioDAO dao = new FuncionarioDAO();
        int opcao = 0;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            try {
                if (opcao == 1) {
                    Funcionario f = new Funcionario();
                    System.out.print("Nome: ");
                    f.setNome(scanner.next());
                    System.out.print("Sobrenome: ");
                    f.setSobrenome(scanner.next());
                    System.out.print("Idade: ");
                    f.setIdade(scanner.nextInt());
                    System.out.print("Salário: ");
                    f.setSalario(scanner.nextDouble());
                    dao.inserir(f);
                    System.out.println("Inserido com sucesso!");

                } else if (opcao == 2) {
                    List<Funcionario> lista = dao.listar();
                    for (Funcionario f : lista) {
                        System.out.printf("Código %d: %s %s - %d anos | Salário: %.2f%n",
                                f.getCodigo(), f.getNome(), f.getSobrenome(),
                                f.getIdade(), f.getSalario());
                    }

                } else if (opcao == 3) {
                    System.out.print("Código do funcionário a atualizar: ");
                    Funcionario f = new Funcionario();
                    f.setCodigo(scanner.nextInt());
                    System.out.print("Novo nome: ");
                    f.setNome(scanner.next());
                    System.out.print("Novo sobrenome: ");
                    f.setSobrenome(scanner.next());
                    System.out.print("Nova idade: ");
                    f.setIdade(scanner.nextInt());
                    System.out.print("Novo salário: ");
                    f.setSalario(scanner.nextDouble());
                    dao.atualizar(f);
                    System.out.println("Atualizado com sucesso!");

                } else if (opcao == 4) {
                    System.out.print("Código do funcionário a excluir: ");
                    int codigo = scanner.nextInt();
                    dao.excluir(codigo);
                    System.out.println("Excluído com sucesso!");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);

        System.out.println("Encerrando...");
        scanner.close();
    }
}