import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void inserir(Funcionario f) throws SQLException {
        Connection conn = ConnectionFactory.createConnection();
        String sql = "INSERT INTO funcionario (nome, sobrenome, idade, salario) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, f.getNome());
        ps.setString(2, f.getSobrenome());
        ps.setInt(3, f.getIdade());
        ps.setDouble(4, f.getSalario());
        ps.execute();
        ps.close();
        conn.close();
    }

    public List<Funcionario> listar() throws SQLException {
        Connection conn = ConnectionFactory.createConnection();
        String sql = "SELECT * FROM funcionario";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Funcionario> lista = new ArrayList<>();
        while (rs.next()) {
            Funcionario f = new Funcionario();
            f.setCodigo(rs.getInt("codigo"));
            f.setNome(rs.getString("nome"));
            f.setSobrenome(rs.getString("sobrenome"));
            f.setIdade(rs.getInt("idade"));
            f.setSalario(rs.getDouble("salario"));
            lista.add(f);
        }
        rs.close();
        ps.close();
        conn.close();
        return lista;
    }

    public void atualizar(Funcionario f) throws SQLException {
        Connection conn = ConnectionFactory.createConnection();
        String sql = "UPDATE funcionario SET nome=?, sobrenome=?, idade=?, salario=? WHERE codigo=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, f.getNome());
        ps.setString(2, f.getSobrenome());
        ps.setInt(3, f.getIdade());
        ps.setDouble(4, f.getSalario());
        ps.setInt(5, f.getCodigo());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public void excluir(int codigo) throws SQLException {
        Connection conn = ConnectionFactory.createConnection();
        String sql = "DELETE FROM funcionario WHERE codigo=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}