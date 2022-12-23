package com.bitstudy.app.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
/* 할일 : Article.java 와 ArticleComment.java 의 중복필드를 합치자!
    1) Article 에 있는 메타데이터(auditing 에 관련된 필드들) 가져오기
    2) 클래스레벨에 @MappedSuperclass 달아주기
    3) auditing 과 관련된 것들 다 가져오기
        ex) Article 에서는 @EntityListeners(AuditingEntityListener.class)


  * 파싱 : 일정한 문법을 토대로 나열된 data 를 그 문법에 맞춰서 분석해서 새로 구성하는거
*/
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class) /*이거 없으면 테스트 할 때 crateAt 때문에 에러남*/
@MappedSuperclass
public class AuditingFields {

    //메타데이터
    @CreatedDate //알아서 데이트 생성해라~
    @Column(nullable = false)
    private LocalDateTime createdAt; // 생성일시

    @CreatedBy
    @Column(nullable = false, length = 100)
    private String createdBy; // 생성자
    /**다른 생성일시 같은 것들은 알아낼 수 있는데, 최초 생성자는(현재 코드 상태) 인증받고 오지 않았기 때문에 따로 알아낼 수가 없다.
     * 이때 아까 만든 jpaConfig 파일을 사용한다.
     * */

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt; // 수정일시

    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modifiedBy; // 수정자

}
