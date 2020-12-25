package com.psbc.zcy;


//import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;


//@EnableSwagger2Doc
@EnableOpenApi
@SpringBootApplication
public class ZcyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZcyApplication.class, args);
    }

}
