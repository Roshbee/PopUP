package runner;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features ={"locationoffeaturefile"},
glue={"Stepdefinition"},
plugin= {"pretty","html:target/cucumber-report.html","json:json-output/cucumber.json","junit:junit-xml/cucumber.xml"},
tags="@Regression",
monochrome =true,dryRun=false,publish=true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
