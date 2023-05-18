import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class Info6 extends JFrame {

    private JButton nextButton;
    private JLabel titleLabel;
    private JTextArea textArea;
    private JLabel imageLabel;

    private static final String text1 = "\n   1. EPEAT - a global environmental rating system for electronics. It helps consumers and businesses choose environmentally friendly products.\n\n   2. Greenpeace: an environmental organization that campaigns for solutions to environmental issues, including electronic waste and climate change. It was founded in Canada in 1971 but has since been expanded to different countries as well.\n\n   3. A Made-in-Ontario Environment Plan - is a plan made by the government of ontario to help the environment. This includes managing and reducing the amount of  e-waste by putting more rules and regulations on them. It also includes reducing the amount of waste that goes to the landfill and steps to prevent waste from ending up in our water.";
    
    public Info6() {
        
        setTitle("Environmental Quiz");
        setSize(800, 400);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                rescale(e.getComponent().getSize());
            }
        });

 
        titleLabel = new JLabel();
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        titleLabel.setText("How to Reduce Negative Impacts:");
        textArea.setText(text1);

        
        nextButton = new JButton();
        nextButton.setText("Start Quiz");
        nextButton.setMnemonic(KeyEvent.VK_N);
        nextButton.addActionListener(this::nextButtonActionListener);

        
        add(titleLabel);
        add(textArea);
        add(nextButton);

        String imagePath = "src/images/Programs&Initiatives.jpg";
        File imageFile = new File(imagePath);
        if (imageFile.exists()) {
            ImageIcon imageIcon = new ImageIcon(imageFile.getAbsolutePath());
            imageLabel = new JLabel(imageIcon);
            add(imageLabel);
        } else {
            System.out.println("Image file not found: " + imagePath);
        }

        this.rescale(getSize());

        
    }

    private void rescale(Dimension dimension) {
        titleLabel.setBounds((dimension.width - dimension.width ) / 2 + 50, 100, dimension.width - dimension.width / 14, dimension.height / 4);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, Math.round(dimension.height / 16.0f)));

        textArea.setBounds((dimension.width - dimension.width ) / 2 + 50, dimension.height  / 3, dimension.width/2+18,  dimension.height / 3);
        textArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, Math.round(dimension.height / 75.0f)));

        
        nextButton.setBounds((dimension.width - dimension.width / 2) / 2 , dimension.height - dimension.height / 4, dimension.width / 8, dimension.height / 16);
        nextButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, Math.round(dimension.height / 32.0f)));

        if (imageLabel != null) {
            imageLabel.setBounds(dimension.width /2+200, dimension.height /3, 612, 612);
        }

       
    }
    private void nextButtonActionListener(ActionEvent e) {

        
        new TechnologyQuizGUI().setVisible(true);
        setVisible(false);
        
        }

    
}


