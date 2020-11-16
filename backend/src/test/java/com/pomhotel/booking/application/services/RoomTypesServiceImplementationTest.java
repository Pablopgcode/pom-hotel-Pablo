package com.pomhotel.booking.application.services;

import com.pomhotel.booking.application.models.RoomtypesModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RoomTypesServiceImplementationTest {

    List<RoomtypesModel> types = new ArrayList<>();
    RoomtypesModel type1 = new RoomtypesModel();
    RoomtypesModel type2 = new RoomtypesModel();

    @MockBean
    private RoomTypesService roomTypesService;

    @BeforeEach
    void setUp() {
        type1.setId(25);
        type1.setName("Suite test");
        type1.setDescription("description");
        type2.setId(26);
        type2.setName("Suite test 2");
        type2.setDescription("description 2");
        types.add(type1);
        types.add(type2);
    }

    @Test
    @DisplayName("Bean injection")
    public void ShouldinjectedBean() {
        assertThat(roomTypesService).isNotNull();
    }

    @Test
    @DisplayName("Test: Get all types")
    public void ShouldGetAllRooms() throws Exception {
        var roomTypesService = Mockito.mock(RoomTypesService.class);
        Mockito.when(roomTypesService.findAll()).thenReturn(types);
        assertEquals(2,types.size());
    }

    @Test
    @DisplayName("Test: Obtain type by id")
    public void ShouldGetTypeById() throws Exception {
        var roomTypesService = Mockito.mock(RoomTypesService.class);
        Mockito.when(roomTypesService.findById(1)).thenReturn(type1);
        assertEquals(25, type1.getId());
    }
}
