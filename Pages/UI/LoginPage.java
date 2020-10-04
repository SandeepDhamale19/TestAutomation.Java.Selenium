package UI;

import ElementsFactory.Button;
import Selenium.LocatorType;

public class LoginPage {

	String loginButton = "login";
	public Button LoginButton = new Button(loginButton, LocatorType.ID);
}
