package pl.mjachyra.beerbrowser;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.List;
import pl.mjachyra.beerbrowser.models.Beer;

public class BeerDetailsActivity extends AppCompatActivity {

  private Beer beer;
  private FloatingActionButton fab;
  private List<Beer> beers;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_beer);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        addToFavorites();
      }
    });

    ActionBar aBar = getSupportActionBar();
    if (aBar != null) {
      aBar.setDisplayHomeAsUpEnabled(true);
    }
    Bundle bundle = getIntent().getExtras();
    if (bundle != null) {
      beer = bundle.getParcelable("beer");
      beers = SharedPreferenceHelper.getBeers(this);
      if (beer != null) {
        showBeerDetails();
      } else {
        fab.setVisibility(View.GONE);
      }
    }
  }

  private void showBeerDetails() {
    TextView beerDetails = (TextView) findViewById(R.id.beer_desc);
    TextView beerStyle = (TextView) findViewById(R.id.beer_style_desc);
    ImageView beerImage = (ImageView) findViewById(R.id.beer_image);
    ActionBar aBar = getSupportActionBar();
    if (aBar != null) {
      aBar.setTitle(beer.getNameDisplay());
    }
    beerDetails.setText(beer.getDescription());
    if (beer.getStyle() != null) {
      beerStyle.setText(beer.getStyle().getDescription());
    }
    if (beer.getLabels() != null) {
      Picasso.with(this)
          .load(beer.getLabels().getLarge())
          .placeholder(R.drawable.beer)
          .into(beerImage);
    } else {
      beerImage.setImageResource(R.drawable.beer);
    }
    if (isInFavorites(beer)) {
      fab.setImageResource(R.drawable.ic_favorite);
    } else {
      fab.setImageResource(R.drawable.ic_favorite_border);
    }
  }

  private boolean isInFavorites(Beer beer) {
    return beers.contains(beer);
  }

  private void addToFavorites() {
    if (beers.contains(beer)) {
      beers.remove(beer);
      fab.setImageResource(R.drawable.ic_favorite_border);
      Toast.makeText(this, "Usunięto z ulubionych", Toast.LENGTH_SHORT).show();
    } else {
      beers.add(beer);
      fab.setImageResource(R.drawable.ic_favorite);
      Toast.makeText(this, "Dodano do ulubionych", Toast.LENGTH_SHORT).show();
    }
    SharedPreferenceHelper.setBeers(this, beers);
  }
}
