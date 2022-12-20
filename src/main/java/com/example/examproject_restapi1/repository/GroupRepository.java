package com.example.examproject_restapi1.repository;

import com.example.examproject_restapi1.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query(value = "select c from Group c where c.company.id = :companyId")
    List<Group> getAllGroup(Long companyId);
}
