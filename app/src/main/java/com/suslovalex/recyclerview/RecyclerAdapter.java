package com.suslovalex.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private List<Card> cards;
    private OnClickListener onclickListener;


    public RecyclerAdapter(List<Card> cards, OnClickListener onClickListener) {
        this.cards = cards;
        this.onclickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_recycle_view, parent, false);
        return new ViewHolder(v,onclickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Card card = cards.get(position);
        holder.title.setText(card.getTitle());
        holder.description.setText(card.getDescription());
        holder.image.setImageResource(card.getImageId());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title;
        public TextView description;
        public ImageView image;

        public OnClickListener onClickListener;

        public ViewHolder(@NonNull final View itemView, OnClickListener onClickListener) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.imageView);

            this.onClickListener = onClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(getAdapterPosition());

        }
    }
    public interface OnClickListener {
        void onClick(int position);
    }
}
