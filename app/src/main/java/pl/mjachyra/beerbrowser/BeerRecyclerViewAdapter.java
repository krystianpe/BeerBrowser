package pl.mjachyra.beerbrowser;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import pl.mjachyra.beerbrowser.models.Beer;

public class BeerRecyclerViewAdapter
    extends RecyclerView.Adapter<BeerRecyclerViewAdapter.ViewHolder> {

  private final List<Beer> beers;
  private final OnListFragmentInteractionListener mListener;

  public BeerRecyclerViewAdapter(List<Beer> items, OnListFragmentInteractionListener listener) {
    beers = items;
    mListener = listener;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_item, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.beer = beers.get(position);
    if (position % 2 == 0) {
      holder.mView.setBackgroundResource(R.color.white);
    } else {
      holder.mView.setBackgroundResource(R.color.gray);
    }
    if (holder.beer.getLabels() != null) {
      Picasso.with(holder.mImageView.getContext())
          .load(holder.beer.getLabels().getIcon())
          .placeholder(R.drawable.beer)
          .into(holder.mImageView);
    } else {
      holder.mImageView.setImageDrawable(
          ContextCompat.getDrawable(holder.mImageView.getContext(), R.drawable.beer));
    }
    holder.mContentView.setText(holder.beer.getNameDisplay());

    holder.mView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (null != mListener) {
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
    public final ImageView mImageView;
    public final TextView mContentView;
    public Beer beer;

    public ViewHolder(View view) {
      super(view);
      mView = view;
      mImageView = (ImageView) view.findViewById(R.id.beer_icon);
      mContentView = (TextView) view.findViewById(R.id.content);
    }

    @Override public String toString() {
      return super.toString() + " '" + mContentView.getText() + "'";
    }
  }
}
