package br.com.qualifylead.lead.domain;


import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Getter;
import lombok.Setter;



@Getter @Setter
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
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name="vlr_imovel_ofertado", columnDefinition= "DECIMAL(7,2) DEFAULT 0,00")
	public BigDecimal  vrImovelOfertado;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#.00")
	@Column(name="comis_ofertada", nullable =  true, columnDefinition= "DECIMAL(1,2) DEFAULT 0,00")
	public BigDecimal comissaoOfertada;
	
	@Column(name="fleg_comissao")
	public  String flegComissao;
	
	
}