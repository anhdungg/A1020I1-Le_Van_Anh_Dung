package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.ContractDetail;

public interface ContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);

    Page<ContractDetail> findAllByAttachService_NameContaining(Pageable pageable, String keyword);

    ContractDetail findById(Integer id);

    void deleteById(Integer id);

    void save(ContractDetail contractDetail);
}
