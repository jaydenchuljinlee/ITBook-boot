결제 정보
- 
- 결제, 결제 정보 등록

결제 및 결제 정보
- 
- 결제를 '결제 객체'와 '결제 정보 객체' 이 두가지로 나눠서 저장을 해놨는데
- 결제의 경우 장바구니에서 여러개를 선택하여 결제할 경우 하나의 결제를 가진 여러개의 결제 정보가 필요하기 때문입니다.
- 따라서 결제/결제 정보 객체를 나눠 줬고, 다중 결제 정보를 처리하기 위한 객체 포함 3개의 결제 관련 객체를 만들었습니다.


- 결제 객체 [Payment.java]
```java
package com.example.ITBook.common.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.*;


/*
 * 결제 테이블
 * */

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
@Table(name = "payment")
public class Payment implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pay_no;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name ="user_no")
    private User user;
	
	@Column(name = "price",length = 10)
	private int totalPrice;
	@Column(name = "quantity",length = 10)
	private int totalquantity;
	@Column(name = "state",length = 10)
	private int state;
	
	@Column(name = "pay_date",columnDefinition = "DATETIME")
	private LocalDateTime payDate;
	
	@Column(name = "name",columnDefinition = "VARCHAR",length = 50)
	private String name;
	@Column(name = "phone",columnDefinition = "VARCHAR",length = 50)
	private String phone;
	@Column(name = "house_phone",columnDefinition = "VARCHAR",length = 50)
	private String call;
	@Column(name = "message",columnDefinition = "VARCHAR",length = 50)
	private String message;
	@Column(name = "address_1",columnDefinition = "VARCHAR",length = 50)
	private String address1;
	@Column(name = "address_2",columnDefinition = "VARCHAR",length = 50)
	private String address2;
	@Column(name = "address_3",columnDefinition = "VARCHAR",length = 50)
	private String address3;
	@Column(name = "method",columnDefinition = "VARCHAR",length = 50)
	private String method;
	@Column(name = "apply_mileage",length = 10)
	private int mileage;

}

```
- 결제 정보 [PaymentInformation.java]
```java
package com.example.ITBook.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.ITBook.common.domain.pk.PaymentInformationPK;

import lombok.*;

/*
 * 결제 정보 테이블
 * */

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
@Table(name = "pay_info")
public class PaymentInformation  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PaymentInformationPK PK;
	
	@ManyToOne
	@MapsId("pay_no")
	@JoinColumn(name = "pay_no")
	private Payment payment;
	
	@ManyToOne
	@MapsId("isbn")
	@JoinColumn(name = "isbn")
	private Book book;
	
	@Column(columnDefinition = "INT",length = 11)
	private int quantity;
	
	
}

```
- 다중 결제 건수를 담아서 처리하기 위한 객체 [PayInfo.java]
```java
package com.example.ITBook.common.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 다중 건  결제 정보
 * */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PayInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Long> isbn;
	private List<Integer> quantity;
	private List<Integer> price;
	private List<String> thumb;
	private List<String> theme;
	
	private int genreCnt;
	private int totalCnt;
	private int totalMil;
	private int totalFee;
	private int delivery;

}

```
- 결제 정보 Primary Key [PaymentInformationPK.java]
```java
package com.example.ITBook.common.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.*;

/*
 * 결제정보 복합키 PK 객체
 * */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class PaymentInformationPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "pay_no")
	private long payNo;
	
	@Column(name = "isbn")
	private long isbn;
	
}

```


- 결제 관련 Controller [PayemntListWebController.java]
```java
package com.example.ITBook.myPage.paymentList.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.common.annotation.Session;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.PayInfo;
import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.myPage.paymentList.service.PaymentService;

/*
 * 결제 관련 컨트롤러
 * */
@Slf4j
@Controller
@SessionAttributes("user")
@RequestMapping("/payment")
public class PayemntListWebController {
	
	@Autowired
	private PaymentService paymentService;

	/*
	 * 장바구니 -> 결제 페이지
	 * */
	@PostMapping(value = "/")
	public String payment(@ModelAttribute PayInfo payInfo
			,Model model) throws Exception {

		log.info("PayemntListWebController.payment :::");

		List<Book> list = new ArrayList<Book>();
		
		setBookList(list,payInfo);//책 정보 세팅
		
		model.addAttribute("bookList", list);
		model.addAttribute("genreCnt", payInfo.getGenreCnt());
		model.addAttribute("totalFee", payInfo.getTotalFee());
		model.addAttribute("totalCnt", payInfo.getTotalCnt());
		model.addAttribute("totalMil", payInfo.getTotalMil());
		model.addAttribute("delivery", payInfo.getDelivery());
		
		return "myPage/payment.myPage-tiles";
	}
	
	/*
	 * 결제 완료
	 * */
	@Session(name = "user")
	@PostMapping(value="/completePay")
	public String completePay(@ModelAttribute Payment payment
			,@ModelAttribute PayInfo payInfo
			,User user
			,Model model) throws Exception {

		log.info("PayemntListWebController.completePay :::");

		List<PaymentInformation> payInfoList = paymentService.insertpayInfo(payment,payInfo,user);
		
		model.addAttribute("payInfoList", payInfoList);
		
		return "myPage/completePay.myPage-tiles";
	}
	
	/*
	 * 결제 정보에 대한 책 정보 리스트 세팅
	 * */
	private void setBookList(List<Book> list, PayInfo payInfo) {

		log.info("PayemntListWebController.setBookList :::");

		int length = payInfo.getIsbn().size();
		
		for(int i = 0; i < length; i++) {
			
			Book book = new Book();
			
			book.setIsbn(payInfo.getIsbn().get(i));
			book.setTheme(payInfo.getTheme().get(i));
			book.setImage(payInfo.getThumb().get(i));
			book.setQuantity(payInfo.getQuantity().get(i));
			book.setPrice(payInfo.getPrice().get(i));
			
			list.add(book);
		}
		
	}
}

```

