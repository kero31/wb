/**
 * 
 */
package batifree.api.application.impl;

import batifree.api.application.interfaces.IFactoryBf;
import batifree.api.metier.impl.AcompteImpl;
import batifree.api.metier.impl.ActiviteImpl;
import batifree.api.metier.impl.AvoirImpl;
import batifree.api.metier.impl.BinaireImpl;
import batifree.api.metier.impl.CategorieImpl;
import batifree.api.metier.impl.ChantierImpl;
import batifree.api.metier.impl.CiviliteImpl;
import batifree.api.metier.impl.ClientImpl;
import batifree.api.metier.impl.CoordonneeCntImpl;
import batifree.api.metier.impl.DetailCntImpl;
import batifree.api.metier.impl.DevisImpl;
import batifree.api.metier.impl.DiversCntImpl;
import batifree.api.metier.impl.EcheancierImpl;
import batifree.api.metier.impl.EcheancierReglementImpl;
import batifree.api.metier.impl.EnginBibImpl;
import batifree.api.metier.impl.EnginEtudeImpl;
import batifree.api.metier.impl.EtatImpl;
import batifree.api.metier.impl.EtudeImpl;
import batifree.api.metier.impl.FactureImpl;
import batifree.api.metier.impl.FamilleImpl;
import batifree.api.metier.impl.FournisseurImpl;
import batifree.api.metier.impl.FournisseurMateriauxImpl;
import batifree.api.metier.impl.GroupeCntImpl;
import batifree.api.metier.impl.ImageImpl;
import batifree.api.metier.impl.LocalisationImpl;
import batifree.api.metier.impl.LotBibImpl;
import batifree.api.metier.impl.LotEtudeImpl;
import batifree.api.metier.impl.MainOeuvreBibImpl;
import batifree.api.metier.impl.MainOeuvreEtudeImpl;
import batifree.api.metier.impl.MateriauxBibImpl;
import batifree.api.metier.impl.MateriauxEtudeImpl;
import batifree.api.metier.impl.ModePaiementImpl;
import batifree.api.metier.impl.PaysImpl;
import batifree.api.metier.impl.ReglementImpl;
import batifree.api.metier.impl.SituationImpl;
import batifree.api.metier.impl.SousTraitantBibImpl;
import batifree.api.metier.impl.SousTraitantEtudeImpl;
import batifree.api.metier.impl.TacheBibImpl;
import batifree.api.metier.impl.TacheEtudeImpl;
import batifree.api.metier.impl.TvaImpl;
import batifree.api.metier.interfaces.IAcompte;
import batifree.api.metier.interfaces.IActivite;
import batifree.api.metier.interfaces.IAffaire;
import batifree.api.metier.interfaces.IAffaireDevis;
import batifree.api.metier.interfaces.IAvoir;
import batifree.api.metier.interfaces.IBinaire;
import batifree.api.metier.interfaces.ICategorie;
import batifree.api.metier.interfaces.IChantier;
import batifree.api.metier.interfaces.ICivilite;
import batifree.api.metier.interfaces.IClient;
import batifree.api.metier.interfaces.ICoordonneeCnt;
import batifree.api.metier.interfaces.IDetailCnt;
import batifree.api.metier.interfaces.IDevis;
import batifree.api.metier.interfaces.IDiversCnt;
import batifree.api.metier.interfaces.IEcheancier;
import batifree.api.metier.interfaces.IEcheancierReglement;
import batifree.api.metier.interfaces.IEnginBib;
import batifree.api.metier.interfaces.IEnginEtude;
import batifree.api.metier.interfaces.IEtat;
import batifree.api.metier.interfaces.IEtude;
import batifree.api.metier.interfaces.IFacture;
import batifree.api.metier.interfaces.IFamille;
import batifree.api.metier.interfaces.IFournisseur;
import batifree.api.metier.interfaces.IFournisseurMateriaux;
import batifree.api.metier.interfaces.IGroupeCnt;
import batifree.api.metier.interfaces.IImage;
import batifree.api.metier.interfaces.ILocalisation;
import batifree.api.metier.interfaces.ILotBib;
import batifree.api.metier.interfaces.ILotEtude;
import batifree.api.metier.interfaces.IMainOeuvreBib;
import batifree.api.metier.interfaces.IMainOeuvreEtude;
import batifree.api.metier.interfaces.IMateriauxBib;
import batifree.api.metier.interfaces.IMateriauxEtude;
import batifree.api.metier.interfaces.IModePaiement;
import batifree.api.metier.interfaces.IPays;
import batifree.api.metier.interfaces.IReglement;
import batifree.api.metier.interfaces.ISituation;
import batifree.api.metier.interfaces.ISousTraitantBib;
import batifree.api.metier.interfaces.ISousTraitantEtude;
import batifree.api.metier.interfaces.ITacheBib;
import batifree.api.metier.interfaces.ITacheEtude;
import batifree.api.metier.interfaces.ITva;

