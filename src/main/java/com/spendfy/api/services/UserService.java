package com.spendfy.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spendfy.api.models.User;
import com.spendfy.api.repository.UserRepository;
import com.spendfy.api.utils.Encrypt;

@Service
public class UserService {

    @Autowired

    private UserRepository userRepository;

    public List<User> getUsers (){
        return userRepository.findAll();
    }

    public void createUser(User user){
        
        try {

            String encrypted_pwd = Encrypt.getInstance(user.getPassword()).encryptString();
            user.setPassword(encrypted_pwd);
            userRepository.save(user);

        } catch(Exception err){
            throw new Error("Cadastro não Efetuado!!", err);
        }
       
    }
    
}
