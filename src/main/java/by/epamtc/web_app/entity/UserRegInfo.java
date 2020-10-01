package by.epamtc.web_app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class UserRegInfo implements Serializable {
    private static final long serialVersionUID = -1021626350444948511L;

    private String login;
    private String password;
    private String email;
    private String surname;
    private String name;
    private String passportID;
    private String passportIdentificationNumber;
    private Date birthday;

    public UserRegInfo(){
    }

    public UserRegInfo(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserRegInfo(String login, String password, String email, String surname, String name, String passportID, String passportIdentificationNumber, Date birthday) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.passportID = passportID;
        this.passportIdentificationNumber = passportIdentificationNumber;
        this.birthday = birthday;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public String getPassportIdentificationNumber() {
        return passportIdentificationNumber;
    }

    public void setPassportIdentificationNumber(String passportIdentificationNumber) {
        this.passportIdentificationNumber = passportIdentificationNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRegInfo)) return false;
        UserRegInfo that = (UserRegInfo) o;
        return Objects.equals(getLogin(), that.getLogin()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getSurname(), that.getSurname()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPassportID(), that.getPassportID()) &&
                Objects.equals(getPassportIdentificationNumber(), that.getPassportIdentificationNumber()) &&
                Objects.equals(getBirthday(), that.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword(), getEmail(), getSurname(), getName(), getPassportID(), getPassportIdentificationNumber(), getBirthday());
    }

    @Override
    public String toString() {
        return "UserRegInfo{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", passportID='" + passportID + '\'' +
                ", passportIdentificationNumber='" + passportIdentificationNumber + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
