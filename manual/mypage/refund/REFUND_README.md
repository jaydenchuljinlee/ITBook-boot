환불 정보
-
- 환불 정보는 환불 정보를 등록하고, 요청/처리/완료에 따라 상태값을 변화합니다

- Todo : 환불 요청에 대한 처리/완료에 따른 로직 구현


- 환불 객체 [Refund.java]
```java
package com.example.ITBook.common.domain;

import java.io.Serializable;

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
* 환불 테이블
* */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "refund")
public class Refund  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idx;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name ="user_no")
    private User user;
	
	@Column(name = "state",columnDefinition = "INT",length = 11)
	private int state;
}

```

- 환불 요청 관련 Controller [RefundWebController.java]
```java
package com.example.ITBook.myPage.refund.web;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.common.annotation.Session;
import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.utils.JsonUtil;
import com.example.ITBook.myPage.paymentList.service.PaymentService;
import com.example.ITBook.myPage.refund.service.RefundService;

/*
 * 환불 관련 컨트롤러
 * */

@Slf4j
@Controller
@SessionAttributes("user")
@RequestMapping("/refund")
public class RefundWebController {

	@Autowired
	private PaymentService paymentService;
	@Autowired
	private RefundService refundService;
	
	/*
	 * 결제 리스트 컨트롤러
	 * */
	@Session(name = "user")
	@GetMapping(value = "/")
	public String refundHome(User user,Model model) throws Exception {

		log.info("RefundWebController.refundHome :::");

		List<PaymentInformation> payInfoList = paymentService.selectList(user.getUserNo());
		
		model.addAttribute("payInfoList", payInfoList);
		
		return "myPage/refund.myPage-tiles";
	}
	
	/*
	 * 환불 요청 컨트롤러
	 * */
	@Session(name = "user")
	@GetMapping(value = "/request")
	@ResponseBody
	public String refundRequest(@RequestParam long pay_no,User user,Model model) throws Exception {

		log.info("RefundWebController.refundRequest :::");

		boolean isSuccess = refundService.updatePaymentStateOnRefund(pay_no,user.getUserNo());
		
		HashMap<String, Object> rtnMap = new HashMap<>();
		
		if (isSuccess) rtnMap.put("RESULT", "SUCCESS");
		else rtnMap.put("RESULT", "FAILED");
		
		return JsonUtil.HashMapToJson(rtnMap);
	}
}

```

- 환불 요청 Service [RefundServiceImpl.java]
```java
package com.example.ITBook.myPage.refund.service;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.myPage.paymentList.repository.PaymentRepository;

/*
* 환불 관련 Service
* */
@Slf4j
@Service
public class RefundServiceImpl implements RefundService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	/*
	 * 결제
	 * @param 	: pay_no(결제 번호), user_no(회원 번호)
	 * @return	: optional<PaymentInformation> (성공 여부)
	 * @throws	: exception
	 * */
	@Override
	public boolean updatePaymentStateOnRefund(long pay_no, long user_no) throws Exception {

		log.info("RefundServiceImpl.refundRequest :::");

		return paymentRepository.updatePaymentStateOnFalse(pay_no, user_no) == 1 ? true : false;
	}
}

```

- 환불 요청은 결제 repository에서 진행 [PaymentRepository.java]
```java
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
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;

/*
* 결제 저장소
* */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

	List<PaymentInformation> findByUser(User user); 
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Payment SET state = 0 "
					+ "WHERE user_no = :#{#user_no} and pay_no = :#{#pay_no}",nativeQuery = false)
	int updatePaymentStateOnFalse(@Param("pay_no") long pay_no, @Param("user_no") long user_no);
	
}

```

