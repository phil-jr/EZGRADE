package com.example.ezgrade.repo;

import com.example.ezgrade.model.GenericResponse;
import com.example.ezgrade.model.StudentClass;

public interface StudentClassRepositoryInterface {
    
    public GenericResponse addClass(StudentClass studentClass);

}