- 결제 정보 Service [PaymentServiceImpl.java]
```java
package com.example.ITBook.myPage.paymentList.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.book.repository.BookRepository;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.PayInfo;
import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;
import com.example.ITBook.common.exception.OveredBookQuantityException;
import com.example.ITBook.common.exception.PamentSizeException;
import com.example.ITBook.myPage.paymentList.repository.PayInfoRepository;
import com.example.ITBook.myPage.paymentList.repository.PaymentRepository;
import com.example.ITBook.user.repository.UserRepository;

/*
* 결제 관련 Service
* */
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PayInfoRepository payInfoRepository;

	/*
	 * 결제
	 * @param 	: payment(결제 객체), payInfo(결제정보-다중구매 리스트)
	 * @return	: 
	 * @throws	: exception, PamentSizeException(결제 처리 0), OveredBookQuantityException(재고 범위 초과)
	 * */
	@Transactional
	@Override
	public List<PaymentInformation> insertpayInfo(Payment payment,PayInfo payInfo, User user) throws Exception {

		log.info("PaymentServiceImpl.insertpayInfo :::");

		List<PaymentInformation> paymentInfoList = new ArrayList<PaymentInformation>();//결제 정보를 저장하기 위한 리스트
		
		List<Book> list		= new ArrayList<Book>();//책 정보를 처리하기 위한 리스트
		
		checkPayment(list,payInfo);// 결제 건수, 재고 유무 처리
		
		user.setMileage(payInfo.getTotalMil());
		payment.setUser(user);
		
		paymentRepository.save(payment);//결제 저장
		
		if (!paymentRepository.existsById(payment.getPay_no())) throw new DoNotUpdateOrInsertException();// 결제가 제대로 이뤄지지 않았을 경우 Exception
		
		paymentInfoSaveInRepository(payInfo,payment,list,paymentInfoList);// 결제 정보 리스트 insert
		
		return paymentInfoList;
	}
	
	/*
	 * 결제
	 * @param 	: user_no(유저 번호)
	 * @return	: 결제 리스트
	 * @throws	: exception
	 * */
	@Override
	public List<PaymentInformation> selectList(Long user_no) throws Exception {

		log.info("PaymentServiceImpl.selectList :::");

		return paymentRepository.findByUser(User.builder()
												.userNo(user_no)
												.build());
	}
	
	/*
	 * 다중 결제정보 처리
	 * @param : list(재고 리스트), payInfo(결제 정보 리스트, payment(결제 테이블),paymentInfoList(리턴 객체))
	 * */
	private void paymentInfoSaveInRepository(PayInfo payInfo, Payment payment, List<Book> list,List<PaymentInformation> paymentInfoList) {

		log.info("PaymentServiceImpl.paymentInfoSaveInRepository :::");

		for (int i = 0,loop = payInfo.getIsbn().size(); i < loop; i++) {//결제 정보를 하나씩 가져와 저장
			
			int quantity = payInfo.getQuantity().get(i);//해당 정보의 수량
			
			//결제 정보
			PaymentInformation paymentInformation = PaymentInformation.builder()
																		.payment(payment)
																		.book(list.get(i))
																		.quantity(quantity)
																		.build();
			
			paymentInfoList.add(payInfoRepository.save(paymentInformation));
		}
		
	}

	/*
	 * 결제 가능 상태 체크
	 * @param : list(재고 리스트), payInfo(결제 정보 리스트)
	 * */
	private void checkPayment(List<Book> list,PayInfo payInfo) {

		log.info("PaymentServiceImpl.checkPayment :::");

		int length = payInfo.getIsbn().size();//결제 정보의 갯수
		
		if (length == 0) throw new PamentSizeException();//결제 처리를 찾을 수 없음
		
		List<Book> original =  bookRepository.findByIsbnIn(payInfo.getIsbn());//재고
		
		for(int i = 0; i < length; i++) {// 결제 정보 리스트 분기문 체크 
			
			long isbn 		= payInfo.getIsbn().get(i);
			
			Book book = Book.builder()
							.isbn(isbn)
							.quantity(payInfo.getQuantity().get(i))
							.build();
			
			int currentCnt	= payInfo.getQuantity().get(i);//현재 요청 구매량
			int originalCnt = original.get(original.indexOf(book)).getQuantity();//재고량
			
			if (originalCnt < currentCnt) //재고 범위 초과
				throw new OveredBookQuantityException(currentCnt, originalCnt);
			
			list.add(book);
		}
	}

}

```

