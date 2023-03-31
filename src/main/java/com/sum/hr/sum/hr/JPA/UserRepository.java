package com.sum.hr.sum.hr.JPA;


import com.sum.hr.sum.hr.MODEL.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer>
{
    Users findByUserNameAndPassword(String userName,String password);

    List<Users> findByEmailId(String emailId);
    List<Users> findByUserId(int userId);
    List<Users> findByUserName(String userName);
}
