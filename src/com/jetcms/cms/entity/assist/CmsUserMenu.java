package com.jetcms.cms.entity.assist;

import com.jetcms.cms.entity.assist.base.BaseCmsUserMenu;



public class CmsUserMenu extends BaseCmsUserMenu {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsUserMenu () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsUserMenu (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsUserMenu (
		Integer id,
		com.jetcms.core.entity.CmsUser user,
		String name,
		String url,
		Integer priority) {

		super (
			id,
			user,
			name,
			url,
			priority);
	}

/*[CONSTRUCTOR MARKER END]*/


}