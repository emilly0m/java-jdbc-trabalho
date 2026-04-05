import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirFuncionario {

    public static void main(String[] args) {
        Connection conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = ConnectionFactory.createConnection();

            String sql = "INSERT INTO loja (nome, sobrenome, idade, salario) " +
                    "VALUES ('Mario', 'Corleone', '28', '2322.39')";

            ps = conexao.prepareStatement(sql);
            ps.execute();

            System.out.println("Registro inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e);
            }
        }
    }
}