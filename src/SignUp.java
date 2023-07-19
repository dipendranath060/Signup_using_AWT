import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;


public class SignUp extends Frame implements ActionListener {
	private TextField txtName;
	private TextArea txtAddress;
	public SignUp()
	{
		this.setVisible(true);
		this.setSize(500,500);
		this.setLayout(new GridLayout(3,2));
		//GridLayout g = new GridLayout(3, 2); setLayout(g);
		Label l1=new Label("NAME :");
		Label l2=new Label("Address :");


		txtName =new TextField(23);
		txtAddress=new TextArea();


		Button B1=new Button("SAVE");
		Button B2=new Button("SHOW DATA");
		B1.addActionListener(this);
		/*B1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click");


			}
		});*/


		add(l1);
		add(txtName);
		add(l2);
		add(txtAddress);
		add(B1);
		add(B2);
		pack();
	}
	public static void main(String[] args) {
		SignUp s=new SignUp();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String name=txtName.getText();

		String address=txtAddress.getText();
		if(DBConnection.save(name, address)>0) {
			System.out.println("Sucessfull");


		}else{
			System.out.println("Unable to save");
		}

	}

}
