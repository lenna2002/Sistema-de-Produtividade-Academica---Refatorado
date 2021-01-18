package objetos;

public class Laboratorio {
	private int colaboradores;
	private int projetosEmElaboracao;
	private int projetosEmAndamento;
	private int projetosConcluidos;
	private int numeroDeProjetos;
	private int numeroDePublicacoes;
	private int numeroDeOrientacoes;
	
	
	
	public Laboratorio() {
		colaboradores = 0;
		projetosEmElaboracao = 0;
		projetosEmAndamento = 0;
		projetosConcluidos = 0;
		numeroDeProjetos = 0;
		numeroDePublicacoes = 0;
		numeroDeOrientacoes = 0;
	}

	public int getColaboradores() {
		return colaboradores;
	}
	
	public void setColaboradores() {
		colaboradores++;
	}
	
	public int getProjetosEmElaboracao() {
		return projetosEmElaboracao;
	}
	
	public void setProjetosEmElaboracao(boolean a) {
		if(a) {
			projetosEmElaboracao++;
		} else {
			projetosEmElaboracao--;
		}
	}
	
	public int getProjetosEmAndamento() {
		return projetosEmAndamento;
	}
	
	public void setProjetosEmAndamento(boolean a) {
		if(a) {
			projetosEmAndamento++;
		} else {
			projetosEmAndamento--;
		}
	}
	
	public int getProjetosConcluidos() {
		return projetosConcluidos;
	}
	
	public void setProjetosConcluidos() {
		projetosConcluidos++;
	}
	
	public int getNumeroDeProjetos() {
		return numeroDeProjetos;
	}
	
	public void setNumeroDeProjetos() {
		numeroDeProjetos++;
	}
	
	public int getNumeroDePublicacoes() {
		return numeroDePublicacoes;
	}
	
	public void setNumeroDePublicacoes() {
		numeroDePublicacoes++;
	}
	
	public int getNumeroDeOrientacoes() {
		return numeroDeOrientacoes;
	}
	
	public void setNumeroDeOrientacoes() {
		numeroDeOrientacoes++;
	}

}
