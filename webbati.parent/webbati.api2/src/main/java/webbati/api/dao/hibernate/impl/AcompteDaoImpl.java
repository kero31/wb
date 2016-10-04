package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IAcompteDao;
import webbati.api.metier.ejb.Acompte;
import webbati.api.metier.impl.AcompteImpl;
import webbati.api.metier.interfaces.IAcompte;

/**
 * Classe <AcompteDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_AcompteDao")
public class AcompteDaoImpl extends AffaireDaoImpl<Acompte, AcompteImpl, IAcompte> implements IAcompteDao {

	/**
	 * Constructeur.
	 * 
	 */
	public AcompteDaoImpl() {
		super(Acompte.class, AcompteImpl.class);
	}

}