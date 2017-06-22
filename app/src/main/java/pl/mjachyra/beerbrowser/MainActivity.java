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

public class MainActivity extends AppCompatActivity implements OnListFragmentInteractionListener {

  private static final String TAG = "MainActivity";

  private static final String BASE_URL = "http://api.brewerydb.com/v2/";
  private static final Retrofit retrofit = new Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build();

  private static final Api apiService = retrofit.create(Api.class);

  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
      new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
          switch (item.getItemId()) {
            case R.id.navigation_home:
              getSupportActionBar().setTitle(R.string.title_home);
              loadBeersFragment();
              return true;
            case R.id.navigation_dashboard:
              getSupportActionBar().setTitle(R.string.title_dashboard);
              loadFavoriteBeersFragment();
              return true;
            case R.id.navigation_notifications:
              getSupportActionBar().setTitle(R.string.title_notifications);
              return true;
          }
          return false;
        }


      };


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    navigation.setSelectedItemId(R.id.navigation_home);
  }

  private void loadBeersFragment() {
    FragmentManager fm = getSupportFragmentManager();
    fm.beginTransaction().replace(R.id.container, BeersFragment.newInstance()).commit();
  }

  private void loadFavoriteBeersFragment() {
    FragmentManager fm = getSupportFragmentManager();
    fm.beginTransaction().replace(R.id.container, FavoriteBeersFragment.newInstance()).commit();
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
}
