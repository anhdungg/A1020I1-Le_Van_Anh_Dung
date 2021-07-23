package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Smartphone;
import vn.codegym.repository.SmartphoneRepository;

import java.util.List;

@Service
public class SmartphoneServiceImpl implements SmartphoneService{
    @Autowired
    private SmartphoneRepository repository;

    @Override
    public List<Smartphone> findAll() {
        return repository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone phone) {
        return repository.save(phone);
    }

    @Override
    public Smartphone remove(Integer id) {
        repository.deleteById(id);
        return null;
    }
}
