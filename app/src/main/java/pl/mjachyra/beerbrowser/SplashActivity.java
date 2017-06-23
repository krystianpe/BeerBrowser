package pl.mjachyra.beerbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity implements Runnable {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_splash);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
    }

    String name = SharedPreferenceHelper.getName(this);

    TextView message = (TextView) findViewById(R.id.splash_message);
    message.setText(getString(R.string.welcome_message, name));
  }

  @Override protected void onPostResume() {
    super.onPostResume();
    Handler handler = new Handler();
    handler.postDelayed(this, 3000);
  }

  @Override public void run() {
    startActivity(new Intent(this, MainActivity.class));
  }
}
