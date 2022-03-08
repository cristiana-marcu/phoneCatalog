package excibit.phonecatalog.phone.persistence;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhoneRepositoryTest {
  @Autowired private PhoneRepository phoneRepository;

  @Test
  void saveOk() {
    // Given a phone
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

    // When saving to database
    phone = phoneRepository.save(phone);

    // Then phone should not be null, nor its id.
    Assertions.assertThat(phone).isNotNull();
    Assertions.assertThat(phone.getId()).isNotNull();
  }
}
