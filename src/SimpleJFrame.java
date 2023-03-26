import javax.swing.*;

public class SimpleJFrame
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        frame.setTitle("Rock Paper Scissors");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}