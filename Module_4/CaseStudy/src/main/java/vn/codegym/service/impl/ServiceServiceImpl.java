package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.RentType;
import vn.codegym.model.Service;
import vn.codegym.model.ServiceType;
import vn.codegym.repository.ServiceRepository;
import vn.codegym.service.ServiceService;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository repository;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Service> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Service> findAllByNameContaining(String keyWord, Pageable pageable) {
        return repository.findAllByNameContaining(keyWord, pageable);
    }

    @Override
    public Service findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    @Override
    public void save(Service service) {
        repository.save(service);
    }

    @Override
    public int update(Service service, String id) {
        return repository.updateById(service.getId(), service.getName(), service.getArea(), service.getCost(),
                service.getMaxPeople(), service.getStandardRoom(), service.getDescriptionOtherConvenience(),
                service.getPoolArea(), service.getNumberOfFloors(), service.getServiceType(), service.getRentType(), id);
    }
}
