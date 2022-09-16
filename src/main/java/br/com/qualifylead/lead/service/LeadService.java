package br.com.qualifylead.lead.service;

import java.util.List;

import br.com.qualifylead.lead.Util.PaginacaoUtil;
import br.com.qualifylead.lead.domain.TbLead;

public interface LeadService {
	void salvar(TbLead lead);
	
	void editar(TbLead lead);
	
	void excluir(Long id);
	
	TbLead buscarPorID(Long id);
	
	List<TbLead> buscarTodos();
	
	PaginacaoUtil<TbLead> buscaPorPagina(int pagina, String direcao);

	List<TbLead> buscarPorNome(String nome);

	List<TbLead> buscarPorContato(String contato);

	List<TbLead> buscarPorSituacao(String situacao);
}
