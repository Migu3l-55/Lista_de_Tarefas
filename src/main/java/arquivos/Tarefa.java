package arquivos;

public class Tarefa {
	private int tarefa_id;
	private boolean concluida;
	private String
	titulo,
	descricao, 
	responsavel,
	prioridade,
	deadline;
	
	
	public Tarefa(int tarefa_id, String titulo, String descricao, 
			String responsavel, String prioridade, String deadline, boolean concluida) {
		this.tarefa_id = tarefa_id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.responsavel = responsavel;
		this.prioridade = prioridade;
		this.deadline = deadline;
		this.concluida = concluida;
	}

	public int getTarefa_id() {
		return tarefa_id;
	}

	public void setTarefa_id(int tarefa_id) {
		this.tarefa_id = tarefa_id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}

	
}
