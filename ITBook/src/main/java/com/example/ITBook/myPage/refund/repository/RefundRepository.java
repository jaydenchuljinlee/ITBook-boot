package com.example.ITBook.myPage.refund.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ITBook.common.domain.Refund;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long>{

}
