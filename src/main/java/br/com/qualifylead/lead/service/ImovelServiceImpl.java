package br.com.qualifylead.lead.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.qualifylead.lead.EntityDao.ImoveisEntityDao;
import br.com.qualifylead.lead.Util.PaginacaoUtil;
import br.com.qualifylead.lead.domain.TbImovel;

@Service("ImovelServiceImpl")
@Transactional(readOnly= false)
public class ImovelServiceImpl  implements ImovelService {

	@Autowired
	private ImoveisEntityDao dao;

	@Override
	public void salvar(TbImovel imovel) {
		imovel.setStatusImovel("Cadastro Ativo");
		dao.save(imovel);
	}

	@Override
	public void editar(TbImovel imovel) {
		dao.update(imovel);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly= true)
	public TbImovel buscarPorID(Long id) {
		
		return dao.findById(id);
	}

	@Override  @Transactional(readOnly= true)
	public List<TbImovel> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public PaginacaoUtil<TbImovel> buscaPorPagina(int pagina, String direcao) {
	
		return dao.buscaPagina(pagina, direcao);
	}

	@Override  @Transactional(readOnly= true)
	public List<TbImovel> buscarPorDsImovel(String nome) {

		return dao.findBydsImovel(nome);
	}

	@Override  @Transactional(readOnly= true)
	public List<TbImovel> buscarPorNome(String nome) {

		return dao.findBynmProprietarioImovel(nome);
	}

	@Override  @Transactional(readOnly= true)
	public List<TbImovel> buscarPorContato(String contato) {
		return dao.findBycelProprietario(contato);
	}

	@Override  @Transactional(readOnly= true)
	public List<TbImovel> buscarPorSituacao(String situacao) {
		
		return dao.findBySituacao(situacao);
	}

	@Override
	public List<TbImovel> buscarPorProprietario(String nome) {

		return dao.findBynmProprietarioImovel(nome);
	}

	@Override
	public List<TbImovel> buscarPorTipoImovel(String nome) {

		return dao.findByTipoImovel(nome);
	}
	@Override
	public List<TbImovel> buscarPorStatus(String nome) {

		return dao.findByStatus(nome);
	}
	

}
