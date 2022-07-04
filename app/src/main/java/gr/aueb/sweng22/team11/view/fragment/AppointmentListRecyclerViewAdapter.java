package gr.aueb.sweng22.team11.view.fragment;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.domain.Appointment;




public class AppointmentListRecyclerViewAdapter extends RecyclerView.Adapter<AppointmentListRecyclerViewAdapter.ViewHolder> {
    private final ArrayList<Appointment> mValues;


    /**
     * the constructor
     * @param items the list of appointments
     */
    public AppointmentListRecyclerViewAdapter(ArrayList<Appointment> items){
        mValues = items;

    }

    /**
     * @param parent the view parent
     * @param viewType the view type
     * @return the new ViewHolder of the view
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_appointment_list_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * @param holder
     * @param position the index of the item
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Appointment currentAppointment = mValues.get(position);
        holder.mItem = currentAppointment;
        String appointment = currentAppointment.getDate().toString()+" " + currentAppointment.getTime().toString();
        holder.txtAppointment.setText(appointment);
        if(currentAppointment.getAvailable().equals(true))
            holder.txtTitle.setText("Declined");
        else
            holder.txtTitle.setText("Accepted");

    }

    /**
     * get the number of appointments in the list
     * @return the number of appointments
     */
    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtAppointment;
        public Appointment mItem;
        public final TextView txtTitle;

        /**
         * constructor
         * @param view the view
         */
        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtAppointment = view.findViewById(R.id.txtAppointment);
            txtTitle = view.findViewById(R.id.titleForAppointment);

        }
    }
}
