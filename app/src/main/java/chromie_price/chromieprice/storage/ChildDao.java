package chromie_price.chromieprice.storage;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ChildDao {

    @Insert
    void insert(ChildTable childTable);

    @Update
    void update(ChildTable... childTables);

    @Delete
    void delete(ChildTable... childTables);

    @Transaction
    @Query("SELECT * FROM childtable")
    List<ChildTable> getAllChilds();

    @Transaction
    @Query("SELECT * FROM childtable WHERE parent_id=:parent_id")
    List<ChildTable> findChildsForParent(final Long parent_id);
}
