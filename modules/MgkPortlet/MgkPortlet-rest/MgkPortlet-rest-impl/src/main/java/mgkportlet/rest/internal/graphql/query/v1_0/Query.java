package mgkportlet.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Map;
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
public class Query {

	public static void setPersonResourceComponentServiceObjects(
		ComponentServiceObjects<PersonResource>
			personResourceComponentServiceObjects) {

		_personResourceComponentServiceObjects =
			personResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {persons(page: ___, pageSize: ___, personId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the persons. Results can be paginated."
	)
	public PersonPage persons(
			@GraphQLName("personId") Integer personId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_personResourceComponentServiceObjects,
			this::_populateResourceContext,
			personResource -> new PersonPage(
				personResource.getPersonsPage(
					personId, Pagination.of(page, pageSize))));
	}

	@GraphQLName("PersonPage")
	public class PersonPage {

		public PersonPage(Page personPage) {
			actions = personPage.getActions();

			items = personPage.getItems();
			lastPage = personPage.getLastPage();
			page = personPage.getPage();
			pageSize = personPage.getPageSize();
			totalCount = personPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Person> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}