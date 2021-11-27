package com.amirdehi.quvo.config;

import com.amirdehi.quvo.service.implementations.VoteServiceImpl;
import com.amirdehi.quvo.service.interfaces.IVoteService;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {
    @Bean
    public DataSource getDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:~/test");
        dataSourceBuilder.username("sa");
        return dataSourceBuilder.build();
    }
    @Bean
    public IVoteService voteService(){
        return new VoteServiceImpl();
    }
}
