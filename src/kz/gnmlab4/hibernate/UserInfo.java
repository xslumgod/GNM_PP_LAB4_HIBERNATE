package kz.gnmlab4.hibernate;

public class UserInfo {


    private Integer id;
    private String placeWork;
    private String workNumber;

    public UserInfo() {
    }

    public UserInfo(String placeWork, String workNumber) {
        this.placeWork = placeWork;
        this.workNumber = workNumber;
    }

        public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaceWork() {
        return placeWork;
    }

    public void setPlaceWork(String placeWork) {
        this.placeWork = placeWork;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }
    
    @Override
    public String toString() {
        return String.format("UserInfo [id=%s, placeWork=%s, workNumber=%s]", id, placeWork, workNumber);
    }
}
