package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Besinler {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("porsiyon")
    @Expose
    private String porsiyon;
    @SerializedName("calories")
    @Expose
    private String calories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPorsiyon() {
        return porsiyon;
    }

    public void setPorsiyon(String porsiyon) {
        this.porsiyon = porsiyon;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

}