package com.svetlanamarhefka.model;

import com.svetlanamarhefka.model.player.Side;

import java.io.Serializable;
import java.util.Vector;
/****************************************************************
 * Name:    Svetlana Marhefka                                   *
 * Project: Project 2 - Longana                                 *
 * Class:   CMPS 366 Organization of Programming Languages (OPL)* 
 * Date:    11/11/2017                                          *
 ****************************************************************/

public class Board implements Serializable {

    /* m*/
    private Vector<Domino> m_BoardVector;
    private int m_EngineValue;
    private boolean m_EngineSet;
    /**
     * Default Constructor
     */
    public Board()
    {
        this.m_BoardVector = new Vector<Domino>();
        m_EngineSet = false;
    }

    /**
     * Overloaded Constructor
     */
    public Board(Vector<Domino> a_inGameBoard)
    {
        m_BoardVector = new Vector<Domino>();
        this.m_BoardVector = a_inGameBoard;
    }

    public void setM_EngineValue(int a_InEngine)
    {
        m_EngineValue = a_InEngine;
    }

    public int getM_EngineValue()
    {
        return m_EngineValue;
    }

    public void setM_EngineSet()
    {
        m_EngineSet = true;
    }

    public boolean isM_EngineSet()
    {
        return m_EngineSet;
    }
    // this function will add a tile to the begining of the vector
    // in the end it will add a tile to the "left" side of the board
    private void addToLeft(Domino a_tileToAdd)
    {
        m_BoardVector.add(0, a_tileToAdd);
    }

    // this function will add a tile to the end of the vector
    // in the end it will add a tile to the "left" side of the board
    private void addToRight(Domino a_tileToAdd)
    {
        m_BoardVector.add(a_tileToAdd);
    }

    // this function will check to see if the board is empty
    private boolean boardEmpty()
    {
        return m_BoardVector.isEmpty() == true;
    }

    // this function will retrieve the left most value of the board
    private int boardLeft()
    {
        return m_BoardVector.elementAt(0).getM_leftSide();
    }

    // this function will retrieve the right most value of the board
    private int boardRight()
    {
        return m_BoardVector.elementAt(m_BoardVector.size() - 1).getM_rightSide();
    }

    public boolean addEngine(Domino a_InDomino, Side a_InSide)
    {
        if(a_InDomino.isEngine(m_EngineValue))
        {
            // If the side selected is Left and the domino is valid
            if(a_InSide == Side.LEFT)
            {
                addToLeft(a_InDomino);
            }
            else if(a_InSide == Side.RIGHT)
            {
                addToRight(a_InDomino);
            }
            return true;
        }
        return false;
    }

    public boolean addToBoard(Domino a_InDomino, Side a_InSide)
    {
        // If there is no engine on the board
        if(!m_EngineSet)
        {
            return false;
        }
        // Check to make sure that the domino is valid
        Domino checkDomino = checkDominoAgainstBoard(a_InDomino, a_InSide);
        if(checkDomino == null)
            return false;
        // If the side selected is Left and the domino is valid
        if(a_InSide == Side.LEFT)
        {
            addToLeft(checkDomino);
        }
        else if(a_InSide == Side.RIGHT)
        {
            addToRight(checkDomino);
        }
        // If it gets all the way down here then we are good
        return true;
    }

    public boolean validDomino(Domino a_InDomino, Side a_InSide)
    {
        // If the board doesn't have the engine
        if(!m_EngineSet)
        {
            return false;
        }
        return checkDominoAgainstBoard(a_InDomino, a_InSide) != null;
    }

    public Domino checkDominoAgainstBoard(Domino a_InDomino, Side a_InSide)
    {
        if (!m_EngineSet)
            return null;
        if(a_InSide == Side.LEFT)
        {
            if(boardLeft() == a_InDomino.getM_rightSide())
            {
                return  a_InDomino;
            }
            else if(boardLeft() == a_InDomino.getM_leftSide())
            {
                return a_InDomino.flipTile();
            }

        }
        else if(a_InSide == Side.RIGHT)
        {
            if(boardRight() == a_InDomino.getM_leftSide())
            {
                return  a_InDomino;
            }
            else if(boardRight() == a_InDomino.getM_rightSide())
            {
                return a_InDomino.flipTile();
            }
        }
        else return null;
        return null;
    }

