package com.tanseer.Springboot.tutorial.repository;

import com.tanseer.Springboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {

        Department department =
                Department.builder()
                .departmentName("Mechanical Engineering")
                .departmentAddress("Delhi")
                .departmentCode("ME - 006")
                .build();

        entityManager.persist(department);
    }

    @Test
    @DisplayName("When FindById is found")
    public void whenFindById_theReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentCode(),"ME - 006");
    }
}