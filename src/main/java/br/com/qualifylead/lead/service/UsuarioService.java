package br.com.qualifylead.lead.service;

import java.util.List;

import br.com.qualifylead.lead.domain.TbUsuario;


public interface UsuarioService {
void salvar(TbUsuario usuario);
	
	void editar(TbUsuario usuario);
	
	void excluir(Long id);
	
	TbUsuario buscarPorID(Long id);
	
	List<TbUsuario> buscarTodos();
}
