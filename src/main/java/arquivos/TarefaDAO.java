package arquivos;
//nunca nomear package como java.files!

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TarefaDAO {
	private static final String URL = "jdbc:{tipo de conexao}://{usuário do banco}:{porta}/{nome do banco}";
	private static final String USER = "{nome do usuario do banco}";
	private static final String PASSWORD = "{senha de acesso ao banco}";	
	
	public Connection conexao() {
		Connection conn = null; 
	
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			if (conn != null) {
				System.out.println("Conexão bem-sucedida");
			}
		} catch (Exception e) {
			System.out.println("Conexão mal-sucedida");
			System.out.println(e);
		}
		return conn;
	}
	
	public void criarTabela(Connection conn)  {
		Statement stmt;
		try {
			String query = String.format("CREATE TABLE tarefa (\r\n"
					+ "	tarefa_id SERIAL PRIMARY KEY,\r\n"
					+ "	titulo VARCHAR(60) NOT NULL,\r\n"
					+ "	descricao VARCHAR(100),\r\n"
					+ "	responsavel VARCHAR(80) NOT NULL,\r\n"
					+ "	prioridade VARCHAR(6) NOT NULL,\r\n"
					+ "	deadline DATE NOT NULL,\r\n"
					+ "	concluida boolean\r\n"
					+ ")");
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			System.out.println("tabela criada com sucesso!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addTarefa(Connection conn, String titulo, String descricao, String responsavel, String prioridade, String deadline)  {
		criarTabela(conn);
		Statement stmt;
		try {
			String query = String.format("INSERT INTO tarefa (titulo, descricao, responsavel, prioridade, deadline, concluida)  VALUES ('%s', '%s', '%s', '%s', '%s', false)", titulo, descricao, responsavel, prioridade, deadline);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			System.out.println("item inserido com sucesso!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Tarefa> listarTarefas(Connection conn) {
		criarTabela(conn);
		ArrayList<Tarefa> arr = new ArrayList<Tarefa>();
		Statement stmt;
		ResultSet rst = null;
		
		try {
			//o String format não é util nesse caso,
			//mas vou deixar pra manter o costume.
			String query = String.format("SELECT * FROM tarefa");
			stmt = conn.createStatement();
			rst = stmt.executeQuery(query);
			
			while (rst.next()) {
				arr.add(new Tarefa(rst.getInt("tarefa_id"), rst.getString("titulo"), rst.getString("descricao"), rst.getString("responsavel"), rst.getString("prioridade"), rst.getString("deadline"), rst.getBoolean("concluida")));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return arr;
	}
	
	public void deletarItem(Connection conn, int tarefa_id) {
		criarTabela(conn);
		Statement stmt;
		try {
			String query = String.format("DELETE FROM tarefa WHERE tarefa_id = %s", tarefa_id);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			System.out.println("item deletado com sucesso!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void concluir_tarefa(Connection conn, int tarefa_id) {
		criarTabela(conn);
		Statement stmt;
		try {
			String query = String.format("UPDATE tarefa SET concluida = true WHERE tarefa_id = %s", tarefa_id);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			System.out.println("item marcado como concluido!");
		} catch (Exception e) {
			
		}
	}
	
	public ArrayList<Tarefa> listarTarefasPorResponsavel(Connection conn, String responsavel) {
		criarTabela(conn);
		ArrayList<Tarefa> arr_Responsavel = new ArrayList<Tarefa>();
		Statement stmt;
		ResultSet rst = null;
			
		try {
			//o String format não é util nesse caso,
			//mas vou deixar pra manter o costume.
			String query = String.format("SELECT * FROM tarefa WHERE responsavel = '%s'", responsavel);
			stmt = conn.createStatement();
			rst = stmt.executeQuery(query);
			
			while (rst.next()) {
				arr_Responsavel.add(new Tarefa(rst.getInt("tarefa_id"), rst.getString("titulo"), rst.getString("descricao"), rst.getString("responsavel"), rst.getString("prioridade"), rst.getString("deadline"), rst.getBoolean("concluida")));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		arr_Responsavel.forEach( (t) -> mostrarDados(t) );
		System.out.println(arr_Responsavel);
		return arr_Responsavel;
	}
	
	public void mostrarDados(Tarefa t) {
		String text = "Não concluida";
		System.out.print(t.getTarefa_id() + " | ");
		System.out.print(t.getTitulo() + " | ");
		System.out.print(t.getResponsavel() + " | ");
		System.out.print(t.getPrioridade() + " | ");
		System.out.print(t.getDeadline() + " | ");
		
		if (t.isConcluida() == true) {
			text = "Concluida";
		}
		System.out.println(text);
	}

}
	

