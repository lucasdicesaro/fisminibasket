package net.fis.hibernate;


import java.util.HashSet;
import java.util.Set;


/**
 * Club generated by MyEclipse - Hibernate Tools
 */

public class Club implements java.io.Serializable
{

    // Fields

    /**
     * 
     */
    private static final long serialVersionUID = -2666969818842662829L;

    private ClubId            id;

    private String            cluDescripcion;

    private String            cluFederado;

    private Set               jugadors         = new HashSet(0);

    // Constructors

    /** default constructor */
    public Club() {
    }

    /** minimal constructor */
    public Club(String cluDescripcion, String cluFederado) {
        this.cluDescripcion = cluDescripcion;
        this.cluFederado = cluFederado;
    }

    /** full constructor */
    public Club(String cluDescripcion, String cluFederado, Set jugadors) {
        this.cluDescripcion = cluDescripcion;
        this.cluFederado = cluFederado;
        this.jugadors = jugadors;
    }

    // Property accessors

    public ClubId getId()
    {
        return this.id;
    }

    public void setId(ClubId id)
    {
        this.id = id;
    }

    public String getCluDescripcion()
    {
        return this.cluDescripcion;
    }

    public void setCluDescripcion(String cluDescripcion)
    {
        this.cluDescripcion = cluDescripcion;
    }

    public String getCluFederado()
    {
        return this.cluFederado;
    }

    public void setCluFederado(String cluFederado)
    {
        this.cluFederado = cluFederado;
    }

    public Set getJugadors()
    {
        return this.jugadors;
    }

    public void setJugadors(Set jugadors)
    {
        this.jugadors = jugadors;
    }

}
