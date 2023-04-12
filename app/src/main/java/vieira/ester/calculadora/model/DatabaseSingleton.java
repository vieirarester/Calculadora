package vieira.ester.calculadora.model;

import android.content.Context;

import androidx.room.Room;

public class DatabaseSingleton {

    public static DatabaseSingleton databaseSingleton;
    public AppDatabase appDatabase;

    private DatabaseSingleton(){

    }

    public static DatabaseSingleton getInstance(Context context){
        if(databaseSingleton == null){
            databaseSingleton = new DatabaseSingleton();
            databaseSingleton.appDatabase = Room.databaseBuilder(context, AppDatabase.class, "banco-dados").allowMainThreadQueries().build();
        }
        return databaseSingleton;
    }

}
