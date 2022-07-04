import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SphereForm {
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JTextField textField1;
    private JTextField textField2;

    private JPanel mainPanel;
    private SphereCanvas SphereCanvas;

    int Diameter(int d) {
        spinner1.setValue(1);
        d = (int)spinner1.getValue();

        return d;
    }
    int maxHeight(int k) {
        spinner2.setValue(100);
        k = (int)spinner2.getValue();

        return k;
    }
    int minHeight(int k) {
        spinner2.setValue(0);
        k = (int)spinner2.getValue();

        return k;
    }

    void DataPatch() {
        int d = (int)spinner1.getValue(), k = (int)spinner2.getValue();
        double volume, height;

        if(d <= 0)
            d = Diameter(d);
        if(k > 100)
            k = maxHeight(k);
        if(k < 0)
            k = minHeight(k);

        SphereCanvas.setDiameter(d);
        SphereCanvas.setHeight(k);

        volume = (Math.PI*d*d*d)/6.0f;
        height = (d/2.0f) + (k/100.0f)*(d/2.0f) - ((100 - k)/100.0f)*(d/2.0f);

        textField1.setText(String.format("%.2f", volume));
        textField2.setText(String.format("%.2f", height));
    }

    public SphereForm() {
        spinner1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                DataPatch();
            }
        } );
        spinner1.setValue(300);

        spinner2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                DataPatch();
            }
        } );
        spinner2.setValue(100);
    }

    public static void main (String[ ]  args) {
        JFrame frame = new JFrame("Сфера с жидкостью");
        frame.setContentPane(new SphereForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}