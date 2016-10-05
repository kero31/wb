/***********************************************************************
 * Module: ICoordonneeCnt.java Author: Kero Purpose: Defines the Interface ICoordonneeCnt
 ***********************************************************************/

package webbati.api.metier.interfaces;

import common.api.exception.WebbatiException;
import common.api.metier.interfaces.IMetier;

/**
 * Interface <b>ICoordonneeCnt</b><br/>
 */
public interface ICoordonneeCnt extends IMetier<Integer> {

	/**
	 * Get Nom
	 * 
	 * @return Nom
	 */
	java.lang.String getNom();

	/**
	 * Set Nom
	 * 
	 * @param pNom Nom
	 */
	void setNom(java.lang.String pNom);

	/**
	 * Get Prenom
	 * 
	 * @return Prenom
	 */
	java.lang.String getPrenom();

	/**
	 * Set Prenom
	 * 
	 * @param pPrenom Prenom
	 */
	void setPrenom(java.lang.String pPrenom);

	/**
	 * Get Rue
	 * 
	 * @return Rue
	 */
	java.lang.String getRue();

	/**
	 * Set Rue
	 * 
	 * @param pRue Rue
	 */
	void setRue(java.lang.String pRue);

	/**
	 * Get Complementaire
	 * 
	 * @return Complementaire
	 */
	java.lang.String getComplementaire();

	/**
	 * Set Complementaire
	 * 
	 * @param pComplementaire Complementaire
	 */
	void setComplementaire(java.lang.String pComplementaire);

	/**
	 * Get CP
	 * 
	 * @return CP
	 */
	java.lang.String getCp();

	/**
	 * Set CP
	 * 
	 * @param pCp CP
	 */
	void setCp(java.lang.String pCp);

	/**
	 * Get Ville
	 * 
	 * @return Ville
	 */
	java.lang.String getVille();

	/**
	 * Set Ville
	 * 
	 * @param pVille Ville
	 */
	void setVille(java.lang.String pVille);

	/**
	 * Get Tel 1
	 * 
	 * @return Tel 1
	 */
	java.lang.String getTel1();

	/**
	 * Set Tel 1
	 * 
	 * @param pTel1 Tel 1
	 */
	void setTel1(java.lang.String pTel1);

	/**
	 * Get Tel 2
	 * 
	 * @return Tel 2
	 */
	java.lang.String getTel2();

	/**
	 * Set Tel 2
	 * 
	 * @param pTel2 Tel 2
	 */
	void setTel2(java.lang.String pTel2);

	/**
	 * Get Fax
	 * 
	 * @return Fax
	 */
	java.lang.String getFax();

	/**
	 * Set Fax
	 * 
	 * @param pFax Fax
	 */
	void setFax(java.lang.String pFax);

	/**
	 * Get Mobile
	 * 
	 * @return Mobile
	 */
	java.lang.String getMobile();

	/**
	 * Set Mobile
	 * 
	 * @param pMobile Mobile
	 */
	void setMobile(java.lang.String pMobile);

	/**
	 * Get Mail
	 * 
	 * @return Mail
	 */
	java.lang.String getMail();

	/**
	 * Set Mail
	 * 
	 * @param pMail Mail
	 */
	void setMail(java.lang.String pMail);

	/**
	 * Get Mail 2
	 * 
	 * @return Mail 2
	 */
	java.lang.String getMail2();

	/**
	 * Set Mail 2
	 * 
	 * @param pMail2 Mail 2
	 */
	void setMail2(java.lang.String pMail2);

	/**
	 * Get Web
	 * 
	 * @return Web
	 */
	java.lang.String getWeb();

	/**
	 * Set Web
	 * 
	 * @param pWeb Web
	 */
	void setWeb(java.lang.String pWeb);

	/**
	 * Get Pays
	 * 
	 * @return Pays
	 * @throws WebbatiException WebbatiException
	 */
	IPays getPays() throws WebbatiException;

	/**
	 * Set Pays
	 * 
	 * @param pPays Pays
	 */
	void setPays(IPays pPays);

	/**
	 * Get Civilite
	 * 
	 * @return Civilite
	 * @throws WebbatiException WebbatiException
	 */
	ICivilite getCivilite() throws WebbatiException;

	/**
	 * Set Civilite
	 * 
	 * @param pCivilite Civilite
	 */
	void setCivilite(ICivilite pCivilite);

	/**
	 * Get Localisation
	 * 
	 * @return Localisation
	 * @throws WebbatiException WebbatiException
	 */
	ILocalisation getLocalisation() throws WebbatiException;

	/**
	 * Set Localisation
	 * 
	 * @param pLocalisation Localisation
	 */
	void setLocalisation(ILocalisation pLocalisation);

}