package img;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPage extends JFrame 
{
    private JLabel totalBillLabel;
    private JButton payButton;
    private double totalBill;

    public PaymentPage(double totalBill) 
    {
        this.totalBill = totalBill;
        setTitle("Payment Page");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        totalBillLabel = new JLabel("Total Bill: $" + String.format("%.2f", totalBill));
        payButton = new JButton("Pay Now");
        payButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                processPayment();
            }
        });

        add(totalBillLabel);
        add(payButton);
    }

	private void processPayment() 
	{
        JOptionPane.showMessageDialog(this, "Payment of $" + String.format("%.2f", totalBill) + " has been processed successfully.");
        
        System.exit(0);
    }
    public static void main(String[] args) 
    {
        double totalBill = 50.00; // This value can be dynamically set from your system
        SwingUtilities.invokeLater(() -> {
            PaymentPage paymentPage = new PaymentPage(totalBill);
            paymentPage.setVisible(true);
        });
    }
}
