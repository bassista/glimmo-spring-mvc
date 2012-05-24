package be.glimmo.dao.preparation;

import org.testng.annotations.BeforeSuite;

/**
 * This class contains method that prepare a database for test purpose
 * @author Kro
 *
 */
public class DatasourceConfigurator {
	
	@BeforeSuite()
	public void loadDBDriver(){
		System.out.println("pouet");
	}
}
