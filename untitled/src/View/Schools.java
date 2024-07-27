package View;

public class Schools {
    private int id;
    private String nameSchool;
    private String addressSchool;
    private static int idNext =1 ;

    public Schools( String nameSchool, String addressSchool) {
        this.id = idNext;
        this.nameSchool = nameSchool;
        this.addressSchool = addressSchool;
        idNext++;
    }

    public Schools(int id, String nameSchool, String addressSchool) {
        this.id = id;
        this.nameSchool = nameSchool;
        this.addressSchool = addressSchool;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    public String getAddressSchool() {
        return addressSchool;
    }

    public void setAddressSchool(String addressSchool) {
        this.addressSchool = addressSchool;
    }

    public static int getIdNext() {
        return idNext;
    }

    public static void setIdNext(int idNext) {
        Schools.idNext = idNext;
    }

    @Override
    public String toString() {
        return "STT trường: "+id +" || Tên truong: "+nameSchool+" || Địa chi trường: "+addressSchool;
    }
}
