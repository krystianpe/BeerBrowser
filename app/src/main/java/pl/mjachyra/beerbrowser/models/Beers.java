package pl.mjachyra.beerbrowser.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Beers {

  @SerializedName("currentPage")
  @Expose
  private Integer currentPage;
  @SerializedName("numberOfPages")
  @Expose
  private Integer numberOfPages;
  @SerializedName("totalResults")
  @Expose
  private Integer totalResults;
  @SerializedName("data")
  @Expose
  private List<Beer> data = null;
  @SerializedName("status")
  @Expose
  private String status;

  public Integer getCurrentPage() {
    return currentPage;
  }

  public Integer getNumberOfPages() {
    return numberOfPages;
  }

  public Integer getTotalResults() {
    return totalResults;
  }

  public List<Beer> getData() {
    return data;
  }

  public String getStatus() {
    return status;
  }

}