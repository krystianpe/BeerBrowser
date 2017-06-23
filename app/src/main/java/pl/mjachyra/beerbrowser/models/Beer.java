
package pl.mjachyra.beerbrowser.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Beer implements Parcelable {

    public static final Creator<Beer> CREATOR = new Creator<Beer>() {
        @Override public Beer createFromParcel(Parcel source) {
            return new Beer(source);
        }

        @Override public Beer[] newArray(int size) {
            return new Beer[size];
        }
    };
    @SerializedName("abv")
    private String mAbv;
    @SerializedName("available")
    private Available mAvailable;
    @SerializedName("availableId")
    private Long mAvailableId;
    @SerializedName("createDate")
    private String mCreateDate;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("glass")
    private Glass mGlass;
    @SerializedName("glasswareId")
    private Long mGlasswareId;
    @SerializedName("id")
    private String mId;
    @SerializedName("isOrganic")
    private String mIsOrganic;
    @SerializedName("labels")
    private Labels mLabels;
    @SerializedName("name")
    private String mName;
    @SerializedName("nameDisplay")
    private String mNameDisplay;
    @SerializedName("servingTemperature")
    private String mServingTemperature;
    @SerializedName("servingTemperatureDisplay")
    private String mServingTemperatureDisplay;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("statusDisplay")
    private String mStatusDisplay;
    @SerializedName("style")
    private Style mStyle;
    @SerializedName("styleId")
    private Long mStyleId;
    @SerializedName("updateDate")
    private String mUpdateDate;

    public Beer() {
    }

    protected Beer(Parcel in) {
        this.mDescription = in.readString();
        this.mId = in.readString();
        this.mGlass = in.readParcelable(Glass.class.getClassLoader());
        this.mLabels = in.readParcelable(Labels.class.getClassLoader());
        this.mNameDisplay = in.readString();
        this.mServingTemperatureDisplay = in.readString();
        this.mStatusDisplay = in.readString();
        this.mStyle = in.readParcelable(Style.class.getClassLoader());
    }

    public String getAbv() {
        return mAbv;
    }

    public Available getAvailable() {
        return mAvailable;
    }

    public Long getAvailableId() {
        return mAvailableId;
    }

    public String getCreateDate() {
        return mCreateDate;
    }

    public String getDescription() {
        return mDescription;
    }

    public Glass getGlass() {
        return mGlass;
    }

    public Long getGlasswareId() {
        return mGlasswareId;
    }

    public String getId() {
        return mId;
    }

    public String getIsOrganic() {
        return mIsOrganic;
    }

    public Labels getLabels() {
        return mLabels;
    }

    public String getName() {
        return mName;
    }

    public String getNameDisplay() {
        return mNameDisplay;
    }

    public String getServingTemperature() {
        return mServingTemperature;
    }

    public String getServingTemperatureDisplay() {
        return mServingTemperatureDisplay;
    }

    public String getStatus() {
        return mStatus;
    }

    public String getStatusDisplay() {
        return mStatusDisplay;
    }

    public Style getStyle() {
        return mStyle;
    }

    public Long getStyleId() {
        return mStyleId;
    }

    public String getUpdateDate() {
        return mUpdateDate;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mDescription);
        dest.writeString(this.mId);
        dest.writeParcelable(this.mGlass, flags);
        dest.writeParcelable(this.mLabels, flags);
        dest.writeString(this.mNameDisplay);
        dest.writeString(this.mServingTemperatureDisplay);
        dest.writeString(this.mStatusDisplay);
        dest.writeParcelable(this.mStyle, flags);
    }

    @Override public boolean equals(Object obj) {
        if (obj instanceof Beer) {
            Beer beer = (Beer) obj;
            return mId != null && mId.equals(beer.mId);
        }
        return super.equals(obj);
    }
}
