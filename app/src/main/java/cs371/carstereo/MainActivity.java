package cs371.carstereo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener, View.OnLongClickListener{

    private Button powerButton;
    //First modification
    private SeekBar volumeBar;
    //Second modification
    private SeekBar tunerBar;
    //Third modification
    private TextView display;
    //Fourth modification
    private Switch amFmButton;
    private boolean isOn = false;
    private boolean amFmOn = false;
    private int fmTrack;
    private double fmValue;
    private int amTrack;

    private Button preset1;
    private Button preset2;
    private Button preset3;
    private Button preset4;
    private Button preset5;



    int[] amStations = {550, 600, 650, 700, 750};
    double[] fmStations = {90.9, 92.9, 94.9, 96.9, 98.9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        powerButton = (Button)findViewById(R.id.powerButton);
        powerButton.setOnClickListener(this);

        volumeBar = (SeekBar)findViewById(R.id.volumeBar);
        tunerBar = (SeekBar)findViewById(R.id.tunerBar);
        tunerBar.setOnSeekBarChangeListener(this);

        display = (TextView)findViewById(R.id.display);
        amFmButton = (Switch)findViewById(R.id.amFmButton);
        amFmButton.setOnCheckedChangeListener(this);

        preset1 = (Button)findViewById(R.id.button);
        preset1.setOnClickListener(this);
        preset2 = (Button)findViewById(R.id.button2);
        preset2.setOnClickListener(this);
        preset3 = (Button)findViewById(R.id.button3);
        preset3.setOnClickListener(this);
        preset4 = (Button)findViewById(R.id.button4);
        preset4.setOnClickListener(this);
        preset5 = (Button)findViewById(R.id.button5);
        preset5.setOnClickListener(this);

        preset1.setOnLongClickListener(this);
        preset2.setOnLongClickListener(this);
        preset3.setOnLongClickListener(this);
        preset4.setOnLongClickListener(this);
        preset5.setOnLongClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if( v.getId() == R.id.powerButton) {
            if(!isOn) {
                volumeBar.setEnabled(true);
                tunerBar.setEnabled(true);
                display.setEnabled(true);
                display.setText("Display");
                amFmButton.setEnabled(true);
                isOn = true;
                preset1.setEnabled(true);
                preset2.setEnabled(true);
                preset3.setEnabled(true);
                preset4.setEnabled(true);
                preset5.setEnabled(true);
            }
            else{
                volumeBar.setEnabled(false);
                tunerBar.setEnabled(false);
                display.setText("");
                display.setEnabled(false);
                amFmButton.setEnabled(false);
                isOn = false;
                preset1.setEnabled(false);
                preset2.setEnabled(false);
                preset3.setEnabled(false);
                preset4.setEnabled(false);
                preset5.setEnabled(false);

            }
        }

        //Preset Buttons
        if(v.getId() == R.id.button){
            if(amFmOn){
                int amValue = amStations[0];
                display.setText("AM Station: " + amValue);
            }
            else{
                double fmStore = fmStations[0];
                display.setText("FM Station: " + fmStore);
            }
        }
        if(v.getId() == R.id.button2){
            if(amFmOn){
                int amValue = amStations[1];
                display.setText("AM Station: " + amValue);
            }
            else{
                double fmStore = fmStations[1];
                display.setText("FM Station: " + fmStore);
            }
        }
        if(v.getId() == R.id.button3){
            if(amFmOn){
                int amValue = amStations[2];
                display.setText("AM Station: " + amValue);
            }
            else{
                double fmStore = fmStations[2];
                display.setText("FM Station: " + fmStore);
            }
        }
        if(v.getId() == R.id.button4){
            if(amFmOn){
                int amValue = amStations[3];
                display.setText("AM Station: " + amValue);
            }
            else{
                double fmStore = fmStations[3];
                display.setText("FM Station: " + fmStore);
            }
        }
        if(v.getId() == R.id.button5){
            if(amFmOn){
                int amValue = amStations[4];
                display.setText("AM Station: " + amValue);
            }
            else{
                double fmStore = fmStations[4];
                display.setText("FM Station: " + fmStore);
            }
        }


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(amFmOn){
            amTrack = i + 530;
            display.setText("AM Station: " + amTrack);
        }
        else {
            fmTrack = i + 881;
            fmValue = fmTrack / 10.0;
            display.setText("FM Station: " + fmValue);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b){
            display.setText("AM Station: ");
            tunerBar.setMax(1170);
            tunerBar.setProgress(0);
            tunerBar.incrementProgressBy(10);
            amFmOn = true;
        }
        else{
            display.setText("FM Station: ");
            tunerBar.setMax(198);
            tunerBar.setProgress(0);
            tunerBar.incrementProgressBy(2);
            amFmOn = false;
        }

    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getId() == R.id.button){
            if(amFmOn){
                amStations[0] = amTrack;
                display.setText("AM Station: " +amTrack + "*");
            }
            else{
                fmStations[0] = fmValue;
                display.setText("FM Station: " + fmValue + "*");
            }
        }
        if(v.getId() == R.id.button2){
            if(amFmOn){
                amStations[1] = amTrack;
                display.setText("AM Station: " +amTrack + "*");
            }
            else{
                fmStations[1] = fmValue;
                display.setText("FM Station: " + fmValue + "*");
            }
        }
        if(v.getId() == R.id.button3){
            if(amFmOn){
                amStations[2] = amTrack;
                display.setText("AM Station: " +amTrack + "*");
            }
            else{
                fmStations[2] = fmValue;
                display.setText("FM Station" + fmValue + "*");
            }
        }
        if(v.getId() == R.id.button4){
            if(amFmOn){
                amStations[3] = amTrack;
                display.setText("AM Station: " +amTrack + "*");
            }
            else{
                fmStations[3] = fmValue;
                display.setText("FM Station: " + fmValue + "*");
            }
        }
        if(v.getId() == R.id.button5){
            if(amFmOn){
                amStations[4] = amTrack;
                display.setText("AM Station: " +amTrack + "*");
            }
            else{
                fmStations[4] = fmValue;
                display.setText("FM Station: " + fmValue + "*");
            }
        }
        return false;
    }
}
