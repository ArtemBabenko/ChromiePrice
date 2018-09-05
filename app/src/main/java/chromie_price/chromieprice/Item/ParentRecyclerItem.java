package chromie_price.chromieprice.Item;

import android.support.v7.widget.RecyclerView;

import java.util.Collection;
import java.util.List;

public class ParentRecyclerItem {

    private Collection<ChildRecyclerItem> childRecyclerItemsList;

    public ParentRecyclerItem(Collection<ChildRecyclerItem> childRecyclerItemsList) {
        this.childRecyclerItemsList = childRecyclerItemsList;
    }

    public Collection<ChildRecyclerItem> getChildRecyclerItemsList() {
        return childRecyclerItemsList;
    }

    public void setChildRecyclerItemsList(Collection<ChildRecyclerItem> childRecyclerItemsList) {
        this.childRecyclerItemsList = childRecyclerItemsList;
    }
}
