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

package com.mgk.portlet.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.mgk.portlet.model.Person;
import com.mgk.portlet.service.base.PersonLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the person local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.mgk.portlet.service.PersonLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author 021mgk
 * @see PersonLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.mgk.portlet.model.Person",
	service = AopService.class
)
public class PersonLocalServiceImpl extends PersonLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.mgk.portlet.service.PersonLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.mgk.portlet.service.PersonLocalServiceUtil</code>.
	 */

	@Indexable(type = IndexableType.REINDEX)
	public Person addPerson(long pId, String name, String family, String email,
							String address, String phoneNumber, String nationalCode,
							String description, String image, ServiceContext serviceContext) throws PortalException {

		long groupId = serviceContext.getScopeGroupId();
		User user = userLocalService.getUserById(pId);
		Date now = new Date();

		long personId = counterLocalService.increment();


		Person person = personPersistence.create(personId);

		person.setUuid(serviceContext.getUuid());
		person.setUserId(pId);
		person.setGroupId(groupId);
		person.setCompanyId(user.getCompanyId());
		person.setUserName(user.getFullName());

		person.setCreateDate(serviceContext.getCreateDate(now));
		person.setModifiedDate(serviceContext.getModifiedDate(now));

		person.setName(name);
		person.setFamily(family);
		person.setEmail(email);
		person.setAddress(address);
		person.setPhoneNumber(phoneNumber);
		person.setNationalCode(nationalCode);
		person.setDescription(description);
		person.setRegisterDate(now);
		person.setImage(image);
		person.setExpandoBridgeAttributes(serviceContext);


		personPersistence.update(person);
//
//		resourceLocalService.addResources(user.getCompanyId(), groupId, pId,
//				Person.class.getName(), personId, false, true, true);

		return person;

	}

	@Indexable(type = IndexableType.REINDEX)
	public Person updatePerson(long pId, long personId, String name, String family, String email,
							   String address, String phoneNumber, String nationalCode,
							   String description, String image, ServiceContext serviceContext) throws PortalException {
		Date now = new Date();

		Person person = getPerson(personId);


		User user = userLocalService.getUser(pId);

		person.setUserId(pId);
		person.setUserName(user.getFullName());
		person.setModifiedDate(serviceContext.getModifiedDate(now));


		person.setName(name);
		person.setFamily(family);
		person.setEmail(email);
		person.setAddress(address);
		person.setPhoneNumber(phoneNumber);
		person.setNationalCode(nationalCode);
		person.setDescription(description);
		person.setRegisterDate(now);
		person.setImage(image);
		person.setExpandoBridgeAttributes(serviceContext);

		personPersistence.update(person);

//		resourceLocalService.updateResources(serviceContext.getCompanyId(),
//				serviceContext.getScopeGroupId(),
//				Person.class.getName(), personId,
//				serviceContext.getModelPermissions());

		return person;

	}


	@Indexable(type = IndexableType.DELETE)
	public Person deletePerson(long personId,
							   ServiceContext serviceContext) throws PortalException,
			SystemException {

		Person person = getPerson(personId);

		Person person1 = deletePerson(person);

//		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
//				Person.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
//				personId);

		return person1;

	}


	public List<Person> getPersons(long groupId) {
		return personPersistence.findByGroupId(groupId);
	}

	public List<Person> getPersons(long groupId, int start, int end, OrderByComparator<Person> obc) {
		return personPersistence.findByGroupId(groupId, start, end, obc);
	}

	public List<Person> getPersons(long groupId, int start, int end) {
		return personPersistence.findByGroupId(groupId, start, end);
	}

	public int getPersonsCount(long groupId) {
		return personPersistence.countByGroupId(groupId);
	}


}