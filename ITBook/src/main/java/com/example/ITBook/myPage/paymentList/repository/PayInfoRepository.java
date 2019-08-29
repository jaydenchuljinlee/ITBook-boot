package com.example.ITBook.myPage.paymentList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ITBook.domain.PaymentInformation;
import com.example.ITBook.domain.pk.PaymentInformationPK;

public interface PayInfoRepository extends JpaRepository<PaymentInformation, PaymentInformationPK>{

}
