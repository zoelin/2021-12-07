package tw.com.fcb.mimosa.workshop.vaccine.ddd.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tw.com.fcb.mimosa.ext.ddd.application.ApplicationUseCase;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.ReplaceResidentProfile;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.AppointmentRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class ReplaceResidentProfileUseCase implements ApplicationUseCase<ReplaceResidentProfile, Void> {

  final AppointmentRepository repository;


  @Override
  public Void execute(@NotNull @Valid ReplaceResidentProfile command) {
    var domain = repository.findById(command.getId());
    if (StringUtils.hasText(command.getPhoneNo())) {
      domain.setPhoneNo(command.getPhoneNo());
      repository.save(domain);
    }
    return null;
  }
}
