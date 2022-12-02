package br.com.qualifylead.lead.EntityDao;

import java.util.List;

import br.com.qualifylead.lead.Util.PaginacaoUtil;
import br.com.qualifylead.lead.domain.TbImovel;

public interface ImoveisEntityDao {
	public void save(TbImovel imovel);
	
	public void update(TbImovel imovel);
	
	public void delete(Long id);
	
	TbImovel findById(Long id);
	
	List<TbImovel> findAll();
	
	PaginacaoUtil<TbImovel> buscaPagina(int pagina, String direcao);

	List<TbImovel> findBynmProprietarioImovel(String nomeProprietarioImovel);

	List<TbImovel>  findBycelProprietario(String contatoProprietario);

	List<TbImovel> findBySituacao(String situacaoImovel);

	List<TbImovel> findBydsImovel(String nome);

	List<TbImovel> findByTipoImovel(String nome);

	List<TbImovel> findByStatus(String nome);


}
