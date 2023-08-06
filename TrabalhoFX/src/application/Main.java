package application;
	
import java.util.LinkedList;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    /*Abaixo está a declaração de cada elemento utilizado no código para a execução em JavaFX*/
    GridPane gridPane = new GridPane();
    
	TextField textField = new TextField();
	TextField textField2 = new TextField();
	TextField textField3 = new TextField();
	TextField textField4 = new TextField();
	TextField textField5 = new TextField();
	TextField textField6 = new TextField();
	TextField textField7 = new TextField();
	TextField textField8 = new TextField();
	TextField textField9 = new TextField();
	TextField textField10 = new TextField();
	TextField textField11 = new TextField();
    
    Label label = new Label();
	Label label2 = new Label();
	Label label3 = new Label();
	Label label4 = new Label();
	Label label5 = new Label();
	Label label6 = new Label();
	Label label7 = new Label();
	Label label8 = new Label();
	Label label9 = new Label();
	Label label10 = new Label();
	Label label11 = new Label();
	Label label12 = new Label();
	Label label13 = new Label();
	
    List<Pessoa> pessoas = new LinkedList<Pessoa>();
    List<Endereco> enderecos = new LinkedList<Endereco>();
    List<Prioridade> prioridades = new LinkedList<Prioridade>();
    List<CarteiraVacina> carteiras = new LinkedList<CarteiraVacina>();
    List<Vacina> vacinas = new LinkedList<Vacina>();
    List<LocalVacinacao> locais = new LinkedList<LocalVacinacao>();
    List<Enfermeiro> enfermeiros = new LinkedList<Enfermeiro>();
    
    ListView<Pessoa> listView = new ListView<Pessoa>();
    ListView<Endereco> listView2 = new ListView<Endereco>();
    ListView<Prioridade> listView3 = new ListView<Prioridade>();
    ListView<CarteiraVacina> listView4 = new ListView<CarteiraVacina>();
    ListView<Vacina> listView5 = new ListView<Vacina>();
    ListView<LocalVacinacao> listView6 = new ListView<LocalVacinacao>();
    ListView<Enfermeiro> listView7 = new ListView<Enfermeiro>();
    
    
	Button button = new Button();
    
    HBox hbox = new HBox();
    
    MenuBar menuBar = new MenuBar();
    
    /*Abaixo estão todas os métodos utilizadas dentro do código e o último é o método que
     *começa a execução da interface gráfica.*/
    public void addVacina() {//Método que adiciona uma vacina à lista de vacinas dentro de uma carteira de vacinas específica
    	clearGrid();
    	
    	label.setText("Digite o nome de uma vacina registrada:");
    	label2.setText("Digite o nome do dono da carteira:");
    	
    	gridPane.add(label, 0, 1);
    	gridPane.add(label2, 0, 2);
    	
    	gridPane.add(textField, 1, 1);
    	gridPane.add(textField2, 1, 2);
    	
    	button.setText("Confirmar");
    	
    	gridPane.add(button, 0, 8);
    	
    	button.setOnAction((event) -> {
    		boolean v1=false,v2=false;
    		Endereco endereco = new Endereco("Default",1,"Default","Default","Default");
    		Prioridade prioridade = new Prioridade("Default");
    		Vacina vacina1 = new Vacina("Default","Default",1,1,1,1,"Default");
    		LocalVacinacao local1 = new LocalVacinacao("Default",endereco);
    		Pessoa pessoa1 = new Pessoa("Default",1,"Default","Default",prioridade,endereco);
    		Enfermeiro enfermeiro1 = new Enfermeiro(1,"Default",1,"Default","Default",prioridade,endereco);
    		CarteiraVacina carteira1 = new CarteiraVacina(vacina1,local1,pessoa1,enfermeiro1);
    		for(Vacina vacina : vacinas) {
    			if(vacina.getNomeVacina().equals(textField.getText())) {
    				v1=true;
    				vacina1 = vacina;
    			}
    		}
    		for(CarteiraVacina carteira : carteiras) {
    			if(carteira.getVacinado().getNome().equals(textField2.getText())) {
    				v2=true;
    				carteira1 = carteira;
    			}
    		}
    		if(v1&&v2) {
    			if(!carteira1.getVacinas().contains(vacina1)) {
    				carteira1.adicionarVacina(vacina1);
	            	clearGrid();
	            	
	            	label13.setText("A vacina foi adicionada à carteira!");
	            	
	            	gridPane.add(label13, 0, 3);
	                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), label13);
	                fadeTransition.setFromValue(1.0);
	                fadeTransition.setToValue(0.0);
	                fadeTransition.setCycleCount(1);
	                fadeTransition.play();
    			}
    			else {
    				clearGrid();
	            	
	            	label13.setText("A vacina requisitada já estava na carteira!");
	            	
	            	gridPane.add(label13, 0, 3);
	                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), label13);
	                fadeTransition.setFromValue(1.0);
	                fadeTransition.setToValue(0.0);
	                fadeTransition.setCycleCount(1);
	                fadeTransition.play();
    			}
    		}
    		else {
    			if(v1) {
    				label.setText("Digite o nome de uma vacina registrada:");
    				label.setStyle("-fx-text-fill: black");
    			}
    			else {
    				label.setText("Vacina não registrada! Tente novamente:");
    				label.setStyle("-fx-text-fill: red");
    			}
    			if(v2) {
    				label2.setText("Digite o nome do dono da carteira:");
    				label2.setStyle("-fx-text-fill: black");
    			}
    			else {
    				label2.setText("Carteira não encontrada! Tente novamente:");
    				label2.setStyle("-fx-text-fill: red");
    			}
    		}
    	});
    }
    
    public void criarCarteira() {//Método que registra uma carteira do tipo CarteiraVacina e guarda dentro de uma lista denominada carteiras.
    	clearGrid();
    	
    	label.setText("Digite o nome de uma vacina registrada:");
    	label2.setText("Digite o nome de um local registrado:");
    	label3.setText("Digite de uma pessoa registrada:");
    	label4.setText("Digite o nome de um enfermeiro registrado:");
    	
    	gridPane.add(label, 0, 1);
    	gridPane.add(label2, 0, 2);
    	gridPane.add(label3, 0, 3);
    	gridPane.add(label4, 0, 4);
    	
    	gridPane.add(textField, 1, 1);
    	gridPane.add(textField2, 1, 2);
    	gridPane.add(textField3, 1, 3);
    	gridPane.add(textField4, 1, 4);
    	
    	button.setText("Confirmar");
    	
    	gridPane.add(button, 0, 8);
    	
    	button.setOnAction((event) -> {
    		boolean v1=false,v2=false,v3=false,v4=false;
    		Endereco endereco = new Endereco("Default",1,"Default","Default","Default");
    		Prioridade prioridade = new Prioridade("Default");
    		Vacina vacina1 = new Vacina("Default","Default",1,1,1,1,"Default");
    		LocalVacinacao local1 = new LocalVacinacao("Default",endereco);
    		Pessoa pessoa1 = new Pessoa("Default",1,"Default","Default",prioridade,endereco);
    		Enfermeiro enfermeiro1 = new Enfermeiro(1,"Default",1,"Default","Default",prioridade,endereco);
    		
    		for(Vacina vacina : vacinas) {
    			if(vacina.getNomeVacina().equals(textField.getText())) {
    				v1=true;
    				vacina1 = vacina;
    			}
    		}
    		for(LocalVacinacao local : locais) {
    			if(local.getNomeLocal().equals(textField2.getText())) {
    				v2=true;
    				local1 = local;
    			}
    		}
    		for(Pessoa pessoa : pessoas) {
    			if(pessoa.getNome().equals(textField3.getText())) {
    				v3=true;
    				pessoa1 = pessoa;
    			}
    		}
    		for(Enfermeiro enfermeiro : enfermeiros) {
    			if(enfermeiro.getNome().equals(textField4.getText())) {
    				v4=true;
    				enfermeiro1 = enfermeiro;
    			}
    		}
    		if(v1&&v2&&v3&&v4) {
    			
            	CarteiraVacina carteira = new CarteiraVacina(vacina1,local1,pessoa1,enfermeiro1);
            	carteiras.add(carteira);
            	clearGrid();
            	
            	label13.setText("Carteira registrada com sucesso!");
            	
            	gridPane.add(label13, 0, 3);
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), label13);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.setCycleCount(1);
                fadeTransition.play();
    		}
    		else {
    			if(v1) {
    				label.setText("Digite o nome de uma vacina registrada:");
    				label.setStyle("-fx-text-fill: black");
    			}
    			else {
    				label.setText("Vacina não encontrada! Tente novamente:");
    				label.setStyle("-fx-text-fill: red");
    			}
    			if(v2) {
    				label2.setText("Digite o nome de um local registrado:");
    				label2.setStyle("-fx-text-fill: black");
    			}
    			else {
    				label2.setText("Local não registrado! Tente novamente:");
    				label2.setStyle("-fx-text-fill: red");
    			}
    			if(v3) {
    				label3.setText("Digite de uma pessoa registrada:");
    				label3.setStyle("-fx-text-fill: black");
    			}
    			else {
    				label3.setText("Pessoa não encontrada! Digite novamente:");
    				label3.setStyle("-fx-text-fill: red");
    			}
    			if(v4) {
    				label4.setText("Digite o nome de um enfermeiro registrado:");
    				label4.setStyle("-fx-text-fill: black");
    			}
    			else {
    				label4.setText("Enfermeito não encontrado! Tente novamente:");
    				label4.setStyle("-fx-text-fill: red");
    			}
    		}
    	});
    }
    
    public void criarLocal() {//Método que registra um local do tipo LocalVacinacao e guarda dentro de uma lista denominada locais.
    	clearGrid();
    	
    	label.setText("Digite o nome do local:");
    	label2.setText("Digite um endereço:");
    	
    	label3.setText("Rua:");
    	label4.setText("Número:");
    	label5.setText("Bairro:");
    	label6.setText("Cidade:");
    	label7.setText("CEP(Opcional):");
    	
    	label2.setUnderline(true);
    	
    	gridPane.add(label, 0, 1);
    	gridPane.add(label2, 0, 2);
    	gridPane.add(label3, 0, 3);
    	gridPane.add(label4, 0, 4);
    	gridPane.add(label5, 0, 5);
    	gridPane.add(label6, 0, 6);
    	gridPane.add(label7, 0, 7);
    	
    	gridPane.add(textField, 1, 1);
    	gridPane.add(textField2, 1, 3);
    	gridPane.add(textField3, 1, 4);
    	gridPane.add(textField4, 1, 5);
    	gridPane.add(textField5, 1, 6);
    	gridPane.add(textField6, 1, 7);
    	
    	button.setText("Confirmar");
    	
    	gridPane.add(button, 0, 8);

        button.setOnAction((event) -> {
        	Endereco endereco = new Endereco("Default",1,"Default","Default","Default");//Rua,número,bairro,cidade,cep
        	LocalVacinacao local = new LocalVacinacao("Default",endereco);
        	boolean v1=true;
        	try {
        		endereco = new Endereco("Default",Integer.valueOf(textField3.getText()),"Default","Default","Default");
    		}catch(NumberFormatException error) {
    			v1=false;
    		}
        	if(v1) {
        		endereco = new Endereco(textField2.getText(),Integer.valueOf(textField3.getText()),textField4.getText(),textField5.getText(),textField6.getText());
        		local = new LocalVacinacao(textField.getText(),endereco);
    			locais.add(local);
            	
            	clearGrid();
            	
            	label13.setText("Local registrado com sucesso!");
            	
            	gridPane.add(label13, 0, 3);
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), label13);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.setCycleCount(1);
                fadeTransition.play();
        	}
        	else {
        		label4.setText("Número Inválido! Insira novamente:");
        		label4.setStyle("-fx-text-fill: red");
        	}
        });
    	
    	
    }
    
    public void criarEnfermeiro() {//Método que registra um enfermeiro do tipo Enfermeiro e guarda dentro de uma lista denominada enfermeiros.
    	clearGrid();
    	
    	label12.setText("Informe seu ID:");
    	label.setText("Digite o nome da pessoa:");
    	label2.setText("Digite a idade:");
    	label3.setText("Digite um cpf válido:");
    	label4.setText("Digite um número de celular:");
    	label5.setText("Digite uma prioridade:");
    	label6.setText("Digite um endereço:");
    	
    	label7.setText("Rua:");
    	label8.setText("Número:");
    	label9.setText("Bairro:");
    	label10.setText("Cidade:");
    	label11.setText("CEP(Opcional):");
    	
    	label6.setUnderline(true);
    	
    	gridPane.add(label12, 0, 1);
    	gridPane.add(label, 0, 2);
    	gridPane.add(label2, 0, 3);
    	gridPane.add(label3, 0, 4);
    	gridPane.add(label4, 0, 5);
    	gridPane.add(label5, 0, 6);
    	gridPane.add(label6, 0, 7);
    	gridPane.add(label7, 0, 8);
    	gridPane.add(label8, 0, 9);
    	gridPane.add(label9, 0, 10);
    	gridPane.add(label10, 0, 11);
    	gridPane.add(label11, 0, 12);
    	
    	
    	
    	gridPane.add(textField, 1, 1);
    	gridPane.add(textField2, 1, 2);
    	gridPane.add(textField3, 1, 3);
    	gridPane.add(textField4, 1, 4);
    	gridPane.add(textField5, 1, 5);
    	gridPane.add(textField6, 1, 6);
    	gridPane.add(textField7, 1, 8);
    	gridPane.add(textField8, 1, 9);
    	gridPane.add(textField9, 1, 10);
    	gridPane.add(textField10, 1, 11);
    	gridPane.add(textField11, 1, 12);
    	
    	button.setText("Confirmar");
    	
    	gridPane.add(button, 0, 13);

        button.setOnAction((event) -> {
        	Endereco endereco = new Endereco("Default",1,"Default","Default","Default");//Rua,número,bairro,cidade,cep
        	Prioridade prioridade = new Prioridade("Default");//tipo da prioridade
        	Enfermeiro	enfermeiro = new Enfermeiro(1,"Default",1,"Default","Default",prioridade,endereco);//ID, Nome, idade, cpf, celular, prioridade, endereço
        	boolean v1=true,v2=true,v3=true,v4=true;
        	try {
        		endereco = new Endereco("Default",Integer.valueOf(textField8.getText()),"Default","Default","Default");
    		}catch(NumberFormatException error) {
    			v1=false;
    		}
        	try {
        		enfermeiro = new Enfermeiro(Integer.valueOf(textField.getText()),"Default",1,"Default","Default",prioridade,endereco);
    		}catch(NumberFormatException error) {
    			v2=false;
    		}
        	try {
        		enfermeiro = new Enfermeiro(1,"Default",Integer.valueOf(textField3.getText()),"Default","Default",prioridade,endereco);
    		}catch(NumberFormatException error) {
    			v3=false;
    		}
        	if(!enfermeiro.validarCPF(textField4.getText()))
        		v4=false;
        	if(v1&&v2&&v3&&v4) {
        		endereco = new Endereco(textField7.getText(),Integer.valueOf(textField8.getText()),textField9.getText(),textField10.getText(),textField11.getText());
        		prioridade = new Prioridade(textField6.getText());//tipo da prioridade
        		enfermeiro = new Enfermeiro(Integer.valueOf(textField.getText()),textField2.getText(),Integer.valueOf(textField3.getText()),textField4.getText(),
        									textField5.getText(),prioridade,endereco);
    			enfermeiros.add(enfermeiro);
            	
            	clearGrid();
            	
            	label13.setText("Enfermeiro registrado com sucesso!");
            	
            	gridPane.add(label13, 0, 3);
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), label13);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.setCycleCount(1);
                fadeTransition.play();
        	}
        	else {
        		if(v1) {
        			label8.setText("Número:");
        			label8.setStyle("-fx-text-fill: black");
        		}
        		else {
        			label8.setText("Número Inválido! Digite novamente:");
        			label8.setStyle("-fx-text-fill: red");
        		}
        		if(v2) {
        			label12.setText("Informe seu ID:");
        			label12.setStyle("-fx-text-fill: black");
        		}
        		else {
        			label12.setText("ID Inválido! Insira novamente:");
        			label12.setStyle("-fx-text-fill: red");
        		}
        		if(v3) {
        			label2.setText("Digite a idade:");
        			label2.setStyle("-fx-text-fill: black");
        		}
        		else {
        			label2.setText("Idade Inválida! Insira novamente:");
        			label2.setStyle("-fx-text-fill: red");
        		}
        		if(v4) {
        			label3.setText("Digite um cpf válido:");
        			label3.setStyle("-fx-text-fill: black");
        		}
        		else {
        			label3.setText("CPF Inválido! Digite novamente:");
        			label3.setStyle("-fx-text-fill: red");
        		}
        	}
        	
        	
        });
    }
    
    public void criarVacina() {//Método que registra uma vacina do tipo Vacina e guarda dentro de uma lista denominada vacinas.
    	clearGrid();
    	
    	label.setText("Insira o nome da vacina:");
    	label2.setText("Insira o nome do fabricante:");
    	label3.setText("Insira a duração da vacina:");
    	label4.setText("Insira a idade mínima da vacina:");
    	label5.setText("Insira a dose:");
    	label6.setText("Insira a eficacia:");
    	label7.setText("Insira as restrições:");
    	
    	gridPane.add(label, 0, 1);
    	gridPane.add(label2, 0, 2);
    	gridPane.add(label3, 0, 3);
    	gridPane.add(label4, 0, 4);
    	gridPane.add(label5, 0, 5);
    	gridPane.add(label6, 0, 6);
    	gridPane.add(label7, 0, 7);
    	
    	gridPane.add(textField, 1, 1);
    	gridPane.add(textField2, 1, 2);
    	gridPane.add(textField3, 1, 3);
    	gridPane.add(textField4, 1, 4);
    	gridPane.add(textField5, 1, 5);
    	gridPane.add(textField6, 1, 6);
    	gridPane.add(textField7, 1, 7);
    	
    	button.setText("Confirmar");
    	
    	gridPane.add(button, 0, 8);
    	
    	button.setOnAction((event) -> {
    		Vacina vacina = new Vacina("Default","Default",1,1,1,1,"Default");
    		boolean v1 = true;boolean v2 = true;boolean v3 = true;boolean v4 = true;
    		try {
    			vacina = new Vacina("Default","Default",Integer.valueOf(textField3.getText()),1,1,1,"Default");
    		}catch(NumberFormatException error) {
    			v1=false;
    		}
    		try {
    			vacina = new Vacina("Default","Default",1,Integer.valueOf(textField4.getText()),1,1,"Default");
    		}catch(NumberFormatException error) {
    			v2=false;
    		}
    		try {
    			vacina = new Vacina("Default","Default",1,1,Integer.valueOf(textField5.getText()),1,"Default");
    		}catch(NumberFormatException error) {
    			v3=false;
    		}
    		try {
    			vacina = new Vacina("Default","Default",1,1,1,Integer.valueOf(textField6.getText()),"Default");
    		}catch(NumberFormatException error) {
    			v4=false;
    		}
    		if(v1&&v2&&v3&&v4) {
    			vacina = new Vacina(textField.getText(),textField2.getText(),Integer.valueOf(textField3.getText()),Integer.valueOf(textField4.getText()),
    					Integer.valueOf(textField5.getText()),Integer.valueOf(textField6.getText()),textField7.getText());
    			vacinas.add(vacina);
            	
            	clearGrid();
            	
            	label13.setText("Vacina registrada com sucesso!");
            	
            	gridPane.add(label13, 0, 3);
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), label13);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.setCycleCount(1);
                fadeTransition.play();
    		}
    		else {
    			if(v1) {
    	        	label3.setText("Insira a duração da vacina:");
            		label3.setStyle("-fx-text-fill: black");
    			}
    			else {
    				label3.setText("Duração inválida! Insira novamente:");
    				label3.setStyle("-fx-text-fill: red");
    			}
    			if(v2) {
    				label4.setText("Insira a idade mínima da vacina:");
            		label4.setStyle("-fx-text-fill: black");
    			}
    			else {
    				label4.setText("Idade inválida! Digite novamente:");
    				label4.setStyle("-fx-text-fill: red");
    			}
    			if(v3) {
    				label5.setText("Insira a dose:");
            		label5.setStyle("-fx-text-fill: black");
    			}
    			else {
    				label5.setText("Dose incorreta! Digite novamente:");
    				label5.setStyle("-fx-text-fill: red");
    				
    			}
    			if(v4) {
    				label6.setText("Insira a eficacia:");
            		label6.setStyle("-fx-text-fill: black");
    			}
    			else {
    				label6.setText("Valor incorreto! Insira novamente:");
    				label6.setStyle("-fx-text-fill: red");
    			}
    		}
    	});
    	
    }
    
    public void criarPessoa() {//Método que registra uma pessoa do tipo Pessoa e guarda dentro de uma lista denominada pessoas.
    	clearGrid();
    	
    	label.setText("Digite o nome da pessoa:");
    	label2.setText("Digite a idade:");
    	label3.setText("Digite um cpf válido:");
    	label4.setText("Digite um número de celular:");
    	label5.setText("Digite uma prioridade:");
    	label6.setText("Digite um endereço:");
    	
    	label7.setText("Rua:");
    	label8.setText("Número:");
    	label9.setText("Bairro:");
    	label10.setText("Cidade:");
    	label11.setText("CEP(Opcional):");
    	
    	label6.setUnderline(true);
    	
    	gridPane.add(label, 0, 1);
    	gridPane.add(label2, 0, 2);
    	gridPane.add(label3, 0, 3);
    	gridPane.add(label4, 0, 4);
    	gridPane.add(label5, 0, 5);
    	gridPane.add(label6, 0, 6);
    	gridPane.add(label7, 0, 7);
    	gridPane.add(label8, 0, 8);
    	gridPane.add(label9, 0, 9);
    	gridPane.add(label10, 0, 10);
    	gridPane.add(label11, 0, 11);
    	
    	
    	
    	gridPane.add(textField, 1, 1);
    	gridPane.add(textField2, 1, 2);
    	gridPane.add(textField3, 1, 3);
    	gridPane.add(textField4, 1, 4);
    	gridPane.add(textField5, 1, 5);
    	gridPane.add(textField6, 1, 7);
    	gridPane.add(textField7, 1, 8);
    	gridPane.add(textField8, 1, 9);
    	gridPane.add(textField9, 1, 10);
    	gridPane.add(textField10, 1, 11);
    	
    	
    	button.setText("Confirmar");
    	
    	gridPane.add(button, 0, 12);

        button.setOnAction((event) -> {
        	Endereco endereco = new Endereco("Default",1,"Default","Default","Default");//Rua,número,bairro,cidade,cep
        	Prioridade prioridade = new Prioridade("Default");//tipo da prioridade
        	Pessoa pessoa = new Pessoa("Default",1,"Default","Default",prioridade,endereco);//Nome, idade, cpf, celular, prioridade, endereço
        	boolean v1=true;
        	boolean v2=true;
        	boolean v3=true;
        	try {
        		endereco = new Endereco(textField6.getText(),Integer.valueOf(textField7.getText()),textField8.getText(),textField9.getText(),textField10.getText());
        	}catch(NumberFormatException error) {
        		v1=false;
        	}
    		prioridade = new Prioridade(textField5.getText());
    		try {
    			pessoa = new Pessoa(textField.getText(),Integer.valueOf(textField2.getText()),textField3.getText(),textField4.getText(),prioridade,endereco);
    		}catch(NumberFormatException error) {
    			v2=false;
    		}
    		if(!pessoa.validarCPF(textField3.getText()))
    			v3=false;
    		
        	if(v1&&v2&&v3) {
            	enderecos.add(endereco);
            	prioridades.add(prioridade);
            	pessoas.add(pessoa);
            	
            	clearGrid();
            	
            	label13.setText("	Pessoa registrada com sucesso!");
            	
            	gridPane.add(label13, 0, 3);
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), label13);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.setCycleCount(1);
                fadeTransition.play();
        	}
        	else {
            	if(v1) {
            		label8.setText("Número:");
            		label8.setStyle("-fx-text-fill: black");
            	}
            	else {
            		label8.setText("Número Inválido! Digite novamente:");
            		label8.setStyle("-fx-text-fill: red");
            	}
            	if(v2) {
            		label2.setText("Digite a idade:");
            		label2.setStyle("-fx-text-fill: black");
            	}
            	else {
            		label2.setText("Idade Inválida! Digite novamente:");
            		label2.setStyle("-fx-text-fill: red");
            	}
            	if(v3) {
            		label3.setText("Digite um cpf válido:");
            		label3.setStyle("-fx-text-fill: black");
            	}
            	else {
            		label3.setText("CPF Inválido! Digite Novamente: ");
            		label3.setStyle("-fx-text-fill: red");
            	}
        	}
       });
    	
    }
    
    
    public void clearGrid() {//Método que reinicia os objetos que manipulam a interface gráfica
    	gridPane.getChildren().remove(label);
    	gridPane.getChildren().remove(label2);
    	gridPane.getChildren().remove(label3);
    	gridPane.getChildren().remove(label4);
    	gridPane.getChildren().remove(label5);
    	gridPane.getChildren().remove(label6);
    	gridPane.getChildren().remove(label7);
    	gridPane.getChildren().remove(label8);
    	gridPane.getChildren().remove(label9);
    	gridPane.getChildren().remove(label10);
    	gridPane.getChildren().remove(label11);
    	gridPane.getChildren().remove(label12);
    	gridPane.getChildren().remove(label13);
    	
    	label.setUnderline(false);
    	label2.setUnderline(false);
    	label3.setUnderline(false);
    	label4.setUnderline(false);
    	label5.setUnderline(false);
    	label6.setUnderline(false);
    	label7.setUnderline(false);
    	label8.setUnderline(false);
    	label9.setUnderline(false);
    	label10.setUnderline(false);
    	label11.setUnderline(false);
    	label12.setUnderline(false);
    	label13.setUnderline(false);
    	
    	textField.clear();
    	textField2.clear();
    	textField3.clear();
    	textField4.clear();
    	textField5.clear();
    	textField6.clear();
    	textField7.clear();
    	textField8.clear();
    	textField9.clear();
    	textField10.clear();
    	textField11.clear();
    	
    	gridPane.getChildren().remove(textField);
    	gridPane.getChildren().remove(textField2);
    	gridPane.getChildren().remove(textField3);
    	gridPane.getChildren().remove(textField4);
    	gridPane.getChildren().remove(textField5);
    	gridPane.getChildren().remove(textField6);
    	gridPane.getChildren().remove(textField7);
    	gridPane.getChildren().remove(textField8);
    	gridPane.getChildren().remove(textField9);
    	gridPane.getChildren().remove(textField10);
    	gridPane.getChildren().remove(textField11);
    	
    	gridPane.getChildren().remove(button);
    	
    	hbox.getChildren().removeAll(listView);
    	hbox.getChildren().removeAll(listView2);
    	hbox.getChildren().removeAll(listView3);
    	hbox.getChildren().removeAll(listView4);
    	hbox.getChildren().removeAll(listView5);
    	hbox.getChildren().removeAll(listView6);
    	hbox.getChildren().removeAll(listView7);
    	
    	listView.getItems().clear();
    	listView2.getItems().clear();
    	listView3.getItems().clear();
    	listView4.getItems().clear();
    	listView5.getItems().clear();
    	listView6.getItems().clear();
    	listView7.getItems().clear();
    	
    	gridPane.getChildren().remove(hbox);
    	
    	label.setStyle("-fx-text-fill: black");
    	label2.setStyle("-fx-text-fill: black");
    	label3.setStyle("-fx-text-fill: black");
    	label4.setStyle("-fx-text-fill: black");
    	label5.setStyle("-fx-text-fill: black");
    	label6.setStyle("-fx-text-fill: black");
    	label7.setStyle("-fx-text-fill: black");
    	label8.setStyle("-fx-text-fill: black");
    	label9.setStyle("-fx-text-fill: black");
    	label10.setStyle("-fx-text-fill: black");
    	label11.setStyle("-fx-text-fill: black");
    	label12.setStyle("-fx-text-fill: black");
    	label13.setStyle("-fx-text-fill: black");
    }
    
    @Override
    public void start(Stage primaryStage) {//Método principal que executa o palco da interface gráfica, cujo nome dado é primaryStage.

        
        primaryStage.setTitle("Base de Dados das Vacinações");
        
        Menu menu = new Menu("Adicionar Dados");
        Menu menu2 = new Menu("Mostrar Dados");
        Menu menu3 = new Menu("Opções das Carteiras");
        
        MenuItem menuItem1 = new MenuItem("Adicionar Pessoa");
        MenuItem menuItem2 = new MenuItem("Adicionar Vacina");
        MenuItem menuItem3 = new MenuItem("Adicionar Enfermeiro");
        MenuItem menuItem4 = new MenuItem("Adicionar Carteira de Vacinação");
        MenuItem menuItem6 = new MenuItem("Adicionar Local de Vacinação");
        
        MenuItem menuItem41 = new MenuItem("Adicionar Vacinas em uma Carteira");
        
        MenuItem menuItem7 = new MenuItem("Listar Pessoas");
        MenuItem menuItem8 = new MenuItem("Listar Locais de Vacinação");
        MenuItem menuItem9 = new MenuItem("Listar Carteiras de Vacinação");
        MenuItem menuItem10 = new MenuItem("Listar Vacinas");
        MenuItem menuItem11 = new MenuItem("Listar Enfermeiros");
        
        menu.getItems().add(menuItem1);
        menu.getItems().add(menuItem2);
        menu.getItems().add(menuItem3);
        menu.getItems().add(menu3);
        menu.getItems().add(menuItem6);
        
        menu2.getItems().add(menuItem7);
        menu2.getItems().add(menuItem8);
        menu2.getItems().add(menuItem9);
        menu2.getItems().add(menuItem10);
        menu2.getItems().add(menuItem11);
        
        menu3.getItems().add(menuItem4);
        menu3.getItems().add(menuItem41);
        
        menuBar.getMenus().add(menu);
        menuBar.getMenus().add(menu2);
        
        menuItem1.setOnAction(e -> {//Adicionar pessoa
        	criarPessoa();
        });
        menuItem2.setOnAction(e -> {//Adicionar Vacina
        	criarVacina();
        });
        menuItem3.setOnAction(e -> {//Enfermeiro
        	criarEnfermeiro();
        });
        menuItem4.setOnAction(e -> {//Adicionar Carteira
        	criarCarteira();
        });
        menuItem41.setOnAction(e -> {//Adicionar Vacinas na carteira
        	addVacina();
        });
        menuItem6.setOnAction(e -> {//Local
        	criarLocal();
        });
        menuItem7.setOnAction(e -> {//Listar Pessoas
        	
        	clearGrid();

        	listView.getItems().addAll(pessoas);
        	hbox.getChildren().add(listView);
        	gridPane.add(hbox, 0, 2);
        });
        menuItem8.setOnAction(e -> {//listar local
        	clearGrid();
        	
        	listView6.getItems().addAll(locais);
        	listView6.setPrefWidth(800);
        	hbox.getChildren().add(listView6);
        	gridPane.add(hbox, 0, 2);
        });
        menuItem9.setOnAction(e -> {//listar carteira
        	clearGrid();
        	
        	listView4.getItems().addAll(carteiras);
        	listView4.setPrefWidth(800);
        	hbox.getChildren().add(listView4);
        	gridPane.add(hbox, 0, 2);
        });
        menuItem10.setOnAction(e -> {//Listar vacinas
        	clearGrid();

        	listView5.getItems().addAll(vacinas);
        	hbox.getChildren().add(listView5);
        	gridPane.add(hbox, 0, 2);
        });
        menuItem11.setOnAction(e ->{//listar enfermeiros
        	clearGrid();
        	
        	listView7.getItems().addAll(enfermeiros);
        	hbox.getChildren().add(listView7);
        	gridPane.add(hbox, 0, 2);
        });
        
        gridPane.add(menuBar, 0, 0);
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(900);
        primaryStage.setHeight(600);
        primaryStage.show();
    }


}