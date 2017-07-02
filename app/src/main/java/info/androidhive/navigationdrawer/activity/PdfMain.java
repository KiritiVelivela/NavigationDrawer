package info.androidhive.navigationdrawer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import info.androidhive.navigationdrawer.R;

public class PdfMain extends AppCompatActivity implements View.OnClickListener {

    Button buttonChooseFile;
    Button buttonUploadFile;
    TextView textViewFilePath;
    EditText editTextFileName;
    Button buttonNext;

    String filePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_main);
        buttonChooseFile = (Button) findViewById(R.id.buttonChooseFile);
        buttonUploadFile = (Button) findViewById(R.id.buttonUploadFile);
        buttonNext = (Button) findViewById(R.id.buttonNext);

        buttonChooseFile.setOnClickListener(this);
        buttonUploadFile.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.buttonChooseFile:
                startActivity(new Intent(this, Uploadmonthly.class));
                break;
            case R.id.buttonUploadFile:
                startActivity(new Intent(this, UploadWeekly.class));
                break;
            case R.id.buttonNext:
                startActivity(new Intent(this, UploadedPDFs.class));
                break;
        }
    }
}
