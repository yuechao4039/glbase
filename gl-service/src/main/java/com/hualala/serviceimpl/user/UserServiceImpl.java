package com.hualala.serviceimpl.user;



import com.hualala.interfaces.general.BaseResp;
import com.hualala.interfaces.general.PageResp;
import com.hualala.interfaces.user.*;
import com.hualala.repository.main.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public BaseResp select(UserQueryReq studentQueryRequest) {
        List<User> list = this.userDao.selectAll();
        PageResp<UserSelectRep> resp = new PageResp<>();
        list.forEach(x -> {
            UserSelectRep rep = new UserSelectRep();
            rep.setId(x.getId());
            rep.setUsername(x.getUsername());
            rep.setAge(x.getAge());
//            resp.add(rep);
        });

        return resp;
    }

    @Override
    public BaseResp add(UserAddReq userAddReq) {
        int i = this.userDao.add(userAddReq);
        return new BaseResp();
    }

    @Override
    public BaseResp update(UserUpdateReq userUpdateReq) {
        int i = this.userDao.update(userUpdateReq);
        return new BaseResp();
    }

    @Override
    public BaseResp delete(UserDelReq userDelReq) {
        int i = this.userDao.delete(userDelReq);
        return new BaseResp();
    }
}
