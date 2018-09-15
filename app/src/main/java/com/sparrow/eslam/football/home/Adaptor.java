package com.sparrow.eslam.football.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.sparrow.eslam.football.R;
import com.sparrow.eslam.football.pojo.Competition;

import java.util.List;

public class Adaptor extends RecyclerView.Adapter<ViewHolder> {
    List<Competition> competitions;

    public Adaptor(List<Competition> competitions){
        this.competitions = competitions;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.competition_view_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.titleTextView.setText(competitions.get(i).getLeague());
        viewHolder.captionTextView.setText(competitions.get(i).getCaption());
        viewHolder.teamsNoTextView.setText(competitions.get(i).getNumberOfGames()+"");

    }

    @Override
    public int getItemCount() {
        return competitions.size();
    }
}
class ViewHolder extends RecyclerView.ViewHolder{
    TextView titleTextView;
    TextView captionTextView;
    TextView teamsNoTextView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView=itemView.findViewById(R.id.title);
        captionTextView=itemView.findViewById(R.id.caption);
        teamsNoTextView=itemView.findViewById(R.id.no_of_teams);
    }
}