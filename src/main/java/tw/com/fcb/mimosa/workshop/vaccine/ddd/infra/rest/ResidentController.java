package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import tw.com.fcb.mimosa.ext.ddd.application.UseCases;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.ApplicationService;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.query.QueryResidents;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.assembler.ResidentAssembler;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.rest.*;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.ResidentProfile;

import java.util.List;

@RestController
@RequiredArgsConstructor
class ResidentController implements ResidentApi {

  final ApplicationService service;
  final ResidentAssembler assembler;
  final UseCases useCases;
  final QueryResidents query;


  @Override
  public long makeAppointment(MakeAppointmentRequest request) {
    var command = assembler.toMakeAppointmentCommand(request);
    return service.makeAppointment(command);
  }

  @Override
  public void chooseVaccine(long id, ChooseVaccineRequest request) {
    var command = assembler.toChooseVaccineCommand(request);
    command.setId(id);
    useCases.execute(command);
    //service.chooseVaccine(command);
  }

  @Override
  public void cancelVaccine(long id, CancelVaccineRequest request) {
    var command = assembler.toCancelVaccineCommand(request);
    command.setId(id);
    useCases.execute(command);
    //service.cancelVaccine(command);
  }

  @Override
  public List<ResidentProfile> getResidents() {
    return query.getResidents();
  }

  @Override
  public void replaceResidentProfile(long id, ReplaceResidentProfileRequest request) {
    var command = assembler.toReplaceResidentProfileCommand(request);
    command.setId(id);
    useCases.execute(command);
  }

}
