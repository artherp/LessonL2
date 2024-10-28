
/**
 * Classe Boleto, que representa um instrumento de pagamento baseado em boleto bancário.
 * Herda da classe {@link InstrumentoPagamento_base}, que abstrai os meios de
 * pagamento. O boleto é vinculado a um pedido e contém as informações das
 * contas bancárias do devedor e credor.
 *
 * @author Professor Cancian
 * @version 1.0
 * @since 2024
 */
public class Boleto extends InstrumentoPagamento_base {

    /**
     * Construtor da classe Boleto. Inicializa um novo objeto de Boleto com os
     * dados fornecidos.
     * <p>
     * O método chama o construtor da classe base
     * {@link InstrumentoPagamento_base} e repassa os parâmetros necessários,
     * incluindo o ID do pedido, o valor total do boleto, as contas bancárias do
     * devedor e do credor, e a transação de pagamento associada.
     *
     * @param idPedido o identificador do pedido associado a esse boleto.
     * @param total o valor total do boleto.
     * @param contaDevedor a conta bancária do devedor (quem pagará o boleto).
     * @param contaCredor a conta bancária do credor (quem receberá o
     * pagamento).
     * @param transacaoPagamento o objeto responsável por gerenciar a transação
     * de pagamento.
     */
    public Boleto(int idPedido, double total, ContaBancaria contaDevedor, ContaBancaria contaCredor, TransacaoPagamento_if transacaoPagamento) {
        super(idPedido, total, contaDevedor, contaCredor, transacaoPagamento);
    }

    private long codigoDeBarras;
}
