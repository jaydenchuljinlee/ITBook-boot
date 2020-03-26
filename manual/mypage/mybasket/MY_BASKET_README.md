장바구니 정보
-
- 장바구니 정보 등록, 수정, 삭제에 관련


장바구니 객체 정보
-
- 장바구니 객체는 기본 테이블과 결제 정보에 필요한 장바구니 Primary Key 객체. 이 두가지를 만들었습니다.

- 장바구니 객체 [MyBasket.java]
```java
package com.example.ITBook.common.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.ITBook.common.domain.pk.MyBasketPK;

import lombok.*;


/*
 * 장바구니 테이블
 * */

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
@Table(name = "mybasket")
public class MyBasket  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MyBasketPK myBasketPK;
	
	@ManyToOne
	@MapsId("isbn")
	@JoinColumn(name = "isbn")
	private Book book;
	
	@ManyToOne
	@MapsId("user_no")
	@JoinColumn(name = "user_no")
	private User user;
}


```
- 장바구니 Primary Key [MyBasketPK.java]
```java
package com.example.ITBook.common.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.*;


/*
* 장바구니 Primary Key
* */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class MyBasketPK  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "isbn")
	private long isbn;
	
	@Column(name = "user_no")
	private long user_no;

	
}

```

- 장바구니 관련 service [MyBasketServiceImpl.java]
```java
package com.example.ITBook.myPage.myBasket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.MyBasket;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.domain.pk.MyBasketPK;
import com.example.ITBook.common.exception.DuplicatedMyBasketException;
import com.example.ITBook.myPage.myBasket.repository.MyBasketRepository;

/*
* 장바구니 정보 Service
* */
@Slf4j
@Service
public class MyBasketServiceImpl implements MyBasketService {
	
	@Autowired
	private MyBasketRepository myBasketRepository;

	/*
	* 장바구니 정보 삭제
	* */
	@Override
	public boolean deleteMyBasket(long isbn, User user) throws Exception {

		log.info("MyBasketServiceImpl.deleteMyBasket :::");

		HashMap<String ,Object> map = new HashMap<>();
		
		Book book = Book.builder()
						.isbn(isbn)
						.build();
		
		MyBasket myBasket = MyBasket.builder()
									.book(book)
									.user(user)
									.build();
			
		return myBasketRepository.remove(myBasket) == 1 ? true : false;
	}

	/*
	* 해당 회원의 등록 된 모든 장바구니
	* */
	@Override
	public List<MyBasket> selectByUser(Long index) throws Exception {

		log.info("MyBasketServiceImpl.selectByUser :::");
		
		return myBasketRepository.findAllByUser(User.builder()//모든 장바구니 정보를 가져옴
													.userNo(index)
													.build());
	}

	/*
	* 장바구니 정보 insert
	* */
	@Override
	public boolean insertMyBasket(long isbn,long userIdx) throws Exception {

		log.info("MyBasketServiceImpl.insertMyBasket :::");

		Optional<MyBasket> chk = checkForExistence(isbn,userIdx);//장바구니 중복 검사
		
		if(chk.isPresent()) throw new DuplicatedMyBasketException(isbn);// 장바구니 중복 Exception
		
		return insertMyBasketInDB(isbn,userIdx);//저장 여부
	}

	/*
	* 장바구니 존재 여부
	* */
	private Optional<MyBasket> checkForExistence(long isbn, long idx) {

		log.info("MyBasketServiceImpl.checkForExistence :::");

		MyBasketPK pk = new MyBasketPK(isbn,idx);// 장바구니 PK
		
		return myBasketRepository.findById(pk);//존재 여부
	}

	/*
	* 데이터베이스에 장바구니 정보 insert
	* */
	private boolean insertMyBasketInDB(long isbn, long idx) throws Exception{

		log.info("MyBasketServiceImpl.insertMyBasketInDB :::");

		Book book = Book.builder()
						.isbn(isbn)
						.build();// 책 객체
		
		User user = User.builder()
						.userNo(idx)
						.build();// 회원 객체
		
		MyBasket myBasket = MyBasket.builder()
									.book(book)
									.user(user)
									.build();// 장바구니 정보 생성
							
		myBasketRepository.save(myBasket);// 저장
		
		return myBasketRepository.existsById(myBasket.getMyBasketPK());//저장 여부
	}
}

```

- 장바구니 관련 repository [MyBasketRepository.java]
```java
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
	
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM MyBasket WHERE isbn = :#{#myBasket.isbn} and user_no = :#{#myBasket.user_no}",nativeQuery = false)
	int remove(@Param("myBasket") MyBasket myBasket) throws Exception;
}

```

