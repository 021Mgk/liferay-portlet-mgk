package mgkportlet.rest.internal.resource.v1_0;

import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.mgk.portlet.model.Person;
import com.mgk.portlet.service.PersonLocalService;
import mgkportlet.rest.dto.v1_0.MGKPerson;
import mgkportlet.rest.internal.dto.v1_0.converter.PersonDTOConverter;
import mgkportlet.rest.resource.v1_0.MGKPersonResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author USER
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/mgk-person.properties",
	scope = ServiceScope.PROTOTYPE, service = MGKPersonResource.class
)
public class MGKPersonResourceImpl extends BaseMGKPersonResourceImpl {
	@Override
	public Page<MGKPerson> getPersonsPage(Long siteId, Integer personId, Pagination pagination) throws Exception {
		System.out.println("siteId = " + siteId);

		return Page.of(
				transform(
						_personLocalService.getPersons(
								siteId,
								0, 20, null),
						this::_toMGKPerson));
	}

	private MGKPerson _toMGKPerson(Person person) throws Exception {
		return _personDTOConverter.toDTO(person);
	}

	@Reference
	private PersonDTOConverter _personDTOConverter;

	@Reference
	private PersonLocalService _personLocalService;
}