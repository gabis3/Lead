package br.com.qualifylead.lead.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.qualifylead.lead.dao.UsuarioDao;
import br.com.qualifylead.lead.domain.TbUsuario;


@Service @Transactional(readOnly= false)
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao dao;
	
	@Override
	public void salvar(TbUsuario usuario) {
		dao.save(usuario);
		
	}

	@Override
	public void editar(TbUsuario usuario) {
		dao.update(usuario);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly= true)
	public TbUsuario buscarPorID(Long id) {
		
		return dao.findById(id);
	}

	@Override  @Transactional(readOnly= true)
	public List<TbUsuario> buscarTodos() {
	
		return dao.findAll();
	}

}
