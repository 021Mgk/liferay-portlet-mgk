package com.mgk.portlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mgk.portlet.constants.MgkPortletWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import com.mgk.portlet.exception.PersonEmailException;
import com.mgk.portlet.model.Person;
import com.mgk.portlet.service.PersonLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author USER
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=MgkPortletWeb",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + MgkPortletWebPortletKeys.MGKPORTLETWEB,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class MgkPortletWebPortlet extends MVCPortlet {

    public void addPerson(ActionRequest request, ActionResponse response) throws Exception {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(Person.class.getName(), request);

        String name = ParamUtil.getString(request, "name");
        System.out.println("name: " + name);
        String family = ParamUtil.getString(request, "family");
        System.out.println("family: " + family);
        String email = ParamUtil.getString(request, "email");
        System.out.println("email:" + email);
        String address = ParamUtil.getString(request, "address");
        System.out.println("address: " + address);
        String nationalcode = ParamUtil.getString(request, "nationalCode");
        System.out.println("nationalcode:" + nationalcode);
        String description = ParamUtil.getString(request, "description");
        System.out.println("des:" + description);
        String phoneNumber = ParamUtil.getString(request, "phoneNumber");
        System.out.println("phone:" + phoneNumber);
        //  String filename =  uploadFile(request , response);
        String image = "file.png";


        Long PID = ParamUtil.getLong(request, "PID");
        System.out.println(PID);

//        try {
//            validate(email);
//
//            if (PID == 0) {
//                try {
//                    Person person = _personLocalService.addPerson(serviceContext.getUserId(), name, family, email, address, phoneNumber, nationalcode, description, image, serviceContext);
//
//                    System.out.println(person.toString());
//
//                    String pID = Long.toString(person.getPersonId());
//                    System.out.println(pID);
//                    response.getRenderParameters().setValue("pID", pID);
//                    PortalUtil.copyRequestParameters(request, response);
//                    response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
//                    SessionMessages.add(request, "personAdded");
//                } catch (Exception e) {
//                    PortalUtil.copyRequestParameters(request, response);
//                    response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
//                    SessionErrors.add(request, "personError");
//                }
//            } else {
//                try {
//                    Person person = _personLocalService.updatePerson(serviceContext.getUserId(), PID, name, family, email, address, phoneNumber, nationalcode, description, image, serviceContext);
//                    System.out.println(person.toString());
//                    String pID = Long.toString(person.getPersonId());
//                    System.out.println(pID);
//                    response.getRenderParameters().setValue("pID", pID);
//                    PortalUtil.copyRequestParameters(request, response);
//                    response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
//                    SessionMessages.add(request, "personAdded");
//                } catch (Exception e) {
//                    PortalUtil.copyRequestParameters(request, response);
//                    response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
//                    SessionErrors.add(request, "personError");
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("--------------------------------------------------------------------------");
//            e.printStackTrace();
//            SessionErrors.add(request, "personError");
//            PortalUtil.copyRequestParameters(request, response);
//            response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
//        }


		Map<String, String> errors = validate(name, family, email, address, nationalcode, description, phoneNumber, request);
		if (errors.size() != 0) {
			request.setAttribute("errors", errors);
			SessionErrors.add(request, "personError");
			PortalUtil.copyRequestParameters(request, response);
			response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
		} else {


			if (PID == 0) {
				try {
					Person person = _personLocalService.addPerson(serviceContext.getUserId(), name, family, email, address, phoneNumber, nationalcode, description, image, serviceContext);

					System.out.println(person.toString());

					String pID = Long.toString(person.getPersonId());
					System.out.println(pID);
					response.getRenderParameters().setValue("pID", pID);
					PortalUtil.copyRequestParameters(request, response);
					response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
					SessionMessages.add(request, "personAdded");
				} catch (Exception e) {
					PortalUtil.copyRequestParameters(request, response);
					response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
					SessionErrors.add(request, "personError");
				}
			} else {
				try {
					Person person = _personLocalService.updatePerson(serviceContext.getUserId(), PID, name, family, email, address, phoneNumber, nationalcode, description, image, serviceContext);
					System.out.println(person.toString());
					String pID = Long.toString(person.getPersonId());
					System.out.println(pID);
					response.getRenderParameters().setValue("pID", pID);
					PortalUtil.copyRequestParameters(request, response);
					response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
					SessionMessages.add(request, "personAdded");
				} catch (Exception e) {
					PortalUtil.copyRequestParameters(request, response);
					response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
					SessionErrors.add(request, "personError");
				}
			}

		}

    }


	public Map<String, String> validate(String name, String family, String email, String address, String nationalCode, String description,
										String phoneNumber, ActionRequest request) throws Exception {
		Map<String, String> errors = new HashMap<>();
		ResourceBundle bundle = getPortletConfig().getResourceBundle(request.getLocale());
		if (Validator.isNull(name)) {
			errors.put("name", "name zarori ast");
			//throw  new PersonEmailException("sadsd");

		}
		if (Validator.isNull(family)) {
			errors.put("family", "family zarorti ast");
		}
		if (Validator.isNull(address)) {
			errors.put("address", "family zarorti ast");
		}
		if (Validator.isNull(phoneNumber) && phoneNumber.length() == 11) {
			errors.put("phoneNumber", "phone number");
		}
		if (Validator.isNull(nationalCode)) {
			errors.put("nationalCode", "cod zarorti ast");
		}
		if (Validator.isNull(description)) {
			errors.put("description", "family zarorti ast");
		}
		if (!Validator.isEmailAddress(email)) {
			errors.put("email", "email sahih vared nammaid");
			//throw  new PersonEmailException();
		}
		return errors;
	}

//
//    public void validate(String email) throws Exception {
//
//        if (!Validator.isEmailAddress(email)) {
//            throw new PersonEmailException();
//        }
//    }


    @Reference
    private PersonLocalService _personLocalService;
}