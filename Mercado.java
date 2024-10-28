
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A classe Mercado representa o mercado que recebe pagamentos de clientes e
 * repassa os valores para os vendedores.
 * <p>
 * O mercado gerencia uma conta bancária e escuta eventos de depósito,
 * processando pedidos e distribuindo os pagamentos correspondentes aos
 * vendedores dos produtos adquiridos pelos compradores.
 * <p>
 * UFSC/CTC/INE/INE5404
 *
 * @author Professor Cancian
 * @version 1.0
 * @since 2024
 */
public class Mercado {

    private ContaBancaria conta;
    private final List<Pedido> pedidos;
    private Set<Integer> pedidosProcessados;
    private Map<Double, List<Pedido>> pedidosPorValor;
    

    /**
     * Construtor que inicializa o mercado com uma conta bancária.
     *
     * @param conta A conta bancária do mercado. Essa conta será usada para
     * receber pagamentos dos compradores e para repassar os valores
     * correspondentes aos vendedores após a conclusão do pagamento de um
     * pedido.
     */
    public Mercado(ContaBancaria conta) {
        this.conta = conta;
        conta.addDepositListener(new Listener() {
            @Override
            public void update(ListenEvent event) {
                onNewDeposit(event);
            }
        });
        this.pedidos = new ArrayList<>();
        this.pedidosProcessados = new HashSet<>();
        this.pedidosPorValor = new HashMap<>();
    }

    /**
     * Processa o pagamento de um pedido feito por um cliente. O cliente paga o
     * valor total ao mercado, e o mercado repassa o pagamento aos vendedores.
     *
     * @param pedido O pedido contendo os produtos e vendedores associados.
     * @param comprador O cliente que está fazendo o pagamento.
     * @param transacaoPagamento O objeto que gerencia a transação de pagamento
     * e cria o instrumento de pagamento.
     *
     * @return Um objeto que implementa a interface InstrumentoPagamento_if,
     * representando o instrumento de pagamento criado para a transação.
     *
     * @throws java.lang.Exception Se houver um erro durante o processamento do
     * pagamento, como falha na criação do instrumento de pagamento.
     */
    public InstrumentoPagamento_if criaInstrumentoPagamentoPedido(Pedido pedido, Comprador comprador, TransacaoPagamento_if transacaoPagamento) throws Exception {
        double total = pedido.calcularTotal();
        System.out.println("Mercado está processando o pagamento de R$ " + total);

        try {
            InstrumentoPagamento_if instrumento = transacaoPagamento.criaInstrumentoPagamento(pedido.getId(), total, comprador.getConta(), conta);
            return instrumento;
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Retorna a conta bancária do mercado.
     *
     * @return A conta bancária do mercado, que pode ser usada para verificar o
     * saldo ou para outras operações financeiras.
     */
    public ContaBancaria getConta() {
        return conta;
    }

    /**
     * Método privado que é chamado quando um novo depósito é realizado na conta
     * do mercado. Ele verifica se o depósito corresponde a um pedido existente
     * e, se for o caso, repassa os valores aos vendedores correspondentes aos
     * itens do pedido.
     *
     * @param event O evento de depósito que contém informações sobre a
     * transação realizada.
     */
    private void onNewDeposit(ListenEvent event) {

        ListenTransactionEvent depositEvent = (ListenTransactionEvent) event;
        List<Pedido> pedidosCorrespondentesPorValor = pedidosPorValor.get(depositEvent.valor);
        if (pedidosCorrespondentesPorValor == null) {
            return;
        }

        List<Pedido> pedidosPendentes = new ArrayList<>();
        for (Pedido pedido : pedidosCorrespondentesPorValor) {
            if (!pedidosProcessados.contains(pedido.getId())) {
                pedidosPendentes.add(pedido);
            }
        }

        for (Pedido pedido : pedidosPendentes) {
        for (ItemPedido item : pedido.getItens()) {
            double valorDeposito = item.produto.getPreco() * item.quantidade;
            ContaBancaria vendedorConta = item.produto.getVendedor().getConta();

            try {
                PagamentoPix pix = new PagamentoPix();
                InstrumentoPagamento_if qrCode = pix.criaInstrumentoPagamento(pedido.getId(), valorDeposito, conta, vendedorConta);
                conta.pagarInstrumento(qrCode);
            } catch (Exception ex) {}
        }
        pedidosProcessados.add(pedido.getId());
    }
    pedidosPendentes.clear();
}

    /**
     * Adiciona um novo pedido à lista de pedidos do mercado.
     *
     * @param pedido O pedido a ser adicionado à lista.
     */
    void addPedido(Pedido pedido) {
        pedidos.add(pedido);
        double total = pedido.calcularTotal();
        List<Pedido> listaPedidos = pedidosPorValor.get(total);
        if(listaPedidos == null) {
            listaPedidos = new ArrayList<>();
            pedidosPorValor.put(total, listaPedidos);
        }
        listaPedidos.add(pedido);
    }

}
