package pl.mjachyra.beerbrowser;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collections;
import pl.mjachyra.beerbrowser.models.Beer;

public class FavoriteBeersFragment extends Fragment {

  private static final String ARG_COLUMN_COUNT = "column-count";
  private OnListFragmentInteractionListener mListener;

  public FavoriteBeersFragment() {
  }

  @SuppressWarnings("unused") public static FavoriteBeersFragment newInstance() {
    FavoriteBeersFragment fragment = new FavoriteBeersFragment();
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_beer_list, container, false);

    // Set the adapter
    if (view instanceof RecyclerView) {
      Context context = view.getContext();
      RecyclerView recyclerView = (RecyclerView) view;
      recyclerView.setLayoutManager(new LinearLayoutManager(context));
      recyclerView.setAdapter(new MyBeerRecyclerViewAdapter(Collections.<Beer>emptyList(), mListener));
    }
    return view;
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnListFragmentInteractionListener) {
      mListener = (OnListFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
    }
  }

  @Override public void onDetach() {
    super.onDetach();
    mListener = null;
  }
}
