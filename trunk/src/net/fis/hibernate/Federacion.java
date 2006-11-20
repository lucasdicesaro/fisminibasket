package net.fis.hibernate;


import java.util.HashSet;
import java.util.Set;


/**
 * Federacion generated by MyEclipse - Hibernate Tools
 */

public class Federacion implements java.io.Serializable
{

    // Fields

    /**
     * 
     */
    private static final long serialVersionUID = 6449904407149273811L;

    private Integer           federacionId;

    private String            fedDescripcion;

    private Set               clubs            = new HashSet(0);

    // Constructors

    /** default constructor */
    public Federacion() {
    }

    /** minimal constructor */
    public Federacion(String fedDescripcion) {
        this.fedDescripcion = fedDescripcion;
    }

    /** full constructor */
    public Federacion(String fedDescripcion, Set clubs) {
        this.fedDescripcion = fedDescripcion;
        this.clubs = clubs;
    }

    // Property accessors

    public Integer getFederacionId()
    {
        return this.federacionId;
    }

    public void setFederacionId(Integer federacionId)
    {
        this.federacionId = federacionId;
    }

    public String getFedDescripcion()
    {
        return this.fedDescripcion;
    }

    public void setFedDescripcion(String fedDescripcion)
    {
        this.fedDescripcion = fedDescripcion;
    }

    public Set getClubs()
    {
        return this.clubs;
    }

    public void setClubs(Set clubs)
    {
        this.clubs = clubs;
    }

}
