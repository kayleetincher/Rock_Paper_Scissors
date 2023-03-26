
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame implements ActionListener
{



    JPanel mainPnl, iconPnl, displayPnl, controlPnl;


    ImageIcon icon, paperIcon, rockIcon, scissorsIcon, quitIcon;

    JTextArea displayTA;
    JScrollPane scroller;


    JLabel title;


    JButton rock, paper, scissors, quit;

    private int playerChoice, computerChoice, playerScore, computerScore;




    public RockPaperScissorsFrame() {


        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);

        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Rock Paper Scissors Game");
        setVisible(true);
    }


    private void createIconPanel ()
    {
        iconPnl = new JPanel();
        icon = new ImageIcon("C:\\Users\\kayle\\Downloads\\download.png");


        title = new JLabel("Rock Paper Scissors Game", icon, JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);
        title.setHorizontalTextPosition(JLabel.CENTER);


        iconPnl.add(title);
    }
    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout());

        rockIcon = new ImageIcon("C:\\Users\\kayle\\Downloads\\FortuneTeller\\rock.png");
        paperIcon = new ImageIcon("C:\\Users\\kayle\\Downloads\\paper1.png");
        scissorsIcon = new ImageIcon("C:\\Users\\kayle\\Downloads\\scissors.png");
        quitIcon = new ImageIcon();

        rock = new JButton("Rock", rockIcon);
        rock.setPreferredSize(new Dimension(100,100));

        paper = new JButton("Paper", paperIcon);
        paper.setPreferredSize(new Dimension(100,100));

        scissors = new JButton("Scissors", scissorsIcon);
        scissors.setPreferredSize(new Dimension(100,100));

        quit = new JButton("Quit", quitIcon);
        quit.setPreferredSize(new Dimension(100,100));


        controlPnl.add(rock);
        rock.addActionListener(this);

        controlPnl.add(paper);
        paper.addActionListener(this);

        controlPnl.add(scissors);
        scissors.addActionListener(this);


        controlPnl.add(quit);
        quit.addActionListener((ActionEvent ae)-> System.exit(0));



    }
    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayTA = new JTextArea(15, 50);

        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == rock) {
            playerChoice = 1;
        } else if (e.getSource() == paper) {
            playerChoice = 2;
        } else if (e.getSource() == scissors) {
            playerChoice = 3;
        }
        computerChoice = (int) (Math.random() * 3) + 1;

        String playerChoiceX = "";
        String computerChoiceX = "";
        String result = "";

        switch (playerChoice) {
            case 1:
                playerChoiceX = "Rock";
                break;
            case 2:
                playerChoiceX = "Paper";
                break;
            case 3:
                playerChoiceX = "Scissors";
                break;
        }

        switch (computerChoice) {
            case 1:
                computerChoiceX = "Rock";
                break;
            case 2:
                computerChoiceX = "Paper";
                break;
            case 3:
                computerChoiceX = "Scissors";
                break;
        }

        if (playerChoice == computerChoice) {
            result = "It's a tie!";
        } else if ((playerChoice == 1 && computerChoice == 3) || (playerChoice == 2 && computerChoice == 1)
                || (playerChoice == 3 && computerChoice == 2)) {
            result = "Player wins!";
            playerScore++;
        } else {
            result = "Computer wins!";
            computerScore++;
        }

        displayTA.setText("Player: " + playerScore + "| Computer: " + computerScore + "\n" +
                "Player's Choice: " + playerChoiceX + "\n"+
                "Computer's Choice: " + computerChoiceX + "\n" + result);


    }}

