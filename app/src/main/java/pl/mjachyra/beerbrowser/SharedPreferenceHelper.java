package pl.mjachyra.beerbrowser;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import pl.mjachyra.beerbrowser.models.Beer;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferenceHelper {

  private static final String NAME = "name";
  private static final String BEERS = "beers";
  private static final String DEFAULT = "default";
  private static final Gson gson = new Gson();

  private SharedPreferenceHelper() {
  }

  public static List<Beer> getBeers(Context context) {
    SharedPreferences sharedPreferences = context.getSharedPreferences(DEFAULT, MODE_PRIVATE);
    List<Beer> beers = new ArrayList<>();
    if (sharedPreferences.contains(BEERS)) {
      String json = sharedPreferences.getString(BEERS, null);
      if (json != null) {
        Type type = new TypeToken<ArrayList<Beer>>() {
        }.getType();
        beers = gson.fromJson(json, type);
      }
    }
    return beers;
  }

  public static void setBeers(Context context, List<Beer> beers) {
    context.getSharedPreferences(DEFAULT, MODE_PRIVATE)
        .edit()
        .putString(BEERS, gson.toJson(beers))
        .apply();
  }

  public static void clearBeers(Context context) {
    context.getSharedPreferences(DEFAULT, MODE_PRIVATE).edit().remove(BEERS).apply();
  }

  public static String getName(Context context) {
    SharedPreferences sharedPreferences = context.getSharedPreferences(DEFAULT, MODE_PRIVATE);
    return sharedPreferences.getString(NAME, context.getString(R.string.unknown));
  }

  public static void setName(Context context, String name) {
    SharedPreferences sharedPreferences = context.getSharedPreferences(DEFAULT, MODE_PRIVATE);
    sharedPreferences.edit().putString(NAME, name).apply();
  }
}
