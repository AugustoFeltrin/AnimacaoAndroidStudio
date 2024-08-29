package com.example.efeitos;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView txtTexto = findViewById(R.id.txtTexto);

        Button btnTransparencia = findViewById(R.id.btnTransparencia);
        Button btnAnimacao = findViewById(R.id.btnAnimacao);

        btnTransparencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTexto.setAlpha(0.5f);
            }
        });

        btnAnimacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation fadeAnimation = new AlphaAnimation(0.0f, 1.0f);
                fadeAnimation.setDuration(1000);
                fadeAnimation.setRepeatCount(1);
                fadeAnimation.setRepeatMode(Animation.REVERSE);

                txtTexto.startAnimation(fadeAnimation);
            }
        });
    }
}
