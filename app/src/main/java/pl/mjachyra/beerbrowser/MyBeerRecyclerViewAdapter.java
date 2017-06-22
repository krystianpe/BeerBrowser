package pl.mjachyra.beerbrowser;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import pl.mjachyra.beerbrowser.models.Beer;

public class MyBeerRecyclerViewAdapter extends RecyclerView.Adapter<MyBeerRecyclerViewAdapter.ViewHolder> {

  private final List<Beer> beers;
  private final OnListFragmentInteractionListener mListener;

  public MyBeerRecyclerViewAdapter(List<Beer> items, OnListFragmentInteractionListener listener) {
    beers = items;
    mListener = listener;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_beer, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.beer = beers.get(position);
    holder.mIdView.setText(holder.beer.getId());
    holder.mContentView.setText(holder.beer.getNameDisplay());

    holder.mView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (null != mListener) {
          // Notify the active callbacks interface (the activity, if the
          // fragment is attached to one) that an item has been selected.
          mListener.onListFragmentInteraction(holder.beer);
        }
      }
    });
  }

  @Override public int getItemCount() {
    return beers.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView mIdView;
    public final TextView mContentView;
    public Beer beer;

    public ViewHolder(View view) {
      super(view);
      mView = view;
      mIdView = (TextView) view.findViewById(R.id.id);
      mContentView = (TextView) view.findViewById(R.id.content);
    }

    @Override public String toString() {
      return super.toString() + " '" + mContentView.getText() + "'";
    }
  }
}
