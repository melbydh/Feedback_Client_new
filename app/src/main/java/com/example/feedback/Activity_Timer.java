package com.example.feedback;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity_Timer extends Activity {
    int durationMin, durationSec, warningMin, warningSec;
    int indexOfProject;
    ProjectInfo project;
    EditText editText_durationMin;
    EditText editText_durationSec;
    EditText editText_warningMin;
    EditText editText_warningSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__timer);

        Intent intent =getIntent();
        indexOfProject = Integer.parseInt(intent.getStringExtra("index"));

        project = AllFunctions.getObject().getProjectList().get(indexOfProject);
        getTimeOfProject();
        init();
    }

    private void getTimeOfProject()
    {
        durationMin = project.getDurationMin();
        durationSec = project.getDurationSec();
        warningMin = project.getWarningMin();
        warningSec = project.getWarningSec();
    }

    private void init()
    {
        editText_durationMin = findViewById(R.id.editText_durationMin_Timer);
        editText_durationMin.setText(String.valueOf(durationMin));
        editText_durationSec = findViewById(R.id.editText_durationSec_Timer);
        editText_durationSec.setText(String.valueOf(durationSec));
        editText_warningMin = findViewById(R.id.editText_warningMin_Timer);
        editText_warningMin.setText(String.valueOf(warningMin));
        editText_warningSec = findViewById(R.id.editText_warningSec_Timer);
        editText_warningSec.setText(String.valueOf(warningSec));

    }

    public void addDurationMin(View view)
    {
        durationMin = Integer.parseInt(editText_durationMin.getText().toString());
        durationMin++;
        if(durationMin>59)
            durationMin = durationMin - 60;
        editText_durationMin.setText(String.valueOf(durationMin));
    }

    public void minusDurationMin(View view)
    {
        durationMin = Integer.parseInt(editText_durationMin.getText().toString());
        durationMin--;
        if(durationMin<0)
            durationMin = durationMin + 60;
        editText_durationMin.setText(String.valueOf(durationMin));
    }

    public void addDurationSec(View view)
    {
        durationSec = Integer.parseInt(editText_durationSec.getText().toString());
        durationSec = durationSec + 5;
        if(durationSec>59)
            durationSec = durationSec - 60;
        editText_durationSec.setText(String.valueOf(durationSec));
    }

    public void minusDurationSec(View view)
    {
        durationSec = Integer.parseInt(editText_durationSec.getText().toString());
        durationSec = durationSec - 5;
        if(durationSec<0)
            durationSec = durationSec + 60;
        editText_durationSec.setText(String.valueOf(durationSec));
    }

    public void addWarningMin(View view)
    {
        warningMin = Integer.parseInt(editText_warningMin.getText().toString());
        warningMin++;
        if(warningMin>59)
            warningMin = warningMin - 60;
        editText_warningMin.setText(String.valueOf(warningMin));
    }

    public void minusWarningMin(View view)
    {
        warningMin = Integer.parseInt(editText_warningMin.getText().toString());
        warningMin--;
        if(warningMin<0)
            warningMin = warningMin + 60;
        editText_warningMin.setText(String.valueOf(warningMin));
    }

    public void addWarningSec(View view)
    {
        warningSec = Integer.parseInt(editText_warningSec.getText().toString());
        warningSec = warningSec + 5;
        if(warningSec>59)
            warningSec = warningSec - 60;
        editText_warningSec.setText(String.valueOf(warningSec));
    }

    public void minusWarningSec(View view)
    {
        warningSec = Integer.parseInt(editText_warningSec.getText().toString());
        warningSec = warningSec - 5;
        if(warningSec<0)
            warningSec = warningSec + 60;
        editText_warningSec.setText(String.valueOf(warningSec));
    }

    public void save_Timer(View view)
    {
        durationMin = Integer.parseInt(editText_durationMin.getText().toString());
        durationSec = Integer.parseInt(editText_durationSec.getText().toString());
        warningMin = Integer.parseInt(editText_warningMin.getText().toString());
        warningSec = Integer.parseInt(editText_warningSec.getText().toString());
        System.out.println("Time in Timer: "+durationMin+":"+durationSec+"   "+warningMin+":"+warningSec);
        AllFunctions.getObject().projectTimer(project,durationMin,durationSec,warningMin,warningSec);
        Intent intent = new Intent(this, Assessment_Preparation_Activity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void back_Timer(View view)
    {
        Intent intent = new Intent(this, Assessment_Preparation_Activity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

}
