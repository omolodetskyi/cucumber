package cucumber;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"}, features="/Users/alexander/Documents/workspace2/cucumber/src/test/java/features/")
public class RunCucumberTest extends AbstractTestNGCucumberTests{
}
