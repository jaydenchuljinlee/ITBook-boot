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

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

	@Modifying
	@Transactional
	@Query(value = "insert into Payment values(:#{#payment})",nativeQuery = false)
	Optional<Payment> insert(@Param("payment") Payment payment);
	
	@Modifying
	@Transactional
	@Query(value = "update payment p set p.state = 0 "
					+ "where p.user_no = :#{#user_no} and p.pay_no = :#{#pay_no}",nativeQuery = false)
	Optional<Payment> updatePaymentStateOnFalse(@Param("pay_no") long pay_no, @Param("user_no") long user_no);
	
}
