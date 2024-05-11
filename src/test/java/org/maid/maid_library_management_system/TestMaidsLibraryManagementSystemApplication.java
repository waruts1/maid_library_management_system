package org.maid.maid_library_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestMaidsLibraryManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.from(MaidsLibraryManagementSystemApplication::main).with(TestMaidsLibraryManagementSystemApplication.class).run(args);
    }

}
