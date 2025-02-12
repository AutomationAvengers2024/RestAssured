package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = {"src/test/resources/Feature/Post.feature"},  
    glue = "stepdefinition",                       
    plugin = {
        "pretty",                                  
        "html:target/cucumber-reports/cucumber.html",   
        "json:target/cucumber-reports/cucumber.json",   
        "junit:target/cucumber-reports/cucumber.xml",   
    },
    monochrome = true,      
    dryRun = false      
)
public class Runner extends AbstractTestNGCucumberTests {
    
}