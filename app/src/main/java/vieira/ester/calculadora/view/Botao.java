package vieira.ester.calculadora.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import vieira.ester.calculadora.model.Calculo;
import vieira.ester.calculadora.model.CalculoDao;
import vieira.ester.calculadora.model.DatabaseSingleton;

public class Botao implements View.OnClickListener{

    String conteudoBt;
    TextView expressaoTxt;
    TextView resultadoTxt;

    Context contexto;

    public Botao(String conteudo, TextView expressao, TextView resultado, Context contexto){
        this.conteudoBt = conteudo;
        this.expressaoTxt = expressao;
        this.resultadoTxt = resultado;
        this.contexto = contexto;
    }

    @Override
    public void onClick(View view) {

        if (this.conteudoBt == "C") {
            expressaoTxt.setText("");
            resultadoTxt.setText("");
        } else if (this.conteudoBt == "="){
            try{
                Expression expression = new ExpressionBuilder(this.expressaoTxt.getText().toString()).build();
                Double calculo = expression.evaluate();
                String calculoTxt = calculo.toString();
                this.resultadoTxt.setText(calculoTxt);

                Calculo c = new Calculo(this.expressaoTxt.getText().toString(), this.resultadoTxt.getText().toString());
                CalculoDao calculoDao = DatabaseSingleton.getInstance(this.contexto).appDatabase.calculoDao();

                calculoDao.inserir(c);

            } catch(Exception e){
                e.getMessage();
            }
        } else {
            this.expressaoTxt.append(this.conteudoBt);
        }
    }
}