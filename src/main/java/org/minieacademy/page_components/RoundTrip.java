package org.minieacademy.page_components;

import org.minieacademy.abstract_components.AbstractComponent;
import org.minieacademy.abstract_components.SearchFlightAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvailability {

    private By radioButtonRoundTrip = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By indianArmCheckBox = By.id("ctl00_mainContent_studentAndDefense");
    private By searchButton = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }


    @Override
    public void checkAvailability(HashMap<String, String> reservationDetails) {
        makeReadyState(s -> selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectCheckButton();
        findElement(searchButton).click();
    }

    private void selectOriginCity(String origin) {
        findElement(from).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    private void selectDestinationCity(String destination) {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
    }

    private void makeReadyState(Consumer<RoundTrip> consumer) {
        System.out.println("Round trip");
        findElement(radioButtonRoundTrip).click();
        consumer.accept(this);
        System.out.println("this is done-tear down");
    }

    private void selectCheckButton() {
//        waitForElementToBeClickable(indianArmCheckBox);
        findElement(indianArmCheckBox).click();
    }

}


















