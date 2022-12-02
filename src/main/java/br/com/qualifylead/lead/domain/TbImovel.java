package br.com.qualifylead.lead.domain;



import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;




@SuppressWarnings("serial")
@Entity
@Table(name ="t_imovel")
public class TbImovel  extends AbstractEntity<Long> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ds_imovel")
	public String dsImovel;
	

	@Column(name="nm_proprietario")
	public String nmProprietarioImovel;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_fk")
	private TbUsuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	public TbEndereco endereco;
	
	@Column(name="ind_corretor")
	public String indCorretor;

	@Column(name="nm_corretor")
	public String nmCorretor;

	@Column(name="cel_corretor")
	public String celCorretor;

	@Column
	@DateTimeFormat(iso = ISO.DATE)
	public LocalDate dtIndicacaoImovel;
	
	@Column(name="tp_imovel")
	public String tpImovel;
	

	@Column(name="cel_proprietario", nullable =  false,  length= 11)
	private String celProprietario;
	
	@Column(name="situacao_imovel")
	public String situacaoImovel;
	
	@Column(name="status_imovel")
	public String statusImovel;
	
	@NumberFormat(style = Style.CURRENCY)
	@Column(name="vlr_imovel_ofertado", columnDefinition= "DECIMAL(7,2) DEFAULT 0,00")
	public Double  vrImovelOfertado;
	
//	@NumberFormat(style = Style.)
//	@Column(name="comis_ofertada", nullable =  true, columnDefinition= "DECIMAL(7,2) DEFAULT 0,00")
	public Double comissaoOfertada;
	
	@Column(name="fleg_comissao")
	public  String flegComissao;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsImovel() {
		return dsImovel;
	}

	public void setDsImovel(String dsImovel) {
		this.dsImovel = dsImovel;
	}

	public String getNmProprietarioImovel() {
		return nmProprietarioImovel;
	}

	public void setNmProprietarioImovel(String nmProprietarioImovel) {
		this.nmProprietarioImovel = nmProprietarioImovel;
	}

	public TbUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(TbUsuario usuario) {
		this.usuario = usuario;
	}

	public TbEndereco getEndereco() {
		return endereco;
	}

	public void setEndereco(TbEndereco endereco) {
		this.endereco = endereco;
	}

	public String getIndCorretor() {
		return indCorretor;
	}

	public void setIndCorretor(String indCorretor) {
		this.indCorretor = indCorretor;
	}

	public String getNmCorretor() {
		return nmCorretor;
	}

	public void setNmCorretor(String nmCorretor) {
		this.nmCorretor = nmCorretor;
	}

	public String getCelCorretor() {
		return celCorretor;
	}

	public void setCelCorretor(String celCorretor) {
		this.celCorretor = celCorretor;
	}

	public LocalDate getDtIndicacaoImovel() {
		return dtIndicacaoImovel;
	}

	public void setDtIndicacaoImovel(LocalDate dtIndicacaoImovel) {
		this.dtIndicacaoImovel = dtIndicacaoImovel;
	}

	public String getTpImovel() {
		return tpImovel;
	}

	public void setTpImovel(String tpImovel) {
		this.tpImovel = tpImovel;
	}

	public String getCelProprietario() {
		return celProprietario;
	}

	public void setCelProprietario(String celProprietario) {
		this.celProprietario = celProprietario;
	}

	public String getSituacaoImovel() {
		return situacaoImovel;
	}

	public void setSituacaoImovel(String situacaoImovel) {
		this.situacaoImovel = situacaoImovel;
	}

	public String getStatusImovel() {
		return statusImovel;
	}

	public void setStatusImovel(String statusImovel) {
		this.statusImovel = statusImovel;
	}

	
	public Double getVrImovelOfertado() {
		return vrImovelOfertado;
	}

	public void setVrImovelOfertado(Double vrImovelOfertado) {
		this.vrImovelOfertado = vrImovelOfertado;
	}

	


	public Double getComissaoOfertada() {
		return comissaoOfertada;
	}

	public void setComissaoOfertada(Double comissaoOfertada) {
		this.comissaoOfertada = comissaoOfertada;
	}

	public String getFlegComissao() {
		return flegComissao;
	}

	public void setFlegComissao(String flegComissao) {
		this.flegComissao = flegComissao;
	}

	
}