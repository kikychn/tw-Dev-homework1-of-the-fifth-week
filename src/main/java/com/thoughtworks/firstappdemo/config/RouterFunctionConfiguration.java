package com.thoughtworks.firstappdemo.config;

import com.thoughtworks.firstappdemo.domain.Employee;
import com.thoughtworks.firstappdemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

@Configuration
public class RouterFunctionConfiguration {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> employeeFindAll(EmployeeRepo employeeRepo) {
        return RouterFunctions.route(RequestPredicates.GET("/employees"),
                request -> {
                    Collection<Employee> employees = employeeRepo.findAll();
                    Flux<Employee> employeeFlux = Flux.fromIterable(employees);
                    return ServerResponse.ok().body(employeeFlux, Employee.class);
                });
    }

}
