/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.mgk.portlet.search.contributor.sort;

import com.liferay.portal.search.contributor.constants.ContributorConstants;
import com.liferay.portal.search.contributor.sort.SortFieldNameTranslator;
import org.osgi.service.component.annotations.Component;

/**
 * @author Lucas Marques de Paula
 */
@Component(
	immediate = true,
	property = ContributorConstants.ENTRY_CLASS_NAME_PROPERTY_KEY + "=com.mgk.portlet.model.Person",
	service = SortFieldNameTranslator.class
)
public class ContactSortFieldNameTranslator implements SortFieldNameTranslator {

	@Override
	public String getSortFieldName(String orderByCol) {
		if (orderByCol.equals("email")) {
			return "email";
		}
//		else if (orderByCol.equals("first-name")) {
//			return "firstName";
//		}
		else if (orderByCol.equals("family")) {
			return "family";
		}
		else if (orderByCol.equals("name")) {
			return "name";
		}

		return orderByCol;
	}

}