
package pl.mjachyra.beerbrowser.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Style implements Parcelable {

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

    public String getAbvMax() {
        return mAbvMax;
    }

    public void setAbvMax(String abvMax) {
        mAbvMax = abvMax;
    }

    public String getAbvMin() {
        return mAbvMin;
    }

    public void setAbvMin(String abvMin) {
        mAbvMin = abvMin;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
    }

    public Long getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(Long categoryId) {
        mCategoryId = categoryId;
    }

    public String getCreateDate() {
        return mCreateDate;
    }

    public void setCreateDate(String createDate) {
        mCreateDate = createDate;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getFgMax() {
        return mFgMax;
    }

    public void setFgMax(String fgMax) {
        mFgMax = fgMax;
    }

    public String getFgMin() {
        return mFgMin;
    }

    public void setFgMin(String fgMin) {
        mFgMin = fgMin;
    }

    public String getIbuMax() {
        return mIbuMax;
    }

    public void setIbuMax(String ibuMax) {
        mIbuMax = ibuMax;
    }

    public String getIbuMin() {
        return mIbuMin;
    }

    public void setIbuMin(String ibuMin) {
        mIbuMin = ibuMin;
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

    public String getOgMin() {
        return mOgMin;
    }

    public void setOgMin(String ogMin) {
        mOgMin = ogMin;
    }

    public String getShortName() {
        return mShortName;
    }

    public void setShortName(String shortName) {
        mShortName = shortName;
    }

    public String getSrmMax() {
        return mSrmMax;
    }

    public void setSrmMax(String srmMax) {
        mSrmMax = srmMax;
    }

    public String getSrmMin() {
        return mSrmMin;
    }

    public void setSrmMin(String srmMin) {
        mSrmMin = srmMin;
    }

    public String getUpdateDate() {
        return mUpdateDate;
    }

    public void setUpdateDate(String updateDate) {
        mUpdateDate = updateDate;
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

    public static final Creator<Style> CREATOR = new Creator<Style>() {
        @Override public Style createFromParcel(Parcel source) {
            return new Style(source);
        }

        @Override public Style[] newArray(int size) {
            return new Style[size];
        }
    };
}
