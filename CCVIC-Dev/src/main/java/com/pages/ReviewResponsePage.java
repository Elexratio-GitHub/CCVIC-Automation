package com.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class ReviewResponsePage {
    private WebDriverWait wait;

   

    public ReviewResponsePage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
    }

    public void reviewResponse(Scenario scenario, Properties properties) throws InterruptedException {
		if (scenario.getSourceTagNames().contains("@CivilSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@CivilObjectToComplyWithTheSubpoena")) {
			submitResponse();
		} else if (scenario.getSourceTagNames().contains("@CrimeSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@CrimeObjectToComplyWithTheSubpoena") || scenario.getSourceTagNames().contains("@CrimeRespondTo32CApplication")||scenario.getSourceTagNames().contains("@AppealSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@AppealObjectToComplyWithTheSubpoena") || scenario.getSourceTagNames().contains("@AppealRespondTo32CApplication")) {
			if (scenario.getSourceTagNames().contains("@CrimeSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@CrimeObjectToComplyWithTheSubpoena")||scenario.getSourceTagNames().contains("@AppealSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@AppealObjectToComplyWithTheSubpoena")) {


				wait.until(ExpectedConditions.elementToBeClickable(By.name("production-date"))).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr/td[2]/span[text()='5']"))).click();

				wait.until(ExpectedConditions.elementToBeClickable(By.name("date-of-judgement"))).click();

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today']"))).click();
			} else if (scenario.getSourceTagNames().contains("@CrimeRespondTo32CApplication")|| scenario.getSourceTagNames().contains("@AppealRespondTo32CApplication")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.name("date-of-judgement"))).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today']"))).click();
			}
			TimeUnit.SECONDS.sleep(3);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("applicant-party"))).sendKeys("victoria");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("defendant-party"))).sendKeys("victoria");
			submitResponse();
		} else if (scenario.getSourceTagNames().contains("@CivilSubmitSubpoenaedMaterial")) {
			submitResponse();
		}
	}

	private void submitResponse() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Submit ']"))).click();
		TimeUnit.SECONDS.sleep(10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()=' Ok '])[2]"))).click();
	}
    }
    

