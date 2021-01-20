package objetos;

import java.util.Scanner;

//import java.util.Scanner;
import sistema.TratamentoDeErros;

public class Publicacoes extends ProducoesAcademicas{
	private String conferenciaDePublicacao;
	private int mesDePublicacao;
	private int anoDePublicacao;
	
	private static Scanner input = new Scanner(System.in);
	
	public Publicacoes() {
		super.setTitulo(null);;
		super.setProjetoAssociado(0);
		this.conferenciaDePublicacao = null;
		this.mesDePublicacao = 0;
		this.anoDePublicacao = 0;
		
	}

	public String getConferenciaDePublicacao() {
		return conferenciaDePublicacao;
	}
	
	public void setConferenciaDePublicacao(String conferenciaDePublicacao) {
		this.conferenciaDePublicacao = conferenciaDePublicacao;
	}

	public int getMesDePublicacao() {
		return mesDePublicacao;
	}

	public void setMesDePublicacao(int mesDePublicacao) {
		this.mesDePublicacao = mesDePublicacao;
	}

	public int getAnoDePublicacao() {
		return anoDePublicacao;
	}

	public void setAnoDePublicacao(int anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}
	
	public ProducoesAcademicas add(int matricula) {
		
		TratamentoDeErros tratamento = new TratamentoDeErros();
		
		ProducoesAcademicas novaProducao = new Publicacoes();
		
		System.out.println("Título da publicação:");
		novaProducao.setTitulo(input.nextLine());
		System.out.println("Conferencia de publicação:");
		((Publicacoes)novaProducao).setConferenciaDePublicacao(input.nextLine());
		System.out.println("Data da publicação:");
		System.out.println("Mês:");
		((Publicacoes)novaProducao).setMesDePublicacao(tratamento.inteiro());
		System.out.println("Ano:");
		((Publicacoes)novaProducao).setAnoDePublicacao(tratamento.inteiro());
		
		//input.close();
				
		return novaProducao;
		
	}
		
}
