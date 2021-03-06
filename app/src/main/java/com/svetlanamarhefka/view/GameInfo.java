package com.svetlanamarhefka.view;

import android.app.Activity;

/****************************************************************
 * Name:    Svetlana Marhefka                                   *
 * Project: Project 2 - Longana                                 *
 * Class:   CMPS 366 Organization of Programming Languages (OPL)* 
 * Date:    11/11/2017                                          *
 * NOTE:    THIS CLASS IS NOT CURRENTLY BEING USED              *
 ****************************************************************/

public class GameInfo extends Activity {

    /*
    private int m_TourScore;
    private String m_UserName;
    private NumberPicker m_PickNumber;
    private EditText m_UserText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_info);

        //Get the widgets reference from XML layout
        final TextView txtView = findViewById(R.id.q_tourScore);
        final NumberPicker myNumPicker = findViewById(R.id.userNumber);

        //Populate NumberPicker values from minimum and maximum value range
        //Set the minimum value of NumberPicker
        myNumPicker.setMinValue(0);
        //Specify the maximum value/number of NumberPicker
        myNumPicker.setMaxValue(999);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        myNumPicker.setWrapSelectorWheel(true);

        //Set a value change listener for NumberPicker
        myNumPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                if(newVal > 0)
                {
                    //Set TextView text color
                    txtView.setTextColor(Color.parseColor("#ffd32b3b"));
                    txtView.setText("Play until: " + newVal);
                }
                else
                {
                    txtView.setTextColor(Color.parseColor("Black"));
                    txtView.setText(R.string.ask_score);
                }
            }
        });
    }

    private void NameWarning()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(GameInfo.this).create();
        alertDialog.setTitle("Warning");
        alertDialog.setMessage("Player name will be set to Human is that okay?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        m_UserText.setText("Human");
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO, Wait I want a name!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void ScoreWarning()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(GameInfo.this);
        alertDialog.setTitle("Error");
        alertDialog.setMessage(R.string.invalid_score)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.create().show();
    }

    public void startGameClick(View view)
    {
        System.out.print("I've been clicked!\n");
        m_PickNumber = findViewById(R.id.userNumber);
        m_UserText = findViewById(R.id.userName);

        if(m_PickNumber.getValue() > 0 && !(m_UserText.getText().toString().isEmpty()))
        {
            m_TourScore = m_PickNumber.getValue();
            m_UserName = m_UserText.getText().toString();
        }
        else if(m_PickNumber.getValue() == 0)
        {
            ScoreWarning();
        }
        else if(m_UserText.getText().toString().isEmpty())
        {
            NameWarning();
        }
    }
    */
}
