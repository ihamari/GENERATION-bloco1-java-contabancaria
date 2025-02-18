package conta;

import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContaController contas = new ContaController();
		
		Scanner leia = new Scanner(System.in);
		int opcao;
		
		int numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		
		
		
		while(true) {
			System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     "
					+ Cores.TEXT_RESET);
			
			try {
				opcao = leia.nextInt();
			}
			catch (InputMismatchException e){
				System.err.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			
			
			if(opcao == 9) {
				System.out.println(Cores.TEXT_YELLOW_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
				
			}
			
			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE_BRIGHT + "Criar Conta\n\n");
					
					System.out.println("Digite o Número da Agência: ");
					agencia = leia.nextInt();
					
					System.out.println("Digite o Nome do Titular");
					leia.skip("\\R");
					titular = leia.nextLine();
					
					do {
						System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP)");
						tipo = leia.nextInt();
					}while(tipo < 1 && tipo > 2);
					
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					
					switch(tipo) {
						case 1:
							System.out.println("Digite o Limite de Crédito (R$): ");
							limite = leia.nextFloat();
							contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
							
							break;
						case 2:
							System.out.println("Digite o dia do Aniversário da Conta:");
							aniversario = leia.nextInt();
							contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
						
					
					
					keyPress();
	
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE_BRIGHT + "Listar todas as Contas\n\n");
					contas.listarTodas();
					
					keyPress();
					
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE_BRIGHT + "Consultar dados da Conta - por número\n\n");
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					contas.procurarPorNumero(numero);
					
					keyPress();
	
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE_BRIGHT + "Atualizar dados da Conta\n\n");
					
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					var buscaConta = contas.buscarNaCollection(numero);
					
					if(buscaConta != null) {
						tipo = buscaConta.getTipo();
						
						System.out.println("Digite o Número da Agência: ");
						agencia = leia.nextInt();
						System.out.println("Digite o Número do Titular: ");
						leia.skip("\\R?");
						titular = leia.nextLine();
						
						System.out.println("Digite o Limite de Crédito (R$) :");
						saldo = leia.nextFloat();
						
						switch (tipo) {
						case 1:
							System.out.println("Digite o Limite de Crédito (R$): ");
							limite = leia.nextFloat();
							
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
							
							break;
						case 2:
							System.out.println("Digite o dia do Aniversario da Conta: ");
							aniversario = leia.nextInt();
							
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, aniversario));
							
						default:
							
							System.out.println("Tipo de conta inválida");
						}
						
					}else {
						System.out.println("A Conta não foi encontrada!");
					}
					
					
					
					keyPress();
	
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE_BRIGHT + "Apagar a Conta\n\n");
					
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					contas.deletar(numero);
					
					keyPress();
					break;
				case 6:
					System.out.println(Cores.TEXT_WHITE_BRIGHT + "Saque\n\n");
					keyPress();
	
					break;
				case 7:
					System.out.println(Cores.TEXT_WHITE_BRIGHT + "Depósito\n\n");
					keyPress();
	
					break;
				case 8:
					System.out.println(Cores.TEXT_WHITE_BRIGHT + "Transferência entre Contas\n\n");
					keyPress();
	
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					keyPress();
					
					break;
			}
			
		}
	}
	
	public static void sobre() {
		System.out.println("\n*****************************************************");
		System.out.println("Projeto Desenvolvido por: Mariana Marie Iha");
		System.out.println("Email - ihamariana@gmail.com");
		System.out.println("github.com/ihamari");
		System.out.println("*******************************************************");
	}
	
	

	public static void keyPress() { // 

		try {

			System.out.println(Cores.TEXT_RESET + "Pressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
	
	
	
	
}





