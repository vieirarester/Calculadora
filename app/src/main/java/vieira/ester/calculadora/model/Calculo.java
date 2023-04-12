package vieira.ester.calculadora.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Calculo {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "conta")
    public String conta;

    @ColumnInfo(name = "resposta")
    public String resposta;

    public Calculo(String conta, String resposta){
        this.conta = conta;
        this.resposta = resposta;
    }

    @Override
    public String toString() {
        return conta + " = " + resposta;
    }
}
