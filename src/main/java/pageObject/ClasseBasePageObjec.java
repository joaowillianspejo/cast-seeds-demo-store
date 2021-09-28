package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClasseBasePageObjec {
	protected WebDriver driver;
	
	public ClasseBasePageObjec(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 public boolean verificaMensagem (WebElement elemento, String mensagem) {
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.textToBePresentInElement(elemento, mensagem));
		 return (elemento.getText().contains(mensagem));
	 }
}
