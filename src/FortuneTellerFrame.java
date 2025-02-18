import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

// FortuneTellerFrame class that extends JFrame
public class FortuneTellerFrame extends JFrame {
    private final JTextArea fortuneTextArea;
    private final ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set JFrame size to ¾ of the screen width and center it
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) (screenSize.width * 0.75), (int) (screenSize.height * 0.75));
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Top Panel with JLabel and ImageIcon
        JPanel topPanel = new JPanel();
        ImageIcon icon = new ImageIcon("fortune_teller.png"); // Ensure the image is in the project folder
        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        // Middle Panel with JTextArea inside JScrollPane
        fortuneTextArea = new JTextArea(10, 50);
        fortuneTextArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel with Buttons
        JPanel bottomPanel = new JPanel();
        JButton readFortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        readFortuneButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        quitButton.setFont(new Font("SansSerif", Font.BOLD, 20));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Initialize fortunes
        fortunes = new ArrayList<>();
        loadFortunes();

        // Add Action Listeners using Java 8 Lambdas
        readFortuneButton.addActionListener(e -> displayNewFortune());
        quitButton.addActionListener(e -> System.exit(0));
    }

    private void loadFortunes() {
        fortunes.add("You will have a great day!");
        fortunes.add("A surprise is waiting for you.");
        fortunes.add("Beware of unexpected challenges.");
        fortunes.add("Happiness is just around the corner.");
        fortunes.add("You will meet someone special soon.");
        fortunes.add("Something lost will soon be found.");
        fortunes.add("Good news is on its way!");
        fortunes.add("Adventure awaits you this weekend.");
        fortunes.add("An old friend will contact you soon.");
        fortunes.add("Your hard work will pay off.");
        fortunes.add("A fun opportunity is coming.");
        fortunes.add("Success is in your near future.");
    }

    private void displayNewFortune() {
        Random rand = new Random();
        int newIndex;
        do {
            newIndex = rand.nextInt(fortunes.size());
        } while (newIndex == lastFortuneIndex);
        lastFortuneIndex = newIndex;

        fortuneTextArea.append(fortunes.get(newIndex) + "\n");
    }
}

// FortuneTellerViewer main class
class FortuneTellerViewer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setVisible(true);
        });
    }
}