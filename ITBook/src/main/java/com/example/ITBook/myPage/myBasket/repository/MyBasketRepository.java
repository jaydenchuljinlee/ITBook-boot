package com.example.ITBook.myPage.myBasket.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ITBook.common.domain.MyBasket;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.domain.pk.MyBasketPK;

/*
* 장바구니 관련 repository
* */
@Repository
public interface MyBasketRepository extends JpaRepository<MyBasket, MyBasketPK>{

	List<MyBasket> findAllByUser(User user)throws Exception;


	/*
	* 환불
	* */
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM MyBasket WHERE isbn = :#{#myBasket.isbn} and user_no = :#{#myBasket.user_no}",nativeQuery = false)
	int remove(@Param("myBasket") MyBasket myBasket) throws Exception;
}
