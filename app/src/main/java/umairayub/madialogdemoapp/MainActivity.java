package umairayub.madialogdemoapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import umairayub.madialog.MaDialog;
import umairayub.madialog.MaDialogListener;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaDialog.Builder(MainActivity.this)
                        .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis scelerisque, turpis et fringilla malesuada, leo velit ullamcorper enim, quis iaculis metus urna ut ligula. Sed malesuada lacinia massa, a accumsan justo condimentum vel.")
                        .build();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaDialog.Builder(MainActivity.this)
                        .setTitle("Basic With Title")
                        .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis scelerisque, turpis et fringilla malesuada, leo velit ullamcorper enim, quis iaculis metus urna ut ligula. Sed malesuada lacinia massa, a accumsan justo condimentum vel.")
                        .build();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaDialog.Builder(MainActivity.this)
                        .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis scelerisque, turpis et fringilla malesuada, leo velit ullamcorper enim, quis iaculis metus urna ut ligula. Sed malesuada lacinia massa, a accumsan justo condimentum vel.")
                        .setPositiveButtonText("Yes")
                        .setNegativeButtonText("Cancel")
                        .setPositiveButtonListener(new MaDialogListener() {
                            @Override
                            public void onClick() {

                            }
                        })
                        .setNegativeButtonListener(new MaDialogListener() {
                            @Override
                            public void onClick() {

                            }
                        })
                        .build();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaDialog.Builder(MainActivity.this)

                        .setTitle("Basic with Title + Buttons")
                        .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis scelerisque, turpis et fringilla malesuada, leo velit ullamcorper enim, quis iaculis metus urna ut ligula. Sed malesuada lacinia massa, a accumsan justo condimentum vel. ")
                        .setPositiveButtonText("Yes")
                        .setNegativeButtonText("Cancel")
                        .setPositiveButtonListener(new MaDialogListener() {
                            @Override
                            public void onClick() {

                            }
                        })
                        .setNegativeButtonListener(new MaDialogListener() {
                            @Override
                            public void onClick() {

                            }
                        })
                        .build();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaDialog.Builder(MainActivity.this)
                        .setTitle("Basic with Image + Title + Buttons")
                        .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis scelerisque, turpis et fringilla malesuada, leo velit ullamcorper enim, quis iaculis metus urna ut ligula. Sed malesuada lacinia massa, a accumsan justo condimentum vel.")
                        .setImage(R.drawable.image)
                        .setPositiveButtonText("Yes")
                        .setNegativeButtonText("Cancel")
                        .setPositiveButtonListener(new MaDialogListener() {
                            @Override
                            public void onClick() {

                            }
                        })
                        .setNegativeButtonListener(new MaDialogListener() {
                            @Override
                            public void onClick() {

                            }
                        })
                        .build();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaDialog.Builder(MainActivity.this)
                        .setTitle("Basic with GIF + Title + Buttons")
                        .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis scelerisque, turpis et fringilla malesuada, leo velit ullamcorper enim, quis iaculis metus urna ut ligula. Sed malesuada lacinia massa, a accumsan justo condimentum vel.")
                        .setGif(R.drawable.dragon)
                        .setPositiveButtonText("Yes")
                        .setNegativeButtonText("Cancel")
                        .setCustomFont(R.font.press_start_2p)

                        .setPositiveButtonListener(new MaDialogListener() {
                            @Override
                            public void onClick() {

                            }
                        })
                        .setNegativeButtonListener(new MaDialogListener() {
                            @Override
                            public void onClick() {

                            }
                        })
                        .build();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://github.com/umairayub79/MaDialog"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }


}
