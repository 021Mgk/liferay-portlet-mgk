package mgkportlet.rest.client.resource.v1_0;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

import mgkportlet.rest.client.dto.v1_0.MGKPerson;
import mgkportlet.rest.client.http.HttpInvoker;
import mgkportlet.rest.client.pagination.Page;
import mgkportlet.rest.client.pagination.Pagination;
import mgkportlet.rest.client.problem.Problem;
import mgkportlet.rest.client.serdes.v1_0.MGKPersonSerDes;

/**
 * @author USER
 * @generated
 */
@Generated("")
public interface MGKPersonResource {

	public static Builder builder() {
		return new Builder();
	}

	public Page<MGKPerson> getPersonsPage(
			Long siteId, Integer personId, Pagination pagination)
		throws Exception;

	public HttpInvoker.HttpResponse getPersonsPageHttpResponse(
			Long siteId, Integer personId, Pagination pagination)
		throws Exception;

	public MGKPerson addPerson(MGKPerson mgkPerson) throws Exception;

	public HttpInvoker.HttpResponse addPersonHttpResponse(MGKPerson mgkPerson)
		throws Exception;

	public MGKPerson updatePerson(MGKPerson mgkPerson) throws Exception;

	public HttpInvoker.HttpResponse updatePersonHttpResponse(
			MGKPerson mgkPerson)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public MGKPersonResource build() {
			return new MGKPersonResourceImpl(this);
		}

		public Builder endpoint(String host, int port, String scheme) {
			_host = host;
			_port = port;
			_scheme = scheme;

			return this;
		}

		public Builder header(String key, String value) {
			_headers.put(key, value);

			return this;
		}

		public Builder locale(Locale locale) {
			_locale = locale;

			return this;
		}

		public Builder parameter(String key, String value) {
			_parameters.put(key, value);

			return this;
		}

		private Builder() {
		}

		private Map<String, String> _headers = new LinkedHashMap<>();
		private String _host = "localhost";
		private Locale _locale;
		private String _login = "test@liferay.com";
		private String _password = "test";
		private Map<String, String> _parameters = new LinkedHashMap<>();
		private int _port = 8080;
		private String _scheme = "http";

	}

	public static class MGKPersonResourceImpl implements MGKPersonResource {

		public Page<MGKPerson> getPersonsPage(
				Long siteId, Integer personId, Pagination pagination)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse = getPersonsPageHttpResponse(
				siteId, personId, pagination);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return Page.of(content, MGKPersonSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse getPersonsPageHttpResponse(
				Long siteId, Integer personId, Pagination pagination)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (personId != null) {
				httpInvoker.parameter("personId", String.valueOf(personId));
			}

			if (pagination != null) {
				httpInvoker.parameter(
					"page", String.valueOf(pagination.getPage()));
				httpInvoker.parameter(
					"pageSize", String.valueOf(pagination.getPageSize()));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/MgkPortlet-rest/v1.0/sites/{siteId}/persons",
				siteId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public MGKPerson addPerson(MGKPerson mgkPerson) throws Exception {
			HttpInvoker.HttpResponse httpResponse = addPersonHttpResponse(
				mgkPerson);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return MGKPersonSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse addPersonHttpResponse(
				MGKPerson mgkPerson)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(mgkPerson.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/MgkPortlet-rest/v1.0/sites/{siteId}/persons");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public MGKPerson updatePerson(MGKPerson mgkPerson) throws Exception {
			HttpInvoker.HttpResponse httpResponse = updatePersonHttpResponse(
				mgkPerson);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return MGKPersonSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse updatePersonHttpResponse(
				MGKPerson mgkPerson)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(mgkPerson.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/MgkPortlet-rest/v1.0/sites/{siteId}/persons");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private MGKPersonResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			MGKPersonResource.class.getName());

		private Builder _builder;

	}

}