package com.supratim.service;


import com.supratim.domain.StoreStatus;
import com.supratim.exceptions.UserException;
import com.supratim.modal.Store;
import com.supratim.modal.User;
import com.supratim.payload.dto.StoreDTO;

import java.util.List;

public interface StoreService {

    StoreDTO createStore(StoreDTO storeDTO, User user);
    StoreDTO getStoreById(Long id) throws Exception;
    List<StoreDTO> getAllStores();
    Store getStoreByAdmin() throws UserException;
    StoreDTO updateStore(Long id, StoreDTO storeDTO) throws UserException;
    void deleteStore(Long id) throws UserException;
    StoreDTO getStoreByEmployee() throws UserException;

    StoreDTO moderateStore(Long id, StoreStatus status) throws Exception;


}
