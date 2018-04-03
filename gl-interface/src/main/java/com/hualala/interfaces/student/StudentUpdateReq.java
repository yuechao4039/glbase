package com.hualala.interfaces.student;


import com.hualala.interfaces.general.BaseReq;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
public class StudentUpdateReq {

    private String uid;

    private String username;

    private String password;
}
