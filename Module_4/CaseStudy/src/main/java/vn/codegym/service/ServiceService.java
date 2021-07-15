package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.RentType;
import vn.codegym.model.Service;
import vn.codegym.model.ServiceType;

import java.util.List;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);

    List<Service> findAll();

    Page<Service> findAllByNameContaining(String keyWord, Pageable pageable);

    Service findById(String id);

    void deleteById(String id);

    boolean existsById(String id);

    void save(Service service);

    int update(Service service, String id);
}
