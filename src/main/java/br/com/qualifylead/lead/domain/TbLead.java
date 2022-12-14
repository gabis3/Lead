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


@Setter @Getter
@SuppressWarnings("serial")
@Entity
@Table(name ="t_lead")
public class TbLead  extends AbstractEntity<Long> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(columnDefinition= "DECIMAL(7,2) DEFAULT 0.00")
	public BigDecimal fgts;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(columnDefinition= "DECIMAL(7,2) DEFAULT 0.00")
	public BigDecimal sinal;
	
	@Column
	public String impRenda;
	
	@Column
	public String finAberto;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(columnDefinition= "DECIMAL(7,2) DEFAULT 0.00")
	public BigDecimal vlParcela;
	
	@Column
	public String qtParcela;
	
	@Column
	public String tpImovel;
	
	@Column
	public String situacaoImovel;
	
	@Column
	public String statusLead;
	
	
}
