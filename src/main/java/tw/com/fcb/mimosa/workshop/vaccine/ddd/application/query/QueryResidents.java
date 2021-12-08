package tw.com.fcb.mimosa.workshop.vaccine.ddd.application.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.AppointmentRepository;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.ResidentProfile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryResidents {

  final AppointmentRepository repository;

  public List<ResidentProfile> getResidents() {
    return repository.findResidents();
  }


}
