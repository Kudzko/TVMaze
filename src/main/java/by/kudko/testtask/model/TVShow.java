package by.kudko.testtask.model;

public class TVShow {
    private String title;
    private String name;
    private String castInformation;
    private String birthDay;
    private Integer id;

    public TVShow() {
    }

    public TVShow(String title, String name, String castInformation, String birthDay) {
        this.title = title;
        this.name = name;
        this.castInformation = castInformation;
        this.birthDay = birthDay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCastInformation() {
        return castInformation;
    }

    public void setCastInformation(String castInformation) {
        this.castInformation = castInformation;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
