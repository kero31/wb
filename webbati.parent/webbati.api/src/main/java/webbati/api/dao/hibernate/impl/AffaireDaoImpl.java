package webbati.api.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IMetier;
import webbati.api.application.impl.ApplicationWb;
import webbati.api.application.interfaces.IFactoryBf;
import webbati.api.dao.interfaces.IAffaireDao;
import webbati.api.metier.ejb.Acompte;
import webbati.api.metier.ejb.Affaire;
import webbati.api.metier.ejb.Avoir;
import webbati.api.metier.ejb.Devis;
import webbati.api.metier.ejb.Facture;
import webbati.api.metier.ejb.Situation;
import webbati.api.metier.impl.AffaireImpl;
import webbati.api.metier.impl.EcheancierImpl;
import webbati.api.metier.impl.EtudeImpl;
import webbati.api.metier.interfaces.IAcompte;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IAvoir;
import webbati.api.metier.interfaces.IDevis;
import webbati.api.metier.interfaces.IEcheancier;
import webbati.api.metier.interfaces.IEtude;
import webbati.api.metier.interfaces.IFacture;
import webbati.api.metier.interfaces.ISituation;

/**
 * 
 * Classe/Interface <b>AffaireDaoImpl</b><br/>
 *
 * @param <T> Affaire
 * @param <TI> AffaireImpl
 * @param <IT> IAffaire
 */
public abstract class AffaireDaoImpl<T extends Affaire, TI extends AffaireImpl, IT extends IAffaire> extends
        BfGenericHibernateDaoImpl<T, TI, IT, Integer> implements IAffaireDao<IT> {

	private static final Logger LOGGER = Logger.getLogger(AffaireDaoImpl.class);

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pClazz Classe hibernate de l'ejb
	 * @param pClazzI Classe ihm de l'ejb
	 */
	public AffaireDaoImpl(Class<T> pClazz, Class<TI> pClazzI) {
		super(pClazz, pClazzI);
	}

	@Override
	public List<IEcheancier> getListEcheancier(IAffaire pAffaire) throws WebbatiException {
		Affaire affaire = getEjbFromMetier(pAffaire);
		if (affaire != null) {
			return getListMetierFromListEjb(affaire.getEcheanciers(), EcheancierImpl.class, IEcheancier.class);
		}
		return null;
	}

	@Override
	public List<IEtude> getListEtude(IAffaire pAffaire) throws WebbatiException {
		Affaire affaire = getEjbFromMetier(pAffaire);
		if (affaire != null) {
			return getListMetierFromListEjb(affaire.getEtudes(), EtudeImpl.class, IEtude.class);
		}
		return null;
	}

	/**
	 * Retourne la classe AffaireImpl à partir de l'interface métier.
	 * 
	 * @param pInterfaceClass l'interface métier
	 * @param <TT> IMetier
	 * @return classe BibliothequeImpl
	 * @throws WebbatiException
	 */
	@SuppressWarnings("unchecked")
	private static <TT extends IMetier<?>> Class<? extends AffaireImpl> getClassImplFromInterface(Class<TT> pInterfaceClass)
	        throws WebbatiException {
		IFactoryBf factory = ApplicationWb.getApplication().getFactory();
		return (Class<? extends AffaireImpl>) factory.getClassImplementation(pInterfaceClass);
	}

	/**
	 * Retourne la classe AffaireImpl à partir de l'ejb.
	 * 
	 * @param <TEJB> ejb
	 * @param pEjb ejb
	 * @return classe AffaireImpl
	 */
	public static <TEJB> Class<? extends AffaireImpl> getClassImplFromEjb(TEJB pEjb) {
		try {
			if (pEjb instanceof Facture) {
				return getClassImplFromInterface(IFacture.class);
			} else if (pEjb instanceof Situation) {
				return getClassImplFromInterface(ISituation.class);
			} else if (pEjb instanceof Devis) {
				return getClassImplFromInterface(IDevis.class);
			} else if (pEjb instanceof Acompte) {
				return getClassImplFromInterface(IAcompte.class);
			} else if (pEjb instanceof Avoir) {
				return getClassImplFromInterface(IAvoir.class);
			}

		} catch (WebbatiException e) {
			LOGGER.error("getClassImplFromEjb", e);
		}

		return null;
	}

	/**
	 * Retourne la liste des classes Affaire avec la classe Affaire Impl. key=Affaire; value=AffaireImpl.
	 * 
	 * @return liste des classes Affaire avec la classe Affaire Impl
	 */
	public static Map<Class<? extends Affaire>, Class<? extends AffaireImpl>> getMapClassImplWithEjb() {
		Map<Class<? extends Affaire>, Class<? extends AffaireImpl>> map = new HashMap<Class<? extends Affaire>, Class<? extends AffaireImpl>>();
		try {
			map.put(Facture.class, getClassImplFromInterface(IFacture.class));
			map.put(Situation.class, getClassImplFromInterface(ISituation.class));
			map.put(Devis.class, getClassImplFromInterface(IDevis.class));
			map.put(Acompte.class, getClassImplFromInterface(IAcompte.class));
			map.put(Avoir.class, getClassImplFromInterface(IAvoir.class));
		} catch (WebbatiException e) {
			LOGGER.error("getClassImplFromEjb", e);
		}

		return map;
	}

}