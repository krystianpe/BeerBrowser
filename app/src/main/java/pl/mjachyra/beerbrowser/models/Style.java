
package pl.mjachyra.beerbrowser.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Style implements Parcelable {

    public static final Creator<Style> CREATOR = new Creator<Style>() {
        @Override public Style createFromParcel(Parcel source) {
            return new Style(source);
        }

        @Override public Style[] newArray(int size) {
            return new Style[size];
        }
    };
    @SerializedName("abvMax")
    private String mAbvMax;
    @SerializedName("abvMin")
    private String mAbvMin;
    @SerializedName("category")
    private Category mCategory;
    @SerializedName("categoryId")
    private Long mCategoryId;
    @SerializedName("createDate")
    private String mCreateDate;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("fgMax")
    private String mFgMax;
    @SerializedName("fgMin")
    private String mFgMin;
    @SerializedName("ibuMax")
    private String mIbuMax;
    @SerializedName("ibuMin")
    private String mIbuMin;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("ogMin")
    private String mOgMin;
    @SerializedName("shortName")
    private String mShortName;
    @SerializedName("srmMax")
    private String mSrmMax;
    @SerializedName("srmMin")
    private String mSrmMin;
    @SerializedName("updateDate")
    private String mUpdateDate;

    public Style() {
    }

    protected Style(Parcel in) {
        this.mAbvMax = in.readString();
        this.mAbvMin = in.readString();
        this.mCategory = in.readParcelable(Category.class.getClassLoader());
        this.mCategoryId = (Long) in.readValue(Long.class.getClassLoader());
        this.mCreateDate = in.readString();
        this.mDescription = in.readString();
        this.mFgMax = in.readString();
        this.mFgMin = in.readString();
        this.mIbuMax = in.readString();
        this.mIbuMin = in.readString();
        this.mId = (Long) in.readValue(Long.class.getClassLoader());
        this.mName = in.readString();
        this.mOgMin = in.readString();
        this.mShortName = in.readString();
        this.mSrmMax = in.readString();
        this.mSrmMin = in.readString();
        this.mUpdateDate = in.readString();
    }

    public String getAbvMax() {
        return mAbvMax;
    }

    public String getAbvMin() {
        return mAbvMin;
    }

    public Category getCategory() {
        return mCategory;
    }

    public Long getCategoryId() {
        return mCategoryId;
    }

    public String getCreateDate() {
        return mCreateDate;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getFgMax() {
        return mFgMax;
    }

    public String getFgMin() {
        return mFgMin;
    }

    public String getIbuMax() {
        return mIbuMax;
    }

    public String getIbuMin() {
        return mIbuMin;
    }

    public Long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getOgMin() {
        return mOgMin;
    }

    public String getShortName() {
        return mShortName;
    }

    public String getSrmMax() {
        return mSrmMax;
    }

    public String getSrmMin() {
        return mSrmMin;
    }

    public String getUpdateDate() {
        return mUpdateDate;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mAbvMax);
        dest.writeString(this.mAbvMin);
        dest.writeParcelable(this.mCategory, flags);
        dest.writeValue(this.mCategoryId);
        dest.writeString(this.mCreateDate);
        dest.writeString(this.mDescription);
        dest.writeString(this.mFgMax);
        dest.writeString(this.mFgMin);
        dest.writeString(this.mIbuMax);
        dest.writeString(this.mIbuMin);
        dest.writeValue(this.mId);
        dest.writeString(this.mName);
        dest.writeString(this.mOgMin);
        dest.writeString(this.mShortName);
        dest.writeString(this.mSrmMax);
        dest.writeString(this.mSrmMin);
        dest.writeString(this.mUpdateDate);
    }
}
