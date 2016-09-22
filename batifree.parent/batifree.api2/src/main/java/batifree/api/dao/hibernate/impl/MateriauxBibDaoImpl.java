package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IMateriauxBibDao;
import batifree.api.metier.ejb.MateriauxBib;
import batifree.api.metier.impl.MateriauxBibImpl;
import batifree.api.metier.interfaces.IMateriauxBib;

/**
 * Classe <MateriauxBibDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_MateriauxBibDao")
public class MateriauxBibDaoImpl extends MateriauxDaoImpl<MateriauxBib, MateriauxBibImpl, IMateriauxBib> implements IMateriauxBibDao {

	/**
	 * Constructeur.
	 * 
	 */
	public MateriauxBibDaoImpl() {
		super(MateriauxBib.class, MateriauxBibImpl.class);
	}
}