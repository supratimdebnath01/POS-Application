package com.supratim.repository;

import com.supratim.modal.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {


    Store findByStoreAdminId(Long id);
}
