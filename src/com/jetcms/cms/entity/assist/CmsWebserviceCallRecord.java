package com.jetcms.cms.entity.assist;

import com.jetcms.cms.entity.assist.base.BaseCmsWebserviceCallRecord;



public class CmsWebserviceCallRecord extends BaseCmsWebserviceCallRecord {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsWebserviceCallRecord () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsWebserviceCallRecord (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsWebserviceCallRecord (
		Integer id,
		CmsWebserviceAuth auth,
		String serviceCode,
		java.util.Date recordTime) {

		super (
			id,
			auth,
			serviceCode,
			recordTime);
	}

/*[CONSTRUCTOR MARKER END]*/


}