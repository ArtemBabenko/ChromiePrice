package chromie_price.chromieprice.storage;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = ParentTable.class, parentColumns = "id", childColumns = "parent_id", onDelete = CASCADE))
public class ChildTable {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;
    @ColumnInfo(name = "parent_id")
    private Long parentId;

    public ChildTable(Long parentId, String name) {
        this.parentId = parentId;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
