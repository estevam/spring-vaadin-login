package ca.est.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class SecurePage extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	private Label secure;
	private Label currentUser;
	private Button otherSecure;
	private Button logout;
	private Label labelServerInfo;

	public static final String NAME = "Secure";

	public SecurePage() {
		
		otherSecure = new Button("OtherSecure");
		otherSecure.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				Page.getCurrent().setUriFragment("!"+OtherSecurePage.NAME);
			}
		});
		
		logout = new Button("Logout");
		logout.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().removeView(SecurePage.NAME);
				getUI().getNavigator().removeView(OtherSecurePage.NAME);
				VaadinSession.getCurrent().setAttribute("user", null);
				Page.getCurrent().setUriFragment("");
			}
		});
		
		labelServerInfo = new Label("I have "
                + Runtime.getRuntime().availableProcessors()
                + " processors and "
                + (Runtime.getRuntime().totalMemory() / 1000000)
                + " MB total memory.");
		
		secure = new Label("secure");
		currentUser = new Label("Current User");

	
		addComponent(secure);
		addComponent(currentUser);
		addComponent(otherSecure);
		addComponent(labelServerInfo);
		addComponent(logout);
		
		   VerticalLayout content = new VerticalLayout();
	        content.setSizeFull(); // Use entire window
	  // Attach to the UI

	        // Add some component
	        content.addComponent(new Label("<b>Hello!</b> - How are you?"));

/*	        Grid<Person> grid = new Grid<>();
	        grid.setCaption("My Grid");//grid.setColumnOrder("id","name", "email");
	        grid.setItems(); // <--
	        grid.setSizeFull();
	        content.addComponent(grid);
	        content.setExpandRatio(grid, 1); // Expand to fill
	        addComponent(grid);*/
	        addComponent(content);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		currentUser.setCaption("Current user : " + VaadinSession.getCurrent().getAttribute("user").toString()); 

	}

}
