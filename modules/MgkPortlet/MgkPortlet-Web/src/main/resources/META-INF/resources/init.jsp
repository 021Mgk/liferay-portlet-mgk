<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@taglib uri="http://liferay.com/tld/clay" prefix="clay" %>



<%@ page import="com.mgk.portlet.model.Person" %>
<%@ page import="com.mgk.portlet.service.PersonLocalServiceUtil" %>
<%@ page import="com.mgk.portlet.exception.PersonEmailException" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>


<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.portal.kernel.model.PersistedModel" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>

<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>




<liferay-frontend:defineObjects/>

<liferay-theme:defineObjects/>

<portlet:defineObjects/>

<%
    String displayStyle = ParamUtil.getString(
            request, "displayStyle");

    System.out.println("displayStyle = " + displayStyle);


%>


