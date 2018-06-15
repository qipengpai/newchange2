package com.qpp.configclient.aop;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class AuthServiceImpl implements AuthService {


    @Override
    public boolean checkAccess() {
        return true;
    }
}