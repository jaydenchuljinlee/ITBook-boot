책 관련 정보
-
책 객체 생성, 책 정보 등록, 책 정보 조회, 책 정보 변경

책 관련 객체 생성
-
- 책 정보를 저장하기 위해 관련 객체를 생성해줬습니다.
- JPA ORM 방식으로 객체를 DB에 매칭시켜주기 위해 각 ENTITY마다 PK라는 객체를 만들어 줘서 매칭을 시켜줬습니다.
- 모든 책 관련 객체들은 dmoain 폴더 밑에 저장 해 뒀습니다.
  
- 책 객체 [Book.java] 
```java

package com.example.ITBook.common.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;

/*
 * 책 정보 DB 테이블
 * */
@NoArgsConstructor @AllArgsConstructor @Builder
@Data @EqualsAndHashCode(callSuper = false)
@Entity @Table(name = "book")
public class Book  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "BIGINT",length = 21)
	private Long isbn;
	
	@Column(columnDefinition = "INT",length = 11)
	private int price;
	@Column(columnDefinition = "INT",length = 11)
	private int page;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scode")
	private Scategory s_category;
	
	@Size(max = 11)
	private int quantity;
	
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String image;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String theme;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String original;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String publish;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String author;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String translator;
	
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime publishdate;
	
	@Column(columnDefinition = "TEXT")
	private String intro;
	@Column(columnDefinition = "TEXT")
	private String contents;
	@Column(columnDefinition = "TEXT")
	private String authorinfo;
}
```

- 책 카테고리 [Bookcategory.java] 

```java
package com.example.ITBook.common.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.example.ITBook.common.domain.pk.BookCategoryPK;

import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * 책 카테고리 테이블
 * */

@NoArgsConstructor
@Getter
@Entity
public class Bookcategory  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private BookCategoryPK pk;// 책 카테고리 복합 키 객체
	
	@ManyToOne
	@MapsId("isbn")
	@JoinColumn(name = "isbn")
	private Book book;
	
	@ManyToOne
	@MapsId("scode")
	@JoinColumn(name = "scode")
	private Scategory scategory;
	
	public Bookcategory(Book book,Scategory scategory) {
		this.pk = new BookCategoryPK(book.getIsbn(),scategory.getCode());
		this.book = book;
		this.scategory = scategory;
	}
	
}

```

- 상위 카테고리 [Bookcategory.java] 

```java
package com.example.ITBook.common.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.*;

/*
 * 상위 카테고리 테이블
 * */

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
@Table(name = "bcategory")
public class Bcategory  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private long code;
	
	private String name;

}

```

- 하위 카테고리 [Scategory.java] 

```java
package com.example.ITBook.common.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

/*
 * 자식 카테고리 테이블
 * */

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
@Table(name = "scategory")
public class Scategory  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private long code;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bcode")
	private Bcategory bcategory;
	
	private String name;
}

```

- 책 카테고리 PK [BookCategoryPK.java] 
```java
package com.example.ITBook.common.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.*;

/*
 * 책 카테고리 복합 키 객체
 * */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class BookCategoryPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "isbn")
	private long isbn;
	
	@Column(name = "scode")
	private long scode;


}

```

- 카테고리 PK [BookCategoryPK.java] 
```java
package com.example.ITBook.common.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.*;

/*
 * 카테고리 복합키 PK 객체
 * */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class CategoryPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "isbn")
	private long isbn;
	
	@Column(name = "code")
	private long code;

}

```



