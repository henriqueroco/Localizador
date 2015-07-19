package br.localizador;

import java.io.File;

public class CriarLista {

	public static void main(String[] args) {
		String dir = "E:\\"; 

		File diretorio = new File(dir); 
		File fList[] = diretorio.listFiles(); 

		System.out.println("Numero de arquivos no diretorio : " + fList.length ); 

		for (File file : fList) {
			if (file.isFile()){
				System.out.println(file.getAbsolutePath());
			} else {
				System.out.println(file.getPath());
			}
		}
	}
	
//	public static java.util.List<FileItem> listDirectoryAppend(File dir, java.util.List<FileItem> lista) {  
//	    if (dir.isDirectory()) {  
//	        String[] filhos = dir.list();  
//	        for (int i = 0; i < filhos.length; i++) {  
//	            File nome = new File(dir, filhos[i]);  
//	            if (nome.isFile()) {  
//	                if (nome.getName().toUpperCase().endsWith(".GBK")) {  
//	                    lista.add(new FileItem(nome));  
//	                }  
//	            } else if (nome.isDirectory()) {  
//	                listDirectoryAppend(nome, lista);  
//	            }  
//	        }  
//	    } else {  
//	        lista.add(new FileItem(dir));  
//	    }  
//	    return lista;  
//	}  
	
}
