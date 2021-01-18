package sistema;

import java.util.Scanner;

public class TratamentoDeErros {
	
	private static Scanner input = new Scanner(System.in);
	
	public long cpf() {
		String id;
		boolean test = false;
		
		do {
			id = input.nextLine();
			try {
				long cpf = Long.parseLong(id);
				return cpf;
			} catch (Exception erro) {
				System.err.println("Erro: " + erro.getMessage());
				System.out.println("Digite novamente!");
			}
		}while(!test);
		

		return 0;
	}

	public int inteiro() {
		String id;
		boolean test = false;
		
		do {
			id = input.nextLine();
			try {
				int mes = Integer.parseInt(id);
				return mes;
			} catch (Exception erro) {
				System.err.println("Erro: " + erro.getMessage());
				System.out.println("Digite novamente!");
			}
		}while(!test);
		

		return 0;
	}
	
	public double doubl() {
		String id;
		boolean test = false;
		
		do {
			id = input.nextLine();
			try {
				double mes = Double.parseDouble(id);
				return mes;
			} catch (Exception erro) {
				System.err.println("Erro: " + erro.getMessage());
				System.out.println("Digite novamente!");
			}
		}while(!test);
		

		return 0;
	}
}
