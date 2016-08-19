package com.eMusicStore.csrf;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

/**
 * Created by Dilipan on 7/4/2016.
 */
public class StatelessCSRFSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().addFilterBefore(new StatelessCSRFFilter(),CsrfFilter.class);
    }

}
