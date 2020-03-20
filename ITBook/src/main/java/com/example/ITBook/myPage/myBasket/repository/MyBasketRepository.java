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

@Repository
public interface MyBasketRepository extends JpaRepository<MyBasket, MyBasketPK>{

	List<MyBasket> findAllByUser(User user)throws Exception;

	@Modifying
	@Transactional
	@Query(value = "insert into MyBasket values(:#{#myBasket})",nativeQuery = false)
	Optional<MyBasket> insert(@Param("myBasket") MyBasket myBasket) throws Exception;
	
	@Modifying
	@Transactional
	@Query(value = "delete from MyBasket mb where mb.isbn = :#{#myBasket.isbn} and mb.user_no = :#{#myBasket.user_no}",nativeQuery = false)
	Optional<MyBasket> remove(@Param("myBasket") MyBasket myBasket) throws Exception;
}
