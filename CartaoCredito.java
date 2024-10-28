
import java.util.Date;

/**
 * Classe CartaoCredito, que representa um instrumento de pagamento baseado em
 * cartão de crédito. Herda da classe {@link InstrumentoPagamento_base}, que
 * abstrai os meios de pagamento. O cartão de crédito contém informações
 * adicionais como número de segurança e data de validade, necessárias para a
 * autenticação do pagamento.
 *
 * @author Professor Cancian
 * @version 1.0
 * @since 2024
 */
public class CartaoCredito extends InstrumentoPagamento_base {

    /**
     * Construtor da classe CartaoCredito. Inicializa um novo objeto de
     * CartaoCredito com os dados fornecidos.
     * <p>
     * O método chama o construtor da classe base
     * {@link InstrumentoPagamento_base}, passando os parâmetros necessários
     * para vincular o cartão de crédito a um pedido específico, especificando
     * também o valor da transação, as contas bancárias envolvidas (devedor e
     * credor) e a transação de pagamento associada.
     *
     * @param idPedido o identificador do pedido associado a este pagamento por
     * cartão de crédito.
     * @param total o valor total da transação.
     * @param contaDevedor a conta bancária do titular do cartão de crédito
     * (quem pagará).
     * @param contaCredor a conta bancária do destinatário do pagamento (quem
     * receberá).
     * @param transacaoPagamento o objeto que gerencia a transação de pagamento,
     * garantindo que as regras de pagamento sejam seguidas.
     */
    public CartaoCredito(int idPedido, double total, ContaBancaria contaDevedor, ContaBancaria contaCredor, TransacaoPagamento_if transacaoPagamento) {
        super(idPedido, total, contaDevedor, contaCredor, transacaoPagamento);
    }

    private Date dataValidade;
    private int numeroSeguranca;
}
