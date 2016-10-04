package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IMateriauxEtudeDao;
import webbati.api.metier.ejb.MateriauxEtude;
import webbati.api.metier.impl.MateriauxEtudeImpl;
import webbati.api.metier.interfaces.IMateriauxEtude;

/**
 * Classe <MateriauxEtudeDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_MateriauxEtudeDao")
public class MateriauxEtudeDaoImpl extends MateriauxDaoImpl<MateriauxEtude, MateriauxEtudeImpl, IMateriauxEtude> implements IMateriauxEtudeDao {

	/**
	 * Constructeur.
	 * 
	 */
	public MateriauxEtudeDaoImpl() {
		super(MateriauxEtude.class, MateriauxEtudeImpl.class);
	}
}