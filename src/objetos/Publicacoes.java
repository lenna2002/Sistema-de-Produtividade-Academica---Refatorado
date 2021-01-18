package objetos;

public class Publicacoes extends ProducoesAcademicas{
	private String conferenciaDePublicacao;
	private int mesDePublicacao;
	private int anoDePublicacao;
	
	public Publicacoes(String titulo, int matricula, String conferenciaDePublicacao, int mesDePublicacao, int anoDePublicacao) {
		this.setTitulo(titulo);
		setProjetoAssociado(matricula);
		this.conferenciaDePublicacao = conferenciaDePublicacao;
		this.mesDePublicacao = mesDePublicacao;
		this.anoDePublicacao = anoDePublicacao;
		
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
	
		
}
