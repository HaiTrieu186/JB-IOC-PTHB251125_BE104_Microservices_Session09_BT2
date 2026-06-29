package re.edu.pharmacyservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PharmacyServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PharmacyServiceApplication.class, args);
    }
}