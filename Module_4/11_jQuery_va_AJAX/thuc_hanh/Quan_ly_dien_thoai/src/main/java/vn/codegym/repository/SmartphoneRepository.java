package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Smartphone;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
