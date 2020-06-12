package cucumber;
/*
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})
public class RunCucumberTest {
}
*/
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},features="/Users/alexander/Documents/workspace2/cucumber/src/test/java/features")
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
