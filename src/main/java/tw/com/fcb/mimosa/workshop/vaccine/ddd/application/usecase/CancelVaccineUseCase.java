package tw.com.fcb.mimosa.workshop.vaccine.ddd.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tw.com.fcb.mimosa.ext.ddd.application.ApplicationUseCase;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.CancelVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.AppointmentRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class CancelVaccineUseCase implements ApplicationUseCase<CancelVaccine, Void> {

  final AppointmentRepository repository;

  //rich model style
  @Override
  public Void execute(@NotNull @Valid CancelVaccine command) {
    var domain = repository.findById(command.getId());
    domain.cancelVaccine(command.getVaccines());
    repository.save(domain);
    return null;
  }
}
