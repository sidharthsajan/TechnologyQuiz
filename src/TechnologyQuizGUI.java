import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TechnologyQuizGUI extends JFrame {
    private JLabel questionLabel;
    private JRadioButton[] choices;
    private JButton submitButton;
    private int[] answers = {0, 2, 1, 2, 2, 0, 0, 1, 1, 0};
    private int score = 0;
    private int currentQuestion = 0;

    private String[] questions = {
            "Q1. What percentage of all electricity and energy used in the world is estimated to come from the energy used to make tech?",
            "Q2. What are some negative impacts of mining for resources on the environment?",
            "Q3. What happens to a significant amount of electronic waste (e-waste) each year?",
            "Q4. How does technology usage contribute to poor posture?",
            "Q5. What are some negative effects of frequent screen use on human health?",
            "Q6. What is one positive impact of renewable energy technologies?",
            "Q7. How does technology contribute to waste reduction?",
            "Q8. What is one positive impact of electric vehicles on the environment?",
            "Q9. How have technological advancements improved human health?",
            "Q10. What is one way to reduce negative impacts of technology on the environment?"

    };

    private String[][] choiceOptions = {
            {"A. 1%", "B. 5%", "C. 10%"},
            {"A. Reduced availability of natural resources and metals", "B. Increased energy consumption and carbon emissions", "C. All of the above"},
            {"A. It gets recycled properly", "B. It ends up in landfills and dumps", "C. It is used to create new technology"},
            {"A. It encourages regular exercise", "B. It promotes ergonomic design", "C. It requires users to sit in one position for extended periods"},
            {"A. Neck or upper back pain", "B. Eye strain", "C. All of the above"},
            {"A. Reduced dependence on fossil fuels","B. Increased carbon emissions","C. Higher energy costs" },
            {"A. By creating more online documents and papers","B. By increasing paper usage","C. By encouraging excessive printing" },
            {"A. Increased carbon emissions","B Reduced dependence on fossil fuels","C. Higher energy consumption" },
            {"A.By Deacreasing access to medical treatments","B. By Increasing access to medical treatments","C. By promoting unhealthy lifestyle choices" },
            {"A. Proper disposal of e-waste","B. Increased energy consumption","C. Excessive technology usage" }
    };

    public TechnologyQuizGUI() {
        setTitle("Technology Quiz");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setLayout(new BorderLayout());

        questionLabel = new JLabel(questions[currentQuestion]);
        questionLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        add(questionLabel, BorderLayout.NORTH);

        JPanel choicesPanel = new JPanel();
        choicesPanel.setLayout(new GridLayout(0, 1));

        ButtonGroup buttonGroup = new ButtonGroup();
        choices = new JRadioButton[choiceOptions[currentQuestion].length];
        for (int i = 0; i < choices.length; i++) {
            choices[i] = new JRadioButton(choiceOptions[currentQuestion][i]);
            buttonGroup.add(choices[i]);
            choicesPanel.add(choices[i]);
        }
        add(choicesPanel, BorderLayout.CENTER);

        submitButton = new JButton("Submit");
        add(submitButton, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userAnswer = -1;
                for (int i = 0; i < choices.length; i++) {
                    if (choices[i].isSelected()) {
                        userAnswer = i;
                        break;
                    }
                }
                if (userAnswer == answers[currentQuestion]) {
                    score++;
                    JOptionPane.showMessageDialog(TechnologyQuizGUI.this, "Correct!");
                } else {
                    JOptionPane.showMessageDialog(TechnologyQuizGUI.this, "Incorrect!");
                }

                currentQuestion++;
                if (currentQuestion < questions.length) {
                    questionLabel.setText(questions[currentQuestion]);
                    for (JRadioButton choice : choices) {
                        choice.setText(choiceOptions[currentQuestion][choicesPanel.getComponentZOrder(choice)]);
                        choice.setSelected(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(TechnologyQuizGUI.this, "Quiz Completed!\nYour score: " + score + "/" + questions.length);
                    System.exit(0);
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
}
