package chromie_price.chromieprice.Item;

import java.util.List;

public class ParentRecyclerItem {

    private List<ChildRecyclerItem> childRecyclerItemsList;

    public ParentRecyclerItem(List<ChildRecyclerItem> childRecyclerItemsList) {
        this.childRecyclerItemsList = childRecyclerItemsList;
    }

    public List<ChildRecyclerItem> getChildRecyclerItemsList() {
        return childRecyclerItemsList;
    }
}
