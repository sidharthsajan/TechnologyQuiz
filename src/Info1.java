import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.io.File;


public class Info1 extends JFrame {

    private JButton nextButton;
    private JLabel titleLabel;
    private JTextArea textArea;
    private JLabel imageLabel;

    private static final String text1 = "\n   1. Mining for Resources - To make different technology it takes a great amount of natural resources and metals from our earth to make them. These resources are finite so the over-mining of them will reduce the amount of natural resources and metals we have. Mining resources also takes huge amounts of energy and releases huge amounts of carbon. It also causes deforestation, water pollution which ruins natural habitats in our environment.\n\n   2. Energy Use and Carbon Footprint - Manufacturers also take huge amounts of energy to turn materials into the technology we use. 198 terawatts(1 trillion watts) per hour was the estimated electricity demand in 2018 from just the energy used to make tech. This was estimated to be 1% of all electricity and energy used in the world at the time.\n\n   3.Electronic Waste - Approximately $6.25 billion in electronic waste (e-waste) gets wasted every year. A very high amount of this ends up in landfills and dumps where they emit carbon emissions and leak chemicals into the waterways and groundwater which causes environmental pollution and harms wildlife.";
    
    public Info1() {
        
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

        titleLabel.setText("Negative Impacts on Environment:");
        textArea.setText(text1);

        
        nextButton = new JButton();
        nextButton.setText("Next");
        nextButton.setMnemonic(KeyEvent.VK_N);
        nextButton.addActionListener(this::nextButtonActionListener);

        
        add(titleLabel);
        add(textArea);
        add(nextButton);

        String imagePath = "src/images/NegativeEnviroment.png";
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
            imageLabel.setBounds(dimension.width /2+70, dimension.height /3, 800, 529);
        }

        
    }
    private void nextButtonActionListener(ActionEvent e) {

        
        new Info2().setVisible(true);
        setVisible(false);
        
        }

    
}


