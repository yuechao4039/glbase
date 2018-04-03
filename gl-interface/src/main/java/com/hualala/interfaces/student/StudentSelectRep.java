package com.hualala.interfaces.student;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentSelectRep {

    private String name = "xxx";

    private Integer age = 14;

    private List<StudentSelectRepPojo>  students = new ArrayList<StudentSelectRepPojo>();

    public void add(StudentSelectRepPojo pojo) {
        this.students.add(pojo);
    }

    @Data
    public class StudentSelectRepPojo {
        private Integer uid;


        private String username;

        private String password;
    }

}
