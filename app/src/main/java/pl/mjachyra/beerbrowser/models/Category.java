
package pl.mjachyra.beerbrowser.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Category implements Parcelable{

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        @Override public Category[] newArray(int size) {
            return new Category[size];
        }
    };
    @SerializedName("createDate")
    private String mCreateDate;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;

    public Category() {
    }

    protected Category(Parcel in) {
        this.mCreateDate = in.readString();
        this.mId = (Long) in.readValue(Long.class.getClassLoader());
        this.mName = in.readString();
    }

    public String getCreateDate() {
        return mCreateDate;
    }

    public Long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mCreateDate);
        dest.writeValue(this.mId);
        dest.writeString(this.mName);
    }
}
