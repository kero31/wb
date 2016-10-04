/**
 * 
 */
package webbati.api.application.impl;

import common.api.application.impl.FactoryImpl;
import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IMetier;
import webbati.api.application.interfaces.IFactoryBf;
import webbati.api.metier.impl.AcompteImpl;
import webbati.api.metier.impl.ActiviteImpl;
import webbati.api.metier.impl.AvoirImpl;
import webbati.api.metier.impl.BinaireImpl;
import webbati.api.metier.impl.CategorieImpl;
import webbati.api.metier.impl.ChantierImpl;
import webbati.api.metier.impl.CiviliteImpl;
import webbati.api.metier.impl.ClientImpl;
import webbati.api.metier.impl.CoordonneeCntImpl;
import webbati.api.metier.impl.DetailCntImpl;
import webbati.api.metier.impl.DevisImpl;
import webbati.api.metier.impl.DiversCntImpl;
import webbati.api.metier.impl.EcheancierImpl;
import webbati.api.metier.impl.EcheancierReglementImpl;
import webbati.api.metier.impl.EnginBibImpl;
import webbati.api.metier.impl.EnginEtudeImpl;
import webbati.api.metier.impl.EtatImpl;
import webbati.api.metier.impl.EtudeImpl;
import webbati.api.metier.impl.FactureImpl;
import webbati.api.metier.impl.FamilleImpl;
import webbati.api.metier.impl.FournisseurImpl;
import webbati.api.metier.impl.FournisseurMateriauxImpl;
import webbati.api.metier.impl.GroupeCntImpl;
import webbati.api.metier.impl.ImageImpl;
import webbati.api.metier.impl.LocalisationImpl;
import webbati.api.metier.impl.LotBibImpl;
import webbati.api.metier.impl.LotEtudeImpl;
import webbati.api.metier.impl.MainOeuvreBibImpl;
import webbati.api.metier.impl.MainOeuvreEtudeImpl;
import webbati.api.metier.impl.MateriauxBibImpl;
import webbati.api.metier.impl.MateriauxEtudeImpl;
import webbati.api.metier.impl.ModePaiementImpl;
import webbati.api.metier.impl.PaysImpl;
import webbati.api.metier.impl.ReglementImpl;
import webbati.api.metier.impl.SituationImpl;
import webbati.api.metier.impl.SousTraitantBibImpl;
import webbati.api.metier.impl.SousTraitantEtudeImpl;
import webbati.api.metier.impl.TacheBibImpl;
import webbati.api.metier.impl.TacheEtudeImpl;
import webbati.api.metier.impl.TvaImpl;
import webbati.api.metier.interfaces.IAcompte;
import webbati.api.metier.interfaces.IActivite;
import webbati.api.metier.interfaces.IAffaire;
import webbati.api.metier.interfaces.IAffaireDevis;
import webbati.api.metier.interfaces.IAvoir;
import webbati.api.metier.interfaces.IBinaire;
import webbati.api.metier.interfaces.ICategorie;
import webbati.api.metier.interfaces.IChantier;
import webbati.api.metier.interfaces.ICivilite;
import webbati.api.metier.interfaces.IClient;
import webbati.api.metier.interfaces.ICoordonneeCnt;
import webbati.api.metier.interfaces.IDetailCnt;
import webbati.api.metier.interfaces.IDevis;
import webbati.api.metier.interfaces.IDiversCnt;
import webbati.api.metier.interfaces.IEcheancier;
import webbati.api.metier.interfaces.IEcheancierReglement;
import webbati.api.metier.interfaces.IEnginBib;
import webbati.api.metier.interfaces.IEnginEtude;
import webbati.api.metier.interfaces.IEtat;
import webbati.api.metier.interfaces.IEtude;
import webbati.api.metier.interfaces.IFacture;
import webbati.api.metier.interfaces.IFamille;
import webbati.api.metier.interfaces.IFournisseur;
import webbati.api.metier.interfaces.IFournisseurMateriaux;
import webbati.api.metier.interfaces.IGroupeCnt;
import webbati.api.metier.interfaces.IImage;
import webbati.api.metier.interfaces.ILocalisation;
import webbati.api.metier.interfaces.ILotBib;
import webbati.api.metier.interfaces.ILotEtude;
import webbati.api.metier.interfaces.IMainOeuvreBib;
import webbati.api.metier.interfaces.IMainOeuvreEtude;
import webbati.api.metier.interfaces.IMateriauxBib;
import webbati.api.metier.interfaces.IMateriauxEtude;
import webbati.api.metier.interfaces.IModePaiement;
import webbati.api.metier.interfaces.IPays;
import webbati.api.metier.interfaces.IReglement;
import webbati.api.metier.interfaces.ISituation;
import webbati.api.metier.interfaces.ISousTraitantBib;
import webbati.api.metier.interfaces.ISousTraitantEtude;
import webbati.api.metier.interfaces.ITacheBib;
import webbati.api.metier.interfaces.ITacheEtude;
import webbati.api.metier.interfaces.ITva;

/**
 * Classe <b>FactoryWb</b>.
 * 
 */
public class FactoryWbImpl extends FactoryImpl implements IFactoryBf {

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
	public IEcheancierReglement createNewInstanceEcheancierReglement(IEcheancier pEcheancier, IReglement pReglement) throws WebbatiException {
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
