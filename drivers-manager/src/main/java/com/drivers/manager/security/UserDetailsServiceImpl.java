package com.drivers.manager.security;

import com.drivers.entity.SysManager;
import com.drivers.repository.SysManagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/12
 */
@Service("userDetailsService")
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysManagerRepository sysManagerRepository;
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        log.debug("Authenticating {}", username);
        Optional<SysManager> sysManager = sysManagerRepository.findOneByUsername(username);
//        String lowercaseLogin = login.toLowerCase();
        if (sysManager.isPresent()){
            SysManager xx = sysManager.get();
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            User user = new User(username,xx.getPassword(),grantedAuthorities);
            return user;
        }
        return null;
    }
}
