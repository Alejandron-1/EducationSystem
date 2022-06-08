package website.CZB.educationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.CZB.educationsystem.entities.Device;
import website.CZB.educationsystem.entities.User;
import website.CZB.educationsystem.mapper.UserMapper;

import java.util.List;

@Service
@Transactional
public class UserService {
    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public User getByUserPhone(String userPhone){
        return userMapper.getByUserPhone(userPhone);
    }

    public void register(User user){
        userMapper.register(user);
    }

    public void update(User user){
        userMapper.update(user);
    }


    public void changeName(User user){
        userMapper.changeName(user);
    }

    public void deleteUser(User user){
        userMapper.deleteUser(user);
    }

    public List<Device> myDeviceList(String userPhone){
        return userMapper.myDeviceList(userPhone);
    }
}
