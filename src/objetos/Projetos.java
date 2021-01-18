package objetos;

public class Projetos {
	private String titulo;
	private int matricula;
	private int mesInicio=0, anoInicio=0;
	private int mesTermino=0, anoTermino=0;
	private String agencia;
	private double valor;
	private String objetivo;
	private String descricao;
	private int quantidadeDeParticipantes;
	private long participantes[] = new long[100];			
	private String status;
	private String publicacoes[] = new String[100];
	private String orientacoes[] = new String[100];
	
	
	
	public Projetos(String titulo, int matricula, int mesInicio, int anoInicio, int mesTermino, int anoTermino, String agencia, double valor,
			String objetivo, String descricao, long professor) {
		this.titulo = titulo;
		this.matricula = matricula;
		this.mesInicio = mesInicio;
		this.anoInicio = anoInicio;
		this.mesTermino = mesTermino;
		this.anoTermino = anoTermino;
 		this.agencia = agencia;
		this.valor = valor;
		this.objetivo = objetivo;
		this.descricao = descricao;
		this.status = "elaboração";
		participantes[0] = professor;
		quantidadeDeParticipantes = 1;
		for(int i = 0; i < 100; i++) {
			publicacoes[i] = null;
			orientacoes[i] = null;
		}
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		if(matricula > 20000)
			this.matricula = matricula;
		else
			System.out.println("Entrada Inválido!");
	}
		
	public String getAgencia() {
		return agencia;
	}
	
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		if(valor > 0)
			this.valor = valor;
		else
			System.out.println("Entrada Inválido!");
		
	}
	
	public String getObjetivo() {
		return objetivo;
	}
	
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public long getParticipantes(int i) {
		return participantes[i];
	}
	
	public void addParticipantes(long participante) {
		this.participantes[quantidadeDeParticipantes] = participante;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public int getMesInicio() {
		return mesInicio;
	}

	public void setMesInicio(int mesInicio) {
		if(mesInicio > 0 && mesInicio <= 12)
			this.mesInicio = mesInicio;
		else System.out.println("Mês de inicio inválido!");
	}

	public int getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}

	public int getMesTermino() {
		return mesTermino;
	}

	public void setMesTermino(int mesTermino) {
		if(mesInicio > 0 && mesInicio <= 12)
			this.mesTermino = mesTermino;
		else System.out.println("Mês de término inválido!");
	}

	public int getAnoTermino() {
		return anoTermino;
	}

	public void setAnoTermino(int anoTermino) {
		this.anoTermino = anoTermino;
	}

	public int getQuantidadeDeParticipantes() {
		return quantidadeDeParticipantes;
	}

	public void setQuantidadeDeParticipantes(boolean a) {
		if(a) {
			quantidadeDeParticipantes ++;
		} else {
			quantidadeDeParticipantes --;
		}
	}

	public String[] getPublicacoes() {
		return publicacoes;
	}

	public void setPublicacoes(String titulo) {
		int i = 1;
		while(publicacoes[i] != null) {
				i++;
		}
		publicacoes[i] = titulo;
		
	}

	public String[] getOrientacoes() {
		return orientacoes;
	}

	public void setOrientacoes(String titulo) {
		int i = 1;
		while(orientacoes[i] != null) {
				i++;
		}
		orientacoes[i] = titulo;
	}
		
}
