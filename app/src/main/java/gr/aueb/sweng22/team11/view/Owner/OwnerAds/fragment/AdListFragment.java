package gr.aueb.sweng22.team11.view.Owner.OwnerAds.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.domain.Ad;

/**
 * This fragment represents a list of ads
 * Every activity that contains this fragment must
 * implement the {@link OnListFragmentInteractionListener} interface
 */
public class AdListFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Default constructor
     */
    public AdListFragment() {}

    /**
     * @param columnCount  the number of columns in the list
     * @return the fragment
     */
    @SuppressWarnings("unused")
    public static AdListFragment newInstance(int columnCount) {
        AdListFragment fragment = new AdListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Creates the layout and initializes the fragment
     * @param savedInstanceState the Instance state
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    /**
     * @param inflater layout inflater
     * @param container the container
     * @param savedInstanceState the Instance state
     * @return the view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ad_list, container, false);
        ArrayList<Ad> adList = mListener.getListAd();


        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new AdListRecyclerViewAdapter(new ArrayList<>(adList), mListener));
        }
        return view;
    }

    /**
     * When the fragment get attached on the OwnerAdsActivity
     * @param context the context of the activity
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    /**
     * When the fragment detaches from the activity
     */
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Every activity that contains this fragment must implement this interface, so
     * that the activity or the other fragments, can interact with the fragment.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Ad item);

        ArrayList<Ad> getListAd();
    }


}
