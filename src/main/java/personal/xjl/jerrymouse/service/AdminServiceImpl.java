package personal.xjl.jerrymouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.xjl.jerrymouse.entity.Admin;
import personal.xjl.jerrymouse.mapper.AdminMapper;

import java.util.List;

@Service
public class AdminServiceImpl {
    @Autowired
    AdminMapper adminMapper;
    //顯示所有管理员
    public List<Admin> findAllAdmins() { return adminMapper.queryAll(); }
    //新增管理员
    public void addAdmin(Admin admin) {adminMapper.insert(admin);}

    //登录功能，select查询结果为空，则没有对应用户，返回false，拒绝登录
    public boolean login(String username, String password) {
        List<Admin> admin=adminMapper.selectByNameAndPassword(username,password);
        if (admin.size()==0)
            return false;
        else
            return true;
    }
}
