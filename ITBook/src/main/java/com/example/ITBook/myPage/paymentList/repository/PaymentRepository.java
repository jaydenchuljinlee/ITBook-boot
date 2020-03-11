package com.example.ITBook.myPage.paymentList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ITBook.common.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
