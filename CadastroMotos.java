package provajava;

import java.util.Scanner;

/**
 * @author Mateus Brusco de Freitas
 * @author Luana do Amaral Lucera
 * @author Matheus Adão Franciosi
 * @version 1.0
 * @since 2022-05-29
 */

public class CadastroMotos {
	// Inicializa variáveis que serão utilizadas 
	String marcaMoto, modeloMoto, corMoto, placaMoto;
	int anoFabrica, anoModelo;
	double quilometragem, valor;
	
		// Método para cadastrar nova moto
		void cadastraMoto() {
			Scanner texto = new Scanner(System.in);
		
			String x = "1";
		
			do {
				ConectaBD cadastromoto = new ConectaBD();
				
				System.out.println("----------------------------------------------------------");
				System.out.println("                  Cadastro de nova Moto                   ");
				System.out.println("----------------------------------------------------------");
				System.out.print("Escreva o modelo da moto: ");
				modeloMoto = texto.nextLine();
			
				System.out.print("Escreva a marca da moto: ");
				marcaMoto = texto.nextLine();
				
				System.out.print("Escreva a placa da moto: ");
				placaMoto = texto.nextLine();
			
				System.out.print("Escreva a cor da moto: ");
				corMoto = texto.nextLine();
			
				System.out.print("Escreva o ano de fabricação da moto: ");
				anoFabrica = texto.nextInt();
			
				System.out.print("Escreva ano do modelo da moto: ");
				anoModelo = texto.nextInt();
			
				System.out.print("Escreva a quilometragem da moto: ");
				quilometragem = texto.nextDouble();
				
				System.out.print("Escreva o valor da moto: ");
				valor = texto.nextDouble();
				System.out.println("----------------------------------------------------------");
				
				// Solicita ao usuário que escolha entre cadastrar nova moto ou retornar à tela principal
				System.out.println();
				System.out.println("Pressione: \n 1 para cadastrar nova moto ou \n qualquer outra tecla para retornar ao menu principal");
				x = texto.next();
				
				// Chama o método cadastraMoto da classe ConectaBD e passa informações inseridas para envio para o banco de dados
			    try {
					cadastromoto.cadastraMoto(modeloMoto, marcaMoto, placaMoto, corMoto, anoFabrica, anoModelo, quilometragem, valor);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
			} while (x == "1");
		
			Principal.main(null);
		
		

	}

}
