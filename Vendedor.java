
/**
 UFSC/CTC/INE/INE5404

 A classe Vendedor representa um vendedor que possui uma conta bancária
 e pode receber pagamentos.

 @author Professor Cancian
 @version 1.0
 @since 2024
 */
public class Vendedor {

	private final String nome; // Nome do vendedor.
	private final ContaBancaria conta; // Conta bancária do vendedor.

	/**
	 Construtor que inicializa o vendedor com um nome e uma conta bancária.

	 @param nome  O nome do vendedor.
	 @param conta A conta bancária do vendedor.
	 */
	public Vendedor(String nome, ContaBancaria conta) {
		this.nome = nome;
		this.conta = conta;
	}

	/**
	 Retorna o nome do vendedor.

	 @return O nome do vendedor.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 Retorna a conta bancária do vendedor.

	 @return A conta bancária do vendedor.
	 */
	public ContaBancaria getConta() {
		return conta;
	}
}
