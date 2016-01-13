package br.com.agrofacil.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the teste_engenaria_reversa database table.
 * 
 */
@Entity
@Table(name="teste_engenaria_reversa")
@NamedQuery(name="TesteEngenariaReversa.findAll", query="SELECT t FROM TesteEngenariaReversa t where t.testeBoolean = false")
public class TesteEngenariaReversa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_TESTE_ID", sequenceName="SEQ_TESTE_ID", initialValue=1, allocationSize=1)
	@GeneratedValue( strategy=GenerationType.SEQUENCE, generator="SEQ_TESTE_ID")
	@Column(name="teste_id", unique=true, nullable=false)
	private Integer testeId;

	@Column(name="teste_boolean")
	private Boolean testeBoolean;

	@Column(name="teste_char_10", length=10)
	private String testeChar10;

	@Column(name="teste_char_2", length=2)
	private String testeChar2;

	@Temporal(TemporalType.DATE)
	@Column(name="teste_dt")
	private Date testeDt;

	@Column(name="teste_nome", length=50)
	private String testeNome;

	@Column(name="teste_numeric", precision=10, scale=2)
	private BigDecimal testeNumeric;

	@Column(name="teste_time")
	private Time testeTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="teste_timestamp")
	private Calendar testeTimestamp;

	public TesteEngenariaReversa() {
	}

	public Integer getTesteId() {
		return this.testeId;
	}

	public void setTesteId(Integer testeId) {
		this.testeId = testeId;
	}

	public Boolean getTesteBoolean() {
		return this.testeBoolean;
	}

	public void setTesteBoolean(Boolean testeBoolean) {
		this.testeBoolean = testeBoolean;
	}

	public String getTesteChar10() {
		return this.testeChar10;
	}

	public void setTesteChar10(String testeChar10) {
		this.testeChar10 = testeChar10;
	}

	public String getTesteChar2() {
		return this.testeChar2;
	}

	public void setTesteChar2(String testeChar2) {
		this.testeChar2 = testeChar2;
	}

	public Date getTesteDt() {
		return this.testeDt;
	}

	public void setTesteDt(Date testeDt) {
		this.testeDt = testeDt;
	}

	public String getTesteNome() {
		return this.testeNome;
	}

	public void setTesteNome(String testeNome) {
		this.testeNome = testeNome;
	}

	public BigDecimal getTesteNumeric() {
		return this.testeNumeric;
	}

	public void setTesteNumeric(BigDecimal testeNumeric) {
		this.testeNumeric = testeNumeric;
	}

	public Time getTesteTime() {
		return this.testeTime;
	}

	public void setTesteTime(Time testeTime) {
		this.testeTime = testeTime;
	}

	public Calendar getTesteTimestamp() {
		return testeTimestamp;
	}

	public void setTesteTimestamp(Calendar testeTimestamp) {
		this.testeTimestamp = testeTimestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}