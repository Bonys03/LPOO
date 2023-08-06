package application;
import java.util.*;

public class CarteiraVacina {
	private List<Vacina> vacinas = new LinkedList<Vacina>();
	private LocalVacinacao local;
	private Pessoa vacinado;
	private Enfermeiro vacinador;
	public CarteiraVacina(Vacina vacina, LocalVacinacao local, Pessoa vacinado, Enfermeiro vacinador) {
		this.vacinas.add(vacina);
		this.local = local;
		this.vacinado = vacinado;
		this.vacinador = vacinador;
	}
	public List<Vacina> getVacinas() {
		return vacinas;
	}
	public void setVacina(Vacina vacina) {
		this.vacinas.add(vacina);
	}
	public LocalVacinacao getLocal() {
		return local;
	}
	public void setLocal(LocalVacinacao local) {
		this.local = local;
	}
	public Pessoa getVacinado() {
		return vacinado;
	}
	public void setVacinado(Pessoa vacinado) {
		this.vacinado = vacinado;
	}
	public Enfermeiro getVacinador() {
		return vacinador;
	}
	public void setVacinador(Enfermeiro vacinador) {
		this.vacinador = vacinador;
	}
	public void adicionarVacina(Vacina vacina) {
		vacinas.add(vacina);
	}
	@Override
	public String toString() {
		return "Nome do vacinado: "+getVacinado().getNome()+
							" | Nome do vacinador: "+getVacinador().getNome()+
							" | Local de vacinação: "+getLocal().getNomeLocal()+
							" | Nomes das vacinas: "+getVacinas();
	}
}
