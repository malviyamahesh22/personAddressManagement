package com.tsystems.repository;

import com.tsystems.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 * Created by Mahesh on 24-01-2022.
 */
@Service
public interface PersonRepo extends JpaRepository<PersonEntity, Integer> {

    @Query(nativeQuery = true, value = "select max(person_id) from T_SYS_PERSON")
    public Integer getMaxPersonId();
}
