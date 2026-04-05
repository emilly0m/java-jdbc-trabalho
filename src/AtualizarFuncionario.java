import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarFuncionario {

    public static void main(String[] args) {
        Connection conexao = null;
        PreparedStatement ps = null;

        String sql = "UPDATE funcionario SET nome=?, sobrenome=? WHERE codigo=?";

        String nome = "Carlos";
        String sobrenome = "Silva";
        int codigo = 1;

        try {
            conexao = ConnectionFactory.createConnection();
            conexao.setAutoCommit(false);

            ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, sobrenome);
            ps.setInt(3, codigo);

            int retorno = ps.executeUpdate();

            if (retorno > 0) {
                System.out.printf("Registro alterado: %d: %s - %s%n", codigo, nome, sobrenome);
            } else {
                System.out.println("Não foi possível alterar os registros!");
            }

            conexao.commit();

        } catch (SQLException e) {
            if (conexao != null) {
                try {
                    System.err.print("Rollback efetuado na transação");
                    conexao.rollback();
                } catch (SQLException e2) {
                    System.err.print("Erro na transação! " + e2);
                }
            }
        } finally {
            try {
                if (ps != null) ps.close();
                if (conexao != null) {
                    conexao.setAutoCommit(true);
                    conexao.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e);
            }
        }
    }
}