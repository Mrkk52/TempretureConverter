
package celciustofahrenheit;

/**
 *
 * @author Kinkar
 */
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;



public class CelciustoFahrenheit extends JFrame{
    JTextField degreeInput;
    JLabel title,select,number,resultLabel;
    JComboBox<String> box;
    JButton button,cancle,clear;
    Border border;
    
    public void My(){
        getContentPane().setBackground(new Color(255, 255, 240));
        setTitle("Tempature Calculator");
        setLayout(null);
        setSize(600,550);
        setLocation(150,200);
        setVisible(true);
        
        //===== Tittle =========================================================
        
        title = new JLabel("Temperature Calculator");
        title.setBounds(150,20,300,40);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        add(title);
        
        //========= Select any one==============================================
        
        select = new JLabel("Select one to Calculate : ");
        select.setBounds(65,100,200,30);
        select.setFont(new Font("Arial", Font.BOLD, 15));
        select.setForeground(Color.blue);
        select.setBackground(Color.white);
        add(select);
         
        box = new JComboBox<>(new String[] {"Celcius","Fahrenheit"});
        box.setBounds(50,145,200,30);
        box.setFont(new Font("Arial", Font.BOLD, 15));
        add(box);
        
        //============Enter number==============================================
        
        number = new JLabel();
        number.setBounds(310,100,240,30);
        number.setFont(new Font("Arial", Font.BOLD, 15));
        number.setForeground(Color.blue);
        number.setBackground(Color.white);
        add(number);
        
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number.setText("Enter "+box.getSelectedItem()+" Degree :");
            }
        });
        
        border = BorderFactory.createLineBorder(Color.gray,2);
        
        degreeInput = new JTextField();
        degreeInput.setBounds(300, 145, 200,30);
        degreeInput.setBorder(border);
        degreeInput.setOpaque(false);
        degreeInput.setFont(new Font("Arial", Font.BOLD, 15));        
        add(degreeInput);
        
        //====================Button============================================
        
        button = new JButton("Convert");
        button.setBounds(70,300,100,30);
        button.setBackground(Color.black);
        button.setBorder(border);
        button.setFont(new Font("Sans-sarif", Font.BOLD, 17));                
        button.setForeground(Color.white);
        add(button);
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                TempretureConveter();
            }
        });
        
        //====================Cancel============================================
        
        cancle = new JButton("Cancel");
        cancle.setBounds(370,300,100,30);
        cancle.setBackground(Color.black);
        cancle.setFont(new Font("Sans-sarif", Font.BOLD, 17));        
        cancle.setBorder(border);
        cancle.setForeground(Color.white);
        add(cancle);
        
        cancle.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
            }
        });
        
        //====================Clear============================================
        
        clear = new JButton("Clear");
        clear.setBounds(220,300,100,30);
        clear.setBackground(Color.black);
        clear.setBorder(border);
        clear.setFont(new Font("Sans-sarif", Font.BOLD, 17));        
        clear.setForeground(Color.white);
        add(clear);
        
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                degreeInput.setText("");
                box.setSelectedItem("Celcius");
                resultLabel.setText("");
            }
        });
        
        
        //===================Result=============================================
        
        resultLabel = new JLabel();
        resultLabel.setBounds(190,220,400,30);
        resultLabel.setBackground(Color.cyan);
        resultLabel.setForeground(Color.magenta);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 25));        
        add(resultLabel);
        
    }
    private void TempretureConveter(){
        try{
            double input = Double.parseDouble(degreeInput.getText());
            double result;
            if(box.getSelectedItem().equals("Celcius")){
                result = ((input -32 ) * (5.0/9.0));
                resultLabel.setText(String.format("%.2f\u00B0 Fahrenheit ",result));
            }else{
                result = ((input * (5.0/9.0))+32);
                resultLabel.setText(String.format("%.2f\u00B0 Celcius ",result));
            }
        }catch(NumberFormatException e){
            resultLabel.setText("Invalid Input.");
        }
    }
    
    public static void main(String[] mrkk) {
        CelciustoFahrenheit o = new CelciustoFahrenheit();
        o.My();
    }
    
}