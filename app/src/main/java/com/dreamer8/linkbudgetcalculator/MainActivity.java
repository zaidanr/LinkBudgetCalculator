package com.dreamer8.linkbudgetcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateFiberLoss(View view) {

        EditText length = (EditText) findViewById(R.id.inputLength);
        EditText loss = (EditText) findViewById(R.id.inputLoss);
        EditText spliceLoss = (EditText) findViewById(R.id.inputSpliceLoss);
        EditText jmlSplice = (EditText) findViewById(R.id.inputJmlSplice);
        EditText lossKonektor = (EditText) findViewById(R.id.inputLossKonektor);
        EditText jmlKonektor = (EditText) findViewById(R.id.inputJmlKonektor);
        EditText lossSwitch = (EditText) findViewById(R.id.inputLossSwitch);
        EditText lossSplitter = (EditText) findViewById(R.id.inputLossSplitter);
        EditText lossKomponen = (EditText) findViewById(R.id.inputLossKomponen);

        EditText[] array = {length, loss, spliceLoss, jmlSplice, lossKonektor, jmlKonektor, lossSwitch, lossSplitter, lossKomponen};
        for(int i = 0; i < array.length; i++){
            if(TextUtils.isEmpty(array[i].getText().toString())){
                Toast.makeText(MainActivity.this, "Mohon masukkan semua nilai parameter", Toast.LENGTH_SHORT).show();
                return;
            };
        }

        //Fiber Loss
        int inputLength = Integer.parseInt(length.getText().toString());
        double inputLoss = Double.parseDouble(loss.getText().toString());

        //Splice Loss
        double inputSpliceLoss = Double.parseDouble(spliceLoss.getText().toString());
        double inputJmlSplice = Double.parseDouble(jmlSplice.getText().toString());

        //Connector Loss
        double inputLossKonektor = Double.parseDouble(lossKonektor.getText().toString());
        int inputJmlKonektor = Integer.parseInt(jmlKonektor.getText().toString());

        //Component Loss

        double inputLossSplitter = Double.parseDouble(lossSplitter.getText().toString());
        double inputLossSwitch = Double.parseDouble(lossSwitch.getText().toString());
        double inputLossKomponen = Double.parseDouble(lossKomponen.getText().toString());

        display(inputLength, inputLoss, inputSpliceLoss, inputJmlSplice, inputLossKonektor, inputJmlKonektor, inputLossSwitch, inputLossSplitter, inputLossKomponen);
    }

    public void display(
            int inputLength,
            double inputLoss,
            double inputSpliceLoss,
            double inputJmlSplice,
            double inputLossKonektor,
            int inputJmlKonektor,
            double inputLossSwitch,
            double inputLossSplitter,
            double inputLossKomponen){
        TextView result = (TextView) findViewById(R.id.result);

        double fiberLoss = (inputLength/1000) * inputLoss;
        double totalSpliceLoss = inputSpliceLoss * inputJmlSplice;
        double connectorLoss = inputLossKonektor * inputJmlKonektor;
        double componentLoss = inputLossSwitch + inputLossSplitter + inputLossKomponen;

        result.setText(fiberLoss + totalSpliceLoss + connectorLoss + componentLoss + "dB");

//        lihatRincian();
    }

//    public void lihatRincian(){
//        setContentView(R.layout.rincian);
//
//        TextView panjang = (TextView) findViewById(R.id.outputLength);
//
//        panjang.setText(this.panjang);
//    }
}
