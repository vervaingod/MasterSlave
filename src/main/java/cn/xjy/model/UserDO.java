package cn.xjy.model;


/**
 * ClassName: UserDO
 * Function: UserBean
 * date: 2018年7月18日
 *
 * @author 许嘉阳
 * @version 1
 */

public class UserDO {
    private Integer userId;
    private String userName;
    private String password;
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