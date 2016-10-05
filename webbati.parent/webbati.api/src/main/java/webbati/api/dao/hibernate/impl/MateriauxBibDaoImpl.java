package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IMateriauxBibDao;
import webbati.api.metier.ejb.MateriauxBib;
import webbati.api.metier.impl.MateriauxBibImpl;
import webbati.api.metier.interfaces.IMateriauxBib;

/**
 * Classe <MateriauxBibDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_MateriauxBibDao")
public class MateriauxBibDaoImpl extends MateriauxDaoImpl<MateriauxBib, MateriauxBibImpl, IMateriauxBib> implements IMateriauxBibDao {

	/**
	 * Constructeur.
	 * 
	 */
	public MateriauxBibDaoImpl() {
		super(MateriauxBib.class, MateriauxBibImpl.class);
	}
}