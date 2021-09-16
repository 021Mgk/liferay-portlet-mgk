package mgkportlet.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import mgkportlet.rest.internal.graphql.mutation.v1_0.Mutation;
import mgkportlet.rest.internal.graphql.query.v1_0.Query;
import mgkportlet.rest.resource.v1_0.MGKPersonResource;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author USER
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setMGKPersonResourceComponentServiceObjects(
			_mgkPersonResourceComponentServiceObjects);

		Query.setMGKPersonResourceComponentServiceObjects(
			_mgkPersonResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/MgkPortlet-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<MGKPersonResource>
		_mgkPersonResourceComponentServiceObjects;

}