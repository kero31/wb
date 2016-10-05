package webbati.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import webbati.api.application.impl.ApplicationWb;
import webbati.api.dao.interfaces.IImageDao;
import webbati.api.metier.ejb.Image;
import webbati.api.metier.impl.ImageImpl;
import webbati.api.metier.interfaces.IImage;

/**
 * Classe <ImageDaoImpl>.
 * 
 * 
 * 
 */
@Repository(ApplicationWb.CODE_PROJECT + "_ImageDao")
public class ImageDaoImpl extends BfGenericHibernateDaoImpl<Image, ImageImpl, IImage, Integer> implements IImageDao {

	/**
	 * Constructeur.
	 * 
	 */
	public ImageDaoImpl() {
		super(Image.class, ImageImpl.class);
	}
}