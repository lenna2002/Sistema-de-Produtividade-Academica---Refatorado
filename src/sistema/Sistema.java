package sistema;

import java.util.Scanner;
import java.util.ArrayList;

import objetos.Colaboradores;
import objetos.ProducoesAcademicas;
import objetos.Publicacoes;
import objetos.Orientacoes;
import objetos.Projetos;
import objetos.Laboratorio;

public class Sistema {
	private static ArrayList <Colaboradores> colaboradores = new ArrayList<Colaboradores>();
	private static ArrayList <Projetos> projetos = new ArrayList<Projetos>();
	private static Laboratorio laboratorio = new Laboratorio();
	private static ArrayList <ProducoesAcademicas> producoes = new ArrayList<ProducoesAcademicas>();
	
	private static TratamentoDeErros tratamento = new TratamentoDeErros();
	
	private static Scanner input = new Scanner(System.in);
	
	private int ultimaMatricula = 20000;
	
	
	/************************** COLABORADORES **************************/
	
	public void addColaboradores() {
		String nome, posicao, email;
		long cpf = 0;
		
		System.out.println("Nome do colaborador:");
		nome = input.nextLine();
		
		System.out.println("CPF do colaborador:");
		cpf = tratamento.cpf();
		
		System.out.println("Posi��o do colaborador(gradua��o, mestrado, "
				+ "doutorado, professor, pesquisador):");
		posicao = input.nextLine();
		
		
		System.out.println("E-mail do colaborador:");
		email = input.nextLine();
		
		Colaboradores novoColaborador = new Colaboradores(nome, cpf, posicao, email);
		
		colaboradores.add(novoColaborador);
		laboratorio.setColaboradores();
		
	}
	
	public void imprimirFichaAluno() {
		long cpf = 0;
		
		if(colaboradoresVazio()) {
			System.out.println("Sem colaboradores cadastrados.");
			return;
		}
		
		cpf = tratamento.cpf();
		for(Colaboradores c: colaboradores) {
			if(cpf == c.getCpf()) {
				System.out.println("Nome:" + c.getNome());
				System.out.println("CPF:" + c.getCpf());
				System.out.println("Posi��o:" + c.getPosicao());
				System.out.println("E-mail:" + c.getEmail());
				System.out.println("Quantidade de projetos:" + c.getQuantidadeDeProjetos());
				
				imprimirProjetosDoColaborador(c);
				
				imprimirProducoesDoColaborador(c);
			}
			return;
		}
		
		System.out.println("Colaborador n�o cadastrado.");
	}
		
	public void atribuirPublicacaoColaborador(String titulo) {
		long cpf = 0;
		
		if(colaboradoresVazio()) {
			System.out.println("Sem colaboradores cadastrados.");
			return;
		}
		
		if(projetosVazio()) {
			System.out.println("Sem projetos cadastrados.");
			return;
		}
		
		if(publicacoesVazio()) {
			System.out.println("Sem publica��es cadastradas.");
			return;
		}
		
		while(cpf != -1) {
			System.out.println("Para sair digite -1.");
			cpf = tratamento.cpf();
			for(Colaboradores c: colaboradores) {
				if(c.getCpf() == cpf) {
					c.setPublicacoes(titulo);
					break;
				}
			}
		}
		input.nextLine();
	}
	
	public void atribuirOrientacaoColaborador(String titulo) {
		long cpf = 0;
		
		if(colaboradoresVazio()) {
			System.out.println("Sem colaboradores cadastrados.");
			return;
		}
		
		if(projetosVazio()) {
			System.out.println("Sem projetos cadastrados.");
			return;
		}
		
		if(orientacoesVazio()) {
			System.out.println("Sem orienta��es cadastradas.");
			return;
		}
		
		while(cpf != -1) {
			System.out.println("Para sair digite -1.");
			cpf = tratamento.cpf();
			for(Colaboradores c: colaboradores) {
				if(c.getCpf() == cpf) {
					c.setPublicacoes(titulo);
					break;
				}
			}
		}
		input.nextLine();
	}
	
	public void atribuirProfessorResponsavel(long cpf, String titulo) {
		for(Colaboradores c: colaboradores) {
			if(cpf == c.getCpf()) {
				c.setOrientacoes(titulo);
			}
		}
	}

