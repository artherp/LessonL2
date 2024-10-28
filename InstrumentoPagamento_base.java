
/**
 * A classe InstrumentoPagamento_base implementa a interface InstrumentoPagamento_if
 * e representa um instrumento de pagamento que pode ser utilizado em transações financeiras.
 *
 * Esta classe contém informações sobre o pedido, o valor total, as contas devedor e credor,
 * além do método de transação associado ao pagamento.
 *
 * @author Professor Cancian
 * @version 1.0
 * @since 2024
 */
public class InstrumentoPagamento_base implements InstrumentoPagamento_if {

    /**
     * Construtor para inicializar um instrumento de pagamento com os detalhes
     * da transação.
     *
     * @param idPedido O identificador do pedido associado ao pagamento.
     * @param total O valor total da transação.
     * @param contaDevedor A conta bancária do devedor que irá realizar o
     * pagamento.
     * @param contaCredor A conta bancária do credor que receberá o pagamento.
     * @param transacaoPagamento O método de transação utilizado para processar
     * o pagamento.
     */
    public InstrumentoPagamento_base(int idPedido, double total, ContaBancaria contaDevedor, ContaBancaria contaCredor, TransacaoPagamento_if transacaoPagamento) {
        this.idPedido = idPedido;
        this.total = total;
        this.contaCredor = contaCredor;
        this.contaDevedor = contaDevedor;
        this.transacaoPagamento = transacaoPagamento;
    }

    /**
     * Retorna a conta bancária do credor.
     *
     * @return A conta bancária do credor.
     */
    @Override
    public ContaBancaria getContaCredor() {
        return contaCredor;
    }

    /**
     * Retorna a conta bancária do devedor.
     *
     * @return A conta bancária do devedor.
     */
    @Override
    public ContaBancaria getContaDevedor() {
        return contaDevedor;
    }

    /**
     * Retorna o identificador do pedido associado ao pagamento.
     *
     * @return O identificador do pedido.
     */
    @Override
    public int getId() {
        return idPedido;
    }

    /**
     * Retorna o valor total da transação.
     *
     * @return O valor total do pagamento.
     */
    @Override
    public double getTotal() {
        return total;
    }

    /**
     * Retorna o método de transação utilizado para processar o pagamento.
     *
     * @return O método de transação associado ao pagamento.
     */
    @Override
    public TransacaoPagamento_if getTransacaoPagamento() {
        return transacaoPagamento;
    }
    private final ContaBancaria contaCredor;
    private final ContaBancaria contaDevedor;
    private final int idPedido;
    private final double total;
    private final TransacaoPagamento_if transacaoPagamento;
}
