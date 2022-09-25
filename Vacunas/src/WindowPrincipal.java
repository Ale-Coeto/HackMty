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
    
    private JFrame frmPrincipal; 
    private JPanel panelPrincipal, panelDiseño1, panelCombo;
	private JLabel lblTitulo, lblNombreHospital, lblSolicitar, lblVacunas, lblEstatus, lblCantVacunas;
	private JComboBox<String> cbNombreHospital;
	private JTextField tfVacunas;
	private JButton btnSolicitar;
	WindowResultado frmResultado;
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
				
				cbNombreHospital.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						String nombre = cbNombreHospital.getSelectedItem().toString();
						Hospital temp = buscarHospital(nombre);
						lblVacunas.setText("Vacunas: " + temp.getVacunas());
						lblEstatus.setText("Estatus: " + temp.getEstatus());


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
		tfVacunas.setBounds(300, 550, 150, 50);
		tfVacunas.setFont(new Font("Helvetica", Font.PLAIN, 25));
		tfVacunas.setEditable(true);

		lblVacunas = new JLabel("");
		panelPrincipal.add(lblVacunas);
		lblVacunas.setForeground(Color.black);
		lblVacunas.setBounds(250, 300, 200, 50);
		lblVacunas.setFont(new Font("Helvetica", Font.PLAIN, 25));

		lblCantVacunas = new JLabel("vacunas");
		panelPrincipal.add(lblCantVacunas);
		lblCantVacunas.setForeground(Color.black);
		lblCantVacunas.setBounds(470, 550, 200, 50);
		lblCantVacunas.setFont(new Font("Helvetica", Font.PLAIN, 25));

		lblEstatus = new JLabel("");
		panelPrincipal.add(lblEstatus);
		lblEstatus.setForeground(Color.black);
		lblEstatus.setBounds(600, 300, 300, 50);
		lblEstatus.setFont(new Font("Helvetica", Font.PLAIN, 25));

		btnSolicitar = new JButton("Solicitar");
		btnSolicitar.setBounds(600, 530, 150, 70);
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

		
    }

	public static void crearHospitales(){
		listaHospitales = new ArrayList<Hospital>();
		Hospital h1 = new Hospital("Cruz roja", 200, 120, "Monterrey", 10, 230);
		listaHospitales.add(h1);
			
		Hospital h2 = new Hospital("Coet", 60, 10, "Saltillo", 100, 5.2);
		listaHospitales.add(h2);

		Hospital h3 = new Hospital("DR Andrik", 340, 300, "Monterrey", 10.4, 15);
		listaHospitales.add(h3);

		Hospital h4 = new Hospital("San José", 10, 100, "Saltillo", 0, 100);
		listaHospitales.add(h4);

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

	
}

