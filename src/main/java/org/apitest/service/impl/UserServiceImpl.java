package org.apitest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apitest.dao.UserDao;
import org.apitest.entity.User;
import org.apitest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service("attrService")
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {


}
