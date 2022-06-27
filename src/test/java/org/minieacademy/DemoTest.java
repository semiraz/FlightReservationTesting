package org.minieacademy;

import org.minieacademy.page_objects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
///home/semira/Documents/reservationDetails.json
public class DemoTest extends BaseTest{
    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setUp() {
        driver = initializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails) {

        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().getLinkCount());

        //one way, round tri, multi trip - checkAvailability(origin, destination)
//        travelHomePage.setBookingStrategy(new MultiTrip());
//        travelHomePage.checkAvailability("origin", "destination");

        travelHomePage.setBookingStrategy("multitrip");
        travelHomePage.checkAvailability(reservationDetails);


//        travelHomePage.setBookingStrategy("roundtrip");
//        travelHomePage.checkAvailability(reservationDetails);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> l = getJsonData(System.getProperty("user.dir") +
                "/src/main/java/org/minieacademy/data_loads/reservationDetails.json");
        return new Object[][] {
                {l.get(0)}, {l.get(1)}
        };
    }



//    @DataProvider
//    public Object[][] getData() {
//        HashMap<String, String> reservationDetails = new HashMap<>();
//        reservationDetails.put("origin", "MAA");
//        reservationDetails.put("destination", "HYD");
//        reservationDetails.put("destination2", "DEL");
//
//        HashMap<String, String> reservationDetails1 = new HashMap<>();
//        reservationDetails1.put("origin", "DEL");
//        reservationDetails1.put("destination", "HYD");
//        reservationDetails1.put("destination2", "MAA");
//
//        List<HashMap<String, String>> l = new ArrayList<>();
//        l.add(reservationDetails);
//        l.add(reservationDetails1);
//
//        return new Object[][] {
//                {l.get(0)}, {l.get(1)}
//        };
//    }

}
















