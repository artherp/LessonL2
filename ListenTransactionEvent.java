
/**
 * A classe ListenTransactionEvent representa um evento de transação
 * bancária, armazenando informações sobre a transferência de um valor
 * entre contas bancárias.
 *
 * Este evento pode ser utilizado por listeners para reagir a
 * transações específicas que ocorrem no sistema, permitindo
 * que outras partes do sistema saibam quando uma transação foi
 * realizada e quais contas estão envolvidas.
 *
 * @author Professor Cancian
 * @version 1.0
 * @since 2024
 */
public class ListenTransactionEvent implements ListenEvent {

    /**
     * Construtor que inicializa um evento de transação com as informações da
     * conta de origem, conta de destino, valor transferido e ID da transação.
     *
     * @param contaOrigem A conta bancária de onde o valor está sendo retirado.
     * @param contaDestino A conta bancária para onde o valor está sendo
     * transferido.
     * @param valor O valor que está sendo transferido na transação.
     * @param idTransacao O identificador único da transação realizada.
     */
    ListenTransactionEvent(ContaBancaria contaOrigem, ContaBancaria contaDestino, double valor, int idTransacao) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.idTransacao = idTransacao;
    }

    final ContaBancaria contaDestino;
    final ContaBancaria contaOrigem;
    final int idTransacao;
    final double valor;

}
