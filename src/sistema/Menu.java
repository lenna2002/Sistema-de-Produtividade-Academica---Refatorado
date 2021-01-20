package sistema;

import java.util.Scanner;

public class Menu {
	
	private static Scanner input = new Scanner(System.in); 
	
	static Sistema sistema = new Sistema();
	
	
	public static void menu() {
		
		int opcao = 1;
		while(opcao != 0) {
			System.out.println("O que deseja fazer?\n"
					+ "0 - Encerrar.\n"
					+ "1 - Adicionar colaborador.\n" 
					+ "2 - Adicionar projeto.\n" 
					+ "3 - Adicionar produção acadêmica.\n"
					+ "4 - Imprimir ficha de um aluno.\n" 
					+ "5 - Adicionar colaborar em um projeto.\n"
					+ "6 - Alterar status do projeto.\n"
					+ "7 - Imprimir ficha do projeto.\n"
					+ "8 - Relatório de produções acadêmicas.");
			
			opcao = input.nextInt();
		
			switch(opcao) {
			case 0: 											return;
			case 1: sistema.addColaboradores();					break;
			case 2: sistema.addProjetos();						break;
			case 3: sistema.addProducoes();						break;
			case 4: sistema.imprimirFichaAluno();				break;
			case 5: sistema.addColaboradorEmProjeto();			break;
			case 6: sistema.alterarStatusDoProjeto(); 			break;
			case 7: sistema.imprimirFichaProjeto(); 			break;
			case 8: sistema.relatorioDeProducaoAcademica(); 	break;
			default:
				System.out.println("Entrada Inválida!");
			}
		}
		
		
	}
}
