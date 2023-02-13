package br.com.alura.loja.orcamento;

import java.util.Map;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.http.HttpAdapter;

public class RegistroDeOrcamento {
	
	private HttpAdapter http;
	
	public RegistroDeOrcamento(HttpAdapter http) {
		this.http = http;
	}


	// chamada HTTP para a API externa
	// URL Connection
	// Http Client
	// lib Rest
	
	/* QUEREMOS EVITAR DETALHE DE LÓGICA COM DETALHES DE INFRAESTRUTURA*/
	public void registrar(Orcamento orcamento) {		
		if(!orcamento.isFinalizado()) {
			throw new DomainException("Orcamento não finalizado!");
		}
		String url = "http://api.externa/orcamento";
		Map<String, Object> dados = Map.of("valor", orcamento.getValor(), "quantidadeItens", orcamento.getQuantidadeItens());
		http.post(url , dados );
	}
	
	
}
