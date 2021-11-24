package com.ruanxinxin.mvc01.dao;

import com.ruanxinxin.mvc01.config.MyCondition;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAOImpl {
    private SqlSessionTemplate sqlSessionTemplate=null;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }
    @Bean
    @Conditional(MyCondition.class)
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate){
        this.sqlSessionTemplate=sqlSessionTemplate;
    }
}
