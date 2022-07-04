package gr.aueb.sweng22.team11.view.Owner.OwnerAds.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.view.Owner.OwnerAds.fragment.AdListFragment.OnListFragmentInteractionListener;


public class AdListRecyclerViewAdapter extends RecyclerView.Adapter<AdListRecyclerViewAdapter.ViewHolder>  {

    private final ArrayList<Ad> mValues;
    private final OnListFragmentInteractionListener mListener;

    /**
     * the constructor
     * @param items the list of ads
     * @param listener the listener for an ad selection
     */
    public AdListRecyclerViewAdapter(ArrayList<Ad> items, OnListFragmentInteractionListener listener){
        mValues = items;
        mListener = listener;
    }

    /**
     *
     * @param parent the view parent
     * @param viewType the view type
     * @return the new ViewHolder of the view
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_ad_list_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * @param holder
     * @param position the index of the item
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Ad currentAd = mValues.get(position);
        holder.mItem = currentAd;
        holder.txtAdTitle.setText(currentAd.getComment());
        holder.txtRentTitle.setText(currentAd.getHouse().getRent()+"€");
        holder.txtRegionTitle.setText(currentAd.getHouse().getRegion());

        holder.btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {

                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    /**
     * get the number of ads in the list
     * @return the number of ad
     */
    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtAdTitle;
        public final TextView txtRegionTitle;
        public final TextView txtRentTitle;
        public final FloatingActionButton btnSelect;
        public Ad mItem;

        /**
         * constructor
         * @param view the view
         */
        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtAdTitle = view.findViewById(R.id.txtAdTitle);
            txtRegionTitle = view.findViewById(R.id.txtAdRegion);
            txtRentTitle = view.findViewById(R.id.txtAdRent);
            btnSelect = view.findViewById(R.id.button_select_ad);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtAdTitle.getText() + "'";
        }
    }

}
