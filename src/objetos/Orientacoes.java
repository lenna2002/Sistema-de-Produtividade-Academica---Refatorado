package objetos;

import java.util.Scanner;

import sistema.Sistema;
import sistema.TratamentoDeErros;

public class Orientacoes extends ProducoesAcademicas {
	private long professor;
	
	private static Scanner input = new Scanner(System.in);
	
	public Orientacoes() {
		this.setTitulo(null);
		setProjetoAssociado(0);
		this.professor = 0;
	}

	public long getProfessor() {
		return professor;
	}

	public void setProfessor(long professor) {
		this.professor = professor;
	}
	
	public ProducoesAcademicas add(int matricula) {
		
		TratamentoDeErros tratamento = new TratamentoDeErros();
		Sistema sistema = new Sistema();
		
		ProducoesAcademicas novaProducao = new Orientacoes();
		
		System.out.println("Título da publicação:");
		novaProducao.setTitulo(input.nextLine());
		System.out.println("CPF do professor responsavel.");
		((Orientacoes)novaProducao).setProfessor(tratamento.cpf());
		sistema.atribuirProfessorResponsavel(((Orientacoes)novaProducao).getProfessor(), novaProducao.getTitulo());
		
		
		return novaProducao;
		
	}
}
