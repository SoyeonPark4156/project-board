package com.bitstudy.app.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity/* 테이블과의 매핑 한다는 뜻
          JPA 가 관리한다.
          PK키 알아볼 수 있게 필드들중 하나에 @Id 어노테이션 달아줘야 한다.
          */
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})

public class Ex02_2_ArticleComment_바인딩_설정 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false)
    private Article article;
//    @Setter
//    @Column(nullable = false)
//    private Long articleId;
    /** 연관관계 매핑
     *  연관관계 없이 만들면 private Long articleId: 이런식으로 (관계형 데이터베이스 스타일) 하면된다.
     *  그런데 우리는 Article과 ArticleComment 가 관계를 맺고 있는 걸 객체지향적으로 표현하려고 이렇게 쓸것임
     *  그러기 위해서 필요한건 단방향 이라는 뜻의 @ManyToOne 에너테이션을 써주고,
     *  이건 필수값이다 라는 뜻으로 (optional = false)
     *  댓글은 여러개인데 게시글은 1개니깐... n:1이라고 표현한 것이고, 단방향 방식을 썼다
     * **/
    @Setter
    @Column(nullable = false, length = 500)
    private String content; //본문

    //메타데이터
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt; // 생성일시

    @CreatedBy
    @Column(nullable = false, length = 100)
    private String createdBy; //생성자

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt; //수정일시

    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modifiedBy; //수정자
}