	public void imprimirProjetosDoColaborador(Colaboradores c) {
		int matricula;
		
		if(colaboradoresVazio()) {
			System.out.println("Sem colaboradores cadastrados.");
			return;
		}
		
		if(projetosVazio()) {
			System.out.println("Sem projetos cadastrados.");
			return;
		}
		
		for(Projetos p: projetos) {
			matricula = p.getMatricula();
			for(int i = 0; i < c.getQuantidadeDeProjetos(); i++) {
				if(c.getProjetos(i) == matricula) {
					System.out.println(p.getTitulo());
				}
			}
		}
	}
	
	public void imprimirProducoesDoColaborador(Colaboradores c) {
		int i = 0;
		
		if(colaboradoresVazio()) {
			System.out.println("Sem colaboradores cadastrados.");
			return;
		}
		
		if(projetosVazio()) {
			System.out.println("Sem projetos cadastrados.");
			return;
		}
		
		if(publicacoesVazio() && orientacoesVazio()) {
			System.out.println("Sem colaboradores cadastrados.");
			return;
		}
		
		String publicacoes[] = c.getPublicacoes();
		String orientacoes[] = c.getOrientacoes();
		while(publicacoes[i] != null) {
			System.out.println(publicacoes[i]);
			i++;
		}
		i = 0;
		while(orientacoes[i] != null) {
			System.out.println(orientacoes[i]);
			i++;
		}
	}
	
