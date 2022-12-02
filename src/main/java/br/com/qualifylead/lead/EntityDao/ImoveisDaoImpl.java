package br.com.qualifylead.lead.EntityDao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.qualifylead.lead.Util.PaginacaoUtil;
import br.com.qualifylead.lead.domain.TbImovel;

@Repository
public class ImoveisDaoImpl extends  AbstractDao<TbImovel, Long> implements ImoveisEntityDao {
	public PaginacaoUtil<TbImovel> buscaPagina(int pagina, String direcao){
	  int tamanho = 5;
	  int inicio = (pagina - 1)* tamanho; // 0*5=0 1*5=5 2*5=10
	  List<TbImovel> imovel =  getEntityManager()
			  .createQuery("select c from TbImovel c order by c.tpImovel " + direcao, TbImovel.class)
			  .setFirstResult(inicio)
			  .setMaxResults(tamanho)
			  .getResultList();
	  
	  long totalRegistros = count();

	  long totalDePaginas = (totalRegistros +(tamanho - 1)) / tamanho;

	return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao,  imovel) ;
	}
	public long count() {
		return getEntityManager()
				.createQuery("select count(*) from TbImovel", Long.class)
				.getSingleResult();
	}
	
	@Override
	public List<TbImovel> findBydsImovel(String nomeImovel) {
		
		return createQuery("select f from TbImovel f where f.dsImovel like concat('%',?1,'%') ", nomeImovel);
	}
	
	@Override
	public List<TbImovel> findBynmProprietarioImovel(String nomeProprietarioImovel) {
		
		return createQuery("select f from TbImovel f where f.nmProprietarioImovel like concat('%',?1,'%') ", nomeProprietarioImovel);
	}
	
	@Override
	public List<TbImovel> findBycelProprietario(String contatoProprietario) {
	
		return createQuery("select f from TbImovel f where f.celProprietario like concat('%',?1,'%') ", contatoProprietario);
		
	}
	@Override
	public List<TbImovel> findBySituacao(String situacaoImovel) {
		return createQuery("select f from TbImovel f where f.situacaoImovel like concat('%',?1,'%') ", situacaoImovel);
	}

	@Override
	public List<TbImovel> findByTipoImovel(String nome) {

		return createQuery("select f from TbImovel f where f.tpImovel like concat('%',?1,'%') ", nome);
	}
	
	@Override
	public List<TbImovel> findByStatus(String statusImovel) {
		return createQuery("select f from TbImovel f where f.statusImovel like concat('%',?1,'%') ", statusImovel);
	}
}
