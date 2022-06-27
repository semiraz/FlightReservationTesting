package org.minieacademy.page_objects;

import org.minieacademy.abstract_components.SearchFlightAvailability;
import org.minieacademy.abstract_components.StrategyFactor;
import org.minieacademy.page_components.FooterNav;
import org.minieacademy.page_components.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    //responsibility of this main page is to help us redirect to other class

    WebDriver driver;
    By sectionElement = By.id("traveller-home");
    By headerNavSectionElement = By.id("buttons");
    SearchFlightAvailability searchFlightAvail;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver, headerNavSectionElement);
    }

    public FooterNav getFooterNav() {
        return new FooterNav(driver, sectionElement);
    }

    public void setBookingStrategy(String strategyType) {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        this.searchFlightAvail = strategyFactor.createStrategy(strategyType);
    }

    public void checkAvailability(HashMap<String, String> reservationDetails) {
        searchFlightAvail.checkAvailability(reservationDetails);
    }

    public String getTitle() {
        System.out.println("Hello!");
        return driver.getTitle();
    }



}





















