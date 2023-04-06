package com.scp.retoback.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/login/login_from_api.feature",
    glue = {"com.scp.retoback.conf", "com.scp.retoback.stepdefinitions"},
    snippets = SnippetType.CAMELCASE)
public class LoginFromApiRunner {}
