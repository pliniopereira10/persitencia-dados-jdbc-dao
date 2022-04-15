package aplicacao;

import java.util.List;
import java.util.Scanner;

import dao.ClienteDao;
import modelo.Cliente;

public class Programa {

	public static void main(String[] args) {
		
		int indice;
		char resposta;
		Integer codCliente;
		String nome;
		String cpf;
		String telefone;
		Cliente novoCliente;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Tabela Cliente");
		
		do {
			System.out.println("Escolha uma das opções:");
			System.out.println("Digite 1 - Para verificar conteúdo da tabela.");
			System.out.println("Digite 2 - Para inserir novo cliente.");
			System.out.println("Digite 3 - Para alterar dado(s) do cliente.");
			System.out.println("Digite 4 - Para remover um cliente.");
			indice = input.nextInt();
			ClienteDao conexaoTabela = new ClienteDao();
			
			switch (indice) {
			case 1:
				System.out.println("Vamos listar o conteúdo da tabela Cliente.");
				
				List<Cliente> lista = conexaoTabela.listar();
				
				for (Cliente cliente : lista) {
					System.out.println(cliente);
				}
				
				break;
			
			case 2:
				System.out.println("Digite os dados do cliente.");
				System.out.print("Nome do cliente: ");
				input.nextLine();
				nome = input.nextLine();
				System.out.print("CPF do cliente: ");
				cpf = input.nextLine();
				System.out.print("Telefone do cliente: ");
				telefone = input.nextLine();
				
				novoCliente = new Cliente(nome, cpf, telefone);
				conexaoTabela.inserir(novoCliente);			
				
				break;
				
			case 3:
				System.out.println("Código do cliente que deseja alterar os dados: ");
				input.nextLine();
				codCliente = input.nextInt();
				System.out.println("Digite o(s) novoc(s) dado(s).");
				System.out.print("Nome do cliente: ");
				input.nextLine();
				nome = input.nextLine();
				System.out.print("CPF do cliente: ");
				cpf = input.nextLine();
				System.out.print("Telefone do cliente: ");
				telefone = input.nextLine();
				
				novoCliente = new Cliente(codCliente, nome, cpf, telefone);
				conexaoTabela.alterar(novoCliente);		
				
				break;
			
			case 4:
				System.out.println("Digite o código do cliente para remoção.");
				input.nextLine();
				codCliente = input.nextInt();
				
				conexaoTabela.remover(codCliente);
				System.out.println("Cliente removido");
				
				break;
	
			default:
				System.out.println("Opção Inválida");
				System.out.println("Digite umas das opções do Menu.");
				break;
			}
			System.out.print("\nDeseja continuar? (sim/nao): ");
			resposta = input.next().charAt(0);
			System.out.println();
			
		} while (resposta != 'n');
		System.out.println("Acesso finalizado!!!");
		
		input.close();

	}

}
