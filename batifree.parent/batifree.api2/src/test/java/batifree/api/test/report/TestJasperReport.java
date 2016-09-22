/**
 * 
 */
package batifree.api.test.report;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import batifree.api.test.commun.TestCommunBfApi;

import common.api.application.interfaces.IImpression.FormatOut;
import common.api.exception.BatifreeException;

/**
 * @author Kero
 * 
 */
public class TestJasperReport extends TestCommunBfApi {

	@Test
	public void generateReport() throws BatifreeException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_activite", 2);
		// TODO Ajouter constance dans IPropertiesApp
		app.getImpression().generateReport("report1", FormatOut.PDF, params, app.getProperties().getProperty("report.directory.out") + "kika.pdf",
		        app);
	}
}
