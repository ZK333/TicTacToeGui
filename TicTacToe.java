package com.company;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

class TicTacToe implements ActionListener
{
    private JFrame frame;
    private JLabel label = new JLabel("TIC TAC TOE");
    int var =0;
    int end =0;

    ArrayList<Integer> X= new ArrayList<>();
    ArrayList<Integer> O=new ArrayList<>();

    public static void main (String[] args)
    {
        TicTacToe guiLayout = new TicTacToe();
        guiLayout.start();
    }

    public void start()
    {
        frame = new JFrame("Border Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();



        frame.pack();
        frame.setVisible(true);

        contentPane.setLayout(new GridLayout(4,2));

        int i=0;

        while(i<9){
            JButton button=new JButton();
            contentPane.add(button);
            button.addActionListener(this);
            button.setText(i+"");
            i++;
        }

        contentPane.add(label);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.BOTTOM);
        label.setFont(label.getFont().deriveFont(70f));

        
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        if(button.getText()!="X"&& button.getText()!="O" && end==0 ) {
            if (var % 2 == 0) {
                X.add(Integer.parseInt(button.getText()));
                button.setText("X");
            } else {
                O.add(Integer.parseInt(button.getText()));
                button.setText("O");
            }
            int check = verification(X,O);
            if(check==1){
                System.out.println("X wins");
                label.setText("X WINS");
                end=1;
            }
            if(check==2){
                System.out.println("O wins");
                label.setText("O WINS");
                end=1;
            }
            var++;
            if(var==9){
                check =verification(X,O);

                if(check==1){
                    System.out.println("X wins");
                    label.setText("X WINS");
                    end=1;
                }
                if(check==2){
                    System.out.println("O wins");
                    label.setText("O WINS");
                    end=1;
                }

                if(check==3) {
                    System.out.println("TIE GAME");
                    label.setText("TIE GAME");
                    end = 1;
                }
            }
        }


    }

    public int verification(ArrayList<Integer> X, ArrayList<Integer> O){

        int i =0;
        Collections.sort(X);
        Collections.sort(O);

        List hor1 = Arrays.asList(0,1,2); // horizontals
        List hor2 = Arrays.asList(3,4,5);
        List hor3 = Arrays.asList(6,7,8);
        List ver1 = Arrays.asList(0,3,6); // verticals
        List ver2 = Arrays.asList(1,4,7);
        List ver3 = Arrays.asList(2,5,8);
        List dig1 = Arrays.asList(0,4,8); // diagonals
        List dig2 = Arrays.asList(2,4,6);
        ArrayList<List> Combos =new ArrayList<>();

        Combos.add(hor1);
        Combos.add(hor2);
        Combos.add(hor3);
        Combos.add(ver1);
        Combos.add(ver2);
        Combos.add(ver3);
        Combos.add(dig1);
        Combos.add(dig2);

        while(i<Combos.size()){
            if(X.containsAll(Combos.get(i))){
                return 1;
            }
            i++;
        }
        i=0;

        while(i<Combos.size()){
            if(O.containsAll(Combos.get(i))){
                return 2;
            }
            i++;
        }


        return 3;
    }
}
