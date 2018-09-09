package chromie_price.chromieprice.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

import chromie_price.chromieprice.Item.ChildRecyclerItem;
import chromie_price.chromieprice.R;

public class FormRecyclerAdapter extends RecyclerView.Adapter<FormRecyclerAdapter.FormViewHolder> {

    private ArrayList<String> itemList = new ArrayList<>();

    @NonNull
    @Override
    public FormViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_form_item, viewGroup, false);

        return new FormViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormViewHolder formViewHolder, int possition) {
        formViewHolder.bind(itemList.get(possition));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setItems(ArrayList<String> items) {
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void clearItems() {
        itemList.clear();
        notifyDataSetChanged();
    }

    public class FormViewHolder extends RecyclerView.ViewHolder {

        TextView head;
        EditText tariff;
        EditText current;

        public FormViewHolder(@NonNull View itemView) {
            super(itemView);
            head = itemView.findViewById(R.id.item_head);
            tariff = itemView.findViewById(R.id.tariff);
            current = itemView.findViewById(R.id.current);
        }

        public void bind(String string) {
            head.setText(string);
        }
    }
}
