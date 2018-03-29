package ca.est.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import ca.est.model.Authentication;

@SuppressWarnings("serial")
@Title("Login")
@Theme("valo")
public class MainUI extends UI {

	public static Authentication AUTH;
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MainUI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	@Override
	protected void init(VaadinRequest request) {
		AUTH = new Authentication();
		new Navigator(this, this);
		
		getNavigator().addView(LoginPage.NAME, LoginPage.class);
		getNavigator().setErrorView(LoginPage.class);

		router("");
	}
	
	private void router(String route){
		Notification.show(route);
		if(getSession().getAttribute("user") != null){
			getNavigator().addView(SecurePage.NAME, SecurePage.class);
			getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
			if(route.equals("!OtherSecure")){
				getNavigator().navigateTo(OtherSecurePage.NAME);
			}else{
				getNavigator().navigateTo(SecurePage.NAME);
			}
		}else{
			getNavigator().navigateTo(LoginPage.NAME);
		}
	}

}