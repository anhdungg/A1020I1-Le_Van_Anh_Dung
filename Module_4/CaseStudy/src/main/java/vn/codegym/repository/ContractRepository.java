package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAll(Pageable pageable);

    @Query("select c from Contract c inner join Customer cs on cs.id = c.customer.id " +
            "inner join Employee e on e.id = c.employee.id inner join Service s on s.id = c.service.id " +
            "where cs.name like %:keyword% or e.name like %:keyword% or s.name like %:keyword%")
    Page<Contract> search(Pageable pageable, @Param("keyword") String keyword);
}
