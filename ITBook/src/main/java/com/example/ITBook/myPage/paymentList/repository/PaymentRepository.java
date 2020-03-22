package com.example.ITBook.myPage.paymentList.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

	List<PaymentInformation> findByUser(User user); 
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Payment SET state = 0 "
					+ "WHERE user_no = :#{#user_no} and pay_no = :#{#pay_no}",nativeQuery = false)
	int updatePaymentStateOnFalse(@Param("pay_no") long pay_no, @Param("user_no") long user_no);
	
}
