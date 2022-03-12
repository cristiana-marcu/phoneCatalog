package excibit.phonecatalog.phone.controller;

import excibit.phonecatalog.phone.persistence.Phone;
import excibit.phonecatalog.phone.persistence.PhoneRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneController {

  private final PhoneRepository phoneRepository;

  public PhoneController(PhoneRepository phoneRepository) {
    this.phoneRepository = phoneRepository;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(path = "/phones")
  public ResponseEntity<List<Phone>> getPhones() {
    List<Phone> phones = phoneRepository.findAll();
    return ResponseEntity.ok(phones);
  }
}
