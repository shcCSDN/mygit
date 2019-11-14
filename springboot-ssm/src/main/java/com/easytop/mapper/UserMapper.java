package com.easytop.mapper;

import com.easytop.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
 
@Repository
public interface UserMapper {
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
    User Sel(int id);
    /**
     * 登陆
     * @param userName
     * @param passWord
     * @return
     */
    User login(String userName,String passWord);
    /**
     * 注册
     * @param user
     * @return
     */
    int register(User user);
    
    /**
     * 修改密码
     * @param userName
     * @return
     */
    void updateUser(String passWord,String userName);
}
