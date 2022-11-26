package HistoricoFatura;

import HistoricoFatura.Conta;
import Utils.Utils;

public class Conta {
	
	//private static int contadorDeContas = 1;
	
	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	
		
	public Conta(int numeroConta, Pessoa pessoa) {
		this.numeroConta = numeroConta;
		this.pessoa = pessoa;
	}


	public int getNumeroConta() {
		return numeroConta;
	}


	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public Double getSaldo() {
		return saldo;
	}

	
	public String toString() {
		
		return "\nNúmero da conta: " + this.getNumeroConta() +
			   "\nNome: " + this.pessoa.getNome() +
			   "\nCPF: " + this.pessoa.getcpf() +
			   "\nEmail: " + this.pessoa.getEmail() +
			   "\nNome: " + Utils.doubleToString(this.getSaldo()) +
			   "\n";
	}
	
	/**public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu depósito foi realizado com sucesso.");
		}else {
			System.out.println("Não foi possível realizar o depósito.");
		}
	}
	
	public void debito(Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Débito realizado com sucesso.");
		}else {
			System.out.println("Não foi possível realizar o débito.");
		}
	}
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transferência realizada com sucesso.");
		}else {
			System.out.println("Não foi possível realizar a transferência.");
		}
	} **/
}
