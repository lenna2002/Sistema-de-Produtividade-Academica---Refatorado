package objetos;

public class Orientacoes extends ProducoesAcademicas {
	private long professor;
	
	public Orientacoes(String titulo, int matricula, long professor) {
		this.setTitulo(titulo);
		setProjetoAssociado(matricula);
		this.professor = professor;
	}

	public long getProfessor() {
		return professor;
	}

	public void setProfessor(long professor) {
		this.professor = professor;
	}
}
