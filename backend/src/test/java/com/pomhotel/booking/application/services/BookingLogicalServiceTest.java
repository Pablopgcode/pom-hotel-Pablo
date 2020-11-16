package com.pomhotel.booking.application.services;

import com.pomhotel.booking.ui.dto.NewPriceDTO;
import com.pomhotel.booking.ui.servicies.BookingLogicalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingLogicalServiceTest {

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
    public void ShouldGetLastPriceAndDiscountApplied(){
        NewPriceDTO lastPrice = new NewPriceDTO();





    }















}
