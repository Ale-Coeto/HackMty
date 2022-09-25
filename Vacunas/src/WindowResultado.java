import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;




public class WindowResultado extends JFrame{

    private static JFrame frmPrincipal; 
    private static JPanel panelPrincipal;
    private static JPanel panelMapa;
    private static JLabel lblTitulo, lblSolicitarA, lblMapa;
    private static JTextArea txtDonadores;
    private static ImageIcon mapa;



     WindowResultado(ArrayList<Hospital> donadores, Hospital solicitante){
        this.setBounds(0,0,650,800);
		this.setLayout(null);
		this.setVisible(true);
		this.setTitle("Donadores");
        this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.white);

        // frmPrincipal = new JFrame();
		// frmPrincipal.setSize(600, 500);
		// frmPrincipal.setResizable(false);
		// frmPrincipal.setTitle("Resultado");
		// frmPrincipal.setForeground(Color.blue);
		// frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        panelPrincipal = new JPanel();
        panelPrincipal.setBounds(0, 0, 650, 800);
		panelPrincipal.setBackground(Color.blue);
        panelPrincipal.setLayout(null);
        panelPrincipal.setVisible(true);
		this.add(panelPrincipal);

        lblTitulo = new JLabel("Donadores:");
        panelPrincipal.add(lblTitulo);
        lblTitulo.setForeground(Color.white);
        lblTitulo.setBounds(100, 40, 200, 50);
        lblTitulo.setFont(new Font("Helvetica", Font.PLAIN, 30));

        lblSolicitarA = new JLabel("Solicitar a: ");
        panelPrincipal.add(lblTitulo);
        lblSolicitarA.setBounds(100, 100, 80, 50);
        lblTitulo.setFont(new Font("Helvetica", Font.PLAIN, 30));

        txtDonadores = new JTextArea();
        txtDonadores.setBounds(100, 100, 280, 90);
        
       

        String txt = "Hospital \t Vacunas \t Distancia \n";
        for(int i = 0; i < donadores.size(); i++){
            txt += donadores.get(i).getNombre() + "\t";
            System.out.println("donadores " + donadores.get(i).getNombre() + " "+donadores.get(i).getX());
            System.out.println(solicitante.getNombre() + " s " + solicitante.getX());

            double distancia = Hospital.getDistancia(solicitante, donadores.get(i));

            distancia = Math.round(distancia*100.0)/100.0;
            System.out.println(Double.toString(distancia));
            txt += (Integer.toString(donadores.get(i).getDonacion())+ "\t");
            txt += (Double.toString(distancia) + "\n");


        }
        txtDonadores.setText(txt);
        panelPrincipal.add(txtDonadores);
    
        panelMapa = new JPanel();
        panelMapa.setBounds(100, 250, 300,200);
		panelMapa.setBackground(Color.red);
        panelMapa.setLayout(null);
		panelPrincipal.add(panelMapa);

         mapa = new ImageIcon(WindowResultado.class.getResource("/HackMty/Vacunas/mapa.png"));
		
		lblMapa = new JLabel("cooo");
		lblMapa.setBounds(0, 0, 300,200);
		lblMapa.setIcon(mapa);
        lblMapa.setFont(new Font("Helvetica", Font.PLAIN, 30));
		panelMapa.add(lblMapa);

     }
    
}
