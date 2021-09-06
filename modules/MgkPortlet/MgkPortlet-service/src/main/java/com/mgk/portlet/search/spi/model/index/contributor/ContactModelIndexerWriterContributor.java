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

package com.mgk.portlet.search.spi.model.index.contributor;


import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.mgk.portlet.model.Person;
import com.mgk.portlet.service.PersonLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.function.Consumer;

/**
 * @author Lucas Marques de Paula
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.mgk.portlet.model.Person",
	service = ModelIndexerWriterContributor.class
)
public class ContactModelIndexerWriterContributor implements ModelIndexerWriterContributor<Person> {

	@Override
	public void customize(
		final BatchIndexingActionable batchIndexingActionable,
		final ModelIndexerWriterDocumentHelper
			modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod(
			new Consumer<Person>() {

				@Override
				public void accept(Person person) {
					batchIndexingActionable.addDocuments(
						modelIndexerWriterDocumentHelper.getDocument(person));
				}

			});
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
				contactLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(Person person) {
		return person.getCompanyId();
	}

	@Reference
	protected PersonLocalService contactLocalService;



	@Reference
	protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

}