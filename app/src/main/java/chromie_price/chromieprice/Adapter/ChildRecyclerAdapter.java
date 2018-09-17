package chromie_price.chromieprice.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import chromie_price.chromieprice.Item.ChildRecyclerItem;
import chromie_price.chromieprice.R;

public class ChildRecyclerAdapter extends RecyclerView.Adapter<ChildRecyclerAdapter.ChildViewHolder> {

    List<ChildRecyclerItem> childItemList = new ArrayList<>();

    public ChildRecyclerAdapter(List<ChildRecyclerItem> childItemList) {
        this.childItemList = childItemList;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chield_recycler_item, viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder childViewHolder, int possition) {

        //            img.setImageResource(childRecyclerItem.getImage());
        childViewHolder.current.setText(String.valueOf(childItemList.get(possition).getCurrent()));
        childViewHolder.previous.setText(String.valueOf(childItemList.get(possition).getPrevious()));
        childViewHolder.difference.setText(String.valueOf(childItemList.get(possition).getDifference()));
        childViewHolder.toPay.setText(String.valueOf(childItemList.get(possition).getToPay()));
    }

    @Override
    public int getItemCount() {

        return childItemList.size();
    }


    @Override
    public boolean onFailedToRecycleView(@NonNull ChildViewHolder holder) {
        return true;
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView current;
        private TextView previous;
        private TextView difference;
        private TextView toPay;


        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            current = (TextView) itemView.findViewById(R.id.current);
            previous = (TextView) itemView.findViewById(R.id.previous);
            difference = (TextView) itemView.findViewById(R.id.difference);
            toPay = (TextView) itemView.findViewById(R.id.to_pay);
        }

    }
}
