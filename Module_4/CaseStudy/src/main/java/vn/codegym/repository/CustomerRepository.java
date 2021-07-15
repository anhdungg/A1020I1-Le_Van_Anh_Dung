package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.Customer;


@Transactional
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByNameContaining(String keyWord, Pageable pageable);

    boolean existsById(String id);

    @Modifying
    @Query(value = "update Customer c set c.id = :newId where c.id = :id")
    int updateById(@Param("newId") String newId, @Param("id") String id);
}
