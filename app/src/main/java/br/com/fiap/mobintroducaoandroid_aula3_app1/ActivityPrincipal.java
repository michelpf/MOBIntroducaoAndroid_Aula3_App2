package br.com.fiap.mobintroducaoandroid_aula3_app1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class ActivityPrincipal extends AppCompatActivity implements View.OnClickListener{


    private ImageView imgComp = null;
    private ImageView imgJog = null;

    private Button btnJog = null;
    private Button btnComp = null;

    private Button btnReiniciar = null;

    private int[] dados = {R.mipmap.ic_dado0, R.mipmap.ic_dado1, R.mipmap.ic_dado2,
            R.mipmap.ic_dado3, R.mipmap.ic_dado4, R.mipmap.ic_dado5, R.mipmap.ic_dado6};


    private int pontosComp=-1;
    private int pontosJog=-1;

    Random rand = new Random();

    @Override
    public void onClick(View v) {
        if (v==btnComp) jogarDadoComp();
        if (v==btnJog) jogarDadoJog();
        if (v==btnReiniciar) reiniciar();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgComp=(ImageView)findViewById(R.id.imgComp);
        imgJog=(ImageView)findViewById(R.id.imgJog);

        btnComp=(Button)findViewById(R.id.btnComp);
        btnJog=(Button)findViewById(R.id.btnJog);
        btnReiniciar=(Button)findViewById(R.id.btnReiniciar);

        btnComp.setOnClickListener(this);
        btnJog.setOnClickListener(this);
        btnReiniciar.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void jogarDadoComp(){

        pontosComp = rand.nextInt(6);
        imgComp.setImageResource(dados[pontosComp]);

        if (pontosJog>=0){
            placar();
        }
    }

    public void placar() {
        if (pontosComp>pontosJog){
            Toast.makeText(this, "Computador Venceu", Toast.LENGTH_SHORT).show();
        }
        if (pontosComp<pontosJog){
            Toast.makeText(this, "Jogador Venceu", Toast.LENGTH_SHORT).show();
        }
        if (pontosComp==pontosJog){
            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show();
        }

        pontosComp=-1;
        pontosJog=-1;



    }

    public void reiniciar(){
        imgJog.setImageResource(dados[0]);
        imgComp.setImageResource(dados[0]);
    }


    public void jogarDadoJog(){

        pontosJog = rand.nextInt(6);
        imgJog.setImageResource(dados[pontosJog]);

        if (pontosComp>=0){
            placar();
        }
    }

}
