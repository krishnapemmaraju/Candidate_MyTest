package com.test.api.testrunners;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		plugin = {"pretty"},
		features= { "src/test/resources/features"},
		glue = {"com.test.api.definitions"},
		dryRun=false
		)
public class CucumberTestSuite {}
