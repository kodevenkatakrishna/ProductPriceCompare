package POM;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import POM.Login_Amazon;
import POM.Login_Flipkart;


public class Calculation {
	WebDriver driver;
	String APrice ;
	String FPrice ;
	Login_Amazon AmazonPrice = new Login_Amazon(driver);
	Login_Flipkart FlipkartPrice = new Login_Flipkart(driver);
	public void Cal() {
		APrice= AmazonPrice.Retreving_Product_Price();
		FPrice = FlipkartPrice.Product_Price();
		
		
		String Split1 = StringUtils.remove(FPrice, "₹");
        String Split2 = StringUtils.remove(APrice, "₹");
        String Split3 = StringUtils.remove(Split1, ",");
        String Split4 = StringUtils.remove(Split2, ",");
        String Split5 = StringUtils.remove(Split4, ".00");
        
        int Flipkart_Price = Integer.parseInt(Split3);
        System.out.println("Flipkart Price : "+"₹"+Flipkart_Price);
        int Amazon_Price = Integer.parseInt(Split5);
        System.out.println("Amazon Price : "+"₹"+Amazon_Price);
        System.out.println(" ");
        System.out.println("₹"+Amazon_Price+" - "+"₹"+Flipkart_Price);
        System.out.println(" ");
        int Diff = Amazon_Price - Flipkart_Price; 
        System.out.println("Price Difference : "+ Diff);
        System.out.println(" ");
        System.out.println("Result : "
        		+ "                    "
        		+ "                     ");
        if(Flipkart_Price >= Amazon_Price) {
        	System.out.println("Amazon is best Place to Buy");
        }
        else
        {
        	System.out.println("Flipkart is best Place to Buy");
        }
	}
}
