package com.hualala.interfaces.student;


import com.hualala.interfaces.general.BaseReq;
import com.hualala.interfaces.general.BaseResp;
import com.hualala.interfaces.general.NormalReq;
import com.hualala.interfaces.general.PageReq;
import com.hualala.interfaces.student.StudentAddReq;
import com.hualala.interfaces.student.StudentDelReq;

import java.util.List;

public interface StudentService {

    BaseResp select(PageReq<StudentQueryReq> studentQueryRequest);

    BaseResp add(NormalReq<StudentAddReq> studentAddReq);

    BaseResp update(NormalReq<StudentUpdateReq> studentUpdateReq);

    BaseResp delete(NormalReq<StudentDelReq> studentDelReq);
}
