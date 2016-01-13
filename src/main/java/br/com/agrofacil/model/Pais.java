package br.com.agrofacil.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "teste_pais")
public class Pais implements Serializable {

	@Id
	@SequenceGenerator(name="SEQ_TESTEPAIS_ID", sequenceName="SEQ_TESTEPAIS_ID", initialValue=1, allocationSize=1)
	@GeneratedValue( strategy=GenerationType.SEQUENCE, generator="SEQ_TESTEPAIS_ID")
	@Column(name="pais_id", unique=true)
	private Integer paisId;

	@Column(name="pais_Is_Exc")
	private Boolean paisIsExc;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar paisTsIns;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar paisTsUpd;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar paisTsDel;
	
	@Column(length=10)
	private String paisCod;
	
	@Column(length=50)
	private String paisNome;
	
	@Column(length=2)
	private Character paisSg;
	
	@Column(length=3)
	private Character paisSgAlternativa;
	
	private static final long serialVersionUID = 1L;

	public Pais() {
		super();
	}

	public Integer getPaisId() {
		return this.paisId;
	}

	public void setPaisId(Integer paisId) {
		this.paisId = paisId;
	}

	public Boolean getPaisIsExc() {
		return this.paisIsExc;
	}

	public void setPaisIsExc(Boolean paisIsExc) {
		this.paisIsExc = paisIsExc;
	}

	public Calendar getPaisTsIns() {
		return paisTsIns;
	}

	public void setPaisTsIns(Calendar paisTsIns) {
		this.paisTsIns = paisTsIns;
	}

	public Calendar getPaisTsUpd() {
		return paisTsUpd;
	}

	public void setPaisTsUpd(Calendar paisTsUpd) {
		this.paisTsUpd = paisTsUpd;
	}

	public Calendar getPaisTsDel() {
		return paisTsDel;
	}

	public void setPaisTsDel(Calendar paisTsDel) {
		this.paisTsDel = paisTsDel;
	}

	public String getPaisCod() {
		return paisCod;
	}

	public void setPaisCod(String paisCod) {
		this.paisCod = paisCod;
	}

	public String getPaisNome() {
		return paisNome;
	}

	public void setPaisNome(String paisNome) {
		this.paisNome = paisNome;
	}

	public Character getPaisSg() {
		return paisSg;
	}

	public void setPaisSg(Character paisSg) {
		this.paisSg = paisSg;
	}

	public Character getPaisSgAlternativa() {
		return paisSgAlternativa;
	}

	public void setPaisSgAlternativa(Character paisSgAlternativa) {
		this.paisSgAlternativa = paisSgAlternativa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
