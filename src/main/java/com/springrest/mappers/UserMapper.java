package com.springrest.mappers;

import com.springrest.model.User;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

/**
 * Created by tanerali on 24/07/2017.
 */

@Mapper
public interface UserMapper {

    String GET_ALL__ACTIVE_USERS = "SELECT * FROM `users`.users where isActive = 1";

    String GET_BY_ID = "SELECT * FROM `users`.users where id = #{id}";

    String INSERT_USER = "INSERT INTO `users`.users (first_name, last_name, isActive) " +
            "VALUES (#{first_name}, #{last_name}, #{isActive})";

    String UPDATE_USER = "UPDATE `users`.users SET first_name = #{first_name}, " +
            "last_name = #{last_name}, isActive = #{isActive} WHERE id = #{id}";

    String DELETE_USER = "UPDATE `users`.users set isActive = 0 WHERE id = #{id}";

    String GET_BY_NAME = "SELECT * FROM `users`.users where first_name = #{first_name}";

    @Select(GET_BY_NAME)
    public User getByName(String name);

    @Select(GET_ALL__ACTIVE_USERS)
    public ArrayList<User> getAllUsers();

    @Select(GET_BY_ID)
    public User getByID(int id);

    @Insert(INSERT_USER)
    public int insertUser (User user);

    @Update(UPDATE_USER)
    public int updateUser (User user);

    @Delete(DELETE_USER)
    public int deleteUser(int id);

}