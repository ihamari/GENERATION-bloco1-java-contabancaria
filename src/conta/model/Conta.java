package conta.model;

public class Conta {
	
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	//Construtor
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	// Getters and Setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	// método que verifica se o usuário pode sacar (booleano)
	public boolean sacar (float valor) {
		if(this.getSaldo() < valor){
			System.out.print("\nSaldo Insuficiente!\n");
			return false;			
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	
	//método para depositar, retorna nada
	public void depositar (float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	
	//método visualizar os dados da conta
	public void visualizar() { 

		String tipo = "";
		
		switch(this.tipo) {
			case 1:
				tipo = "Conta Corrente";
				break;
			case 2:
				tipo = "Conta Poupança";
				break;
		}
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados da Conta:");
		System.out.println("***********************************************************");
		System.out.println("Numero da Conta: " + this.numero);
		System.out.println("Agência: " + this.agencia);
		System.out.println("Tipo da Conta: " + tipo);
		System.out.println("Titular: " + this.titular);
		System.out.println("Saldo: " + this.saldo);

	}
	
	
	

}
