package mgkportlet.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import mgkportlet.rest.dto.v1_0.Person;
import mgkportlet.rest.resource.v1_0.PersonResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author USER
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setPersonResourceComponentServiceObjects(
		ComponentServiceObjects<PersonResource>
			personResourceComponentServiceObjects) {

		_personResourceComponentServiceObjects =
			personResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Creates a new person")
	public Person addPerson(@GraphQLName("person") Person person)
		throws Exception {

		return _applyComponentServiceObjects(
			_personResourceComponentServiceObjects,
			this::_populateResourceContext,
			personResource -> personResource.addPerson(person));
	}

	@GraphQLField(description = "Update person")
	public Person updatePerson(@GraphQLName("person") Person person)
		throws Exception {

		return _applyComponentServiceObjects(
			_personResourceComponentServiceObjects,
			this::_populateResourceContext,
			personResource -> personResource.updatePerson(person));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(PersonResource personResource)
		throws Exception {

		personResource.setContextAcceptLanguage(_acceptLanguage);
		personResource.setContextCompany(_company);
		personResource.setContextHttpServletRequest(_httpServletRequest);
		personResource.setContextHttpServletResponse(_httpServletResponse);
		personResource.setContextUriInfo(_uriInfo);
		personResource.setContextUser(_user);
		personResource.setGroupLocalService(_groupLocalService);
		personResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<PersonResource>
		_personResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}