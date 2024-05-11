package org.maid.maid_library_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class MaidsLibraryManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaidsLibraryManagementSystemApplication.class, args);
    }

}
