package website.CZB.educationsystem.mapper;


import org.apache.ibatis.annotations.Mapper;
import website.CZB.educationsystem.entities.Admin;

@Mapper
public interface AdminMapper {
    Admin getByAdminPhone(String adminPhone);

    void register(Admin admin);

    void update(Admin admin);

    void changeName(Admin admin);

    //void deleteAdmin(Admin admin);

}
