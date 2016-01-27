package br.com.agrofacil.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "ge_pais")
public class Pais implements Serializable {

	@Id
	@SequenceGenerator(name = "seq_pais_id", sequenceName = "seq_pais_id", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pais_id")
	@Column(name = "pais_id", unique = true)
	private Integer paisId;

	@NotNull
	@Column(name = "pais_is_exc")
	private Boolean paisIsExc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pais_ts_ins")
	private Calendar paisTsIns;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pais_ts_upd")
	private Calendar paisTsUpd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pais_ts_del")
	private Calendar paisTsDel;

//	@Index(columnList = "pais_cod", unique=true, name="pais_cod")
	@Column(name = "pais_cod", length = 10)
	private String paisCod;

	@NotNull
	@Column(name = "pais_nome", length = 50)
	private String paisNome;

	@Column(name = "pais_sg", length = 2)
	private String paisSg;

	@Column(name = "pais_sg_alternativa", length = 3)
	private String paisSgAlternativa;

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

	public String getPaisSg() {
		return paisSg;
	}

	public void setPaisSg(String paisSg) {
		this.paisSg = paisSg;
	}

	public String getPaisSgAlternativa() {
		return paisSgAlternativa;
	}

	public void setPaisSgAlternativa(String paisSgAlternativa) {
		this.paisSgAlternativa = paisSgAlternativa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
