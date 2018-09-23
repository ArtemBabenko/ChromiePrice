package chromie_price.chromieprice.Holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import chromie_price.chromieprice.Item.ChildRecyclerItem;
import chromie_price.chromieprice.R;

public class ChildViewHolder extends com.bignerdranch.expandablerecyclerview.ChildViewHolder {

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

    public void bind(ChildRecyclerItem childRecyclerItem) {
//        img.setImageResource(Integer.valueOf(childRecyclerItem.getImage()));
        current.setText(String.valueOf(childRecyclerItem.getCurrent()));
        previous.setText(String.valueOf(childRecyclerItem.getPrevious()));
        difference.setText(String.valueOf(childRecyclerItem.getDifference()));
        toPay.setText(String.valueOf(childRecyclerItem.getToPay()));
    }

}
