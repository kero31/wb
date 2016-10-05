package webbati.api.test.util;

public class TestArborescence {

	// @Test
	// public void test() {
	//
	// LigneEtudeImpl velo = new LigneEtudeImpl("velo");
	//
	// LigneEtudeImpl terrestre = new LigneEtudeImpl("terrestre");
	// terrestre.getListLigneEtude().add(velo);
	//
	// LigneEtudeImpl avion = new LigneEtudeImpl("avion");
	//
	// LigneEtudeImpl ulm = new LigneEtudeImpl("ulm");
	//
	// LigneEtudeImpl aerien = new LigneEtudeImpl("aerien");
	// aerien.getListLigneEtude().add(avion);
	// aerien.getListLigneEtude().add(ulm);
	//
	// LigneEtudeImpl transport = new LigneEtudeImpl("transport");
	// transport.getListLigneEtude().add(aerien);
	// transport.getListLigneEtude().add(terrestre);
	//
	// List<ILigneEtude> list = new ArrayList<>();
	// list.add(transport);
	//
	// afficheListLigneEtude(list, 1);
	// }

	/**
	 * Enregistre la liste des ligne étude.
	 * 
	 * @param pListLigneEtude list
	 * @throws WebbatiException
	 */
	// private void afficheListLigneEtude(List<ILigneEtude> pListLigneEtude, Integer pBorneGauche) {
	// if (pListLigneEtude != null) {
	// Integer borneGauche = pBorneGauche;
	// for (ILigneEtude iLigneEtude : pListLigneEtude) {
	//
	// Integer borneDroite = getBorneDroite(iLigneEtude, borneGauche);
	//
	// System.out.println(iLigneEtude + "; gauche=" + borneGauche + "; droite=" + borneDroite);
	// afficheListLigneEtude(iLigneEtude.getListLigneEtude(), borneGauche + 1);
	// borneGauche = borneDroite + 1;
	// }
	// }
	// }

	// private Integer getBorneDroite(ILigneEtude pLigneEtude, Integer pBorneGauche) {
	// Integer borneDroite = 0;
	// if (pLigneEtude != null) {
	// if (pLigneEtude.getListLigneEtude().size() == 0) {
	// borneDroite = pBorneGauche + 1;
	// } else {
	// Integer borneGauche = pBorneGauche;
	// for (ILigneEtude iLigneEtude : pLigneEtude.getListLigneEtude()) {
	// borneDroite = getBorneDroite(iLigneEtude, borneGauche + 1);
	// borneGauche = borneDroite;
	// }
	// borneDroite++;
	// }
	// }
	// return borneDroite;
	// }

}
