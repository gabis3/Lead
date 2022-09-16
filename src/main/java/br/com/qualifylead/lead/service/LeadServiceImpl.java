package br.com.qualifylead.lead.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.qualifylead.lead.Util.PaginacaoUtil;
import br.com.qualifylead.lead.dao.LeadDao;
import br.com.qualifylead.lead.domain.TbLead;




@Service @Transactional(readOnly= false)
public class LeadServiceImpl  implements LeadService {

	@Autowired
	private LeadDao dao;

	
	
	@Override
	public void salvar(TbLead lead) {
		lead.setStatusLead("Cadastro Ativo");
		

		dao.save(lead);
		
	}

	@Override
	public void editar(TbLead lead) {
		dao.update(lead);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly= true)
	public TbLead buscarPorID(Long id) {
		
		return dao.findById(id);
	}

	@Override  @Transactional(readOnly= true)
	public List<TbLead> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public PaginacaoUtil<TbLead> buscaPorPagina(int pagina, String direcao) {
	
		return dao.buscaPagina(pagina, direcao);
	}

	@Override
	public List<TbLead> buscarPorNome(String nome) {

		return dao.findBynmLead(nome);
	}

	@Override
	public List<TbLead> buscarPorContato(String contato) {
		return dao.findBycelLead(contato);
	}

	@Override
	public List<TbLead> buscarPorSituacao(String situacao) {
		
		return dao.findBysituacao(situacao);
	}

	

}
