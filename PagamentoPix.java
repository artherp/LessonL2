
/**
 * A classe PagamentoPix implementa o pagamento via Pix.
 * Esta classe estende a classe abstrata TransacaoPagamento_abs e
 * fornece a implementação específica para autenticação e criação
 * de instrumentos de pagamento do tipo Pix.
 *
 * UFSC/CTC/INE/INE5404
 *
 * @author Professor Cancian
 * @version 1.0
 * @since 2024
 */
public class PagamentoPix extends TransacaoPagamento_abs {

    /**
     * Autentica o instrumento de pagamento, verificando se a conta do comprador
     * está habilitada para realizar pagamentos via Pix.
     *
     * @param contaComprador A conta bancária do comprador.
     * @param instrumentoPagamento O instrumento de pagamento a ser autenticado.
     *
     * @return Um código de autenticação que pode ser utilizado para confirmar a
     * transação. Neste caso, retorna 0, indicando que a autenticação é
     * bem-sucedida (pode ser uma lógica mais complexa em uma implementação
     * real).
     */
    @Override
    public int autenticaInstrumento(ContaBancaria contaComprador, InstrumentoPagamento_if instrumentoPagamento) {
        return 0; // Lógica de autenticação pode ser implementada aqui.
    }

    /**
     * Cria um instrumento de pagamento do tipo Pix.
     *
     * @param idPedido O identificador do pedido associado ao pagamento.
     * @param valor O valor a ser pago via Pix.
     * @param contaComprador A conta bancária do comprador.
     * @param contaMercado A conta bancária do mercado que receberá o pagamento.
     *
     * @return Um objeto que implementa a interface InstrumentoPagamento_if,
     * representando o Pix criado para a transação.
     */
    @Override
    public InstrumentoPagamento_if criaInstrumentoPagamento(int idPedido, double valor, ContaBancaria contaComprador, ContaBancaria contaMercado) {
        return new Pix(idPedido, valor, contaComprador, contaMercado, this);
    }

    /**
     * Realiza o pagamento específico para um instrumento de pagamento. Este
     * método processa o pagamento via Pix, realizando um saque na conta do
     * comprador e um depósito na conta do mercado.
     *
     * @param instrumentoPagamento O instrumento de pagamento a ser processado.
     * @param autenticacao O código de autenticação retornado pelo método
     * autenticaInstrumento.
     *
     * @throws Exception Se ocorrer um erro durante o processamento do
     * pagamento.
     */
    @Override
    protected void realizarPagamentoEspecifico(InstrumentoPagamento_if instrumentoPagamento, int autenticacao) throws Exception {
        if (instrumentoPagamento.getContaDevedor().autenticado(autenticacao) && instrumentoPagamento instanceof Pix) {
            instrumentoPagamento.getContaDevedor().transferirPara(instrumentoPagamento.getContaCredor(), instrumentoPagamento.getTotal(), autenticacao, instrumentoPagamento.getId());
        } else {
            throw new IllegalArgumentException();
        }
    }

}

