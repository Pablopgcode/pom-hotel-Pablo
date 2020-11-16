package com.pomhotel.booking.application.services;

import com.pomhotel.booking.application.domain.factories.ClientsFactory;
import com.pomhotel.booking.application.repositories.ClientLoginRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientLoginServiceImplementationTest {

    @Autowired
    ClientsFactory clientsFactory;
    @Autowired
    ClientLoginRepository repository;

    @Test
    @DisplayName("Bean injection")
    public void ShouldinjectedBean() {
        assertThat(clientsFactory).isNotNull();
    }

    @Test
    @DisplayName("Test: Find a client by his username")
    public void ShouldFindClientByUsername(){
        String username = "Miguel";
        clientsFactory.createModel(repository.findClientByUsername(username));
    }
}
