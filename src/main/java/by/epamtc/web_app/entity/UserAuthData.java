package by.epamtc.web_app.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserAuthData implements Serializable {

    private static final long serialVersionUID = 2949363305125203047L;
    private String login;
    private String password;
    private String role;

    public UserAuthData(){
    }

    public UserAuthData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserAuthData(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAuthData)) return false;
        UserAuthData that = (UserAuthData) o;
        return Objects.equals(getLogin(), that.getLogin()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getRole(), that.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword(), getRole());
    }

    @Override
    public String toString() {
        return "UserAuthData{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
