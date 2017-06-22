package pl.mjachyra.beerbrowser;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import pl.mjachyra.beerbrowser.models.Beer;
import pl.mjachyra.beerbrowser.models.Beers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class BeersFragment extends Fragment implements Callback<Beers> {

  private static final String ARG_COLUMN_COUNT = "column-count";
  private OnListFragmentInteractionListener mListener;
  private RecyclerView recyclerView;
  private MyBeerRecyclerViewAdapter adapter;

  /**
   * Mandatory empty constructor for the fragment manager to instantiate the
   * fragment (e.g. upon screen orientation changes).
   */
  public BeersFragment() {
  }

  @SuppressWarnings("unused") public static BeersFragment newInstance() {
    BeersFragment fragment = new BeersFragment();
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
      recyclerView = (RecyclerView) view;
      recyclerView.setLayoutManager(new LinearLayoutManager(context));
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

  @Override public void onResume() {
    super.onResume();
    Call<Beers> call = mListener.apiService().getBeers("754ee5190b579048b28566b4efab9bab", 4, 1);
    call.enqueue(this);
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
        List<Beer> beers = beersObj.getData();
        adapter = new MyBeerRecyclerViewAdapter(beers, mListener);
        recyclerView.setAdapter(adapter);
      }
    }
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
