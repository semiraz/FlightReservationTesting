package org.minieacademy.page_components;

import org.minieacademy.abstract_components.AbstractComponent;
import org.minieacademy.abstract_components.SearchFlightAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvailability {

    private By multiCityButton = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By modelPopup = By.id("MultiCityModelAlert");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By from2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By searchButton = By.id("ctl00_mainContent_btn_FindFlights");

    //    private By to2 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }


    @Override
    public void checkAvailability(HashMap<String, String> reservationDetails) {

        makeStateReady(s -> selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity2(reservationDetails.get("destination2"));

    }

    private void selectOriginCity(String origin) {
        findElement(from).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    private void selectDestinationCity(String destination) {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
    }

    private void selectDestinationCity2(String destination2) {
        findElement(from2).click();
        findElement(By.xpath("(//a[@value='" + destination2 + "'])[3]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer) {
        //common prerequisites code
        //execute actual function - book/calendar
        //tear down method

        System.out.println("MultiTrip");
        findElement(multiCityButton).click();
        findElement(modelPopup).click();
        waitForElementToDisappear(modelPopup);

        consumer.accept(this);
        System.out.println("this is done-tear down");

    }


}

















