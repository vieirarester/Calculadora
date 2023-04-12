package vieira.ester.calculadora.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Calculo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CalculoDao calculoDao();

}
