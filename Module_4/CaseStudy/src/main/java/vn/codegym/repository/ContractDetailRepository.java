package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.ContractDetail;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    Page<ContractDetail> findAll(Pageable pageable);

    Page<ContractDetail> findAllByAttachService_NameContaining(Pageable pageable, String keyword);
}
