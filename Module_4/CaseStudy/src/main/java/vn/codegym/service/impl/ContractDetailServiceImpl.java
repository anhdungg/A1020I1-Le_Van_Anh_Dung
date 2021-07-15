package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.ContractDetail;
import vn.codegym.repository.ContractDetailRepository;
import vn.codegym.service.ContractDetailService;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository repository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<ContractDetail> findAllByAttachService_NameContaining(Pageable pageable, String keyword) {
        return repository.findAllByAttachService_NameContaining(pageable, keyword);
    }


    @Override
    public ContractDetail findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        repository.save(contractDetail);
    }
}
