import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Administradora adm = new Administradora();
	static Scanner in = new Scanner(System.in);
	static int op;

	public static void menuCliente(){
		Menu menuCliente = new Menu("Menu Cliente", Arrays.asList("Adicionar cliente", "Remover cliente", "Sair"));

		Cliente c = null;
		String cpf, nome;

		do{
			op = menuCliente.getSelection();
			switch(op){
				case 0:	// Adicionar clientes
					System.out.println("Informe o CPF do cliente: ");
					cpf = in.nextLine();
					
					if (adm.verificarCPF(cpf) == null){
						System.out.println("Informe o nome do Cliente: ");
						nome = in.nextLine();
						c = new Cliente(nome, cpf, new ArrayList<Conta>());

						adm.cadastrarCliente(c);
					}
					else{
						System.out.println("CPF já existente!");
					}
					break;

				case 1:	// Remover clientes
					System.out.println("Informe o CPF do Cliente: ");
					cpf = in.nextLine();
					c = adm.verificarCPF(cpf);

					if(c != null){
						adm.removerCliente(c);
					}
					else{
						System.out.println("Cliente inexistente");
					}
					break;
			}
		} while (op != 2);

		System.out.println("\nFim do menu Cliente");
	}

	public static void menuConta(){
		Menu menuCliente = new Menu("Menu Contas", Arrays.asList("Adicionar conta", "Remover conta", "Operações", "Sair"));

		System.out.println("Digite o cpf do cliente: ");
		String cpf = in.nextLine();

		Cliente cliente = adm.verificarCPF(cpf);

		if(cliente == null){ System.out.println("Cliente inexistente!"); return; }

		Conta c = null;
		int nro;

		do{
			op = menuCliente.getSelection();
			switch(op){
				case 0:	// Adicionar contas
					System.out.println("Digite o numero da conta: ");
					nro = in.nextInt();

					if(adm.verificarConta(nro) == null){
						int resp;
						do{
							System.out.println("Deseja já depositar algum valor na conta? < 1 ! 2 >");
							resp = in.nextInt();

						}while(resp != 1 && resp != 2);

						if(resp == 1){
							System.out.println("Valor para deposito: ");
							double valor = in.nextDouble();
							c = new Conta(nro, valor);
						}
						else{
							c = new Conta(nro, 0.0);
						}
 
						cliente.addConta(c);
					}
					else{
						System.out.println("Conta já existente!");
					}

					break;

				case 1:	// Remover contas
					System.out.println("Digite o numero da conta a ser removida: ");	
					nro = in.nextInt();

					if(adm.verificarConta(nro) != null){
						cliente.excluirConta(nro);
					}
					else{
						System.out.println("Conta inexistente!");
					}
					break;

				case 2:	// Operacoes
					menuOperacoes();
					break;
			}
		} while (op != 3);

		System.out.println("\nFim do menu Conta");
	}

	public static void menuOperacoes(){
		Menu menuOperacoes = new Menu("Menu Operacoes", Arrays.asList("Realizar saque", "Realizar deposito", "Realizar transferencia", "Ver saldo", "Sair"));

		System.out.println("Digite o cpf do cliente: ");
		String cpf = in.nextLine();

		Cliente cliente = adm.verificarCPF(cpf);

		if(cliente == null){ System.out.println("Cliente inexistente!"); return; }

		System.out.println("Digite o nro da conta: ");
		int nro = in.nextInt();
		int nro2;
		Conta c1 = adm.verificarConta(nro);

		if(c1 == null){ System.out.println("Conta inexistente!"); return; }

		do{
			op = menuOperacoes.getSelection();
			switch(op){
				case 0:	// Realizar saque
					if(c1 != null){
						System.out.println("Digite o valor para o saque: ");
						double valor = in.nextDouble();
						cliente.sacar(valor, c1);
					}
					else{
						System.out.println("Conta inexistente!");
					}

					break;

				case 1:	// Realizar deposito
					if(c1 != null){
						System.out.println("Digite o valor para o deposito: ");
						double valor = in.nextDouble();
						cliente.depositar(valor, c1);
					}
					else{
						System.out.println("Conta inexistente!");
					}

					break;
				
				case 2:	// Realizar transferencia
					System.out.println("Digite a conta destinataria: ");
					nro2 = in.nextInt();
					Conta c2 = adm.verificarConta(nro2);

					if(c2 != null){
						System.err.println("Digite o valor para a transferencia: ");
						double valor = in.nextDouble();
						cliente.transferir(valor, c1, c2);
					}
					else{
						System.out.println("Conta destino inexistente");
					}
					break;

				case 3:	// Ver saldo
					if(c1 != null){
						System.out.println("Saldo: " + c1.getSaldo());
					}
					else{
						System.out.println("Conta inexistente");
					}
					break;
			}
		} while (op != 4);

		System.out.println("\nFim do menu Operacoes");
	}

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Cliente", "Conta", "Operacoes", "Sair"));

		do {
			op = mainMenu.getSelection();
			switch(op){
				case 0:	// Cliente
					menuCliente();
					break;

				case 1:	// Conta
					menuConta();
					break;

				case 2:	// Operacoes
					menuOperacoes();
					break;
			}

		} while(op!=4);	// Sair
		System.out.println("\n\nTerminou!");
	}
}
