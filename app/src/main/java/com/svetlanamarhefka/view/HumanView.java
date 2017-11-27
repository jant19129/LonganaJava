package com.svetlanamarhefka.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.svetlanamarhefka.model.Domino;

import java.util.Vector;

/****************************************************************
 * Name:    Svetlana Marhefka                                             *
 * Project: Project 2 - Longana                                 *
 * Class:   CMPS 366 Organization of Programming Languages (OPL)* 
 * Date:    11/25/2017                                             *
 ****************************************************************/

public class HumanView extends View {

    private MainGame m_MainView;
    private DominoView m_DominoView;
    private Context m_Context;

    public HumanView(Context context, MainGame a_InMainGame)
    {
        super(context);
        m_Context = context;
        m_DominoView = new DominoView(m_Context);
        m_MainView = a_InMainGame;
    }

    public void displayHand(Vector<Domino> a_InDomino, LinearLayout a_InLayout)
    {
        GridLayout.LayoutParams gridLayoutParam;

        int row = 0, col = 0;
        for (int i = 0; i < a_InDomino.size(); i++) {
            if (i >= 14) row = 1;
            col = i % 14;
            GridLayout.Spec gridRow = GridLayout.spec(row, 1);
            GridLayout.Spec gridCol = GridLayout.spec(col, 1);
            gridLayoutParam = new GridLayout.LayoutParams(gridRow, gridCol);
            gridLayoutParam.setMargins(4, 0, 4, 0);
            a_InLayout.addView(btnDominoUpDwn (a_InDomino.get(i), true), gridLayoutParam);
        }
    }

    public ImageButton btnDominoUpDwn(final Domino a_InDomino, boolean buttonsEnabled) {
        ImageButton button = new ImageButton(m_Context);
        button.setLayoutParams(new ViewGroup.LayoutParams(1, 2));

        if (buttonsEnabled) {
            //eventListenerForButton
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(m_Context, "Clicked on image button", Toast.LENGTH_SHORT).show();
                    System.out.print("I've been clicked!!");
                }
            });
        }

        button.setBackground(m_DominoView.drawDomino(a_InDomino.getM_leftSide(), a_InDomino.getM_rightSide(), true, false));
        return button;
    }
}