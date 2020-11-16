package com.pomhotel.booking.application.services;

import com.pomhotel.booking.ui.dto.NewPriceDTO;
import com.pomhotel.booking.ui.servicies.BookingLogicalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.PrintConversionEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingLogicalServiceTest {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private BookingLogicalService bookingLogical;

    @Test
    @DisplayName("Bean injection")
    public void ShouldInnjectedBeanNeverShouldBeNull() throws Exception
    {
        assertThat(bookingLogical).isNotNull();
    }

    @Test
    @DisplayName("Test: Verify correct calculate of method")
    public void ShouldGetNumberOfDaysBetweenTwoDates() {
        assertEquals(2, bookingLogical.getDaysBetweenTwoDates(Date.valueOf("2020-01-01"), Date.valueOf("2020-01-03")));
        assertEquals(15, bookingLogical.getDaysBetweenTwoDates(Date.valueOf("2020-01-01"), Date.valueOf("2020-01-16")));
        assertEquals(5, bookingLogical.getDaysBetweenTwoDates(Date.valueOf("2020-11-10"), Date.valueOf("2020-11-15")));
    }

    @Test
    @DisplayName("Test: Verify correct calculate of month's Date")
    public void ShouldGetNumberOfMonthOfDate(){
        assertEquals(2, bookingLogical.getMonth(Date.valueOf("2020-02-01")));
        assertEquals(6, bookingLogical.getMonth(Date.valueOf("2020-06-01")));
    }

    @Test
    @DisplayName("Test: Verify correct calculate last final price of the booking and discount applied")
    public void ShouldGetLastPriceAndDiscountApplied() throws Exception{
        /* DTO's to simulate */
        NewPriceDTO lastPrice1 = new NewPriceDTO();
        NewPriceDTO lastPrice2 = new NewPriceDTO();
        NewPriceDTO lastPrice3 = new NewPriceDTO();

        /* Set up first DTO & assert it */
        Date checkIn = convert(format.parse("15/01/2020"));
        Date checkOut = convert(format.parse("18/01/2020"));
        lastPrice1 = bookingLogical.calculateTotalPrice(checkIn,checkOut,300.00,false,false,false,false);
        assertEquals(855, lastPrice1.getLastPrice());
        assertEquals("5% for booking in low season", lastPrice1.getMessage());

        /* Set up first DTO & assert it */




    }

    @Test
    @DisplayName("Test: Verify correct calculate of CalculateFinalPrice()")
    public void ShouldGetCorrectLastPrice() throws Exception{
        assertEquals(600, bookingLogical.CalculateFinalPrice(300.00, 2, 0, 0));
        assertEquals(860.70, bookingLogical.CalculateFinalPrice(285.00, 3, 17, 0.05));
        assertEquals(809.10, bookingLogical.CalculateFinalPrice(155.00, 5, 19, 0.07));
        assertEquals(53.90, bookingLogical.CalculateFinalPrice(50.00, 1, 5, 0.02));
        assertEquals(1284, bookingLogical.CalculateFinalPrice(300.00, 4, 21, 0));
    }

    /* Convert date method */
    private static Date convert(java.util.Date utilDate) {
        Date sqlDate = new Date(utilDate.getTime());
        return sqlDate;
    }
}
