package application;

public class Prioridade {
	private String tipoPrioridade;
	public Prioridade(String tipoPrioridade) {
		this.tipoPrioridade = tipoPrioridade;
	}
	
	public String getTipoPrioridade() {
		return tipoPrioridade;
	}

	@Override
	public String toString() {
		return getTipoPrioridade();
	}
}
