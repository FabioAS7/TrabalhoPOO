package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Doador;

public class DoadorDAOImpl implements DoadorDAO {

	private static final String DB_CLASS = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://localhost:3007/hospitaldb?allowPublicKeyRetrieval=true";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "alunofatec";
	private Connection conexao = null;

	public DoadorDAOImpl() {
		try {

			Class.forName(DB_CLASS);
			conexao = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void inserir(Doador objeto) throws Exception {
		try {
			String SQL = """
					INSERT INTO doador (cpf, nome, nascimento, email, telefone, tipoSanguinio)
					VALUES (?, ?, ?, ?, ?, ?)
					""";
			PreparedStatement stm = conexao.prepareStatement(SQL);
			stm.setInt(1, objeto.getCpf());
			stm.setString(2, objeto.getNome());
			java.sql.Date data = java.sql.Date.valueOf(objeto.getNascimento());
			stm.setDate(3, data);
			stm.setString(4, objeto.getEmail());
			stm.setInt(5, objeto.getTelefone());
			stm.setString(6, objeto.getTipoSanguinio());

			int i = stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@Override
	public void atualizar(Doador objeto) throws Exception {
		try {
			String SQL = """
					UPDATE doador SET nome=?, nascimento=?, email=?, telefone=?,  tipoSanguinio=?
					WHERE cpf=?
					""";
			PreparedStatement stm = conexao.prepareStatement(SQL);
			stm.setString(1, objeto.getNome());
			java.sql.Date data = java.sql.Date.valueOf(objeto.getNascimento());
			stm.setDate(2, data);
			stm.setString(3, objeto.getEmail());
			stm.setInt(4, objeto.getTelefone());
			stm.setString(5, objeto.getTipoSanguinio());
			stm.setInt(6, objeto.getCpf());

			int i = stm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@Override
	public void remover(Doador objeto) throws Exception {
		try {

			String SQL = """
					DELETE FROM doador
					WHERE cpf = ?
					""";

			PreparedStatement stm = conexao.prepareStatement(SQL);
			stm.setInt(1, objeto.getCpf());
			int i = stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);

		}

	}

	@Override
	public List<Doador> pesquisar(String itemPesquisa) throws Exception {
		
		List<Doador> lista = new ArrayList<>();
		
		try {
			String SQL = """
					SELECT * FROM doador
					WHERE nome LIKE ?
					""";

			PreparedStatement stm = conexao.prepareStatement(SQL);
			stm.setString(1, "%" + itemPesquisa + "%");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}

		return lista;
	}

	@Override
	public List<Doador> pesquisarTodos() throws Exception {
		List<Doador> lista = new ArrayList<>();

		try {
			String SQL = "SELECT * FROM ---";
			PreparedStatement stm = conexao.prepareStatement(SQL);
			ResultSet resultados = stm.executeQuery();

			while (resultados.next()) {
				Doador d = new Doador();

				d.setCpf(resultados.getInt("cpf"));
				d.setNome(resultados.getString("nome"));
				d.setNascimento(resultados.getDate("nascimento").toLocalDate());
				d.setEmail(resultados.getString("email"));
				d.setTelefone(resultados.getInt("telefone"));
				d.setTipoSanguinio(resultados.getString("tipoSanguinio"));

				lista.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return lista;
	}

}