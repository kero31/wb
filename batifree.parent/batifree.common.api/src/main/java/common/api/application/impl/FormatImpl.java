package common.api.application.impl;

import java.util.Date;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import common.api.application.interfaces.IFormat;

/**
 * 
 * Classe/Interface <FormatImpl>
 *
 */
@Service("Format")
public class FormatImpl implements IFormat {

	public static final String NULL_VALUE = "";
	public static final String DATE_FORMAT = "dd/MM/yyyy";

	@Override
	public String toString(String pValue) {
		return (pValue == null) ? NULL_VALUE : pValue;
	}

	@Override
	public String toStringJS(String pValue) {
		return toString(pValue).replace("\"", "\\\"");
	}

	@Override
	public String toString(BigDecimal pValue) {
		String ret = "";
		if (pValue == null) {
			ret = "0";
		} else {
			ret = pValue.toString();
		}

		return ret;
	}

	@Override
	public String toString(Date pValue) {
		String ret = "";
		if (pValue == null) {
			ret = NULL_VALUE;
		} else {
			SimpleDateFormat formatDateJour = new SimpleDateFormat(DATE_FORMAT);
			ret = formatDateJour.format(pValue);
		}

		return ret;
	}

	@Override
	public String toString(Object pObj) {
		if (pObj != null) {
			if (String.class.equals(pObj.getClass())) {
				return toString((String) pObj);
			} else if (BigDecimal.class.equals(pObj.getClass())) {
				return toString((BigDecimal) pObj);
			} else {
				return pObj.toString();
			}
		}

		return NULL_VALUE;
	}
}
