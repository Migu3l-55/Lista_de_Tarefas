package arquivos;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

@ManagedBean
@RequestScoped
public class TarefaBean {
	private String titulo; 
	private String descricao;
	private String responsavel;
	private String prioridade;
	private String deadline;
	private List<Tarefa> listaTarefas; 
	
	public TarefaBean() {
		
	}

	@PostConstruct
	public void init() {
		exibirTarefas();
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
	
	public List<Tarefa> getListaTarefas() {
		return listaTarefas;
	}

	public void setListaTarefas(List<Tarefa> listaTarefas) {
		this.listaTarefas = listaTarefas;
	}
	
	public void adicionar_tarefa() {
		TarefaDAO conn = new TarefaDAO();
		String titulo = getTitulo();
		String descricao = getDescricao();
		String responsavel = getResponsavel();
		String prioridade = getPrioridade();
		String deadline = getDeadline();
		boolean dados_validos = false;

		//verifica se os dados sao validos.
		if ((responsavel != null && responsavel.trim().isEmpty()) || (titulo != null && titulo.trim().isEmpty())) {
		    titulo = null;
			responsavel = null;
		}

				
		if (titulo != null || responsavel != null) {
				if (titulo.length() <= 60 && descricao.length() <= 100 && 
					responsavel.length() <= 80 && deadline.length() <= 10) {
				dados_validos = true;
			}
		}
		
		if (dados_validos == true) {	
						
			conn.addTarefa(conn.conexao(), titulo, descricao,
					responsavel, prioridade, deadline);
		
	        this.titulo = "";
	        this.descricao = "";
	        this.responsavel = "";
	        this.prioridade = "";
	        this.deadline = "";
	        
	        try {
	        	//impede que o item seja adicionado novamente quando a página é atualizada.
	            FacesContext.getCurrentInstance().getExternalContext().redirect("Tarefas.xhtml");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		} else {
			System.out.println("Dados inválidos, dados não foram inseridos!");
		}
		exibirTarefas();

	}
	
	public void exibirTarefas() {
		TarefaDAO conn = new TarefaDAO();
		setListaTarefas(conn.listarTarefas(conn.conexao()));
	}
	
	public void  deletarItem(int tarefa_id) {
		TarefaDAO conn = new TarefaDAO();
		conn.deletarItem(conn.conexao(), tarefa_id);
		try {
        	//impede que algum item seja deletado novamente quando a página é atualizada.
            FacesContext.getCurrentInstance().getExternalContext().redirect("Listagem.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
		exibirTarefas();
	}
	
	public void concluir_tarefa(int tarefa_id) {
		TarefaDAO conn = new TarefaDAO();
		conn.concluir_tarefa(conn.conexao(), tarefa_id);
		try {
        	//impede que algum item seja deletado novamente quando a página é atualizada.
            FacesContext.getCurrentInstance().getExternalContext().redirect("Listagem.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
		exibirTarefas();
	}
		
	public void exibirTarefas_Responsavel(String responsavel) {
		TarefaDAO conn = new TarefaDAO();
		setListaTarefas(conn.listarTarefasPorResponsavel(conn.conexao(), responsavel));
	}

//	public void editarItem(int tarefa_id) {
//		TarefaDAO conn = new TarefaDAO();
//		setListaTarefas(conn.listarTarefasPorResponsavel(conn.conexao(), responsavel));
//	}

}
