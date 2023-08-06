package application;
import java.util.*;

public class Pessoa implements Verificavel {
	private String nome;
	private Integer idade;
	private String cpf;
	private String celular;
	private Prioridade prioridade;
	private Endereco endereco;
	public Pessoa(String nome, Integer idade, String cpf, String celular, Prioridade prioridade, Endereco endereco){
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	@Override
	public boolean validarCPF(String cpf) {
		int i;
		int c=1;
		if(cpf.length()==11) {
			for(i=0;i<11;i++) {
				if((i+1)!=11)
					if(cpf.charAt(i)==cpf.charAt(i+1))
						c++;
			}
			if(c==11) return false;
		}
		else if(cpf.length()!=11) {
			return false;
		}
		char n10,n11;
		int soma, r, num, peso;
		try {
			soma=0;
			peso=10;
			for(i=0;i<9;i++) {
				num=(int)(cpf.charAt(i) - 48);
				soma+=(num*peso);
				peso--;
			}
			r=11-(soma%11);
			if((r==10)||(r==11)) n10='0';
			else n10=(char)(r+48);
			soma=0;
			peso=11;
			for(i=0;i<10;i++) {
				num=(int)(cpf.charAt(i) - 48);
				soma+=(num*peso);
				peso--;
			}
			r=11-(soma%11);
			if((r==10)||(r==11)) n11='0';
			else n11=(char)(r+48);
			if((n10==cpf.charAt(9))&&(n11==cpf.charAt(10))) return true;
			else return false;
				
			
		}catch(InputMismatchException e) {
			return false;
		}
	}
	@Override
	public String toString(){
		return "Nome: "+getNome()+" | "+"Idade: "+getIdade();
	}
}
