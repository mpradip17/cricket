package cricket.circket.model;

/**
 * Created by root on 16/3/17.
 */

public class Theme {
    private int imageResourceId;
    private String profileName;
    private String phoneNumber;
    private String emailId;


    public Theme(int imageResourceId, String profileName) {
        this.imageResourceId = imageResourceId;
        this.profileName = profileName;

    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public String getProfileName() {
        return profileName;
    }


}
