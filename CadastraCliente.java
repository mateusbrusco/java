package provajava;

import java.util.Scanner;

/**
 * @author Mateus Brusco de Freitas
 * @author Luana do Amaral Lucera
 * @author Matheus Adão Franciosi
 * @version 1.0
 * @since 2022-05-29
 */

public class CadastraCliente {
	// Inicializa variáveis utilizadas para cadastrar novo cliente.
	String nome, cpf, dataNasc, telefone, email, endereco, numero, complemento, cidade, estado;
	
	// Função para cadastrar novo cliente.
	void cadastraCliente() {

		Scanner teclado = new Scanner(System.in);
		
		String x = "1";
		
		// Solicita informações do usuário para cadastrar novo cliente.
		do {
			
		ConectaBD cadastro = new ConectaBD();
		System.out.println("----------------------------------------------------------");
		System.out.println("                 Cadastro de novo cliente                 ");
		System.out.println("----------------------------------------------------------");
		System.out.println();
		System.out.print("Nome: ");
		nome = teclado.nextLine();
		System.out.print("CPF: ");
		cpf = teclado.nextLine();
		System.out.print("Data de nascimento (dd/mm/aaaa): ");
		dataNasc = teclado.nextLine();
		System.out.print("Telefone: ");
		telefone = teclado.nextLine();
		System.out.print("E-mail: ");
		email = teclado.nextLine();
		System.out.print("Endereço: ");
		endereco = teclado.nextLine();
		System.out.print("Número: ");
		numero = teclado.nextLine();
		System.out.print("Complemento: ");
		complemento = teclado.nextLine();
		System.out.print("Cidade: ");
		cidade = teclado.nextLine();
		System.out.print("Estado: ");
		estado = teclado.nextLine(); 
		System.out.println("----------------------------------------------------------");
		
		// Chama o método cadastraCliente da classe ConectaBD e passa informações inseridas para envio para o banco de dados
	    try {
			cadastro.cadastraCliente(nome, cpf, dataNasc, telefone, email, endereco, numero, complemento, cidade, estado);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	    // Solicita ao usuário que escolha entre cadastrar novo cliente ou retornar à tela principal
		System.out.println();
		System.out.println("Pressione: \n 1 para cadastrar novo cliente \n qualquer outra tecla para retornar ao menu principal");
		x = teclado.next();
		
		}
		while (x == "1");
		
		Principal.main(null);
	    
		
	}
	


}
