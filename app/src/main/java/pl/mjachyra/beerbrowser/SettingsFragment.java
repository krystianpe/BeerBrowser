package pl.mjachyra.beerbrowser;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class SettingsFragment extends Fragment implements View.OnClickListener {

  private static final String NAME = "NAME";
  private OnListFragmentInteractionListener listener;
  private TextInputEditText nameEt;

  public static SettingsFragment newInstance() {
    return new SettingsFragment();
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_settings, container, false);
    nameEt = (TextInputEditText) view.findViewById(R.id.name_et);
    if (savedInstanceState != null) {
      nameEt.setText(savedInstanceState.getString(NAME, null));
    } else {
      nameEt.setText(SharedPreferenceHelper.getName(getContext()));
    }
    AppCompatButton button = (AppCompatButton) view.findViewById(R.id.erase_favs);
    button.setOnClickListener(this);
    return view;
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    outState.putString(NAME, nameEt.getText().toString());
    super.onSaveInstanceState(outState);
  }

  @Override public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);
    if (savedInstanceState != null) {
      nameEt.setText(savedInstanceState.getString(NAME, null));
    }
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnListFragmentInteractionListener) {
      listener = (OnListFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(
          context.toString() + " must implement OnListFragmentInteractionListener");
    }
  }

  @Override public void onStop() {
    super.onStop();
    SharedPreferenceHelper.setName(getContext(), nameEt.getText().toString());
  }

  @Override public void onDetach() {
    super.onDetach();
    listener = null;
  }

  @Override public void onClick(View v) {
    if (v.getId() == R.id.erase_favs) {
      SharedPreferenceHelper.clearBeers(getContext());
      Toast.makeText(getContext(), R.string.favs_erased, Toast.LENGTH_SHORT).show();
    }
  }
}
