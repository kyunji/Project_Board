package com.board.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//application.properties에 mybatis 설정이 추가되어서 해당 설정을 처리할 bean을 정의해야함


@Configuration
//해당 클래스에서 참조할 properties 파일 위치를 지정함
@PropertySource("classpath:/application.properties")
public class DBConfiguration {

    //bean으로 등록된 인스턴스를 클래스에 주입하는데 사용
    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    //@PropertySource에 지정된 파일(application.properties)에서 prefix에 해당하는 spring.datasource.hikari로 시작하는 설정을 모두 읽어들여 메서드에 매핑(바인딩)함
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    //히카리cp(connection pool 라이브러리 중 하나) 객체 생성
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    //순수 JDBC는 SQL을 실행할 때마다 커넥션을 맺고 끊는 I/O 작업을 함. 이 문제를 해결하기 위해 connnection pool 등장.
    //datasource는 connection pool을 지원하기 위한 인터페이스
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    //DB connection, SQL 실행에 대한 모든 것을 가침. mybatis와 spring 연동 모듈로 사용됨.
    //mybatis XML Mapper, 설정 파일 위치 등 지정, SqlSessionFactoryBean 자체가 아닌 getObject 메서드가 리턴함
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        //getResources 메서드의 인자로 지정된 패턴에 포함되는 XML Mapper를 인식하는 역할
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/**/*Mapper.xml"));
        //BoardMapper XML에서 parameterType과 resultType은 클래스의 full 패키지 경로가 포함되어야함. 이 설정을 통해서 패키지 경로를 일부 생략할 수 있음.
        factoryBean.setTypeAliasesPackage("com.board.domain");
        //mybatis 설정과 관련된 bean을 설정파일로 지정
        factoryBean.setConfiguration(mybatisConfg());
        return factoryBean.getObject();
    }

    @Bean
    //SqlSessionTemplate은 mybatis-spring 연동의 핵심 모듈
    //SqlSession을 구현하고 코드에서 SqlSession을 대체하는 역할
    //SqlSessionTemplate은 SqlSessionFactory를 통해 생성되고, DB의 커밋, 롤백 등 SQL에 필요한 모든 메서드를 갖는 객체
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    @Bean
    //application.properties에서 mybatis.configuration으로 시작하는 모든 설정을 읽어서 bean으로 등록
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration mybatisConfg() {
        return new org.apache.ibatis.session.Configuration();
    }

}
