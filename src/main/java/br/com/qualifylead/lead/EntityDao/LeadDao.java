package br.com.qualifylead.lead.EntityDao;

import java.util.List;

import br.com.qualifylead.lead.Util.PaginacaoUtil;
import br.com.qualifylead.lead.domain.TbLead;

public interface LeadDao {
	public void save(TbLead lead);
	
	public void update(TbLead lead);
	
	public void delete(Long id);
	
	TbLead findById(Long id);
	
	List<TbLead> findAll();
	
	PaginacaoUtil<TbLead> buscaPagina(int pagina, String direcao);

	List<TbLead> findBynmLead(String nome);

	List<TbLead>  findBycelLead(String contato);

	List<TbLead> findBysituacao(String situacao);
}
