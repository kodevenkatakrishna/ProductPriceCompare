package StepDefinations;

import org.openqa.selenium.WebDriver;

import POM.Calculation;
import io.cucumber.java.en.And;

public class Calcu {
	Calculation Price = new Calculation();
	@And("Print the Price")
	public void Price() {
		Price.Cal();
	}
}
