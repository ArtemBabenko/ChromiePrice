package chromie_price.chromieprice.app;

import android.app.Application;
import android.arch.persistence.room.Room;

import chromie_price.chromieprice.storage.Database;

public class App extends Application {

    public static App instance;
    private Database database;

    public void onCreate(){
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, Database.class, "database").allowMainThreadQueries().build();
    }

    public static App getInstance() {
        return instance;
    }

    public Database getDatabase() {
        return database;
    }
}
