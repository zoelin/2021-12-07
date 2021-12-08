package tw.com.fcb.mimosa.workshop.vaccine;

import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import tw.com.fcb.mimosa.Mimosa;
import tw.com.fcb.mimosa.MimosaBootstrap;

@EnableScheduling
@EnableJpaRepositories
@EnableFeignClients
@MimosaBootstrap
public class Vaccine1922Application {

  public static void main(String[] args) {
    Mimosa.bootstrap(Vaccine1922Application.class, args);
  }
}
