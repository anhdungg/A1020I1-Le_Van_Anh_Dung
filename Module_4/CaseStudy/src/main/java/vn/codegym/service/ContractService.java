package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Contract;

import java.util.List;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    List<Contract> findAll();

    Page<Contract> search(Pageable pageable, String keyword);

    Contract findById(Integer id);

    void deleteById(Integer id);

    void save(Contract contract);
}
