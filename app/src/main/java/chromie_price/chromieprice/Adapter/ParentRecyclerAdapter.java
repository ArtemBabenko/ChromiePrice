package chromie_price.chromieprice.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;

import java.util.List;

import chromie_price.chromieprice.Holders.ChildViewHolder;
import chromie_price.chromieprice.Holders.ParentViewHolder;
import chromie_price.chromieprice.Item.ChildRecyclerItem;
import chromie_price.chromieprice.Item.ParentRecyclerItem;
import chromie_price.chromieprice.R;

public class ParentRecyclerAdapter extends ExpandableRecyclerAdapter<ParentRecyclerItem, ChildRecyclerItem, ParentViewHolder, ChildViewHolder> {


    private LayoutInflater inflater;
    private Context context;

    public ParentRecyclerAdapter(Context context, @NonNull List<ParentRecyclerItem> parentList) {
        super(parentList);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View parentView = inflater.inflate(R.layout.card_view_item, parentViewGroup, false);
        return new ParentViewHolder(context, parentView);
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View childView = inflater.inflate(R.layout.chield_recycler_item, childViewGroup, false);
        return new ChildViewHolder(childView);
    }

    @Override
    public void onBindParentViewHolder(@NonNull ParentViewHolder parentViewHolder, int parentPosition, @NonNull ParentRecyclerItem parent) {
        parentViewHolder.bind(parent);
    }

    @Override
    public void onBindChildViewHolder(@NonNull ChildViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull ChildRecyclerItem child) {
        childViewHolder.bind(child);
    }
}
