
/**
 A classe Produto representa um produto vendido por um vendedor.
 Ela contém informações sobre o nome do produto, seu preço e o vendedor
 associado.

 UFSC/CTC/INE/INE5404

 @author Professor Cancian
 @version 1.0
 @since 2024
 */
public class Produto {

	private String nome;      // Nome do produto
	private double preco;     // Preço do produto
	private Vendedor vendedor; // Vendedor que está vendendo o produto

	/**
	 Construtor que inicializa o produto com nome, preço e o vendedor que o vende.

	 @param nome     O nome do produto.
	 @param preco    O preço do produto.
	 @param vendedor O vendedor que está vendendo o produto.
	 */
	public Produto(String nome, double preco, Vendedor vendedor) {
		this.nome = nome;
		this.preco = preco;
		this.vendedor = vendedor;
	}

	/**
	 Retorna o nome do produto.

	 @return O nome do produto.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 Retorna o preço do produto.

	 @return O preço do produto.
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 Retorna o vendedor que vende o produto.

	 @return O vendedor do produto.
	 */
	public Vendedor getVendedor() {
		return vendedor;
	}

	/**
	 Retorna uma representação textual do produto.

	 @return Uma string contendo informações sobre o produto.
	 */
	@Override
	public String toString() {
		return "Produto{"
				+ "nome='" + nome + '\''
				+ ", preco=" + preco
				+ ", vendedor=" + vendedor.getNome()
				+ // Supondo que Vendedor tenha um método getNome()
				'}';
	}
}
