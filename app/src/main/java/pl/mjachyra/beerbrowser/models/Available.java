
package pl.mjachyra.beerbrowser.models;

import com.google.gson.annotations.SerializedName;

public class Available {

    @SerializedName("description")
    private String mDescription;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
