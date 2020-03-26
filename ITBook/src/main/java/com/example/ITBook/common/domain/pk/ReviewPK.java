package com.example.ITBook.common.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.*;

/*
 * ���� ����Ű PK ��ü
 * */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class ReviewPK  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "isbn")
	private long isbn;
	
	@Column(name = "user_no")
	private long user_no;
}
