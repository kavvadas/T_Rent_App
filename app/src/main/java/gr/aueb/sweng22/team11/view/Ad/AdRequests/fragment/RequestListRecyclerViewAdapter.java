package gr.aueb.sweng22.team11.view.Ad.AdRequests.fragment;


import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import gr.aueb.sweng22.team11.view.Ad.AdRequests.fragment.RequestListFragment.OnListFragmentInteractionListener;
import java.util.ArrayList;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.domain.Request;


public class RequestListRecyclerViewAdapter extends RecyclerView.Adapter<RequestListRecyclerViewAdapter.ViewHolder>  {

    private final ArrayList<Request> mValues;
    private final OnListFragmentInteractionListener mListener;

    /**
     * the constructor
     * @param items the list of requests
     */
    public RequestListRecyclerViewAdapter(ArrayList<Request> items, OnListFragmentInteractionListener listener){
        mValues = items;
        mListener = listener;
    }

    /**
     * @param parent the view parent
     * @param viewType the view type
     * @return the new ViewHolder of the view
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_request_list_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * @param holder
     * @param position the index of the item
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Request currentRequest = mValues.get(position);
        holder.mItem = currentRequest;
        holder.txtRenterNickname.setText(currentRequest.getRenter().getNickname());
        String appointment = currentRequest.getAppointment().getDate().toString()+"  "+currentRequest.getAppointment().getTime().toString();
        holder.txtDateAppointment.setText(appointment);

        holder.btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {

                    mListener.onListFragmentInteraction(holder.mItem,position);
                }
            }
        });
    }

    /**
     * get the number of requests in the list
     * @return the number of requests
     */
    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtRenterNickname;
        public final TextView txtDateAppointment;
        public final FloatingActionButton btnSelect;
        public Request mItem;

        /**
         * constructor
         * @param view the view
         */
        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtRenterNickname = view.findViewById(R.id.txtRenterNickname);
            txtDateAppointment = view.findViewById(R.id.txtDateAppointment);
            btnSelect = view.findViewById(R.id.button_select_request);
        }
    }

}