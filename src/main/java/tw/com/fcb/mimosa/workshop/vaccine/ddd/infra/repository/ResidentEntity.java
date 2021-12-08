package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository;


import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "RESIDENT")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ResidentEntity {

  @Id
  @GeneratedValue
  Long id;
  String nhiNo;
  String phoneNo;

  @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
  @JoinColumn(name = "resident_id")
  List<ChooseEntity> chooses;

  @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
  @JoinColumn(name = "resident_id")
  List<CancelEntity> cancels;

  @LastModifiedDate
  LocalDateTime lastModifiedDate;

}
