package br.com.qualifylead.lead.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name ="t_usuarios")
public class TbUsuario extends AbstractEntity<Long> {
	@Column(nullable= false, unique= true, length= 60)
	private String nmUsuario;
	
	@Column(length= 60)
	private String senha;

	@OneToMany(mappedBy="usuario")
	private List<TbLead> leads;

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}


	public List<TbLead> getLeads() {
		return leads;
	}

	public void setLeads(List<TbLead> leads) {
		this.leads = leads;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	
	
}
