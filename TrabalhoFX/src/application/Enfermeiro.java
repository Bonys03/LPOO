package application;

public class Enfermeiro extends Pessoa {
	private Integer id;
	public Enfermeiro(Integer id, String nome, Integer idade, String cpf, String celular, Prioridade prioridade, Endereco endereco){
		super(nome,idade,cpf,celular,prioridade,endereco);
		this.id = id;
	}
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Nome: "+getNome()+" | "+"ID: "+getId();
	}
}
