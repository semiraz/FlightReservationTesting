package org.minieacademy.page_components;

import org.minieacademy.abstract_components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent {

    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public String getFlightAttribute() {
        return findElement(flights).getAttribute("class");
    }

    public int getLinkCount() {
        return findElements(links).size();
    }

}
