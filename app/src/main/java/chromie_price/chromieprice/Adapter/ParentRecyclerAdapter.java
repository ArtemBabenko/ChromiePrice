package chromie_price.chromieprice.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import chromie_price.chromieprice.Item.ParentRecyclerItem;
import chromie_price.chromieprice.R;

public class ParentRecyclerAdapter extends RecyclerView.Adapter<ParentRecyclerAdapter.ParentViewHolder> {

    private List<ParentRecyclerItem> parentItemList = new ArrayList<>();
    RecyclerView.RecycledViewPool viewPool;

    private Context context;

    public ParentRecyclerAdapter(Context context, List<ParentRecyclerItem> parentItemList) {
        this.context = context;
        this.parentItemList = parentItemList;
        viewPool = new RecyclerView.RecycledViewPool();
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_item, viewGroup, false);
        ParentViewHolder holder = new ParentViewHolder(view);
        holder.chieldRecyclerView.setRecycledViewPool(viewPool);
        holder.chieldRecyclerView.getRecycledViewPool().setMaxRecycledViews(0, 4);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder parentViewHolder, int position) {
        parentViewHolder.chieldRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        parentViewHolder.chieldRecyclerView.setItemAnimator(new DefaultItemAnimator());
        ChildRecyclerAdapter recyclerAdapter = new ChildRecyclerAdapter(parentItemList.get(position).getChildRecyclerItemsList());
        parentViewHolder.chieldRecyclerView.setAdapter(recyclerAdapter);

    }

    @Override
    public int getItemCount() {
        return parentItemList.size();
    }


    @Override
    public boolean onFailedToRecycleView(@NonNull ParentViewHolder holder) {
        return true;
    }

    public class ParentViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView chieldRecyclerView;
        private CardView cardView;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            chieldRecyclerView = (RecyclerView) itemView.findViewById(R.id.child_recycler);
        }

    }
}
