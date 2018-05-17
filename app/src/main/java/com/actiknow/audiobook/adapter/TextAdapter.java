package com.actiknow.audiobook.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.actiknow.audiobook.R;

import java.util.List;

/**
 * Created by actiknow on 9/21/17.
 */

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder> {
    private Activity activity;
    private List<String> textList;
    // Allows to remember the last item shown on screen
    private int lastPosition = - 1;
    
    
    public TextAdapter (Activity activity, List<String> textList) {
        this.activity = activity;
        this.textList = textList;
    }
    
    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from (parent.getContext ());
        final View sView = layoutInflater.inflate (R.layout.list_item_text, parent, false);
        return new ViewHolder (sView);
    }
    
    @Override
    public void onBindViewHolder (ViewHolder holder, int position) {
        String text = textList.get (position);
//        Text text = textList.get (position);
        holder.tvText.setText (text);
        
        // Here you apply the animation when the view is bound
        setAnimation (holder.itemView, position);
    }

    private void setAnimation (View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation (activity, R.anim.slide_in_right);
            viewToAnimate.startAnimation (animation);
            lastPosition = position;
        }
    }
    
    @Override
    public int getItemCount () {
        return textList.size ();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvText;
        
        public ViewHolder (View itemView) {
            super (itemView);
            tvText = (TextView) itemView.findViewById (R.id.tvText);
            itemView.setOnClickListener (this);
        }
        
        @Override
        public void onClick (View view) {
    
        }
    }
}