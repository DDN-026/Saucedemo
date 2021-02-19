package com.ui.runnerclass;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

public class runner {
	@RunWith(Cucumber.class)
	@CucumberOptions(
			tags= {"@test"},
	 features = {"src\\test\\resources\\features\\Test.feature"}
	 ,glue={"info.seleniumcucumber.userStepDefintions"}
	 )
	 
	public class TestRunner {
	 
	}
}
