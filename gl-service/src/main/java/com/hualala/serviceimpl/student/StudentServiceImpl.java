package com.hualala.serviceimpl.student;



import com.github.pagehelper.PageHelper;
import com.hualala.interfaces.general.*;
import com.hualala.interfaces.student.*;
import com.hualala.repository.minor.student.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "studentServiceImpl")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public BaseResp select(PageReq<StudentQueryReq> studentQueryRequest) {

        PageHelper.startPage(studentQueryRequest.getNum(), studentQueryRequest.getSize());
        List<Student> list = this.studentDao.selectAll();
        PageResp<StudentSelectRep> resp = new PageResp<>();
        StudentSelectRep rep = new StudentSelectRep();
        list.forEach(student -> {
            StudentSelectRep.StudentSelectRepPojo pojo = rep.new StudentSelectRepPojo();
            pojo.setUid(student.getUid());
            pojo.setUsername(student.getUsername());
            pojo.setPassword(student.getPassword());
            rep.add(pojo);
        });
        resp.setData(rep);
        resp.setRows(list.size());

        return resp;
    }

    @Override
    public BaseResp add(NormalReq<StudentAddReq> studentAddReq) {
        int i = this.studentDao.add(studentAddReq.getData());
        return new BaseResp();
    }

    @Override
    public BaseResp update(NormalReq<StudentUpdateReq> studentUpdateReq) {
        int i = this.studentDao.update(studentUpdateReq.getData());
        return new BaseResp();
    }

    @Override
    public BaseResp delete(NormalReq<StudentDelReq> studentDelReq) {
        int i = this.studentDao.delete(studentDelReq.getData());
        return new BaseResp();
    }


}
