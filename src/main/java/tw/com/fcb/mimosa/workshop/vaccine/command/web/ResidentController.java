package tw.com.fcb.mimosa.workshop.vaccine.command.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tw.com.fcb.mimosa.workshop.vaccine.command.service.ResidentService;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.CancelVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.ChooseVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.MakeAppointment;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.ReplaceResidentProfile;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.ResidentProfile;

import java.util.List;

/**
 * 命令風格 API
 */
@RequiredArgsConstructor
@RequestMapping("/command/residents")
// @RestController
class ResidentController {

  final ResidentService service;

  @PutMapping("/{id}")
  void replaceResidentProfile(@PathVariable("id") long id,
   @RequestBody ReplaceResidentProfile command) {
    service.replaceResidentProfile(id, command);
  }

  @PutMapping("/{id}/vaccines")
  void chooseVaccine(@PathVariable("id") long id,
    @RequestBody ChooseVaccine command) {
    service.chooseVaccine(id, command);
  }

  @DeleteMapping("/{id}/vaccines")
  void cancelVaccine(@PathVariable("id") long id,
    @RequestBody CancelVaccine command) {
    service.cancelVaccine(id, command);
  }

  @PostMapping
  long makeAppointment(
    @RequestBody MakeAppointment command) {
    return service.makeAppointment(command);
  }

  @GetMapping
  List<ResidentProfile> getResidents() {
    return service.getResidents();
  }
}
