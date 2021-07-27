package vn.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.customer.model.Province;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {

}
