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
@Table(name ="t_lead")
public class TbLead  extends AbstractEntity<Long> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@ManyToOne
//	@JoinColumn(name="id_usuario_fk")
//	private TbUsuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	public TbEndereco endereco;
		
	@Column(nullable =  false,  length= 60)
	private String nmLead;
	
	@Column(nullable =  false, unique= true, length= 11)
	private String celLead;

	@Column
	@DateTimeFormat(iso = ISO.DATE)
	public LocalDate dtNasc;
	
	@Column
	public String indCorretor;

	@Column
	public String nmCorretor;

	@Column
	public String celCorretor;
	
	@Column
	@DateTimeFormat(iso = ISO.DATE)
	public LocalDate dtIndicacao;
	
	
	@Column
	public String escrituraImovel;
	
	@Column
	public String origRenda;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(columnDefinition= "DECIMAL(7,2) DEFAULT 0.00")
	public BigDecimal rendaAtual;
	
	@Column
	public String fgts;
	
	@Column
	public String sinal;
	
	@Column
	public String impRenda;
	
	@Column
	public String finAberto;
	
	@Column
	public String vlParcela;
	
	@Column
	public String qtParcela;
	
	@Column
	public String tpImovel;
	
	@Column
	public String situacaoImovel;
	
	@Column
	public String statusLead;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
//	public TbUsuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(TbUsuario usuario) {
//		this.usuario = usuario;
//	}

	public String getNmLead() {
		return nmLead;
	}

	public void setNmLead(String nmLead) {
		this.nmLead = nmLead;
	}

	public String getCelLead() {
		return celLead;
	}

	public void setCelLead(String celLead) {
		this.celLead = celLead;
	}

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(LocalDate dtNasc) {
		this.dtNasc = dtNasc;
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
	
	
	public LocalDate getDtIndicacao() {
		return dtIndicacao;
	}

	public void setDtIndicacao(LocalDate dtIndicacao) {
		this.dtIndicacao = dtIndicacao;
	}

	public String getEscrituraImovel() {
		return escrituraImovel;
	}

	public void setEscrituraImovel(String escrituraImovel) {
		this.escrituraImovel = escrituraImovel;
	}

	public String getOrigRenda() {
		return origRenda;
	}

	public void setOrigRenda(String origRenda) {
		this.origRenda = origRenda;
	}

	public BigDecimal getRendaAtual() {
		return rendaAtual;
	}

	public void setRendaAtual(BigDecimal rendaAtual) {
		this.rendaAtual = rendaAtual;
	}

	public String getFgts() {
		return fgts;
	}

	public void setFgts(String fgts) {
		this.fgts = fgts;
	}

	public String getSinal() {
		return sinal;
	}

	public void setSinal(String sinal) {
		this.sinal = sinal;
	}

	public String getImpRenda() {
		return impRenda;
	}
	
	


	public String getStatusLead() {
		return statusLead;
	}

	public void setStatusLead(String statusLead) {
		this.statusLead = statusLead;
	}

	public void setImpRenda(String impRenda) {
		this.impRenda = impRenda;
	}

	public String getFinAberto() {
		return finAberto;
	}

	public void setFinAberto(String finAberto) {
		this.finAberto = finAberto;
	}

	public String getVlParcela() {
		return vlParcela;
	}

	public void setVlParcela(String vlParcela) {
		this.vlParcela = vlParcela;
	}

	public String getQtParcela() {
		return qtParcela;
	}

	public void setQtParcela(String qtParcela) {
		this.qtParcela = qtParcela;
	}

	public String getTpImovel() {
		return tpImovel;
	}

	public void setTpImovel(String tpImovel) {
		this.tpImovel = tpImovel;
	}

	public String getSituacaoImovel() {
		return situacaoImovel;
	}

	public void setSituacaoImovel(String situacaoImovel) {
		this.situacaoImovel = situacaoImovel;
	}

	public TbEndereco getEndereco() {
		return endereco;
	}

	public void setEndereco(TbEndereco endereco) {
		this.endereco = endereco;
	}

	

	
}
