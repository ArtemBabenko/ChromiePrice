package chromie_price.chromieprice.Holders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import chromie_price.chromieprice.Item.ParentRecyclerItem;
import chromie_price.chromieprice.R;

public class ParentViewHolder extends com.bignerdranch.expandablerecyclerview.ParentViewHolder {

    private static final float INITIAL_POSITION = 0.0f;
    private static final float ROTATED_POSITION = 180f;

    private CardView cardView;
    private ImageView arrow;
    private TextView dataTime;
    private LinearLayout headItemLayout;

    Context context;

    public ParentViewHolder(Context context, @NonNull View itemView) {
        super(itemView);
        this.context = context;
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        arrow = (ImageView) itemView.findViewById(R.id.arrow);
        dataTime = (TextView) itemView.findViewById(R.id.data_time);
        headItemLayout = (LinearLayout) itemView.findViewById(R.id.head_item_layout);
    }

    public void bind(ParentRecyclerItem parentRecyclerItem) {
        dataTime.setText(parentRecyclerItem.getName());
    }


    //Следующие методы нужны для розвертывания списка
    @SuppressLint("NewApi")
    @Override
    public void setExpanded(boolean expanded) {
        super.setExpanded(expanded);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            if (expanded) {
                arrow.setRotation(ROTATED_POSITION);
                arrow.setColorFilter(ContextCompat.getColor(context, R.color.toolbar));
                headItemLayout.setVisibility(View.VISIBLE);
            } else {
                arrow.setRotation(INITIAL_POSITION);
                arrow.setColorFilter(ContextCompat.getColor(context, R.color.list_arrow_color));
                headItemLayout.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onExpansionToggled(boolean expanded) {
        super.onExpansionToggled(expanded);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            RotateAnimation rotateAnimation;
            if (expanded) { // rotate clockwise
                rotateAnimation = new RotateAnimation(ROTATED_POSITION,
                        INITIAL_POSITION,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            } else { // rotate counterclockwise
                rotateAnimation = new RotateAnimation(-1 * ROTATED_POSITION,
                        INITIAL_POSITION,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            }

            rotateAnimation.setDuration(200);
            rotateAnimation.setFillAfter(true);
            arrow.startAnimation(rotateAnimation);
        }
    }

}