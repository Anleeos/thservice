package com.tracehub.service.thservice.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.tracehub.service.thservice.Data.User;
import com.tracehub.service.thservice.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository uRepository;
    @PostMapping("/signup")
    public Map<String,String> signUp(@RequestBody User user)
    {
        Map<String,String> msg = new HashMap<String,String>();
        String name  = user.getName();
        Optional<User> ret = uRepository.findById(name); 
        boolean find = !ret.isEmpty();
        if(find)
        {
            msg.put("msg", "existed");
            return msg;
        }
        uRepository.save(user);
        msg.put("msg", "success");
        return msg;
    }
    @PostMapping("/login")
    public Map<String,String> logIn(@RequestBody User user)
    {
        Map<String,String> msg = new HashMap<String,String>();
        Optional<User> ret = uRepository.findById(user.getName());
        boolean find = !ret.isEmpty();
        if(find)
        {
            boolean password = ret.get().getPassword().equals(user.getPassword());
            if(password)
            {
                msg.put("msg", "success");
                return msg;
            }
        }
        msg.put("msg", "wrong");
        return msg;
    }
}
