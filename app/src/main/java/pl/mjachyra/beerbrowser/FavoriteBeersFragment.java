package pl.mjachyra.beerbrowser;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import pl.mjachyra.beerbrowser.models.Beer;

public class FavoriteBeersFragment extends Fragment {

  private static final String TAG = "FavoriteBeersFragment";
  private OnListFragmentInteractionListener mListener;
  private RecyclerView recyclerView;
  private View progressView;

  @SuppressWarnings("unused") public static FavoriteBeersFragment newInstance() {
    return new FavoriteBeersFragment();
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_beer_list, container, false);
    recyclerView = (RecyclerView) view.findViewById(R.id.list);
    progressView = view.findViewById(R.id.progress_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    return view;
  }

  @Override public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);
    Log.d(TAG,
        "onViewStateRestored() called with: savedInstanceState = [" + savedInstanceState + "]");
  }

  @Override public void onResume() {
    super.onResume();
    List<Beer> beers = SharedPreferenceHelper.getBeers(getContext());
    recyclerView.setAdapter(new BeerRecyclerViewAdapter(beers, mListener));
    progressView.setVisibility(View.GONE);
    recyclerView.setVisibility(View.VISIBLE);
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
