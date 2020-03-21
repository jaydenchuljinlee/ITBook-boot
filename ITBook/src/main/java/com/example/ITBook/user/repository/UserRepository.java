package com.example.ITBook.user.repository;

import com.example.ITBook.common.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByIdentity(String identity) throws Exception;
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE User SET name = :#{#user.name}"
    		+ ", password = :#{#user.password}"
    		+ ", principal = :#{#user.principal}"
    		+ ", socialType = :#{#user.socialType}"
    		+ ", phone = :#{#user.phone}"
    		+ ", address_1 = :#{#user.address1}"
    		+ ", address_2 = :#{#user.address2}"
    		+ ", address_3 = :#{#user.address3}"
    		+ ", mileage = :#{#user.mileage} WHERE user_no = :#{#user.user_no}",nativeQuery = false)
    int update(@Param("user") User user) throws Exception;
    
    
}
