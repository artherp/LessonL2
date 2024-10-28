
import java.util.ArrayList;
import java.util.List;

/**
 * A classe ContaBancaria representa uma conta bancária simples, permitindo
 * depósitos e saques de dinheiro.
 * <p>
 * A conta é identificada por um número de conta e tem um saldo inicial. Possui
 * funcionalidades para realizar depósitos, saques, transferências e
 * autenticação do usuário.
 *
 * @author Professor Cancian
 * @version 1.0
 * @since 2024
 */
public class ContaBancaria {

    /**
     * @return the autenticacao
     */
    public int getAutenticacao() {
        return autenticacao;
    }

    /**
     * Construtor para inicializar uma conta bancária com um saldo inicial.
     *
     * @param numeroConta O número da conta bancária.
     * @param saldoInicial O saldo inicial da conta.
     * @param autenticacao A chave de autenticação para operações na conta.
     */
    public ContaBancaria(String numeroConta, double saldoInicial, int autenticacao) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.autenticacao = autenticacao;
        this.listeners = new ArrayList<>();
    }

    /**
     * Adiciona um ouvinte (Listener) para eventos de depósito na conta.
     *
     * @param listener O ouvinte a ser adicionado.
     */
    public void addDepositListener(Listener listener) {
        listeners.add(listener);
    }

    /**
     * Verifica se a autenticação fornecida corresponde à chave de autenticação
     * da conta.
     *
     * @param autenticacao A chave de autenticação a ser verificada.
     *
     * @return true se a autenticação for válida, false caso contrário.
     */
    public boolean autenticado(int autenticacao) {
        return this.getAutenticacao() == autenticacao;
    }

    /**
     * Realiza um depósito na conta bancária, adicionando o valor ao saldo
     * atual.
     * <p>
     * Este método atualiza o saldo da conta e notifica todos os ouvintes
     * registrados sobre a transação de depósito, criando um evento de transação
     * que é enviado a cada ouvinte.
     *
     * @param valor O valor a ser depositado.
     * @param idTransacao O identificador da transação.
     */
    public void depositar(double valor, int idTransacao) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " na conta " + numeroConta);
        ListenTransactionEvent event = new ListenTransactionEvent(null, this, valor, idTransacao);
        for (Listener ouvinte : this.listeners) {
            ouvinte.update(event);
        }
    }

    /**
     * Retorna o número da conta bancária.
     *
     * @return O número da conta bancária.
     */
    public String getNumeroConta() {
        return numeroConta;
    }

    /**
     * Retorna o saldo atual da conta bancária.
     *
     * @param autenticacao A chave de autenticação para acessar o saldo.
     *
     * @return O saldo da conta bancária.
     *
     * @throws Exception Se a autenticação for inválida.
     */
    public double getSaldo(int autenticacao) throws Exception {
        if (autenticacao != this.getAutenticacao()) {
            throw new Exception("Autenticacao invalida na conta " + numeroConta);
        }
        return saldo;
    }

    /**
     * Realiza um saque da conta bancária, retirando o valor do saldo atual.
     * <p>
     * Se o saldo for insuficiente ou a autenticação for inválida, uma mensagem
     * de erro é exibida e uma exceção é lançada.
     *
     * @param valor O valor a ser sacado.
     * @param autenticacao A chave de autenticação para poder sacar.
     *
     * @return O valor sacado.
     *
     * @throws Exception Se o saldo for insuficiente ou a autenticação for
     * inválida.
     */
    public double sacar(double valor, int autenticacao) throws Exception {
        if (autenticacao == this.getAutenticacao()) { // autenticação válida
            if (saldo >= valor) {
                saldo -= valor;
                System.out.println("Saque de R$ " + valor + " da conta " + numeroConta);
            } else {
                System.out.println("Saldo insuficiente na conta " + numeroConta);
                throw new Exception("Saldo insuficiente na conta " + numeroConta);
            }
        } else {
            System.out.println("Autenticacao invalida na conta " + numeroConta);
            throw new Exception("Autenticacao invalida na conta " + numeroConta);
        }
        return valor;
    }

    /**
     * Realiza uma transferência de um valor da conta atual para outra conta
     * bancária.
     * <p>
     * Este método primeiro realiza o saque do valor da conta atual e, em
     * seguida, efetua o depósito na conta destino. A operação é autenticada
     * utilizando a chave de autenticação fornecida.
     *
     * @param contaDestino A conta bancária para onde o valor será transferido.
     * @param valor O valor a ser transferido.
     * @param autenticacao A chave de autenticação para realizar a
     * transferência.
     * @param idTransacao O identificador da transação.
     *
     * @throws Exception Se ocorrer um erro durante a transferência, como saldo
     * insuficiente ou autenticação inválida.
     */
    public void transferirPara(ContaBancaria contaDestino, double valor, int autenticacao, int idTransacao) throws Exception {
        sacar(valor, autenticacao);
        contaDestino.depositar(valor, idTransacao);
    }

    /**
     * Realiza o pagamento utilizando um instrumento de pagamento. Este método
     * chama o método realizarPagamento do objeto de transação associado ao
     * instrumento de pagamento, autenticando a operação.
     *
     * @param instrumentoPagamento O instrumento de pagamento a ser utilizado.
     *
     * @throws Exception Se ocorrer um erro durante o processo de pagamento.
     */
    void pagarInstrumento(InstrumentoPagamento_if instrumentoPagamento) throws Exception {
        TransacaoPagamento_if transacaoPagamento = instrumentoPagamento.getTransacaoPagamento();
        transacaoPagamento.realizarPagamento(instrumentoPagamento, autenticacao);
    }

    private final int autenticacao;
    private final List<Listener> listeners;
    private final String numeroConta;
    private double saldo;
}
