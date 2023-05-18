import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class Info3 extends JFrame {

    private JButton nextButton;
    private JLabel titleLabel;
    private JTextArea textArea;
    private JLabel imageLabel;

    private static final String text1 = "\n   1. Renewable energy - The development of renewable energy technologies such as solar and wind power has reduced our dependence on fossil fuels, which contributes to climate change.\n\n   2. Recycling - Technology has made it easier to recycle waste, reducing the amount of waste that ends up in landfills. Examples of this include reducing the amount of paper used by creating online documents and papers for people to read, write, and use (just like this one!).\n\n   3.Electric vehicles - Electric vehicles do not produce carbon emissions. This has a very positive impact on the environment because this lowers the amount of carbon emissions produced. According to Nissan Electric will become cheaper than petrol-run cars by 2024 and it's a way forward to a “greener society”.";

    public Info3() {

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

        titleLabel.setText("Positive Impacts on Environment:");
        textArea.setText(text1);

        nextButton = new JButton();
        nextButton.setText("Next");
        nextButton.setMnemonic(KeyEvent.VK_N);
        nextButton.addActionListener(this::nextButtonActionListener);

        add(titleLabel);
        add(textArea);
        add(nextButton);

        String imagePath = "src/images/PostiveEnviroment.png";
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
            imageLabel.setBounds(dimension.width /2+70, dimension.height /3, 800, 526);
        }
    }

    private void nextButtonActionListener(ActionEvent e) {
        new Info4().setVisible(true);
        setVisible(false);
    }
}
