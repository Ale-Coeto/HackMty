import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;


import java.awt.Color;


public class WindowResultado {

    private JFrame frmPrincipal; 
    private JPanel panelPrincipal, panelMapa;
    private JLabel lblTitulo, lblSolicitarA;


    public WindowResultado(){
        frmPrincipal = new JFrame();
		frmPrincipal.setSize(600, 500);
		frmPrincipal.setResizable(false);
		frmPrincipal.setTitle("Resultado");
		frmPrincipal.setForeground(Color.blue);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void primerPanel(){
        panelPrincipal = new JPanel();
        panelPrincipal.setBounds(20, 200, 180, 130);
		panelPrincipal.setBackground(Color.black);
        panelPrincipal.setLayout(null);
		frmPrincipal.getContentPane().add(panelPrincipal);

        lblTitulo = new JLabel("Donadores:");
        panelPrincipal.add(lblTitulo);
        lblTitulo.setForeground(Color.white);
        lblTitulo.setBounds(100, 200, 200, 50);
        lblTitulo.setFont(new Font("Helvetica", Font.PLAIN, 30));

        lblSolicitarA = new JLabel("Solicitar a: ");
        panelPrincipal.add(lblTitulo);
        lblSolicitarA.setBounds(100, 300, 80, 50);
        lblTitulo.setFont(new Font("Helvetica", Font.PLAIN, 30));

        

    }

    public void PanelMapa(){
        panelMapa = new JPanel();
        panelPrincipal.setBounds(403, 380, 80, 30);
		panelPrincipal.setBackground(Color.black);
        panelPrincipal.setLayout(null);
		frmPrincipal.getContentPane().add(panelPrincipal);


    }
    
}
