package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.RentType;
import vn.codegym.model.Service;
import vn.codegym.model.ServiceType;

@Transactional
public interface ServiceRepository extends JpaRepository<Service, String> {
    Page<Service> findAll(Pageable pageable);

    Page<Service> findAllByNameContaining(String keyWord, Pageable pageable);

    boolean existsById(String id);

    @Modifying
    @Query(value = "update Service s set s.id = :newId, s.name = :newName, s.area = :newArea, s.cost = :newCost," +
            " s.maxPeople = :newMaxPeople, s.standardRoom = :newStandardRoom, s.descriptionOtherConvenience = :newDescription," +
            "s.poolArea = :newPoolArea, s.numberOfFloors = :newNumberOfFloors, s.serviceType = :newServiceType, " +
            "s.rentType = :newRentType where s.id = :id")
    int updateById(@Param("newId") String newId, @Param("newName") String newName, @Param("newArea") Double newArea,
                   @Param("newCost") Double newCost, @Param("newMaxPeople") Integer newMaxPeople,
                   @Param("newStandardRoom") String newStandardRoom, @Param("newDescription") String newDescription,
                   @Param("newPoolArea") Double newPoolArea, @Param("newNumberOfFloors") Integer newNumberOfFloors,
                   @Param("newServiceType") ServiceType newServiceType, @Param("newRentType") RentType newRentType, @Param("id") String id);
}
