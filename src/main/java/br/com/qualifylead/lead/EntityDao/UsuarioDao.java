package br.com.qualifylead.lead.EntityDao;

import java.util.List;

import br.com.qualifylead.lead.domain.TbUsuario;



public interface UsuarioDao {
public void save(TbUsuario usuario);
	
	public void update(TbUsuario usuario);
	
	public void delete(Long id);
	
	TbUsuario findById(Long id);
	
	List<TbUsuario> findAll();
}
