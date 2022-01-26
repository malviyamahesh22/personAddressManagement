package com.tsystems.repository;

import com.tsystems.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mahesh on 24-01-2022.
 */
public interface AddressRepo extends JpaRepository<AddressEntity, Integer> {

}
