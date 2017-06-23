package pl.mjachyra.beerbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import pl.mjachyra.beerbrowser.models.Beer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements OnListFragmentInteractionListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

  public static final String FRAGMENT = "fragment";
  private static final String TAG = "MainActivity";
  private static final String BASE_URL = "http://api.brewerydb.com/v2/";
  private static final Retrofit retrofit = new Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build();
  private static final Api apiService = retrofit.create(Api.class);
  private BottomNavigationView navigation;
  private int lastFragment;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    lastFragment =
        savedInstanceState != null ? savedInstanceState.getInt(FRAGMENT, R.id.navigation_beers)
            : R.id.navigation_beers;
    navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(this);
    navigation.setSelectedItemId(lastFragment);
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    outState.putInt(FRAGMENT, navigation.getSelectedItemId());
    super.onSaveInstanceState(outState);
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    savedInstanceState.getInt(FRAGMENT, R.id.navigation_beers);
  }

  @Override public void onListFragmentInteraction(Beer beer) {
    Log.d(TAG, "onListFragmentInteraction() called with: beer = [" + beer + "]");
    Intent intent = new Intent(this, BeerDetailsActivity.class);
    intent.putExtra("beer", beer);
    startActivity(intent);
  }

  @Override public Api apiService() {
    return apiService;
  }

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.navigation_beers:
        getSupportActionBar().setTitle(R.string.title_beers);
        loadBeersFragment();
        return true;
      case R.id.navigation_favs:
        getSupportActionBar().setTitle(R.string.title_favs);
        loadFavoriteBeersFragment();
        return true;
      case R.id.navigation_settings:
        getSupportActionBar().setTitle(R.string.title_settings);
        loadSettingsFragment();
        return true;
    }
    return false;
  }

  private void loadSettingsFragment() {
    FragmentManager fm = getSupportFragmentManager();
    fm.beginTransaction().replace(R.id.container, SettingsFragment.newInstance()).commit();
  }

  private void loadBeersFragment() {
    FragmentManager fm = getSupportFragmentManager();
    fm.beginTransaction().replace(R.id.container, BeersFragment.newInstance()).commit();
  }

  private void loadFavoriteBeersFragment() {
    FragmentManager fm = getSupportFragmentManager();
    fm.beginTransaction().replace(R.id.container, FavoriteBeersFragment.newInstance()).commit();
  }

}
