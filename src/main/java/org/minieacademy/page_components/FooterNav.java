package org.minieacademy.page_components;

import org.minieacademy.abstract_components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends AbstractComponent {
    //method to handle flights
    //when selenium executes any method in this class - scope of selenium should be in the footer section only

    WebDriver driver;
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);

    }

    public String getFlightAttribute() {
        return findElement(flights).getAttribute("class");
//        findElement(flights).click();
    }

    public int getLinkCount() {
        return findElements(links).size();
    }


}












