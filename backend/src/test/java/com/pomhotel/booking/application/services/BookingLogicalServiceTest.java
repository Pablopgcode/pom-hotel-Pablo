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
        Date checkIn1 = convert(format.parse("15/01/2020"));
        Date checkOut1 = convert(format.parse("18/01/2020"));
        lastPrice1 = bookingLogical.calculateTotalPrice(checkIn1,checkOut1,300.00,false,false,false,false);
        assertEquals(855, lastPrice1.getLastPrice());
        assertEquals("5% for booking in low season", lastPrice1.getMessage());

        /* Set up second DTO & assert it */
        Date checkIn2 = convert(format.parse("14/11/2020"));
        Date checkOut2 = convert(format.parse("30/11/2020"));
        lastPrice2 = bookingLogical.calculateTotalPrice(checkIn2,checkOut2,150.00,true,false,true,false);
        assertEquals(2514.72, lastPrice2.getLastPrice());
        assertEquals("7% for booking more than 7 days in low season", lastPrice2.getMessage());

        /* Set up third DTO & assert it */
        Date checkIn3 = convert(format.parse("29/07/2020"));
        Date checkOut3 = convert(format.parse("07/08/2020"));
        lastPrice3 = bookingLogical.calculateTotalPrice(checkIn3,checkOut3,285.00,false,true,true,true);
        assertEquals(2743.02, lastPrice3.getLastPrice());
        assertEquals("2% for booking more than 7 days", lastPrice3.getMessage());
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
