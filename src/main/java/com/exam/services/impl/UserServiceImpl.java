package com.exam.services.impl;

import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRole) throws Exception {
        User local = this.userRepository.findByUserName(user.getUserName());
        if(local != null){
            System.out.println("User is already there !!!");
            throw new Exception("User already present");
        }else{
            //create user
            for(UserRole ur: userRole){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRole);
            local =  this.userRepository.save(user);

        }
        return local;
    }

}
