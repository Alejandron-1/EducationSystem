package website.CZB.educationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.CZB.educationsystem.entities.Admin;
import website.CZB.educationsystem.mapper.AdminMapper;

@Service
@Transactional
public class AdminService {
    private AdminMapper adminMapper;
    @Autowired

    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
    public Admin getByAdminPhone(String adminPhone){
        System.out.println("999999999999999999" + adminMapper + adminPhone);
        System.out.println(adminMapper);
        return adminMapper.getByAdminPhone(adminPhone);
    }

    public void register(Admin admin){
        adminMapper.register(admin);
    }

    public void update(Admin admin){
        adminMapper.update(admin);
    }

    public void changeName(Admin admin){
        adminMapper.changeName(admin);
    }

//    public void deleteAdmin(Admin admin){
//        adminMapper.deleteAdmin(admin);
//    }


}
