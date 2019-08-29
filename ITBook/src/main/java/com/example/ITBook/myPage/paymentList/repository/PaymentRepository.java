package com.example.ITBook.myPage.paymentList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ITBook.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
