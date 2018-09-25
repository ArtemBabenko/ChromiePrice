package chromie_price.chromieprice.storage;

import android.arch.persistence.room.RoomDatabase;

@android.arch.persistence.room.Database(entities = {ParentTable.class, ChildTable.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase{
    public abstract ParentDao parentDao();
    public abstract ChildDao childDao();
}
