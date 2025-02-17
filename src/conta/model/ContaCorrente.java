package conta.model;

import java.util.Scanner;

public class ContaCorrente extends Conta{
	
	private float limite;
	private Scanner leia = new Scanner(System.in);
	private int autorizacaoLimiteConta;
	
	//Construtor
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}
	
	
	// Getter and Setter
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	


	//Métodos da classe
	@Override
	public boolean sacar(float valor) {
		if (valor<0) {  // Verifica valor negativo
			System.out.print("\nValor inválido\n");
	        return false; 
	    }
		if (super.sacar(valor)) { // Tenta realizar o saque sem limite e retorna true caso consiga
	        return true; 
	    }
		if((this.getSaldo() + this.getLimite()) < valor) { // vê se o valor é mais alto que o limite de conta + saldo
			System.out.println("Limite insuficiente para o saque!");
			return false;
		}
		else { // pergunta pro usuário autoriza limite de conta ou não
			System.out.println("\nDeseja usar limite da conta? (1-Sim   2-Não)");
			autorizacaoLimiteConta = leia.nextInt();
			
			switch (autorizacaoLimiteConta) {
				case 1:
					this.setLimite((this.getSaldo() - valor) + this.getLimite());
					this.setSaldo(0.0f);
					System.out.println("\nSaque realizado com sucesso!");
					return true;
				case 2:
					System.out.println("\nSaque do limite conta não autorizado!");
					return false;
				default:
					System.out.println("\nOpção Inválida");
					return false;
			}
		}
			
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite de Crédito: " + this.limite);
	}
	
	
	
	
	
	
}
