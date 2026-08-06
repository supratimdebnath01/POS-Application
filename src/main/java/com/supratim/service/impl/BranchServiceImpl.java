package com.supratim.service.impl;

import com.supratim.exceptions.UserException;
import com.supratim.modal.Store;
import com.supratim.modal.User;
import com.supratim.payload.dto.BranchDTO;
import com.supratim.repository.BranchRepository;
import com.supratim.repository.StoreRepository;
import com.supratim.repository.UserRepository;
import com.supratim.service.BranchService;
import com.supratim.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final StoreRepository storeRepository;
    private final UserService userService;

    @Override
    public BranchDTO createBranch(BranchDTO branchDTO, User user) throws UserException {
        User currentUser = userService.getCurrentUser();
        Store store = storeRepository.findByStoreAdminId(user.getId());
        return null;
    }

    @Override
    public BranchDTO updateBranch(Long id, BranchDTO branchDTO, User user) {
        return null;
    }

    @Override
    public BranchDTO deleteBranch(Long id) {
        return null;
    }

    @Override
    public List<BranchDTO> getAllBranchesByStoreId(Long storeId) {
        return List.of();
    }

    @Override
    public BranchDTO getBranchById(Long id) {
        return null;
    }
}
