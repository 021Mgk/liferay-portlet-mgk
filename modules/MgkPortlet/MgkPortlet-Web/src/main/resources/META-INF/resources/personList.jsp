<%@include file="init.jsp" %>



<liferay-portlet:renderURL varImpl="iteratorURL">
    <portlet:param name="mvcRenderCommandName" value="/person/list"></portlet:param>
</liferay-portlet:renderURL>

<liferay-ui:search-container
        total="<%= PersonLocalServiceUtil.getPersonsCount(scopeGroupId.longValue())%>"
        delta="20" iteratorURL="<%= iteratorURL %>">

    <liferay-ui:search-container-results
            results="<%= PersonLocalServiceUtil.getPersons(scopeGroupId,
			searchContainer.getStart(), searchContainer.getEnd()) %>" />

    <liferay-ui:search-container-row className="com.mgk.portlet.model.Person" modelVar="person">

        <liferay-ui:search-container-column-text property="name"/>
        <liferay-ui:search-container-column-text property="family"/>
        <%--        <liferay-ui:search-container-column-status property="status" />--%>
        <liferay-ui:search-container-column-jsp align="right" path="/person_actions.jsp" />


    </liferay-ui:search-container-row >

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>


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