	public boolean colaboradoresVazio() {
		if(laboratorio.getColaboradores() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/************************** PROJETOS **************************/
	
	public void addProjetos() {
		String titulo, agencia, objetivo, descricao;
		int mesInicio, anoInicio, mesTermino, anoTermino; 
		long cpf;
		double valor;
		
		if(colaboradoresVazio()) {
			System.out.println("Sem colaboradores cadastrados.");
			return;
		}
		
		System.out.println("T�tulo do projeto:");
		titulo = input.nextLine();
		
		System.out.println("In�cio do projeto:");
		System.out.println("M�s:");
		mesInicio = tratamento.inteiro();
		System.out.println("Ano:");
		anoInicio = tratamento.inteiro();
		
		System.out.println("T�rmino do projeto:");
		System.out.println("M�s:");
		mesTermino = tratamento.inteiro();
		System.out.println("Ano:");
		anoTermino = tratamento.inteiro();
		
		System.out.println("Ag�ncia Financiadora do projeto:");
		input.nextLine();
		agencia = input.nextLine();
		
		System.out.println("Valor financeiro do projeto:");
		valor = tratamento.doubl();
		
		System.out.println("Objetivo do projeto:");
		input.nextLine();
		objetivo = input.nextLine();
		
		System.out.println("Descri��o do projeto:");
		descricao = input.nextLine();
		
		System.out.println("Cpf do professor responsavel:");
		cpf = tratamento.cpf();
		for(Colaboradores c: colaboradores) {
			if(c.getCpf() == cpf) {
				if(!c.getPosicao().equalsIgnoreCase("professor")) {
					System.out.println("Colaborador n�o � professor.\nOpena��o cancelada.");
					return;
				} else {
					c.setQuantidadeDeProjetos(true);
					c.addProjeto(ultimaMatricula);
					System.out.println(ultimaMatricula);
					return;
				}
			}	
		}	
		
		
		
		Projetos novoProjeto = new Projetos(titulo, ultimaMatricula++, mesInicio, anoInicio, mesTermino, anoTermino, agencia, valor, 
				objetivo, descricao, cpf);
		
		if(projetos.size() != 0) {
			for(int i = 0; i < projetos.size(); i++) {
				if(anoTermino < projetos.get(i).getAnoTermino()) {
					if(mesTermino < projetos.get(i).getMesTermino()) {
						projetos.add(i, novoProjeto);
					}
				}
			}
		} else {
			projetos.add(novoProjeto);
		}
		
		laboratorio.setProjetosEmElaboracao(true);
		laboratorio.setNumeroDeProjetos();
		
	}
	
	public void addColaboradorEmProjeto() {
		long cpf;
		int matricula, i, j;
		
		if(colaboradoresVazio()) {
			System.out.println("Sem colaboradores cadastrados.");
			return;
		}
		
		if(projetosVazio()) {
			System.out.println("Sem projetos cadastrados.");
			return;
		}
		
		
		System.out.println("Matr�cula do projeto:");
		matricula = tratamento.inteiro();
		
		for(j = 0; j < projetos.size(); j++) {
			if(projetos.get(j).getMatricula() == matricula) {
				if(!projetos.get(j).getStatus().equalsIgnoreCase("elabora��o")) {
					System.out.println("Projeto em " + projetos.get(j).getStatus());
					return;
				} else {
					break;
				}
			}
		}
		
		System.out.println("CPF do colaborador:");
		cpf = tratamento.cpf();
		
		for(i = 0; i < colaboradores.size(); i++) {
			if(colaboradores.get(i).getPosicao().equalsIgnoreCase("gradua��o")) {
				if(colaboradores.get(i).getQuantidadeDeProjetos() >= 2) {
					System.out.println("Aluno de gradua��o atingiu o limite m�ximo de prjetos em andamento.\nOpera��o cancelada!");
					return;
				}
				break;
			}
		}
		
		colaboradores.get(i).addProjeto(matricula);
		colaboradores.get(i).setQuantidadeDeProjetos(true);
		projetos.get(j).addParticipantes(cpf);
		projetos.get(j).setQuantidadeDeParticipantes(true);
	}
	
	public void alterarStatusDoProjeto() {
		int matricula;
		
		if(projetosVazio()) {
			System.out.println("Sem projetos cadastrados.");
			return;
		}
		
		System.out.println("Matricula do projeto:");
		matricula = tratamento.inteiro();
		
		for(Projetos p: projetos) {
			if(p.getMatricula() == matricula) {
				
				if(p.getStatus().equalsIgnoreCase("concluido")) {
					System.out.println("Projeto conclu�do. N�o pode ser alterado.");
				} else if (p.getStatus().equalsIgnoreCase("elabora��o")){
					laboratorio.setProjetosEmElaboracao(false);
					laboratorio.setProjetosEmAndamento(true);
					System.out.println("O projeto agora est� em andamento.");
					p.setStatus("andamento");
				} else {
					if(!checarProducoes(p)) {
						System.out.println("Prjeto n�o tem produ��es acad�micas associadas. Opera��o cancelada!");
						return;
					}
					laboratorio.setProjetosEmAndamento(false);
					laboratorio.getProjetosConcluidos();
					for(int i = 0; i < p.getQuantidadeDeParticipantes(); i++) {
						long cpf = p.getParticipantes(i);
						for(Colaboradores c: colaboradores) {
							if(c.getCpf() == cpf) {
								c.setQuantidadeDeProjetos(false);
							}
						}
					}
					System.out.println("O projeto agora est� conclu�do.");
					p.setStatus("concluido");
				}
				return;
			}
		}
		
	}
	
	public void atribuirPublicacaoProjeto(String titulo, Projetos c) {
		c.setPublicacoes(titulo);
	}
	
	public void atribuirOrientacaoProjeto(String titulo, Projetos c) {
		c.setOrientacoes(titulo);
	}
	
	public void imprimirFichaProjeto() {
		int matricula;
		
		if(projetosVazio()) {
			System.out.println("Sem projetos cadastrados.");
			return;
		}
		
		System.out.println("Matr�cula do projeto:");
		matricula = tratamento.inteiro();
		for(Projetos p: projetos) {
			if(p.getMatricula() == matricula) {
				System.out.println("T�tulo: " + p.getTitulo());
				System.out.println("Matr�cula: " + p.getMatricula());
				System.out.println("Data de in�cio do projeto: " + p.getMesInicio() + " " + p.getAnoInicio());
				System.out.println("Data de t�rmino prevista: " + p.getMesTermino() + " " + p.getAnoTermino());
				System.out.println("Ag�ncia financiadora: " + p.getAgencia());
				System.out.println("Valor do financiamento: " + p.getValor());
				System.out.println("Objetivo do projeto: " + p.getObjetivo());
				System.out.println("Descri��o: " + p.getDescricao());
				System.out.println("Quantidade de participantes: " + p.getQuantidadeDeParticipantes());
				for(int i = 1; i <= p.getQuantidadeDeParticipantes(); i++) {
					System.out.println(i + " - " + p.getParticipantes(i));
				}
				System.out.println("Status do projeto: " + p.getTitulo());
				System.out.println("Produ��es acad�micas: ");
				imprimirProducoesDoProjeto(p);
				return;
			}
		}
	}
	
	public void imprimirProducoesDoProjeto(Projetos p) {
		int i = 0;
		
		String publicacoes[] = p.getPublicacoes();
		String orientacoes[] = p.getOrientacoes();
		while(publicacoes[i] != null) {
			System.out.println(publicacoes[i]);
		}
		i = 0;
		while(orientacoes[i] != null) {
			System.out.println(orientacoes[i]);
		}
	}
	
	public boolean projetosVazio() {
		if(laboratorio.getNumeroDeProjetos() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/************************** PRODU��ES **************************/
	
	public void addPublicacao() {
		int matricula, mesDePublicacao, anoDePublicacao;
		String titulo, conferencia;
		
		if(projetosVazio()) {
			System.out.println("Sem projetos cadastrados.");
			return;
		}
		
		System.out.println("Qual a matricula do projeto associado?");
		matricula = tratamento.inteiro();
		for(Projetos c: projetos) {
			if(c.getMatricula() == matricula) {
				if(!c.getStatus().equalsIgnoreCase("andamento")) {
					System.out.println("Essa opere��o � permitida apenas quando o projeto est� em andamento. Opera��o cancelada!");
					return;
				}
				System.out.println("T�tulo da publica��o:");
				titulo = input.nextLine();
				System.out.println("Conferencia de publica��o:");
				conferencia = input.nextLine();
				System.out.println("Data da publica��o:");
				System.out.println("M�s:");
				mesDePublicacao = tratamento.inteiro();
				System.out.println("Ano:");
				anoDePublicacao = tratamento.inteiro();
				
				Publicacoes novaProducao = new Publicacoes(titulo, matricula, conferencia, 
						mesDePublicacao, anoDePublicacao);
				
				producoes.add(novaProducao);
				
				atribuirPublicacaoColaborador(titulo);
				atribuirPublicacaoProjeto(titulo, c);
				laboratorio.setNumeroDePublicacoes();
				
				return;
			}
		}
		
		
		
	}
	
	public void addOrientacao() {
		int matricula;
		long cpf;
		String titulo;
		
		if(projetosVazio()) {
			System.out.println("Sem projetos cadastrados.");
			return;
		}
		
		System.out.println("Qual a matricula do projeto associado?");
		matricula = tratamento.inteiro();
		for(Projetos c: projetos) {
			if(c.getMatricula() == matricula) {
				if(!c.getStatus().equalsIgnoreCase("andamento")) {
					System.out.println("Essa opere��o � permitida apenas quando o projeto est� em andamento. Opera��o cancelada!");
					return;
				}
				System.out.println("T�tulo da publica��o:");
				titulo = input.nextLine();
				System.out.println("CPF do professor responsavel.");
				cpf = tratamento.cpf();
				atribuirProfessorResponsavel(cpf, titulo);
				
				Orientacoes novaOrientacao = new Orientacoes(titulo, matricula, cpf);
				
				producoes.add(novaOrientacao);
				
				atribuirOrientacaoColaborador(titulo);
				atribuirOrientacaoProjeto(titulo, c);
				laboratorio.setNumeroDeOrientacoes();
				
			}
		}
		
		
		
	}
	
	public boolean checarProducoes(Projetos p) {
		String publicacoes[] = p.getPublicacoes();
		if(publicacoes[0] != null) {
			return true;
		}
		String orientacoes[] = p.getOrientacoes();
		if(orientacoes[0] != null) {
			return true;
		}
		return false;
		
	}
	
	public boolean publicacoesVazio() {
		if(laboratorio.getNumeroDePublicacoes() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean orientacoesVazio() {
		if(laboratorio.getNumeroDeOrientacoes() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/************************** SISTEMA **************************/
	
	public void relatorioDeProducaoAcademica() {
		System.out.println("N�mero de colaboradores:" + laboratorio.getColaboradores());
		System.out.println("N�mero de projetos em elabora��o:" + laboratorio.getProjetosEmElaboracao());
		System.out.println("N�mero de projetos em Andamento:" + laboratorio.getProjetosEmAndamento());
		System.out.println("N�mero de projetos conclu�dos:" + laboratorio.getProjetosConcluidos());
		System.out.println("N�mero total de projetos:" + laboratorio.getNumeroDeProjetos());
		System.out.println("N�mero de publica��es:" + laboratorio.getNumeroDePublicacoes());
		System.out.println("N�mero de orienta��es:" + laboratorio.getNumeroDeOrientacoes());
		
		
	}

}
