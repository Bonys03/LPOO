package application;

public class Vacina {
	private String nomeVacina;
	private String fabricante;
	private Integer duracao;
	private Integer idadeMinima;
	private Integer dose;
	private Integer eficacia;
	private String restricoes;
	public Vacina(String nomeVacina, String fabricante, Integer duracao, Integer idadeMinima, Integer dose,
			Integer eficacia, String restricoes) {
		this.nomeVacina = nomeVacina;
		this.fabricante = fabricante;
		this.duracao = duracao;
		this.idadeMinima = idadeMinima;
		this.dose = dose;
		this.eficacia = eficacia;
		this.restricoes = restricoes;
	}
	
	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
	
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Integer getIdadeMinima() {
		return idadeMinima;
	}

	public void setIdadeMinima(Integer idadeMinima) {
		this.idadeMinima = idadeMinima;
	}

	public Integer getDose() {
		return dose;
	}

	public void setDose(Integer dose) {
		this.dose = dose;
	}

	public Integer getEficacia() {
		return eficacia;
	}

	public void setEficacia(Integer eficacia) {
		this.eficacia = eficacia;
	}

	public String getRestricoes() {
		return restricoes;
	}

	public void setRestricoes(String restricoes) {
		this.restricoes = restricoes;
	}

	@Override
	public String toString() {
		return "Vacina: "+getNomeVacina();
	}
	public int compareTo(Vacina vacina) {
		if(vacina.toString() == this.nomeVacina)
			return 1;
		return 0;
	}
	
}
