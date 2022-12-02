package br.com.qualifylead.lead.service;

import java.util.List;

import br.com.qualifylead.lead.Util.PaginacaoUtil;
import br.com.qualifylead.lead.domain.TbImovel;

public interface ImovelService {
	void salvar(TbImovel imovel);
	
	void editar(TbImovel imovel);
	
	void excluir(Long id);
	
	TbImovel buscarPorID(Long id);
	
	List<TbImovel> buscarTodos();
	
	PaginacaoUtil<TbImovel> buscaPorPagina(int pagina, String direcao);

	List<TbImovel> buscarPorNome(String nomeProprietarioImovel);

	List<TbImovel> buscarPorContato(String contatoProprietario);

	List<TbImovel> buscarPorSituacao(String situacaoImovel);

	List<TbImovel> buscarPorDsImovel(String nome);

	List<TbImovel> buscarPorProprietario(String nome);

	List<TbImovel> buscarPorTipoImovel(String nome);

	List<TbImovel> buscarPorStatus(String status);
	
	
}
