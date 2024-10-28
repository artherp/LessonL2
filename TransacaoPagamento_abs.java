
/**
 A classe TransacaoPagamento_abs define um modelo abstrato para transações de pagamento.
 As subclasses devem implementar a lógica específica de pagamento.

 UFSC/CTC/INE/INE5404

 @author Professor Cancian
 @version 1.0
 @since 2024
 */
public abstract class TransacaoPagamento_abs implements TransacaoPagamento_if {

	/**
	 Realiza o pagamento utilizando um instrumento de pagamento autenticado.

	 @param instrumentoPagamento O instrumento de pagamento a ser utilizado.
	 @param autenticacao         O código de autenticação da conta de pagamento.

	 @throws Exception Se a conta não estiver autenticada ou se ocorrer um erro
	 durante o pagamento específico.
	 */
	@Override
	public void realizarPagamento(InstrumentoPagamento_if instrumentoPagamento, int autenticacao) throws Exception {
		// Verifica se a conta devedora está autenticada
		if (!instrumentoPagamento.getContaDevedor().autenticado(autenticacao)) {
			throw new Exception("A conta de pagamento não foi autenticada");
		}
		// Chama o método específico de pagamento
		realizarPagamentoEspecifico(instrumentoPagamento, autenticacao);
	}

	/**
	 Método abstrato que deve ser implementado pelas subclasses para realizar
	 o pagamento específico, dependendo do tipo de transação.

	 @param instrumentoPagamento O instrumento de pagamento a ser processado.
	 @param autenticacao         O código de autenticação retornado pela conta.

	 @throws Exception Se ocorrer um erro durante o processamento do pagamento.
	 */
	abstract protected void realizarPagamentoEspecifico(InstrumentoPagamento_if instrumentoPagamento, int autenticacao) throws Exception;
}
