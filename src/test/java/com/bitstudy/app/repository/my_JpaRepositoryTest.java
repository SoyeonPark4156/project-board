package com.bitstudy.app.repository;

import com.bitstudy.app.config.JpaConfig;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(JpaConfig.class)

public class my_JpaRepositoryTest {

}
