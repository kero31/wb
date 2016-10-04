package admin.api.dao.hibernate.util;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

/**
 * 
 * Classe/Interface <b>AdminHibernateStrategy</b><br/>
 *
 */
public class AdminHibernateStrategy extends DelegatingReverseEngineeringStrategy {

	/**
	 * 
	 * Constructeur.
	 * 
	 * @param pDelegate ReverseEngineeringStrategy
	 */
	public AdminHibernateStrategy(ReverseEngineeringStrategy pDelegate) {
		super(pDelegate);
	}

	@Override
	public String columnToPropertyName(TableIdentifier pTable, String pColumn) {
		String prop = "";
		int underscoreIndex = pColumn.indexOf('_');
		prop = pColumn.substring(underscoreIndex + 1).toLowerCase();
		while (prop.indexOf('_') != -1) {
			int i = prop.indexOf('_');
			String first = prop.substring(0, i);
			String car = "";
			String last = "";
			if (prop.length() == i + 2) {
				car = prop.substring(i + 1);
			} else if (prop.length() > i + 2) {
				car = prop.substring(i + 1, i + 2);
				last = prop.substring(i + 2);
			}
			prop = first + car.toUpperCase() + last;
		}
		return prop;
	}
}