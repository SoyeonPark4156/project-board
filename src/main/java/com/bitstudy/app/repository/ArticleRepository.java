package com.bitstudy.app.repository;

import com.bitstudy.app.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**TDD 를 위해서 임시로 만들어 놓은 저장소(이거로 DB에 접근할거다)
 *
 * - TDD 만드는 법
 * 1) 우클릭 > go to > Test(ctrl+shift+T)
 * 2) Junit5 버전인지 확인
 */
/* 할일 - 클래스 위에
* */

@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
