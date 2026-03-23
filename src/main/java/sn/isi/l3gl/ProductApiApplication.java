package sn.isi.l3gl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

// Dit à JPA où trouver les entités (@Entity) de product-core
// @EntityScan(basePackages = "sn.isi.l3gl.core.entity")

// Dit à Spring où trouver les repositories (@Repository) de product-core
// @EnableJpaRepositories(basePackages = "sn.isi.l3gl.core.repository")
public class ProductApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApiApplication.class, args);
    }
}