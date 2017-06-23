package pl.mjachyra.beerbrowser;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import pl.mjachyra.beerbrowser.models.Beer;
import pl.mjachyra.beerbrowser.models.Beers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class BeersFragment extends Fragment implements Callback<Beers> {

  public static final String BEERS = "BEERS";
  private OnListFragmentInteractionListener mListener;
  private RecyclerView recyclerView;
  private BeerRecyclerViewAdapter adapter;
  private View progressView;
  private List<Beer> beerList;

  public static BeersFragment newInstance() {
    BeersFragment fragment = new BeersFragment();
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_beer_list, container, false);

    recyclerView = (RecyclerView) view.findViewById(R.id.list);
    progressView = view.findViewById(R.id.progress_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    return view;
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    if (beerList != null && !beerList.isEmpty()) {
      outState.putParcelableArrayList(BEERS, (ArrayList<? extends Parcelable>) beerList);
    }
    super.onSaveInstanceState(outState);
  }

  @Override public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);
    if (savedInstanceState != null) {
      beerList = savedInstanceState.getParcelableArrayList(BEERS);
    }
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnListFragmentInteractionListener) {
      mListener = (OnListFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
    }
  }

  @Override public void onResume() {
    super.onResume();
    if (beerList == null || beerList.isEmpty()) {
      Call<Beers> call = mListener.apiService().getBeers("754ee5190b579048b28566b4efab9bab", 4, 1);
      call.enqueue(this);
    } else {
      showBeers();
    }
  }

  @Override public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  @Override public void onResponse(@NonNull Call<Beers> call, @NonNull Response<Beers> response) {
    Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");
    if (response.isSuccessful()) {
      Beers beersObj = response.body();
      if (beersObj != null) {
        beerList = beersObj.getData();
        showBeers();
      }
    }
  }

  private void showBeers() {
    adapter = new BeerRecyclerViewAdapter(beerList, mListener);
    recyclerView.setAdapter(adapter);
    progressView.setVisibility(View.GONE);
    recyclerView.setVisibility(View.VISIBLE);
  }

  @Override public void onFailure(@NonNull Call<Beers> call, @NonNull Throwable t) {
    Log.e(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   * <p/>
   * See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */

}
