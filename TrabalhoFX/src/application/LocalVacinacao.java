package application;

public class LocalVacinacao {
	private String nomeLocal;
	private Endereco endereco;
	public LocalVacinacao(String nomeLocal, Endereco endereco) {
		this.nomeLocal = nomeLocal;
		this.endereco = endereco;
	}
	
	public String getNomeLocal() {
		return nomeLocal;
	}

	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return 	"Nome do local: "+getNomeLocal()+
				" | Rua: "+endereco.getRua()+
				" | Numero: "+endereco.getNumero()+
				" | Bairro: "+endereco.getBairro();
	}
}
