package batifree.api.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import batifree.api.dao.interfaces.IImageDao;
import batifree.api.metier.ejb.Image;
import batifree.api.metier.impl.ImageImpl;
import batifree.api.metier.interfaces.IImage;

/**
 * Classe <ImageDaoImpl>.
 * 
 * 
 * 
 */
@Repository("BF_ImageDao")
public class ImageDaoImpl extends BfGenericHibernateDaoImpl<Image, ImageImpl, IImage, Integer> implements IImageDao {

	/**
	 * Constructeur.
	 * 
	 */
	public ImageDaoImpl() {
		super(Image.class, ImageImpl.class);
	}
}