package SideProject.CodeLingo.mapper;

import SideProject.CodeLingo.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USER_TABLE WHERE USER_ID is #{userId}")
    User getUserProfile(
            @Param("userId") Long userId
    );

    @Select("SELECT * FROM USER_TABLE")
    List<User> getAllUserProfile();

    @Insert("INSERT INTO USER_TABLE VALUES(#{userId}, #{userName}, #{userEmail})")
    int insertUserProfile(
            @Param("userId") Long userId,
            @Param("userName") String userName,
            @Param("userEmail") String userEmail
    );

    @Update("UPDATE USER_TABLE " +
            "SET USER_NAME=#{userName}, USER_EMAIL=#{userEmail} " +
            "WHERE USER_ID is #{userId}")
    int updateUserProfile(
            @Param("userId") Long userId,
            @Param("userName") String userName,
            @Param("userEmail") String userEmail
    );

    @Delete("DELETE FROM USER_TABLE WHERE USER_ID is #{userId}")
    int deleteUserProfile(
            @Param("userId") Long userId
    );
}
