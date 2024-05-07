package settingsPerEnv.reportAutomation.pages;

import common.services.Actions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;


public class ScreamingFrogPage {
    private Actions actions;
    public ScreamingFrogPage(){
        actions = new Actions();
    }
    public void frogLink(){
        actions.clickWithJS(element(By.xpath("//span[text()='ScreamingFrog']")));
    }
    public void preprodLinkClick(){
        actions.clickWithJS(element(By.xpath("//td//span[text()='preprod']")));
    }
    public void prodLinkClick(){
        actions.clickWithJS(element(By.xpath("//td//span[text()='prod']")));
    }

}
