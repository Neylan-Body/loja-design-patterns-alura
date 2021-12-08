package br.com.alura.loja;

import br.com.alura.loja.acao.EnviarEmailPedido;
import br.com.alura.loja.acao.SalvarPedidoNoBancoDeDados;
import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;

import java.math.BigDecimal;
import java.util.List;

public class TestesPedidos {

    public static void main(String[] args) {
        String cliente = "Neylan";
        BigDecimal valorOrcamento = new BigDecimal("300");
        int quantidadeItens = 10;

        GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
        GeraPedidoHandler handler = new GeraPedidoHandler(
                List.of(new EnviarEmailPedido(),
                        new SalvarPedidoNoBancoDeDados()));
        handler.execute(gerador);
    }
}
