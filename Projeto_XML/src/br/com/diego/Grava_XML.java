package br.com.diego;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class Grava_XML {
	
	public static void gravar_xml_pessoa(Pessoa pessoa) {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoa.getNome();
		pessoa.getCpf();
		pessoa.getCidade();
		pessoa.getRua();
		pessoas.add(pessoa);
		
		XStream xstream = new XStream();
		xstream.alias("cadastro", List.class);
		
		File arquivo = new File("cadastro.xml");
		FileOutputStream gravar;
		try {
			gravar = new FileOutputStream(arquivo);
			gravar.write(xstream.toXML(pessoas).getBytes());
			gravar.close();
		} catch (IOException error) {
			error.printStackTrace();
		}
	}
	
}

