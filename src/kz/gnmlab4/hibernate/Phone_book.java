package kz.gnmlab4.hibernate;

public class Phone_book {


    private Integer id;
    private UserInfo userInfo;
    private String Name_person;
    private String Surname;
    private String MiddleName;
    private String Address;
    private String Number;

    public Phone_book() {
    }

    public Phone_book(Integer id) {
        this.id = id;
    }

    public Phone_book(Integer id, UserInfo userIole, String Name_person) {
        this.id = id;
        this.userInfo = userIole;
        this.Name_person = Name_person;
    }

      public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getName_person() {
        return Name_person;
    }

    public void setName_person(String Name_person) {
        this.Name_person = Name_person;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String toString() {
        return String.format("Role-%d %s, Login-%s", userInfo.getId(), userInfo.getPlaceWork(), Name_person);
    }

}
