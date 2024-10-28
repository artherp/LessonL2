import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 A classe Pedido representa um pedido feito por um cliente,
 que contém uma lista de produtos comprados de vários vendedores.
 <p>
 UFSC/CTC/INE/INE5404

 @author Professor Cancian
 @version 1.0
 @since 2024
 */
public class Pedido {

	/**
	 Construtor que inicializa o pedido com uma lista vazia de itens de pedido
	 e gera um ID único para o pedido baseado no hashCode.
	 */
	public Pedido() {
		this.itens = new ArrayList<>();
		this.id = this.hashCode(); // Gera um ID único
	}

	/**
	 Adiciona um produto e uma quantidade ao pedido.

	 @param produto    O produto a ser adicionado.
	 @param quantidade A quantidade a ser adicionada.
	 */
	public void adicionarProduto(Produto produto, int quantidade) {
		if (quantidade <= 0) {
			throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
		}
		itens.add(new ItemPedido(produto, quantidade));
	}

	/**
	 Calcula o valor total do pedido, somando os preços de todos os produtos,
	 considerando a quantidade comprada.

	 @return O valor total do pedido.
	 */
	public double calcularTotal() {
		double total = 0;
		for (ItemPedido item : getItens()) {
			total += item.produto.getPreco() * item.quantidade;
		}
		return total;
	}

	/**
	 @return O ID do pedido.
	 */
	public int getId() {
		return id;
	}

	/**
	 @return Uma lista não modificável de itens no pedido.
	 */
	public List<ItemPedido> getItens() {
		return Collections.unmodifiableList(itens);
	}

	private final int id; // ID único do pedido
	private final List<ItemPedido> itens; // Lista de itens do pedido
}
