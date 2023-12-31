package website.CZB.educationsystem.mapper;


import org.apache.ibatis.annotations.Mapper;
import website.CZB.educationsystem.entities.Device;
import website.CZB.educationsystem.entities.User;
import java.util.List;

@Mapper
public interface UserMapper {

    User getByUserPhone(String userPhone);

    void userRegister(User user);

    void userUpdate(User user);

    void userChangeName(User user);

    void deleteUser(User user);

    List<Device> myDeviceList(String userPhone);


}
