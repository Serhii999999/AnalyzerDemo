package common.services;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class Actions {

    public  void openUrl(String url){
        open(url);
    }
    public  void click(SelenideElement element) {
        element.shouldBe(Condition.visible);
        if(element.isDisplayed()){
            element.click();
        }
    }
    public void clickWithJS(SelenideElement element){
        executeJavaScript("arguments[0].click();", element);
    }
    public  void navigateBack(){
        back();
    }

    public  boolean areApproximatelyEqual(int val1, int val2, int threshold){
        int difference = Math.abs(val1-val2);
        return difference <= threshold;
    }
    public  int retrieveNumberFromPage(String p, String url) {
        SelenideElement preElement = $("pre").shouldBe(Condition.visible);
        String preText = preElement.getText();

        String pattern = "\"Site Crawled\",\"" + url + "/\".*?" + p;
        Pattern patternMatch = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher matcher = patternMatch.matcher(preText);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            throw new RuntimeException("Pattern not found in the page content");
        }
    }

}
