
/**
 A interface TransacaoPagamento_if define o comportamento necessário para qualquer
 método de pagamento no sistema de pagamentos.

 UFSC/CTC/INE/INE5404

 @author Professor Cancian
 @version 1.0
 @since 2024
 */
public interface TransacaoPagamento_if {

	/**
	 Realiza o pagamento utilizando um instrumento de pagamento autenticado.

	 @param instrumentoPagamento O instrumento de pagamento a ser utilizado.
	 @param autenticacao         O código de autenticação da conta de pagamento.

	 @throws Exception Se ocorrer um erro durante o processamento do pagamento.
	 */
	void realizarPagamento(InstrumentoPagamento_if instrumentoPagamento, int autenticacao) throws Exception;

	/**
	 Autentica um instrumento de pagamento em relação à conta do comprador.

	 @param contaComprador       A conta bancária do comprador.
	 @param instrumentoPagamento O instrumento de pagamento a ser autenticado.

	 @return Um código de autenticação que indica o resultado da autenticação.
	 */
	int autenticaInstrumento(ContaBancaria contaComprador, InstrumentoPagamento_if instrumentoPagamento);

	/**
	 Cria um novo instrumento de pagamento para a transação.

	 @param idPedido       O identificador do pedido associado ao pagamento.
	 @param valor          O valor a ser pago.
	 @param contaComprador A conta bancária do comprador.
	 @param contaMercado   A conta bancária do mercado que receberá o pagamento.

	 @return Um objeto que implementa a interface InstrumentoPagamento_if,
	 representando o instrumento de pagamento criado.
	 */
	InstrumentoPagamento_if criaInstrumentoPagamento(int idPedido, double valor, ContaBancaria contaComprador, ContaBancaria contaMercado);
}
