package cn.xjy.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ClassName: UserDO
 * Function: UserBean
 * date: 2018年7月18日
 *
 * @author 许嘉阳
 * @version 1
 */

@ApiModel(value = "UserDO", description = "User对象")
public class UserDO {
    @ApiModelProperty(value = "用户编号", name = "userId", example = "1")
    private Integer userId;
    @ApiModelProperty(value = "用户名", name = "userName", example = "test")
    private String userName;
    @ApiModelProperty(value = "用户密码", name = "password", example = "admin")
    private String password;
    @ApiModelProperty(value = "用户电话", name = "phone", example = "12345678921")
    private String phone;

    public UserDO() {

    }

    public UserDO(String userName, String password, String phone) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
    }

    public UserDO(Integer userId, String userName, String password, String phone) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}