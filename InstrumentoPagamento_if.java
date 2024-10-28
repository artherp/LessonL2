
/**
 A interface InstrumentoPagamento_if define os métodos que um instrumento de pagamento
 deve implementar. Os instrumentos de pagamento são utilizados para processar transações financeiras,
 permitindo a transferência de valores entre contas bancárias.

 @author Professor Cancian
 @version 1.0
 @since 2024
 */
public interface InstrumentoPagamento_if {

	/**
	 Retorna o valor total da transação associada ao instrumento de pagamento.

	 @return O valor total do pagamento.
	 */
	double getTotal();

	/**
	 Retorna o identificador do pedido associado ao pagamento.

	 @return O identificador do pedido.
	 */
	int getId();

	/**
	 Retorna o método de transação utilizado para processar o pagamento.

	 @return O método de transação associado ao pagamento.
	 */
	TransacaoPagamento_if getTransacaoPagamento();

	/**
	 Retorna a conta bancária do devedor que realiza o pagamento.

	 @return A conta bancária do devedor.
	 */
	ContaBancaria getContaDevedor();

	/**
	 Retorna a conta bancária do credor que receberá o pagamento.

	 @return A conta bancária do credor.
	 */
	ContaBancaria getContaCredor();
}
