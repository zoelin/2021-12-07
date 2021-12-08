package tw.com.fcb.mimosa.workshop.vaccine.sharedkernel;

import lombok.Data;

import java.util.List;

@Data
public class ResidentProfile {
  String nhiNo;
  String phoneNo;
  List<Vaccine> chooses;
}
