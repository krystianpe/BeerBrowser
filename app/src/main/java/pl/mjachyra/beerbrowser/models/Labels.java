
package pl.mjachyra.beerbrowser.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Labels implements Parcelable {

    @SerializedName("icon")
    private String mIcon;
    @SerializedName("large")
    private String mLarge;
    @SerializedName("medium")
    private String mMedium;

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getLarge() {
        return mLarge;
    }

    public void setLarge(String large) {
        mLarge = large;
    }

    public String getMedium() {
        return mMedium;
    }

    public void setMedium(String medium) {
        mMedium = medium;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mIcon);
        dest.writeString(this.mLarge);
        dest.writeString(this.mMedium);
    }

    public Labels() {
    }

    protected Labels(Parcel in) {
        this.mIcon = in.readString();
        this.mLarge = in.readString();
        this.mMedium = in.readString();
    }

    public static final Creator<Labels> CREATOR = new Creator<Labels>() {
        @Override public Labels createFromParcel(Parcel source) {
            return new Labels(source);
        }

        @Override public Labels[] newArray(int size) {
            return new Labels[size];
        }
    };
}
