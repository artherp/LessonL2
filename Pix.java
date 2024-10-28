
/**
 A classe Pix representa um instrumento de pagamento via Pix.
 Esta classe estende InstrumentoPagamento_base e fornece os
 parâmetros necessários para processar um pagamento via Pix.

 UFSC/CTC/INE/INE5404

 @author Professor Cancian
 @version 1.0
 @since 2024
 */
public class Pix extends InstrumentoPagamento_base {

	private String descricao; // Descrição do pagamento, pode ser útil para identificação ou histórico

	/**
	 Construtor que inicializa o pagamento via Pix.

	 @param idPedido           O ID do pedido associado a este pagamento.
	 @param total              O valor total do pagamento.
	 @param contaDevedor       A conta bancária do devedor que está fazendo o pagamento.
	 @param contaCredor        A conta bancária do credor que receberá o pagamento.
	 @param transacaoPagamento A transação de pagamento associada.
	 */
	public Pix(int idPedido, double total, ContaBancaria contaDevedor, ContaBancaria contaCredor,
			TransacaoPagamento_if transacaoPagamento) {
		super(idPedido, total, contaDevedor, contaCredor, transacaoPagamento);
		this.descricao = "Pagamento via Pix para o pedido " + idPedido; // Descrição inicial
	}

	/**
	 Retorna a descrição do pagamento.

	 @return A descrição do pagamento via Pix.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 Define uma nova descrição para o pagamento.

	 @param descricao A nova descrição a ser definida.
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
