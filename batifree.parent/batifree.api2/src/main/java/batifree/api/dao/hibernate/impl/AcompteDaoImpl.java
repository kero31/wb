package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IAcompteDao;
import batifree.api.metier.ejb.Acompte;
import batifree.api.metier.impl.AcompteImpl;
import batifree.api.metier.interfaces.IAcompte;

/**
 * Classe <AcompteDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_AcompteDao")
public class AcompteDaoImpl extends AffaireDaoImpl<Acompte, AcompteImpl, IAcompte> implements IAcompteDao {

	/**
	 * Constructeur.
	 * 
	 */
	public AcompteDaoImpl() {
		super(Acompte.class, AcompteImpl.class);
	}

}