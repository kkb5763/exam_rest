package membership;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"membership.*"})
@SpringBootApplication
public class membershipApplication {
    public static void main(String[] args) {
        SpringApplication.run(membershipApplication.class, args);
    }
}
