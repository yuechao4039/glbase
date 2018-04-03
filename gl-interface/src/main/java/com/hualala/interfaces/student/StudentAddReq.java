package com.hualala.interfaces.student;


import com.hualala.interfaces.general.BaseReq;
import com.hualala.interfaces.general.NormalReq;
import lombok.Data;

@Data
public class StudentAddReq {


        private String uid;

        private String username;

        private String password;
}
