package net.fis.hibernate;

import java.util.Date;

/**
 * Aviso generated by MyEclipse - Hibernate Tools
 */

public class Aviso implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8809726008875937889L;

	private Integer aviId;

	private Jugador jugador;

	private String aviEstado;

	private Date aviFecha;

	private String aviTipo;

	// Constructors

	/** default constructor */
	public Aviso() {
	}

	/** full constructor */
	public Aviso(Jugador jugador, String aviEstado, Date aviFecha,
			String aviTipo) {
		this.jugador = jugador;
		this.aviEstado = aviEstado;
		this.aviFecha = aviFecha;
		this.aviTipo = aviTipo;
	}

	// Property accessors

	public Integer getAviId() {
		return this.aviId;
	}

	public void setAviId(Integer aviId) {
		this.aviId = aviId;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public String getAviEstado() {
		return this.aviEstado;
	}

	public void setAviEstado(String aviEstado) {
		this.aviEstado = aviEstado;
	}

	public Date getAviFecha() {
		return this.aviFecha;
	}

	public void setAviFecha(Date aviFecha) {
		this.aviFecha = aviFecha;
	}

	public String getAviTipo() {
		return this.aviTipo;
	}

	public void setAviTipo(String aviTipo) {
		this.aviTipo = aviTipo;
	}

}