
/**
 * A classe Comprador representa um cliente que possui uma conta bancária
 * e pode realizar pagamentos utilizando diferentes métodos de pagamento.
 * Cada comprador é identificado por um nome e vinculado a uma conta bancária.
 *
 * A classe fornece funcionalidades para realizar pagamentos a partir de sua conta bancária
 * utilizando um instrumento de pagamento, como boleto, cartão de crédito, etc.
 *
 * @author Professor Cancian
 * @version 1.0
 * @since 2024
 */
public class Comprador {

    /**
     * Construtor que inicializa o comprador com um nome e uma conta bancária.
     *
     * @param nome O nome do comprador.
     * @param conta A conta bancária do comprador.
     */
    public Comprador(String nome, ContaBancaria conta) {
        this.nome = nome;
        this.conta = conta;
    }

    /**
     * Retorna a conta bancária associada ao comprador.
     *
     * @return A conta bancária do comprador.
     */
    public ContaBancaria getConta() {
        return conta;
    }

    /**
     * Realiza o pagamento de um valor ao mercado utilizando um instrumento de
     * pagamento, que será processado pela conta bancária do comprador. O método
     * exibe uma mensagem indicando o valor a ser pago e, em seguida, processa o
     * pagamento utilizando a funcionalidade da conta bancária do comprador.
     * <p>
     * Este método invoca o método
     * {@link ContaBancaria#pagarInstrumento(InstrumentoPagamento_if)} da conta
     * bancária do comprador, que gerencia a lógica do pagamento.
     *
     * @param instrumentoPagamento O instrumento de pagamento (como boleto ou
     * cartão) a ser utilizado para processar o pagamento.
     *
     * @throws Exception Se ocorrer algum problema durante o processo de
     * pagamento.
     */
    public void pagar(InstrumentoPagamento_if instrumentoPagamento) throws Exception {
        System.out.println(nome + " está pagando R$ " + instrumentoPagamento.getTotal() + " para o Mercado.");
        instrumentoPagamento.getContaDevedor().pagarInstrumento(instrumentoPagamento);
    }

    private ContaBancaria conta;
    private final String nome;
}
