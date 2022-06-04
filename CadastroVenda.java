package provajava;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Mateus Brusco de Freitas
 * @author Luana do Amaral Lucera
 * @author Matheus Adão Franciosi
 * @version 1.0
 * @since 2022-05-29
 */

public class CadastroVenda {

	void cadastraVenda() {
		Scanner teclado = new Scanner(System.in);
		
		// Inicializa variáveis que serão utilizadas
		String nomeCons, placaCons, nome = null, cpf = null, endereco = null, numero = null, modeloMoto = null, marcaMoto = null, placaMoto = null;
		int anoMoto = 0, opcao;
		double valorMoto = 0, valorNegociado;
		
		// Solicita informações do usuário para buscar cliente e moto no banco de dados
		System.out.println("----------------------------------------------------------");
		System.out.print("Digite o nome do cliente para busca: ");
		nomeCons = teclado.nextLine();
		System.out.print("Digite a placa da moto para busca: ");
		placaCons = teclado.nextLine();
		
		ConectaBD busca = new ConectaBD();
		try {
			// Busca cliente pelo nome e retorna demais informações do banco de dados
			busca.buscaCliente(nomeCons);
			while (busca.rs.next()) {
				nome = busca.rs.getString("nome");
				cpf = busca.rs.getString("cpf");
				endereco = busca.rs.getString("endereco");
				numero = busca.rs.getString("numero");
			}
			// Busca moto pela placa e retorna demais informações do banco de dados
			busca.buscaMoto(placaCons);
			while (busca.rsMoto.next()) {
				modeloMoto = busca.rsMoto.getString("modelo");
				marcaMoto = busca.rsMoto.getString("marca");
				placaMoto = busca.rsMoto.getString("placa");
				anoMoto = busca.rsMoto.getInt("anoModelo");
				valorMoto = busca.rsMoto.getDouble("valor");
			}
			// Gera tela de venda com informações do banco de dados
			System.out.println();
			System.out.println("----------------------------------------------------------");
			System.out.println("                  Cadastro de nova venda                  ");
			System.out.println("----------------------------------------------------------");
			System.out.println("Cliente: " + nome);
			System.out.println("CPF: " + cpf);
			System.out.println("Endereço: " + endereco);
			System.out.println("Número: " + numero);
			System.out.println("----------------------------------------------------------");
			System.out.println("Moto: " + marcaMoto + " " + modeloMoto);
			System.out.println("Placa: " + placaMoto);
			System.out.println("Ano modelo: " + anoMoto);
			System.out.printf("Valor da moto: R$%.2f", valorMoto);
			System.out.println();
			System.out.print("Valor negociado: R$");
			valorNegociado = teclado.nextDouble();
			System.out.println("----------------------------------------------------------");
			// Solicita confirmação de venda
			System.out.print("Pressione 1 para confirmar venda ou 2 para cancelar: ");
			opcao = teclado.nextInt();
			
			switch (opcao) {
			case 1: 
				// Caso a venda foi confirmada, chama o método cadastraVenda da classe ConectaBD e passa informações da venda
				busca.cadastraVenda(nome, cpf, endereco, numero, modeloMoto, marcaMoto, placaMoto, anoMoto, valorNegociado);
				System.out.println("Venda registrada com sucesso");
			break;
			// Se a venda não foi confirmada, retorna para o menu principal
			case 2: Principal.main(null);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

	}
}
