package vieira.ester.calculadora.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CalculoDao {

    @Insert
    void inserir(Calculo calculo);

    @Query("SELECT * FROM calculo")
    List<Calculo> listarTodos();

    @Delete
    void deletar(Calculo calculo);

}
