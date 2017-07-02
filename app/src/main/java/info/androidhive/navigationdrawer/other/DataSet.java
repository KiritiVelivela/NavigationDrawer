package info.androidhive.navigationdrawer.other;

/**
 * Created by srilu on 5/31/17.
 */

public class DataSet {

    private String name, avatar_url;
    private int age;
    private String gender;
    private String history;
    private int technologyExists;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return avatar_url;
    }

    public void setImage(String image) {
        this.avatar_url = image;
    }

    public int getYear() {
        return age;
    }

    public void setYear(int year) {
        this.age = year;
    }

    public String getSource() {
        return gender;
    }

    public void setSource(String source) {
        this.gender = source;
    }

    public String getWorth() {
        return history;
    }

    public void setWorth(String worth) {
        this.history = worth;
    }

    public int getTechnologyExists() {
        return technologyExists;
    }

    public void setTechnologyExists(int technologyExists) {
        this.technologyExists = technologyExists;
    }

}
