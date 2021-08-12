package com.lowes.govindsoni.repository;


import com.lowes.govindsoni.model.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<DataEntity, Long> {
}
