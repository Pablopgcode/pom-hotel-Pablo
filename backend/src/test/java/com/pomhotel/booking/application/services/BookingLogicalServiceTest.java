package com.pomhotel.booking.application.services;

import com.pomhotel.booking.ui.servicies.BookingLogicalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    public void getDaysBetweenTwoDates() {
        assertEquals(2, bookingLogical.getDaysBetweenTwoDates(Date.valueOf("2020-01-01"), Date.valueOf("2020-01-03")));
        assertEquals(15, bookingLogical.getDaysBetweenTwoDates(Date.valueOf("2020-01-01"), Date.valueOf("2020-01-16")));
        assertEquals(5, bookingLogical.getDaysBetweenTwoDates(Date.valueOf("2020-11-10"), Date.valueOf("2020-11-15")));
    }







}
