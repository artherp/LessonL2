
/**
 * A classe ItemPedido representa um item em um pedido de compra,
 * incluindo o produto solicitado e a quantidade desse produto.
 *
 * @author Professor Cancian
 * @version 1.0
 * @since 2024
 */
public class ItemPedido {

    /**
     * Construtor que inicializa um item de pedido com um produto e a quantidade
     * desejada.
     *
     * @param produto O produto associado a este item de pedido.
     * @param quantidade A quantidade do produto a ser adquirida.
     */
    ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    /**
     * O produto associado a este item de pedido.
     */
    final Produto produto;

    /**
     * A quantidade do produto neste item de pedido.
     */
    final int quantidade;
}
