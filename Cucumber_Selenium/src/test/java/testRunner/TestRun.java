package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = ".//Features/", 
		//features={".//Features/Customers.feature/",".//Features/Login.feature/"},
		//features=".//Features/Login.feature/",
		glue = "stepDefinitions", 
		dryRun = false, 
		monochrome = true, 
		plugin = {"pretty", "html:Reports" },
		tags= {"@searchCustomer"}
		)

public class TestRun {

}
