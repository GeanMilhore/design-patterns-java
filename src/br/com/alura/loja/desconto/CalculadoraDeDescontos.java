package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class CalculadoraDeDescontos {

	public BigDecimal calcular(Orcamento orcamento) {

		Desconto cadeiaDeDescontos = new DescontoOrcamentoComMaisDeCincoItens(new DescontoOrcamentoComValorMaiorQueQuinhentos(new SemDesconto()));
		
		return cadeiaDeDescontos.calcular(orcamento);
	}
}
