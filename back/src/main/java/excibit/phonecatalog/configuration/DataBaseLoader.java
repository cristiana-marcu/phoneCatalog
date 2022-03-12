package excibit.phonecatalog.configuration;

import excibit.phonecatalog.phone.persistence.Phone;
import excibit.phonecatalog.phone.persistence.PhoneRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements ApplicationRunner {

  private final PhoneRepository phoneRepository;

  public DataBaseLoader(PhoneRepository phoneRepository) {
    this.phoneRepository = phoneRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Phone phone1 = new Phone();

    phone1.setName("Samsung 8");
    phone1.setManufacturer("SAMSUNG");
    phone1.setDescription("Nice phone for gaming");
    phone1.setColor("Blue");
    phone1.setPrice(457d);
    phone1.setImageFileName("files/samsung8.png");
    phone1.setScreen("4,7 inch IPS");
    phone1.setProcessor("A10");
    phone1.setRam(4);
    phoneRepository.save(phone1);

    Phone phone2 = new Phone();

    phone2.setName("iPhone 7");
    phone2.setManufacturer("Apple Inc.");
    phone2.setDescription("Your greatest photos ever");
    phone2.setColor("Gold");
    phone2.setPrice(527d);
    phone2.setImageFileName("files/iphone7.png");
    phone2.setScreen("4,7 inch retina HD");
    phone2.setProcessor("A10 Fusion");
    phone2.setRam(2);
    phoneRepository.save(phone2);
  }
}