    public boolean addTileBack(Domino a_InTile)
    {
        // If the RIGHT side of the BOARD doesn't match up with the left or the right side
        // of the tile then it isn't valid for that side
        if ((boardRight() != a_InTile.getM_leftSide()) && (boardRight() != a_InTile.getM_rightSide()))
        {
            System.out.println("Invalid tile: " + a_InTile.toString() + " not appendable\n");
            return false;
        }

        /**
        // If the right side of the board == to the left side of the tile --> just add
        if(boardRight() == a_InTile.getLeft())
        {
            m_boardVector.add(a_InTile);
        }
        // otherwise turn the tile around
        else
        {
            a_InTile.flipTile();
            m_boardVector.add(a_InTile);
        }
        */
        // SHOULD BE THE SAME AS
        if(boardRight() == a_InTile.getM_rightSide())
        {
            a_InTile.flipTile();
        }
        addToRight(a_InTile);
        //m_boardVector.add(a_InTile);
        System.out.println("Tile: " + a_InTile.toString() + " appended successfully\n");
        return true;
    }

    public boolean addTileFront(Domino a_InTile)
    {
        // If the LEFT side of the BOARD doesn't match up with the left or the right side
        // of the tile then it isn't valid for that side
        if ((boardLeft() != a_InTile.getM_leftSide()) && (boardLeft() != a_InTile.getM_rightSide()))
        {
            System.out.println("Invalid tile: " + a_InTile.toString() + " not placeable\n");
            return false;
        }
        /**
        // If the LEFT SIDE of the BOARD == to the RIGHT SIDE of the TILE --> just add
        if(boardLeft() == a_InTile.getRight())
        {
            m_boardVector.add(0, a_InTile);
        }
        // otherwise turn the tile around
        else
        {
            a_InTile.flipTile();
            m_boardVector.add(a_InTile);
        }
        */

        // SHOULD BE THE SAME AS
        if(boardLeft() == a_InTile.getM_leftSide())
        {
            a_InTile.flipTile();
        }
        //m_boardVector.add(0, a_InTile);
        addToLeft(a_InTile);
        System.out.println("Tile: " + a_InTile.toString() + " added successfully\n");
        return true;
    }

    public boolean addDoubleTile(Domino a_InTile, Side a_InSide)
    {
        // If the tile is not a double
        if(!a_InTile.isDouble())
        {
            System.out.println("Invalid double: " + a_InTile.toString());
            return false;
        }
        // If the side selected is LEFT --> check the tile against the LEFT side of the board
        // Because it is a double
        if(a_InSide.equals("L") && (boardLeft() == a_InTile.getM_leftSide()))
        {
            System.out.println("Double: " + a_InTile.toString() + "prepended to layout (added to the left).");
            // m_boardVector.add(0, a_InTile);
            addToLeft(a_InTile);
            return true;
        }
        // If the side selected is RIGHT --> check the tile against the RIGHT side of the board
        if(a_InSide.equals("R") && (boardRight() == a_InTile.getM_rightSide()))
        {
            System.out.println("Double: " + a_InTile.toString() + "appended to layout (added to the right).");
            // m_boardVector.add(0, a_InTile);
            addToRight(a_InTile);
            return true;

        }
        return false;
    }

    public Vector<Domino> getM_BoardVector()
    {
        return m_BoardVector;
    }

    // this function will print the curent board to the screen
    public void printBoard()
    {
        String fullString = "";

        for(int itemVal = 0; itemVal < m_BoardVector.size(); itemVal++)
        {
            fullString = fullString.concat(m_BoardVector.get(itemVal).toString() + " ");
        }
        System.out.println("Board Ouput\n" + "L " + fullString + " R" + "\n");
    }
}