import common.api.application.impl.FactoryImpl;
import common.api.exception.BatifreeException;
import common.api.metier.interfaces.IMetier;

/**
 * Classe <b>FactoryBf</b>.
 * 
 */
public class FactoryBfImpl extends FactoryImpl implements IFactoryBf {

	/**
	 * Retourne l'implémentation métier Etude avec son affaire.
	 * 
	 * @param pAffaire l'affaire
	 * @return implémentation métier Etude
	 */
	@Override
	public IEtude createNewInstanceEtude(IAffaire pAffaire) {
		return new EtudeImpl(pAffaire);
	}

	@Override
	public <IT extends IMetier<?>> Class<?> getClassImplementation(IT pInterface, Class<IT> pInterfaceClass) {
		Class<?> clazz = null;

		if (pInterfaceClass == IDevis.class || pInterface instanceof IDevis) {
			clazz = DevisImpl.class;
		} else if (pInterfaceClass == IFacture.class || pInterface instanceof IFacture) {
			clazz = FactureImpl.class;
		} else if (pInterfaceClass == ISituation.class || pInterface instanceof ISituation) {
			clazz = SituationImpl.class;
		} else if (pInterfaceClass == IAvoir.class || pInterface instanceof IAvoir) {
			clazz = AvoirImpl.class;
		} else if (pInterfaceClass == IAcompte.class || pInterface instanceof IAcompte) {
			clazz = AcompteImpl.class;
		} else if (pInterfaceClass == ITva.class || pInterface instanceof ITva) {
			clazz = TvaImpl.class;
		} else if (pInterfaceClass == IMateriauxBib.class || pInterface instanceof IMateriauxBib) {
			clazz = MateriauxBibImpl.class;
		} else if (pInterfaceClass == IMainOeuvreBib.class || pInterface instanceof IMainOeuvreBib) {
			clazz = MainOeuvreBibImpl.class;
		} else if (pInterfaceClass == IEnginBib.class || pInterface instanceof IEnginBib) {
			clazz = EnginBibImpl.class;
		} else if (pInterfaceClass == ISousTraitantBib.class || pInterface instanceof ISousTraitantBib) {
			clazz = SousTraitantBibImpl.class;
		} else if (pInterfaceClass == ITacheBib.class || pInterface instanceof ITacheBib) {
			clazz = TacheBibImpl.class;
		} else if (pInterfaceClass == ILotBib.class || pInterface instanceof ILotBib) {
			clazz = LotBibImpl.class;
		} else if (pInterfaceClass == IFournisseurMateriaux.class || pInterface instanceof IFournisseurMateriaux) {
			clazz = FournisseurMateriauxImpl.class;
		} else if (pInterfaceClass == IFournisseur.class || pInterface instanceof IFournisseur) {
			clazz = FournisseurImpl.class;
		} else if (pInterfaceClass == IFamille.class || pInterface instanceof IFamille) {
			clazz = FamilleImpl.class;
		} else if (pInterfaceClass == IImage.class || pInterface instanceof IImage) {
			clazz = ImageImpl.class;
		} else if (pInterfaceClass == IBinaire.class || pInterface instanceof IBinaire) {
			clazz = BinaireImpl.class;
		} else if (pInterfaceClass == IClient.class || pInterface instanceof IClient) {
			clazz = ClientImpl.class;
		} else if (pInterfaceClass == ICoordonneeCnt.class || pInterface instanceof ICoordonneeCnt) {
			clazz = CoordonneeCntImpl.class;
		} else if (pInterfaceClass == IDetailCnt.class || pInterface instanceof IDetailCnt) {
			clazz = DetailCntImpl.class;
		} else if (pInterfaceClass == IDiversCnt.class || pInterface instanceof IDiversCnt) {
			clazz = DiversCntImpl.class;
		} else if (pInterfaceClass == IGroupeCnt.class || pInterface instanceof IGroupeCnt) {
			clazz = GroupeCntImpl.class;
		} else if (pInterfaceClass == ILocalisation.class || pInterface instanceof ILocalisation) {
			clazz = LocalisationImpl.class;
		} else if (pInterfaceClass == IPays.class || pInterface instanceof IPays) {
			clazz = PaysImpl.class;
		} else if (pInterfaceClass == ICivilite.class || pInterface instanceof ICivilite) {
			clazz = CiviliteImpl.class;
		} else if (pInterfaceClass == IActivite.class || pInterface instanceof IActivite) {
			clazz = ActiviteImpl.class;
		} else if (pInterfaceClass == ICategorie.class || pInterface instanceof ICategorie) {
			clazz = CategorieImpl.class;
		} else if (pInterfaceClass == IEtat.class || pInterface instanceof IEtat) {
			clazz = EtatImpl.class;
		} else if (pInterfaceClass == IEcheancier.class || pInterface instanceof IEcheancier) {
			clazz = EcheancierImpl.class;
		} else if (pInterfaceClass == IReglement.class || pInterface instanceof IReglement) {
			clazz = ReglementImpl.class;
		} else if (pInterfaceClass == IChantier.class || pInterface instanceof IChantier) {
			clazz = ChantierImpl.class;
		} else if (pInterfaceClass == IMateriauxEtude.class || pInterface instanceof IMateriauxEtude) {
			clazz = MateriauxEtudeImpl.class;
		} else if (pInterfaceClass == IMainOeuvreEtude.class || pInterface instanceof IMainOeuvreEtude) {
			clazz = MainOeuvreEtudeImpl.class;
		} else if (pInterfaceClass == IEnginEtude.class || pInterface instanceof IEnginEtude) {
			clazz = EnginEtudeImpl.class;
		} else if (pInterfaceClass == ISousTraitantEtude.class || pInterface instanceof ISousTraitantEtude) {
			clazz = SousTraitantEtudeImpl.class;
		} else if (pInterfaceClass == ILotEtude.class || pInterface instanceof ILotEtude) {
			clazz = LotEtudeImpl.class;
		} else if (pInterfaceClass == ITacheEtude.class || pInterface instanceof ITacheEtude) {
			clazz = TacheEtudeImpl.class;
		} else if (pInterfaceClass == IModePaiement.class || pInterface instanceof IModePaiement) {
			clazz = ModePaiementImpl.class;
		}

		return clazz;
	}

	@Override
	public IEcheancierReglement createNewInstanceEcheancierReglement(IEcheancier pEcheancier, IReglement pReglement) throws BatifreeException {
		return new EcheancierReglementImpl(pEcheancier, pReglement);
	}

	@Override
	public <IT extends IAffaire> IT createNewInstanceAffaire(Class<IT> pInterfaceClass, IDevis pDevis) {
		IT affaire = createNewInstance(pInterfaceClass);
		if (affaire instanceof IAffaireDevis) {
			IAffaireDevis affaireDevis = (IAffaireDevis) affaire;
			affaireDevis.setDevis(pDevis);
		}
		return affaire;
	}

	@Override
	public IEcheancier createNewInstanceEcheancier(IAffaire pAffaire) {
		return new EcheancierImpl(pAffaire);
	}
}
