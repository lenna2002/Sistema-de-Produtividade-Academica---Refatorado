package sistema;

import objetos.ProducoesAcademicas;
import objetos.Publicacoes;
import objetos.Orientacoes;

public class ProducoesFactory {
	
	public static ProducoesAcademicas qualProducao(boolean i, int matricula) {
		ProducoesAcademicas novaProducao;
		
		if (i) {
			novaProducao = new Publicacoes();
			return ((Publicacoes)novaProducao).add(matricula);
		} else {
			novaProducao = new Orientacoes();
			return ((Orientacoes)novaProducao).add(matricula);
		}
	}

}
