package br.com.alura.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class GeraPedidoHandler {

	private List<AcaoAposGerarPedido> acoes;

	public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
		this.acoes = acoes;
	}

	public void execute(GeraPedido dados) {
		Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
		
		EnviarEmailPedido email = new EnviarEmailPedido();
		SalvarPedidoNoBancoDeDados salvar = new SalvarPedidoNoBancoDeDados();

		acoes.forEach(a -> a.executarAcao(pedido));
	}
}