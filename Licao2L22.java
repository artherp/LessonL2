
import com.sun.tools.javac.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Professor Cancian
 */
public class Licao2L22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Criando contas bancárias
        ContaBancaria contaComprador1 = new ContaBancaria("12345", 6000, 12345);
        ContaBancaria contaComprador2 = new ContaBancaria("67890", 8000, 67890);
        ContaBancaria contaMercado = new ContaBancaria("54321", 100, 54321);

        // Criando contas dos vendedores
        List<ContaBancaria> contasVendedores = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            contasVendedores.add(new ContaBancaria("11111" + i, 200 + i * 100, 11111 + i));
        }

        // Criando clientes e vendedores
        Comprador comprador1 = new Comprador("João", contaComprador1);
        Comprador comprador2 = new Comprador("Ana", contaComprador2);
        List<Vendedor> vendedores = new ArrayList<>();
        for (int i = 0; i < contasVendedores.size(); i++) {
            vendedores.add(new Vendedor("Vendedor " + (i + 1), contasVendedores.get(i)));
        }

        // Criando mercado
        Mercado mercado = new Mercado(contaMercado);

        // Criando produtos
        List<Produto> produtos = new ArrayList<>();
        for (Vendedor vendedor : vendedores) {
            for (int j = 1; j <= 4; j++) {
                produtos.add(new Produto("Produto " + j + " de " + vendedor.getNome(), 100 + j * 50, vendedor));
            }
        }

        // Criando pedidos para comprador 1
        for (int k = 1; k <= 2; k++) {
            Pedido pedido = new Pedido();
            pedido.adicionarProduto(produtos.get((k - 1) * 4), 1); // Produto do primeiro vendedor
            pedido.adicionarProduto(produtos.get((k - 1) * 4 + 1), 1); // Produto do segundo vendedor
            pedido.adicionarProduto(produtos.get((k - 1) * 4 + 2), 1); // Produto do terceiro vendedor
            mercado.addPedido(pedido);

            // Escolhendo o método de pagamento (boleto ou cartão)
            TransacaoPagamento_if transacaoPagamento = k == 1 ? new PagamentoBoleto() : new PagamentoCartaoCredito();
            try {
                // Processando o pagamento do pedido
                InstrumentoPagamento_if instrumentoPagamento = mercado.criaInstrumentoPagamentoPedido(pedido,
                        comprador1, transacaoPagamento);
                comprador1.pagar(instrumentoPagamento);
                System.out.println("Pagamento do Comprador 1 realizado para o Pedido " + pedido.getId());
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Criando pedidos para comprador 2
        for (int k = 1; k <= 2; k++) {
            Pedido pedido = new Pedido();
            pedido.adicionarProduto(produtos.get((k - 1) * 4 + 3), 2); // Produto do quarto vendedor
            pedido.adicionarProduto(produtos.get((k - 1) * 4 + 2), 1); // Produto do terceiro vendedor
            pedido.adicionarProduto(produtos.get((k - 1) * 4 + 1), 1); // Produto do segundo vendedor
            mercado.addPedido(pedido);

            // Escolhendo o método de pagamento (Pix)
            TransacaoPagamento_if transacaoPagamento = new PagamentoPix();
            try {
                // Processando o pagamento do pedido
                InstrumentoPagamento_if instrumentoPagamento = mercado.criaInstrumentoPagamentoPedido(pedido,
                        comprador2, transacaoPagamento);
                comprador2.pagar(instrumentoPagamento);
                System.out.println("Pagamento do Comprador 2 realizado para o Pedido " + pedido.getId());
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
