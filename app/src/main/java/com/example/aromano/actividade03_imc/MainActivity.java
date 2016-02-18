package com.example.aromano.actividade03_imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById retorna o componente para dentro de uma variavel
        // precisa de um argumento que eh o id do elemento em questao,
        // elemento esse que pode ser acedido atravez de: R.id.<nome do elemento>
        // no caso de se querer ir buscar strings, tera que ser com: R.string.<nome da string>
        final EditText et_peso = (EditText) findViewById(R.id.et_peso);
        final EditText et_altura = (EditText) findViewById(R.id.et_altura);
        final Button btn_avaliar = (Button) findViewById(R.id.btn_avaliar);

        // atribuimos um evento de click no botao.
        btn_avaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            // quando o botao for premido esta funcao executa
            public void onClick(View v) {
                // acedemos aos elementos et_peso e et_altura
                // e retornamos o texto neles contidos para dentro das variaveis
                int peso = Integer.parseInt(et_peso.getText().toString());
                int altura = Integer.parseInt(et_altura.getText().toString());
                // executamos a funcao calcularImc e passamos o resultado para dentro da variavel rslt
                String rslt = calcularImc(peso, altura);

                // fazemos aparecer uma mensagem no ecra em forma de Toast com a variavel rslt
                Toast.makeText(MainActivity.this, "IMC: " + rslt, Toast.LENGTH_LONG).show();
            }
        });
    }
    // funcao calcularImc aceita como parametros o peso e a altura
    private String calcularImc(int peso, int altura) {
        // converte a altura em centimetros para metros
        float altMetros = (float)(altura)/100;
        double alt = Math.pow(altMetros,2);
        float imc = (float) (peso / alt);
        String rslt;
        if(imc < 17) {
            rslt = "Muito baixo peso";
        } else if(imc < 18.50f) {
            rslt = "Abaixo do peso";
        } else if(imc < 25) {
            rslt = "Peso normal";
        } else if(imc < 30) {
            rslt = "Acima do peso";
        } else if(imc < 35) {
            rslt = "Obesidade I";
        } else if(imc < 40) {
            rslt = "Obesidade II";
        } else {
            rslt = "Obesidade III";
        }

        return rslt;
    }
}
