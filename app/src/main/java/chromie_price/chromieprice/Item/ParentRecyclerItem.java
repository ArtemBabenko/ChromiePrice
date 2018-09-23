package chromie_price.chromieprice.Item;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.List;

public class ParentRecyclerItem implements Parent<ChildRecyclerItem> {

    private String name;

    private List<ChildRecyclerItem> childRecyclerItemsList;

    public ParentRecyclerItem(String name, List<ChildRecyclerItem> childRecyclerItemsList) {
        this.name = name;
        this.childRecyclerItemsList = childRecyclerItemsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildList(List<ChildRecyclerItem> childRecyclerItemsList) {
        this.childRecyclerItemsList = childRecyclerItemsList;
    }

    public List<ChildRecyclerItem> getChildList() {
        return childRecyclerItemsList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
