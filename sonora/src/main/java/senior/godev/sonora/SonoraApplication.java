package senior.godev.sonora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SonoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(SonoraApplication.class, args);
    }

}
