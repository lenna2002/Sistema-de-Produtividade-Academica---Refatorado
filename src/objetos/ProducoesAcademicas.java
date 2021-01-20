package objetos;

public abstract class ProducoesAcademicas {
	private String titulo;
	private int projetoAssociado;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getProjetoAssociado() {
		return projetoAssociado;
	}
	public void setProjetoAssociado(int projetoAssociado) {
		this.projetoAssociado = projetoAssociado;
	}
	
	public abstract ProducoesAcademicas add(int matricula);
	
}
