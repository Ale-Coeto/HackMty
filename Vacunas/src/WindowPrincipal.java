import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;


public class WindowPrincipal{
    
    private JFrame frmPrincipal; 
    private JPanel panelPrincipal;
	private JLabel lblNombreHospital, lblSolicitar, lblVacunas, lblEstatus, lblCantVacunas;
	private JComboBox<String> cbNombreHospital;
	private JTextField tfVacunas;
	private JButton btnSolicitar;

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
		panelPrincipal.setBackground(Color.black);
        panelPrincipal.setLayout(null);
		frmPrincipal.getContentPane().add(panelPrincipal);

        lblNombreHospital = new JLabel("Hospital:");
        panelPrincipal.add(lblNombreHospital);
        lblNombreHospital.setForeground(Color.white);
        lblNombreHospital.setBounds(100, 200, 200, 50);
        lblNombreHospital.setFont(new Font("Helvetica", Font.PLAIN, 30));

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
				//cbNombreHospital.scrollRectToVisible(aRect);
				cbNombreHospital.setFont(new Font("Helvetica", Font.PLAIN, 25));
				panelPrincipal.add(cbNombreHospital);
				
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
		lblSolicitar.setForeground(Color.white);
		lblSolicitar.setBounds(100, 550, 200, 50);
		lblSolicitar.setFont(new Font("Helvetica", Font.PLAIN, 30));

		tfVacunas = new JTextField();
		panelPrincipal.add(tfVacunas);
		tfVacunas.setBounds(300, 550, 150, 50);
		tfVacunas.setFont(new Font("Helvetica", Font.PLAIN, 25));
		tfVacunas.setEditable(true);

		lblVacunas = new JLabel("");
		panelPrincipal.add(lblVacunas);
		lblVacunas.setForeground(Color.white);
		lblVacunas.setBounds(300, 300, 200, 50);
		lblVacunas.setFont(new Font("Helvetica", Font.PLAIN, 25));

		lblCantVacunas = new JLabel("vacunas");
		panelPrincipal.add(lblCantVacunas);
		lblCantVacunas.setForeground(Color.white);
		lblCantVacunas.setBounds(470, 550, 200, 50);
		lblCantVacunas.setFont(new Font("Helvetica", Font.PLAIN, 25));

		lblEstatus = new JLabel("");
		panelPrincipal.add(lblEstatus);
		lblEstatus.setForeground(Color.white);
		lblEstatus.setBounds(650, 300, 200, 50);
		lblEstatus.setFont(new Font("Helvetica", Font.PLAIN, 25));

		btnSolicitar = new JButton("Solicitar");
		btnSolicitar.setBounds(600, 530, 150, 70);
		btnSolicitar.setFont(new Font("Helvetica", Font.PLAIN, 20));
		btnSolicitar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("vacunas: " + tfVacunas.getText());
			}
		});
		btnSolicitar.setActionCommand("newProduct");
		panelPrincipal.add(btnSolicitar);

    }

	public static void crearHospitales(){
		listaHospitales = new ArrayList<Hospital>();
		Hospital h1 = new Hospital("Cruz roja", 500, 50, "Monterrey", 0, 20);
		listaHospitales.add(h1);
		Hospital h2 = new Hospital("Coet", 600, 100, "Saltillo", 30, 15);
		listaHospitales.add(h2);
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

