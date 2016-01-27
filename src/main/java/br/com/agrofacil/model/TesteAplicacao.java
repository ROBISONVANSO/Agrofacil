package br.com.agrofacil.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the teste_aplicacao database table.
 * 
 */
@Entity
@Table(name="teste_aplicacao")
//@NamedQuery(name="TesteAplicacao.findAll", query="SELECT t FROM TesteAplicacao t")
public class TesteAplicacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_teste_id", sequenceName = "seq_teste_id", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_teste_id")
	@Column(name="test_id", unique=true, nullable=false)
	private Integer testId;

	@Column(name="test_boolean", nullable=false)
	private Boolean testBoolean;

//	@Column(name="test_byte")
//	private byte[] testByte;

	@Temporal(TemporalType.DATE)
	@Column(name="test_data")
	private Date testData;

	@Column(name="test_descricao", length=4000)
	private String testDescricao;

	@Column(name="test_nome", nullable=false, length=100)
	private String testNome;

	@Column(name="test_password", length=50)
	private String testPassword;

	@Column(name="test_valor", precision=10, scale=2)
	private BigDecimal testValor;

	public TesteAplicacao() {
	}

	public Integer getTestId() {
		return this.testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public Boolean getTestBoolean() {
		return this.testBoolean;
	}

	public void setTestBoolean(Boolean testBoolean) {
		this.testBoolean = testBoolean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getTestData() {
		return this.testData;
	}

	public void setTestData(Date testData) {
		this.testData = testData;
	}

	public String getTestDescricao() {
		return this.testDescricao;
	}

	public void setTestDescricao(String testDescricao) {
		this.testDescricao = testDescricao;
	}

	public String getTestNome() {
		return this.testNome;
	}

	public void setTestNome(String testNome) {
		this.testNome = testNome;
	}

	public String getTestPassword() {
		return this.testPassword;
	}

	public void setTestPassword(String testPassword) {
		this.testPassword = testPassword;
	}

	public BigDecimal getTestValor() {
		return this.testValor;
	}

	public void setTestValor(BigDecimal testValor) {
		this.testValor = testValor;
	}

}