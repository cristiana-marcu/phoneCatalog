package excibit.phonecatalog.phone.controller;

import excibit.phonecatalog.phone.persistence.Phone;
import excibit.phonecatalog.phone.persistence.PhoneRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(PhoneController.class)
class PhoneControllerTest {

  @Autowired private MockMvc mockMvc;
  @MockBean private PhoneRepository phoneRepository;

  @Test
  @DisplayName("Get /phones endpoint should return phones")
  void getPhonesOk() throws Exception {
    // Given a list of phone(s)
    Phone phone = new Phone();
    phone.setName("Samsung 8");
    phone.setManufacturer("SAMSUNG");
    phone.setDescription("Nice phone for gaming");
    phone.setColor("Blue");
    phone.setPrice(457d);
    phone.setImageFileName("files/samsung8.png");
    phone.setScreen("4,7 inch IPS");
    phone.setProcessor("A10");
    phone.setRam(4);

    List<Phone> phones = List.of(phone);

    Mockito.when(phoneRepository.findAll()).thenReturn(phones);

    // When trying endpoint /phones
    mockMvc
        .perform(MockMvcRequestBuilders.get("/phones"))
        .andDo(print())
        // Then status should be ok
        .andExpect(MockMvcResultMatchers.status().isOk())
        // And response should contain phone name
        .andExpect(
            MockMvcResultMatchers.content().string(CoreMatchers.containsString("Samsung 8")));
  }
}
