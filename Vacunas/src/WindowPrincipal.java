import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


//import org.w3c.dom.css.RGBColor;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;



public class WindowPrincipal{
    
    private static JFrame frmPrincipal; 
    private JPanel panelPrincipal, panelDiseño1, panelCombo, panelDVacunas, panelDSolicitudes, panelDEstatus, panelDVacunas2, 
	panelDSolicitudes2, panelDEstatus2;
	private JLabel lblLimite, lblTitulo, lblNombreHospital, lblSolicitar, lblVacunas, lblSolicitudes, lblEstatus, lblCantVacunas,
	lblVacunas2, lblSolicitudes2, lblEstatus2;
	private JComboBox<String> cbNombreHospital;
	private JTextField tfVacunas;
	private JButton btnSolicitar;
	static WindowResultado frmResultado;
	//private Font = new Font();

	public static ArrayList<Hospital> listaHospitales;
	
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowPrincipal window = new WindowPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WindowPrincipal() {
        frmPrincipal = new JFrame();
		frmPrincipal.setSize(1000, 700);
		frmPrincipal.setResizable(false);
		frmPrincipal.setTitle("Vacunas");
		frmPrincipal.setForeground(Color.black);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		crearHospitales();      

		primerPanel();
	}

    public void primerPanel(){
        panelPrincipal = new JPanel();
        panelPrincipal.setBounds(0, 0, 1000, 700);
		panelPrincipal.setBackground(Color.white);
        panelPrincipal.setLayout(null);
		frmPrincipal.getContentPane().add(panelPrincipal);

		lblTitulo = new JLabel("Distribución de Vacunas");
		panelPrincipal.add(lblTitulo);
        lblTitulo.setForeground(new Color(0x2A2A2A));
        lblTitulo.setBounds(100, 50, 1000, 50);
		lblTitulo.setBackground(Color.gray);
        lblTitulo.setFont(new Font("Sans-serif", Font.BOLD, 30));

		panelDiseño1 = new JPanel();
		panelDiseño1.setBounds(100, 120, 800, 3);
		panelDiseño1.setBackground(new Color(0xCBCACA));
        panelDiseño1.setLayout(null);
		panelPrincipal.add(panelDiseño1);

        lblNombreHospital = new JLabel("Hospital:");
        panelPrincipal.add(lblNombreHospital);
        lblNombreHospital.setForeground(Color.black);
        lblNombreHospital.setBounds(100, 200, 200, 50);
        lblNombreHospital.setFont(new Font("Helvetica", Font.PLAIN, 30));

		panelCombo = new JPanel();
		panelCombo.setBounds(250, 200, 300, 60);
		panelCombo.setBackground(Color.white);
		panelCombo.setLayout(new BorderLayout());
		panelPrincipal.add(panelCombo);

		//crearHospitales();
		cbNombreHospital = new JComboBox<String>();
			if(listaHospitales.size() < 1){
				JOptionPane.showMessageDialog(frmPrincipal, "No hay hospitales disponibles.");
				System.out.println("Nel");
			} else{
				System.out.println("Siu");
				cbNombreHospital.addItem("");
				for(int i = 0 ; i < listaHospitales.size(); i++){
					cbNombreHospital.addItem(listaHospitales.get(i).getNombre());
					
				}
				cbNombreHospital.setVisible(true);
				cbNombreHospital.setSelectedIndex(0);
				cbNombreHospital.setBounds(250, 200, 300, 60);
				cbNombreHospital.setFont(new Font("Helvetica", Font.PLAIN, 15));
				panelCombo.add(cbNombreHospital);
				
				lblLimite = new JLabel("");
			lblLimite.setForeground(Color.black);
			lblLimite.setBounds(100, 450, 500, 50);
			lblLimite.setFont(new Font("Helvetica", Font.PLAIN, 20));
			panelPrincipal.add(lblLimite);

		

				cbNombreHospital.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						String nombre = cbNombreHospital.getSelectedItem().toString();
						Hospital temp = buscarHospital(nombre);
						lblVacunas2.setText("" + temp.getVacunas());
						lblEstatus2.setText("" + temp.getEstatus());
						lblSolicitudes2.setText("" + temp.getSolicitudes());

						if(temp.getSolicitudes() <= temp.getVacunas()){
							lblLimite.setText("Hay suficientes vacunas para cumplir con las solicitudes");
							tfVacunas.setEditable(false);
						} else{
							lblLimite.setText("");
							tfVacunas.setEditable(true);
						}
					}
				});
				
			}
		

		lblSolicitar = new JLabel("Solicitar:");
		panelPrincipal.add(lblSolicitar);
		lblSolicitar.setForeground(Color.black);
		lblSolicitar.setBounds(100, 550, 200, 50);
		lblSolicitar.setFont(new Font("Helvetica", Font.PLAIN, 30));

		tfVacunas = new JTextField();
		panelPrincipal.add(tfVacunas);
		tfVacunas.setBounds(220, 550, 150, 50);
		tfVacunas.setFont(new Font("Helvetica", Font.PLAIN, 25));
		tfVacunas.setEditable(true);

		lblVacunas = new JLabel("Vacunas");
		panelPrincipal.add(lblVacunas);
		lblVacunas.setForeground(Color.white);
		lblVacunas.setBounds(160, 307, 200, 50);
		lblVacunas.setFont(new Font("Helvetica", Font.PLAIN, 20));

		lblVacunas2 = new JLabel("");
		panelPrincipal.add(lblVacunas2);
		lblVacunas2.setForeground(Color.black);
		lblVacunas2.setBounds(180, 355, 200, 50);
		lblVacunas2.setFont(new Font("Helvetica", Font.PLAIN, 20));

		lblSolicitudes = new JLabel("Solicitudes");
		panelPrincipal.add(lblSolicitudes);
		lblSolicitudes.setForeground(Color.white);
		lblSolicitudes.setBounds(450, 307, 200, 50);
		lblSolicitudes.setFont(new Font("Helvetica", Font.PLAIN, 20));

		lblSolicitudes2 = new JLabel("");
		panelPrincipal.add(lblSolicitudes2);
		lblSolicitudes2.setForeground(Color.black);
		lblSolicitudes2.setBounds(480, 355, 200, 50);
		lblSolicitudes2.setFont(new Font("Helvetica", Font.PLAIN, 20));

		lblEstatus = new JLabel("Estatus");
		panelPrincipal.add(lblEstatus);
		lblEstatus.setForeground(Color.white);
		lblEstatus.setBounds(765, 307, 300, 50);
		lblEstatus.setFont(new Font("Helvetica", Font.PLAIN, 20));

		lblEstatus2 = new JLabel("");
		panelPrincipal.add(lblEstatus2);
		lblEstatus2.setForeground(Color.black);
		lblEstatus2.setBounds(760, 355, 300, 50);
		lblEstatus2.setFont(new Font("Helvetica", Font.PLAIN, 20));

		lblCantVacunas = new JLabel("vacunas");
		panelPrincipal.add(lblCantVacunas);
		lblCantVacunas.setForeground(Color.black);
		lblCantVacunas.setBounds(380, 550, 200, 50);
		lblCantVacunas.setFont(new Font("Helvetica", Font.PLAIN, 20));

		btnSolicitar = new JButton("Solicitar");
		btnSolicitar.setBounds(500, 545, 150, 60);
		btnSolicitar.setFont(new Font("Helvetica", Font.PLAIN, 20));
		btnSolicitar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String nombre = cbNombreHospital.getSelectedItem().toString();
						Hospital temp = buscarHospital(nombre);
						temp.setSolicitudes(Integer.parseInt(tfVacunas.getText()));
				System.out.println("vacunas: " + tfVacunas.getText());

				ArrayList<Hospital> lista = Hospital.Solicitar(temp);

				frmResultado = new WindowResultado(lista, temp);

			}
		});
		btnSolicitar.setActionCommand("newProduct");
		panelPrincipal.add(btnSolicitar);

		//Más diseño
		panelDVacunas = new JPanel();
		panelDVacunas.setBounds(100, 350, 200, 60);
		panelDVacunas.setBackground(new Color(0xCBCACA));
        panelDVacunas.setLayout(null);
		panelPrincipal.add(panelDVacunas);

		panelDSolicitudes = new JPanel();
		panelDSolicitudes.setBounds(400, 350, 200, 60);
		panelDSolicitudes.setBackground(new Color(0xCBCACA));
        panelDSolicitudes.setLayout(null);
		panelPrincipal.add(panelDSolicitudes);

		panelDEstatus = new JPanel();
		panelDEstatus.setBounds(700, 350, 200, 60);
		panelDEstatus.setBackground(new Color(0xCBCACA));
        panelDEstatus.setLayout(null);
		panelPrincipal.add(panelDEstatus);

		panelDVacunas2 = new JPanel();
		panelDVacunas2.setBounds(100, 310, 200, 50);
		panelDVacunas2.setBackground(new Color(0x548FFD));
        panelDVacunas2.setLayout(null);
		panelPrincipal.add(panelDVacunas2);

		panelDSolicitudes2 = new JPanel();
		panelDSolicitudes2.setBounds(400, 310, 200, 50);
		panelDSolicitudes2.setBackground(new Color(0x548FFD));
        panelDSolicitudes2.setLayout(null);
		panelPrincipal.add(panelDSolicitudes2);

		panelDEstatus2 = new JPanel();
		panelDEstatus2.setBounds(700, 310, 200, 50);
		panelDEstatus2.setBackground(new Color(0x548FFD));
        panelDEstatus2.setLayout(null);
		panelPrincipal.add(panelDEstatus2);
    }

	public static void crearHospitales(){
		listaHospitales = new ArrayList<Hospital>();
		Hospital h1 = new Hospital("San Nicolás", 200, 120, "Monterrey", 10, 230);
		listaHospitales.add(h1);
			
		Hospital h2 = new Hospital("M. Alemán", 60, 10, "Saltillo", 100, 5.2);
		listaHospitales.add(h2);

		Hospital h3 = new Hospital("Centro salud", 340, 300, "Monterrey", 10.4, 15);
		listaHospitales.add(h3);

		Hospital h4 = new Hospital("Cruz Roja", 100, 110, "Saltillo", 260, 150);
		listaHospitales.add(h4);

		Hospital h5 = new Hospital("Doctors", 400, 280, "CD Mx", 90, 50);
		listaHospitales.add(h5);

		Hospital h6 = new Hospital("San Gerardo", 400, 280, "CD Mx", 170, 30);
		listaHospitales.add(h6);

		Hospital h7 = new Hospital("H Sur", 100, 280, "CD Mx", 270, 380);
		listaHospitales.add(h7);

		Hospital h8 = new Hospital("Clínica", 290, 300, "CD Mx", 270, 380);
		listaHospitales.add(h8);

		Hospital h9 = new Hospital("Felipe C", 400, 280, "CD Mx", 170, 280);
		listaHospitales.add(h9);

		Hospital h10 = new Hospital("Tec", 130, 20, "CD Mx", 70, 380);
		listaHospitales.add(h10);

		//ArrayList<Hospital> lista = Hospital.Solicitar(h3);
		//System.out.println("Lista: " + lista.get(0).getNombre());
		//System.out.println("Lista: " + lista.get(1).getNombre());

		
	}

	public static Hospital buscarHospital(String nombre){
		for(int i = 0; i < listaHospitales.size(); i++) {
			if(listaHospitales.get(i).getNombre().equals(nombre)) {
				Hospital temp = listaHospitales.get(i);
				return temp;
			}
		}
		return null;
	}

	public static void alert(){
		JOptionPane.showMessageDialog(frmResultado, "No hay suficientes vacunas en los hospitales de la zona.");
	}

	
}

