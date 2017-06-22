package pl.mjachyra.beerbrowser;

import pl.mjachyra.beerbrowser.models.Beers;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

  @GET("beers") Call<Beers> getBeers(@Query("key") String key, @Query("glasswareId") int id, @Query("p") int page);
}