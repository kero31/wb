/**
 * 
 */
package common.api.metier.ejb;

/**
 * Classe <b>ILigneEjb</b>.
 * 
 */
public interface ILigneEjb {

	/**
	 * Retourne la borne gauche.
	 * 
	 * @return borne gauche
	 */
	Integer getBorneGauche();

	/**
	 * Met à jour la borne gauche.
	 * 
	 * @param pBorneGauche borne gauche
	 */
	void setBorneGauche(Integer pBorneGauche);

	/**
	 * Retourne la borne droite.
	 * 
	 * @return borne droite
	 */
	Integer getBorneDroite();

	/**
	 * Met à jour la borne gauche.
	 * 
	 * @param pBorneDroite borne droite
	 */
	void setBorneDroite(Integer pBorneDroite);

	/**
	 * Retourne le niveau.
	 * 
	 * @return niveau
	 */
	Integer getNiveau();

	/**
	 * Met à jour le niveau.
	 * 
	 * @param pNiveau niveau
	 */
	void setNiveau(Integer pNiveau);

	/**
	 * Retourne le super parent id.
	 * 
	 * @return super parent id
	 */
	Integer getSuperParentId();

	/**
	 * Met à jour le super parent id.
	 * 
	 * @param pSuperParentId super parent id
	 */
	void setSuperParentId(Integer pSuperParentId);

	/**
	 * Retourne l'id.
	 * 
	 * @return l'id
	 */
	Integer getId();

	/**
	 * Met à jour l'id.
	 * 
	 * @param pId l'id
	 */
	void setId(Integer pId);
}
