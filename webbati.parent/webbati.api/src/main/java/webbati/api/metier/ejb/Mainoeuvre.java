package webbati.api.metier.ejb;

// Generated 4 avr. 2014 20:19:57 by Hibernate Tools 4.0.0

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Mainoeuvre generated by hbm2java
 */
@Entity
@Table(name = "MAINOEUVRE")
@PrimaryKeyJoinColumn(name = "BIB_ID", referencedColumnName = "BIB_ID")
@SuppressWarnings("serial")
public class Mainoeuvre extends Bibliotheque implements java.io.Serializable {

}
