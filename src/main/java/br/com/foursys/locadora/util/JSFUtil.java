package br.com.foursys.locadora.util;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

public class JSFUtil {

	public static void addInfoMessage(String type, String title, String msg) {
		FacesMessage facesMessage = null;
		
		switch (type) {
		case "INFO":
			 facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg);
			break;
		case "ERROR":
			 facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
			break;
		case "FATAL":
			 facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL, title, msg);
			break;
		case "WARN":
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, title, msg);
			break;

		}

		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(msg, facesMessage);

	}

	public static void refresh() {

		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}

}
