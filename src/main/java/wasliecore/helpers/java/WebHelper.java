package wasliecore.helpers.java;

import java.awt.Desktop;
import java.net.URL;

public class WebHelper {
	public void openURL(String url){
		try{
			Desktop.getDesktop().browse(new URL(url).toURI());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}