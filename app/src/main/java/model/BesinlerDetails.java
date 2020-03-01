package model;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BesinlerDetails {

    @SerializedName("besinler")
    @Expose
    private List<Besinler> besinler = null;

    public List<Besinler> getBesinler() {
        return besinler;
    }

    public void setBesinler(List<Besinler> besinler) {
        this.besinler = besinler;
    }

}