package com.example.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView frases;
    private Button gerarFrases;
    private TextView TextView;
    //private List<FraseAPI> frase = new ArrayList<>();
    private String frase = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frases = findViewById(R.id.IDfrases);
        TextView = (TextView) findViewById(R.id.IDfrases);
        gerarFrases = findViewById(R.id.IDGerarButton);

        getSupportActionBar().hide();

        /*gerarFrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] frasescampo = {"A persistência é o caminho do êxito.","As pessoas costumam dizer que a motivação não dura sempre. Bem, nem o efeito do banho, por isso recomenda-se diariamente.","Motivação é a arte de fazer as pessoas fazerem o que você quer que elas façam porque elas o querem fazer.",

                        "O sucesso é o seguinte: você não é o único. O seu fracasso é o único.","O sucesso não é a soma de todas as recompensas, mas sim a multiplicação das recompensas pelo número de vezes que você desafia o seu limite e esforça para superá-lo.","O sucesso não vem de ter muitos sonhos, mas sim de ter um sonho bem realizado.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma vontade de realizá-lo.","O sucesso não vem de ter um plano, mas sim de ter uma"};




                //Random random = new Random();
                //int numerosAleatorio = random.nextInt(frasescampo.length);

                frases.setText(frasescampo[new Random().nextInt(frasescampo.length)]);
            }
        });*/
        gerarFrases.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Tarefa tarefa = new Tarefa();
                tarefa.execute("https://positive-vibes-api.herokuapp.com/quotes/random");
            }
        });

    }

    private class Tarefa extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... String) {
            String retorno = Connection.getDados(String[0]);

            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            frase = ConnectionJson2.jsonDados(s);
            //TextView.setText((CharSequence) frase);
            //TextView.setText(s);
            //exibirDados();
            TextView.setText(frase);
        }

        private void exibirDados() {
            if(frase != null) {
                /*for (FraseAPI frase : frase) {
                    TextView.append(frase.getData() + "\n");
                    System.out.println(frase.getData());
                }*/
            }
        }
    }
}