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
		
		System.out.println("Posição do colaborador(graduação, mestrado, "
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
				System.out.println("Posição:" + c.getPosicao());
				System.out.println("E-mail:" + c.getEmail());
				System.out.println("Quantidade de projetos:" + c.getQuantidadeDeProjetos());
				
				imprimirProjetosDoColaborador(c);
				
				imprimirProducoesDoColaborador(c);
			}
			return;
		}
		
		System.out.println("Colaborador não cadastrado.");
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
			System.out.println("Sem publicações cadastradas.");
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
			System.out.println("Sem orientações cadastradas.");
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
		
		System.out.println("Título do projeto:");
		titulo = input.nextLine();
		
		System.out.println("Início do projeto:");
		System.out.println("Mês:");
		mesInicio = tratamento.inteiro();
		System.out.println("Ano:");
		anoInicio = tratamento.inteiro();
		
		System.out.println("Término do projeto:");
		System.out.println("Mês:");
		mesTermino = tratamento.inteiro();
		System.out.println("Ano:");
		anoTermino = tratamento.inteiro();
		
		System.out.println("Agência Financiadora do projeto:");
		input.nextLine();
		agencia = input.nextLine();
		
		System.out.println("Valor financeiro do projeto:");
		valor = tratamento.doubl();
		
		System.out.println("Objetivo do projeto:");
		input.nextLine();
		objetivo = input.nextLine();
		
		System.out.println("Descrição do projeto:");
		descricao = input.nextLine();
		
		System.out.println("Cpf do professor responsavel:");
		cpf = tratamento.cpf();
		for(Colaboradores c: colaboradores) {
			if(c.getCpf() == cpf) {
				if(!c.getPosicao().equalsIgnoreCase("professor")) {
					System.out.println("Colaborador não é professor.\nOpenação cancelada.");
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
		
		
		System.out.println("Matrícula do projeto:");
		matricula = tratamento.inteiro();
		
		for(j = 0; j < projetos.size(); j++) {
			if(projetos.get(j).getMatricula() == matricula) {
				if(!projetos.get(j).getStatus().equalsIgnoreCase("elaboração")) {
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
			if(colaboradores.get(i).getPosicao().equalsIgnoreCase("graduação")) {
				if(colaboradores.get(i).getQuantidadeDeProjetos() >= 2) {
					System.out.println("Aluno de graduação atingiu o limite máximo de prjetos em andamento.\nOperação cancelada!");
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
					System.out.println("Projeto concluído. Não pode ser alterado.");
				} else if (p.getStatus().equalsIgnoreCase("elaboração")){
					laboratorio.setProjetosEmElaboracao(false);
					laboratorio.setProjetosEmAndamento(true);
					System.out.println("O projeto agora está em andamento.");
					p.setStatus("andamento");
				} else {
					if(!checarProducoes(p)) {
						System.out.println("Prjeto não tem produções acadêmicas associadas. Operação cancelada!");
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
					System.out.println("O projeto agora está concluído.");
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
		
		System.out.println("Matrícula do projeto:");
		matricula = tratamento.inteiro();
		for(Projetos p: projetos) {
			if(p.getMatricula() == matricula) {
				System.out.println("Título: " + p.getTitulo());
				System.out.println("Matrícula: " + p.getMatricula());
				System.out.println("Data de início do projeto: " + p.getMesInicio() + " " + p.getAnoInicio());
				System.out.println("Data de término prevista: " + p.getMesTermino() + " " + p.getAnoTermino());
				System.out.println("Agência financiadora: " + p.getAgencia());
				System.out.println("Valor do financiamento: " + p.getValor());
				System.out.println("Objetivo do projeto: " + p.getObjetivo());
				System.out.println("Descrição: " + p.getDescricao());
				System.out.println("Quantidade de participantes: " + p.getQuantidadeDeParticipantes());
				for(int i = 1; i <= p.getQuantidadeDeParticipantes(); i++) {
					System.out.println(i + " - " + p.getParticipantes(i));
				}
				System.out.println("Status do projeto: " + p.getTitulo());
				System.out.println("Produções acadêmicas: ");
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
	
	/************************** PRODUÇÕES **************************/
	
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
					System.out.println("Essa opereção é permitida apenas quando o projeto está em andamento. Operação cancelada!");
					return;
				}
				System.out.println("Título da publicação:");
				titulo = input.nextLine();
				System.out.println("Conferencia de publicação:");
				conferencia = input.nextLine();
				System.out.println("Data da publicação:");
				System.out.println("Mês:");
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
					System.out.println("Essa opereção é permitida apenas quando o projeto está em andamento. Operação cancelada!");
					return;
				}
				System.out.println("Título da publicação:");
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
		System.out.println("Número de colaboradores:" + laboratorio.getColaboradores());
		System.out.println("Número de projetos em elaboração:" + laboratorio.getProjetosEmElaboracao());
		System.out.println("Número de projetos em Andamento:" + laboratorio.getProjetosEmAndamento());
		System.out.println("Número de projetos concluídos:" + laboratorio.getProjetosConcluidos());
		System.out.println("Número total de projetos:" + laboratorio.getNumeroDeProjetos());
		System.out.println("Número de publicações:" + laboratorio.getNumeroDePublicacoes());
		System.out.println("Número de orientações:" + laboratorio.getNumeroDeOrientacoes());
		
		
	}

}
