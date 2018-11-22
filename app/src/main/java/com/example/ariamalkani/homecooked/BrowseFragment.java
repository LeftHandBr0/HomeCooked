// Cite: Bottom navigation and recycler view learned from here https://www.androidhive.info/2017/12/android-working-with-bottom-navigation/

package com.example.ariamalkani.homecooked;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BrowseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrowseFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Meal> mealList;
    private MealAdapter mAdapter;

    public BrowseFragment() {
        // Required empty public constructor
    }

    public static BrowseFragment newInstance(String param1, String param2) {
        BrowseFragment fragment = new BrowseFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_browse, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        mealList = new ArrayList<>();
        addMeals();
        mAdapter = new MealAdapter(getActivity(), mealList);

        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    private void addMeals() {
        Meal m1 = new Meal("Shady Bob's BBQ", true, false,
                "3.1/5", "Avg. $7", R.drawable.bbq);

        mealList.add(m1);
    }

    class MealAdapter extends RecyclerView.Adapter<MealAdapter.MyViewHolder> {
        private Context context;
        private List<Meal> mealList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView chefName, avgPrice, rating, vegan, verified;
            public ImageView thumbnail;

            public MyViewHolder(View view) {
                super(view);

                chefName = view.findViewById(R.id.chef_name);
                avgPrice = view.findViewById(R.id.avg_price);
                rating = view.findViewById(R.id.rating);
                vegan = view.findViewById(R.id.vegan);
                verified = view.findViewById(R.id.verified);
                thumbnail = view.findViewById(R.id.thumbnail);
            }
        }

        public MealAdapter(Context context, List<Meal> mealList) {
            this.context = context;
            this.mealList = mealList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.meal_card, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            final Meal meal = mealList.get(position);
            holder.chefName.setText(meal.getChefName());
            if (meal.getVerified()) {
                holder.verified.setText("Verified");
            }
            if (meal.getVegan()) {
                holder.vegan.setText("Vegan");
            }
            holder.avgPrice.setText(meal.getAvgPrice());
            holder.rating.setText(meal.getRating());
            holder.thumbnail.setImageResource(meal.getThumbnail());
        }

        @Override
        public int getItemCount() {
            return mealList.size();
        }
    }

}
