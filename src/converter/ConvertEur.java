package converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

class ConvertEur extends JFrame {

    private static DecimalFormat df = new DecimalFormat("0.00");
    private JTextField EUR;
    private JTextField textFieldEU;
    private JButton convertPLtoEU;

    ConvertEur() {
        super ("Currency");
        setLayout (new FlowLayout ());
        EUR = new JTextField (10);
        add (EUR);
        JLabel labelCurr = new JLabel("PLN:  ", SwingConstants.RIGHT);
        labelCurr.setToolTipText("This is a current exchange ratio");
        add (labelCurr);
        JLabel labelEur = new JLabel("Eur:  ", SwingConstants.RIGHT);
        add(labelEur);
        textFieldEU = new JTextField (10);
        add (textFieldEU);
        convertPLtoEU = new JButton ("CONVERT");
        add (convertPLtoEU);
        JPanel panel = new JPanel(new GridLayout(2, 2, 12, 6));
        panel.add(labelCurr);
        panel.add(textFieldEU);
        panel.add(labelEur);
        panel.add(EUR);
        add(panel, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(convertPLtoEU);
        add(buttonPanel, BorderLayout.SOUTH);
        convertPLtoEU.addActionListener(new PLNListener());
    }

    private class PLNListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == convertPLtoEU){
                double conPLNtoEUR = (double) (((((Double.parseDouble(textFieldEU.getText())))) / 4.2033));
                EUR.setText(df.format(conPLNtoEUR) + " EUR");
                textFieldEU.requestFocus();
                textFieldEU.selectAll();
            }
        }
    }
}