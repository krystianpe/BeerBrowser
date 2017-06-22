
package pl.mjachyra.beerbrowser.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Glass implements Parcelable {

    @SerializedName("createDate")
    private String mCreateDate;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;

    public String getCreateDate() {
        return mCreateDate;
    }

    public void setCreateDate(String createDate) {
        mCreateDate = createDate;
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

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mCreateDate);
        dest.writeValue(this.mId);
        dest.writeString(this.mName);
    }

    public Glass() {
    }

    protected Glass(Parcel in) {
        this.mCreateDate = in.readString();
        this.mId = (Long) in.readValue(Long.class.getClassLoader());
        this.mName = in.readString();
    }

    public static final Creator<Glass> CREATOR = new Creator<Glass>() {
        @Override public Glass createFromParcel(Parcel source) {
            return new Glass(source);
        }

        @Override public Glass[] newArray(int size) {
            return new Glass[size];
        }
    };
}
