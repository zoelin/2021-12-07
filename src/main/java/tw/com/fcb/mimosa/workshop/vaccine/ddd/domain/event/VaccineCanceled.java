package tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.event;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

import java.util.List;
@Data
@RequiredArgsConstructor
public class VaccineCanceled {

 final List<Vaccine> vaccines;

}
