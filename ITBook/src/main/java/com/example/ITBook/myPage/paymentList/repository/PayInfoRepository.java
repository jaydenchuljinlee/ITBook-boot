package com.example.ITBook.myPage.paymentList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.pk.PaymentInformationPK;

@Repository
public interface PayInfoRepository extends JpaRepository<PaymentInformation, PaymentInformationPK>{

}
