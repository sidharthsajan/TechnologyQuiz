import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class Info2 extends JFrame {

    private JButton nextButton;
    private JLabel titleLabel;
    private JTextArea textArea;
    private JLabel imageLabel;
    


    private static final String text1 = "\n   1. Poor Posture - Most technology promotes poor posture. Examples include smartphones, tablets, computers, and more. A 5-year study in the journal Applied Ergonomics found a correlation between using technology and neck or upper back pain in young adults.\n\n   2. Eye strain - Frequent use of screens such as computers and smartphones can cause eye strain, which can lead to vision problems.\n\n   3. Mental health - Overuse of social media and other technologies has been linked to mental health problems such as anxiety and depression.    ";
    
    public Info2() {
        
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

        titleLabel.setText("Negative Impacts on Human Health:");
        textArea.setText(text1);

        
        nextButton = new JButton();
        nextButton.setText("Next");
        nextButton.setMnemonic(KeyEvent.VK_N);
        nextButton.addActionListener(this::nextButtonActionListener);

        
        add(titleLabel);
        add(textArea);
        add(nextButton);
        String imagePath = "src/images/NegativeHealth.jpeg";
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

        
        nextButton.setBounds((dimension.width - dimension.width / 2) / 2 , dimension.height - dimension.height / 4, dimension.width / 16, dimension.height / 16);
        nextButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, Math.round(dimension.height / 32.0f)));

        if (imageLabel != null) {
            imageLabel.setBounds(dimension.width /2+70, dimension.height /3, 940, 530);
        }

        
    }
    private void nextButtonActionListener(ActionEvent e) {

        
        new Info3().setVisible(true);
        setVisible(false);
        
        }

    
}


