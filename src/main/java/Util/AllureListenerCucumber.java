package Util;


import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestStepFinished;
import io.qameta.allure.Allure;
import io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureListenerCucumber extends AllureCucumber6Jvm {
    public static WebDriver driver = DriverManager.getDriverManager().getDriver();

    @Override
    public void setEventPublisher(EventPublisher publisher){
        publisher.registerHandlerFor(TestStepFinished.class, testStepFinished -> {
            if(!testStepFinished.getResult().getStatus().is(Status.PASSED))
            {
                Allure.getLifecycle().addAttachment("screen", "image/jpg", null, ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
        });
        super.setEventPublisher(publisher);
    }

}