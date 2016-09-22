package batifree.web.beans.ihm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <b>DownloadBean</b><br/>
 *
 */
@ManagedBean
@SessionScoped
public class DownloadBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private StreamedContent file;

	/**
	 * 
	 * Constructeur.
	 * 
	 * @throws BatifreeException
	 */
	public DownloadBean() throws BatifreeException {
		/*InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
		.getResourceAsStream("\\WEB-INF\\classes\\kika.pdf")*/
		InputStream stream = null;
		try {
			InputStream fstream = new FileInputStream(
			        new File(
			                "J:\\Batifree\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\batifree.web.jsf\\WEB-INF\\classes\\kika.pdf"));
			stream = fstream;
			file = new DefaultStreamedContent(stream, "application/pdf", "kika999.pdf");
		} catch (FileNotFoundException e) {
			throw new BatifreeException("Erreur download", e);
		}
	}

	/**
	 * Retourne le StreamedContent
	 * 
	 * @return StreamedContent
	 */
	public StreamedContent getFile() {
		return file;
	}
}