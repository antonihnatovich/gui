package com.l;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.l.gui.IcButton;
import com.l.gui.R;

import folder.VisibleButtonUnitTest;

public class AdditionalActivity extends AppCompatActivity {

    public Button button1, button2;
    public IcButton icButton;
    public EditText editText;
    public VisibleButtonUnitTest forButton = new VisibleButtonUnitTest();
    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.edit_text);

        editText.setText("Clicked " + counter + " times. Time - " + forButton.getCurrentMinutes());

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("Clicked " + ++counter + " times. Time - " + forButton.getCurrentMinutes());
            }
        });
        visibleTester(button1);
    }

    public void visibleTester(Button button) {
        button.setVisibility(isVisible() ? View.VISIBLE : View.INVISIBLE);
    }

    public boolean isVisible() {
        return forButton.nameOfReadyState().equals("visible") ? true : false;
    }
}
