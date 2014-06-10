package br.com.diego;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Nome;
	private JTextField textField_Cpf;
	private JTextField textField_Cidade;
	private JTextField textField_Rua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		setTitle("Java GUI");
		setResizable(false);
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botao_salvar = new JButton("Salvar");
		botao_salvar.setFont(new Font("Calibri", Font.PLAIN, 12));
		botao_salvar.setBounds(345, 238, 89, 23);
		contentPane.add(botao_salvar);
		
		JLabel label_titulo = new JLabel("Cadastre seu Usuário para Gerar XML");
		label_titulo.setFont(new Font("Calibri", Font.PLAIN, 15));
		label_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		label_titulo.setBounds(10, 11, 424, 14);
		contentPane.add(label_titulo);
		
		JLabel label_nome = new JLabel("Nome Completo");
		label_nome.setFont(new Font("Calibri", Font.PLAIN, 12));
		label_nome.setHorizontalAlignment(SwingConstants.CENTER);
		label_nome.setBounds(40, 50, 100, 14);
		contentPane.add(label_nome);
		
		textField_Nome = new JTextField();
		textField_Nome.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Nome.setBounds(145, 47, 200, 20);
		contentPane.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setBounds(40, 85, 100, 14);
		contentPane.add(lblCpf);
		
		textField_Cpf = new JTextField();
		textField_Cpf.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Cpf.setBounds(145, 82, 200, 20);
		contentPane.add(textField_Cpf);
		textField_Cpf.setColumns(10);
		
		JLabel label_cidade = new JLabel("Cidade");
		label_cidade.setFont(new Font("Calibri", Font.PLAIN, 12));
		label_cidade.setHorizontalAlignment(SwingConstants.CENTER);
		label_cidade.setBounds(40, 120, 100, 14);
		contentPane.add(label_cidade);
		
		textField_Cidade = new JTextField();
		textField_Cidade.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Cidade.setBounds(145, 117, 200, 20);
		contentPane.add(textField_Cidade);
		
		JLabel label_rua = new JLabel("Rua");
		label_rua.setFont(new Font("Calibri", Font.PLAIN, 12));
		label_rua.setHorizontalAlignment(SwingConstants.CENTER);
		label_rua.setBounds(40, 155, 100, 14);
		contentPane.add(label_rua);
		
		textField_Rua = new JTextField();
		textField_Rua.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Rua.setBounds(145, 152, 200, 20);
		contentPane.add(textField_Rua);
		
		botao_salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(textField_Nome.getText());
				pessoa.setCpf(textField_Cpf.getText());
				pessoa.setCidade(textField_Cidade.getText());
				pessoa.setRua(textField_Rua.getText());
				
				Grava_XML gravar = new Grava_XML();
				gravar.gravar_xml_pessoa(pessoa);

				JOptionPane.showMessageDialog(null, pessoa.getNome() + "\n" + pessoa.getCpf() + "\n" + pessoa.getCidade() + "\n" + pessoa.getRua());
				//JOptionPane.showMessageDialog(null, "XML gerado com sucesso!");
								
			}
		});
	}
}
