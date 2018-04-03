package com.hualala.interfaces.user;



import com.hualala.interfaces.general.BaseResp;


import java.util.List;

public interface UserService {
    BaseResp select(UserQueryReq studentQueryRequest);

    BaseResp add(UserAddReq studentAddReq);

    BaseResp update(UserUpdateReq studentUpdateReq);

    BaseResp delete(UserDelReq studentDelReq);
}
