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
    public Optional<User> findByEmail(String email);
    
    public Optional<User> findByEmailAndPassword(String email,String password);
    
    @Modifying
    @Transactional
    @Query(value = "update User u set u.name = :#{#user.name}"
    		+ ", u.password = :#{#user.password}"
    		+ ", u.principal = :#{#user.principal}"
    		+ ", u.socialType = :#{#user.socialType}"
    		+ ", u.phone = :#{#user.phone}"
    		+ ", u.address_1 = :#{#user.address1}"
    		+ ", u.address_2 = :#{#user.address2}"
    		+ ", u.address_3 = :#{#user.address3}"
    		+ ", u.mileage = :#{#user.mileage} where u.user_no = :#{#user.user_no}",nativeQuery = false)
    int update(@Param("user") User user);
    
}
