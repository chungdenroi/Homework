package spring.mvc.model;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
    @NotNull("Enter your name!")
    private String fullname;
    private Date birthday;
    private String email;
    private String address;
    private String mobilePhone;
    private String gender;

    public Customer() {
    }

    public Customer(String fullname, Date birthday, String email, String address, String mobilePhone, String gender) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String show() {
        return  "Full name: " + fullname + ", Birthday: " + birthday.toString() + ", Email: " + email + ", Address: " + address + ", Mobile Phone: " + mobilePhone + ", Gender: " + gender;
    }
}
