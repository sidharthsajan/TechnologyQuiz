import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class Info4 extends JFrame {

    private JButton nextButton;
    private JLabel titleLabel;
    private JTextArea textArea;
    private JLabel imageLabel;

    private static final String text1 = "\n   1. Improved medical treatments -  Technological advancements in medical treatments have led to better health outcomes and increased life expectancy. Examples Include X Rays, MRI scanners and daily research equipment.\n\n   2. Increased access to information - Technology has made it easier to access information about health and wellness, enabling people to make better-informed decisions. This also allows for better research for cures to different diseases and problems.\n\n   3. Medical Communication - The use of technology has enabled healthcare providers to deliver medical care remotely, increasing access to healthcare for people in remote areas or those with mobility issues. It also allows patients to reach out to a doctor as fast as possible in a time of need.";
    
    public Info4() {
        
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

        titleLabel.setText("Positive Impacts on Human Health:");
        textArea.setText(text1);

        
        nextButton = new JButton();
        nextButton.setText("Next");
        nextButton.setMnemonic(KeyEvent.VK_N);
        nextButton.addActionListener(this::nextButtonActionListener);

        
        add(titleLabel);
        add(textArea);
        add(nextButton);

        String imagePath = "src/images/PositiveHealth.jpg";
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
            imageLabel.setBounds(dimension.width /2+200, dimension.height /3, 500, 335);
        }

       
    }
    private void nextButtonActionListener(ActionEvent e) {

        
        new Info5().setVisible(true);
        setVisible(false);
        
        }

    
}


