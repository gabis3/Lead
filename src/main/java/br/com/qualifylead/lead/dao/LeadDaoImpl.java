package br.com.qualifylead.lead.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.qualifylead.lead.Util.PaginacaoUtil;
import br.com.qualifylead.lead.domain.TbLead;

@Repository
public class LeadDaoImpl extends AbstractDao<TbLead, Long> implements LeadDao {
	public PaginacaoUtil<TbLead> buscaPagina(int pagina, String direcao){
		  int tamanho = 5;
		  int inicio = (pagina - 1)* tamanho; // 0*5=0 1*5=5 2*5=10
		  List<TbLead> lead =  getEntityManager()
				  .createQuery("select c from TbLead c order by c.nmLead " + direcao, TbLead.class)
				  .setFirstResult(inicio)
				  .setMaxResults(tamanho)
				  .getResultList();
		  
		  long totalRegistros = count();

		  long totalDePaginas = (totalRegistros +(tamanho - 1)) / tamanho;
	  
		return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao,  lead) ;
		
	}
	public long count() {
		return getEntityManager()
				.createQuery("select count(*) from TbLead", Long.class)
				.getSingleResult();
	}
	@Override
	public List<TbLead> findBynmLead(String nome) {
		
		return createQuery("select f from TbLead f where f.nmLead like concat('%',?1,'%') ", nome);
	}
	@Override
	public List<TbLead> findBycelLead(String contato) {
	
		return createQuery("select f from TbLead f where f.celLead like concat('%',?1,'%') ", contato);
		
	}
	@Override
	public List<TbLead> findBysituacao(String situacao) {
		return createQuery("select f from TbLead f where f.statusLead like concat('%',?1,'%') ", situacao);
	}
	
}
