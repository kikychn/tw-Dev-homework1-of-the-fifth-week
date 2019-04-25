package com.thoughtworks.firstappdemo.repo;

import com.thoughtworks.firstappdemo.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EmployeeRepo {

    private final Map<Integer, Employee> repository = new HashMap<>();
    private final static AtomicInteger idGenerator = new AtomicInteger();

    public boolean save(Employee employee) {
        Integer id = idGenerator.getAndIncrement();
        employee.setId(id);
        return repository.put(id, employee) == null;
    }

    public Collection<Employee> findAll() {
        return repository.values();
    }
}
