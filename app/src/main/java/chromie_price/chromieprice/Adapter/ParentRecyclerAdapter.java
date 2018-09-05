package chromie_price.chromieprice.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import chromie_price.chromieprice.Item.ParentRecyclerItem;
import chromie_price.chromieprice.R;

public class ParentRecyclerAdapter extends RecyclerView.Adapter<ParentRecyclerAdapter.ParentViewHolder> {

    private List<ParentRecyclerItem> parentItemList = new ArrayList<>();
    public ChildRecyclerAdapter childRecyclerAdapter;


    private Context context;

    public ParentRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_item, viewGroup, false);

        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder parentViewHolder, int position) {
        parentViewHolder.bind(parentItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return parentItemList.size();
    }

    public void setItems(Collection<ParentRecyclerItem> items) {
        parentItemList.addAll(items);
        notifyDataSetChanged();
    }

    public void clearItems() {
        parentItemList.clear();
        notifyDataSetChanged();
    }

    public class ParentViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView chieldRecyclerView;
        private CardView cardView;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            chieldRecyclerView = (RecyclerView) itemView.findViewById(R.id.child_recycler);
        }

        public void bind(ParentRecyclerItem parentRecyclerItem) {
            chieldRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            childRecyclerAdapter = new ChildRecyclerAdapter();
            chieldRecyclerView.setAdapter(childRecyclerAdapter);
            childRecyclerAdapter.setItems(parentRecyclerItem.getChildRecyclerItemsList());
        }
    }
}
