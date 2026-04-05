import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarFuncionarios {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnection();

            String sql = "SELECT codigo, nome, sobrenome, idade, salario FROM funcionario";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                // Recupera pelo nome da coluna
                int codigo = rs.getInt("codigo");

                // Recupera pelo índice da coluna
                String nome = rs.getString(2);
                String sobreNome = rs.getString("sobrenome");
                String nomeCompleto = nome.concat(" " + sobreNome);

                int idade = rs.getInt("idade");
                Double salario = rs.getDouble("salario");

                System.out.printf("Código %d: %s - %d | Salário: %.2f%n",
                        codigo, nomeCompleto, idade, salario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e);
            }
        }
    }
}
