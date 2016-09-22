package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IMateriauxEtudeDao;
import batifree.api.metier.ejb.MateriauxEtude;
import batifree.api.metier.impl.MateriauxEtudeImpl;
import batifree.api.metier.interfaces.IMateriauxEtude;

/**
 * Classe <MateriauxEtudeDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_MateriauxEtudeDao")
public class MateriauxEtudeDaoImpl extends MateriauxDaoImpl<MateriauxEtude, MateriauxEtudeImpl, IMateriauxEtude> implements IMateriauxEtudeDao {

	/**
	 * Constructeur.
	 * 
	 */
	public MateriauxEtudeDaoImpl() {
		super(MateriauxEtude.class, MateriauxEtudeImpl.class);
	}
}