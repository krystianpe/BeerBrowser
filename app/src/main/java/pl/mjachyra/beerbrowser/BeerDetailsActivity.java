package pl.mjachyra.beerbrowser;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import pl.mjachyra.beerbrowser.models.Beer;

public class BeerDetailsActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_beer);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show();
      }
    });
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    TextView beerDetails = (TextView) findViewById(R.id.beer_details);
    ImageView beerImage = (ImageView) findViewById(R.id.beer_image);

    Bundle bundle = getIntent().getExtras();
    if (bundle != null) {
      Beer beer = bundle.getParcelable("beer");
      if (beer != null) {
        getSupportActionBar().setTitle(beer.getNameDisplay());
        beerDetails.setText(beer.getDescription());
        Picasso.with(this).load(beer.getLabels().getLarge()).placeholder(R.drawable.ic_sync).into(beerImage);
      }
    }
  }
}
