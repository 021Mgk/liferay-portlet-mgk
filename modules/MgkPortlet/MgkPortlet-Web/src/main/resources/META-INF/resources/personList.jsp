<%@ page import="com.mgk.portlet.internal.display.context.PersonsManagementToolbarDisplayContext" %>
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList" %>
<%@ page import="com.mgk.portlet.internal.clay.PersonEntryVerticalCard" %>
<%@include file="init.jsp" %>


<%


//    PersonsManagementToolbarDisplayContext personsManagementToolbarDisplayContext =
//            new PersonsManagementToolbarDisplayContext(request, liferayPortletRequest,
//                    liferayPortletResponse, displayStyle);

    ViewTypeItemList viewTypeItems = new ViewTypeItemList(currentURLObj, displayStyle) {
        {
            addCardViewTypeItem();
            addListViewTypeItem();
            addTableViewTypeItem();
        }
    };


%>

<clay:management-toolbar
        viewTypeItems="<%=viewTypeItems%>"
        searchContainerId="personEntries"
        supportsBulkActions="<%= true %>"
/>

<liferay-portlet:renderURL varImpl="iteratorURL">
    <portlet:param name="mvcRenderCommandName" value="/person/list"></portlet:param>
</liferay-portlet:renderURL>

<clay:container-fluid
        cssClass="main-content-body"
>

<liferay-ui:search-container
        id="personEntries"
        total="<%= PersonLocalServiceUtil.getPersonsCount(scopeGroupId.longValue())%>"
        delta="20" iteratorURL="<%= iteratorURL %>">

    <liferay-ui:search-container-results
            results="<%= PersonLocalServiceUtil.getPersons(scopeGroupId,
			searchContainer.getStart(), searchContainer.getEnd()) %>" />

    <liferay-ui:search-container-row className="com.mgk.portlet.model.Person" modelVar="person">

        <c:choose>
            <c:when test="<%=displayStyle.equals("icon")%>">
                <%
                    row.setCssClass("entry-card lfr-asset-item");
                %>

                <liferay-portlet:renderURL varImpl="rowURL">
                    <portlet:param name="mvcRenderCommandName" value="/persons/edit" />
                </liferay-portlet:renderURL>

                <liferay-ui:search-container-column-text>
                    <clay:vertical-card
                            verticalCard="<%=
				new PersonEntryVerticalCard(person, renderRequest, renderResponse, null, rowURL.toString(),
				 permissionChecker, resourceBundle) %>"
                    />
                </liferay-ui:search-container-column-text>
            </c:when>

            <c:otherwise>
                <liferay-ui:search-container-column-text property="name"/>
                <liferay-ui:search-container-column-text property="family"/>
                <%--        <liferay-ui:search-container-column-status property="status" />--%>
                <liferay-ui:search-container-column-jsp align="right" path="/person_actions.jsp" />
            </c:otherwise>
        </c:choose>





    </liferay-ui:search-container-row >

    <liferay-ui:search-iterator
            displayStyle="<%= displayStyle %>"
            markupView="lexicon"
    />

</liferay-ui:search-container>

</clay:container-fluid>


<%--<div id="error">--%>
<%--    <c:if test="${!empty personList}">--%>

<%--        <table>--%>
<%--            <tr>--%>
<%--                <th>name</th>--%>
<%--                <th>family</th>--%>
<%--                <th>email</th>--%>
<%--            </tr>--%>
<%--            <c:forEach items="${personList}" var="person">--%>
<%--                <tr>--%>
<%--                    <td>${person.name}</td>--%>
<%--                    <td>${person.family}</td>--%>
<%--                    <td>${person.email}</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </table>--%>
<%--    </c:if>--%>

<%--</div>--%>
<%--                    <span>${person.name}</span>--%>
<%--                    <span></span>--%>
<%--                    <span>${person.phoneNumber}</span>--%>
<%--                    <span>${person.address}</span>--%>
<%--                    <span>${person.description}</span>--%>
<%--                    <span></span>--%>
<%--                    <span>${person.nationaCode}</span>--%>
<%--                    <c:out value="${person}"></c:out>--%>



