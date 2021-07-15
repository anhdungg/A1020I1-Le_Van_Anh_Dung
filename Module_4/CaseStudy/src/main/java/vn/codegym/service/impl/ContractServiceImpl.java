package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Contract;
import vn.codegym.repository.ContractRepository;
import vn.codegym.service.ContractService;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository repository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Contract> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Contract> search(Pageable pageable, String keyword) {
        return repository.search(pageable, keyword);
    }

    @Override
    public Contract findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Contract contract) {
        repository.save(contract);
    }
}
