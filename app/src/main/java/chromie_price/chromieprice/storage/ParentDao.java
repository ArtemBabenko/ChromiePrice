package chromie_price.chromieprice.storage;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ParentDao {

    @Insert
    long insert(ParentTable parentTables);

    @Update
    void update(ParentTable... parentTables);

    @Delete
    void delete(ParentTable... parentTables);

    @Transaction
    @Query("SELECT * FROM parenttable")
    List<ParentTable> getAllParents();
}
