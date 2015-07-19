package br.localizador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

public class Transferidor {

	// Documentos Word e textos
	private static String DOC = "D:\\Users\\WEIBER\\Documents\\DOC";
	// Documentos planilhas eletronicas
	private static String XLS = "D:\\Users\\WEIBER\\Documents\\XLS";
	// Documentos PDF
	private static String PDF = "D:\\Users\\WEIBER\\Documents\\PDF";
	// Documentos autocad
	private static String DWG = "D:\\Users\\WEIBER\\Documents\\DWG";
	// Documentos apresentaï¿½ï¿½o power point
	private static String PPT = "D:\\Users\\WEIBER\\Documents\\PPT";
	// Documentos txt simples (sql, dentre outros
	private static String TXT = "D:\\Users\\WEIBER\\Documents\\TXT";
	// Documentos modelos Sketchup
	private static String SKP = "D:\\Users\\WEIBER\\Documents\\SKP";
	// Caminho
	private static File origem = new File("I:\\");

	public static void main(String[] args) throws IOException {

		validar(origem);
	}

	private static void validar(File file) throws IOException {
		File files = new File(file.getPath());
		if (!file.getPath().equals("I:\\$RECYCLE.BIN")) {
			for (File file2 : files.listFiles()) {
				if (file.isFile()) {
					verificarTipoDeArquivoETransferir(file);
				} else {
					validar(file2);
				}
			}
		}
	}

	/**
	 * 
	 * @param file
	 * @throws IOException
	 */
	private static void verificarTipoDeArquivoETransferir(File file)
			throws IOException {
		if (file.getPath().endsWith(".txt") || file.getPath().endsWith(".TXT")
				&& (!file.getParentFile().equals(TXT))) {
			File destino = new File(TXT + file.getName());
			copy(file, destino, true);
			file.delete();
		}
		if (file.getPath().endsWith(".doc") || file.getPath().endsWith(".DOC")
				|| file.getPath().endsWith(".docx")
				|| file.getPath().endsWith(".DOCX")
				&& (!file.getParentFile().equals(DOC))) {
			File destino = new File(DOC + file.getName());
			copy(file, destino, true);
			file.delete();
		}
		if (file.getPath().endsWith(".xls") || file.getPath().endsWith(".xlsx")
				|| file.getPath().endsWith(".XLS")
				|| file.getPath().endsWith(".XLSX")
				&& (!file.getParentFile().equals(XLS))) {
			File destino = new File(XLS + file.getName());
			copy(file, destino, true);
			file.delete();
		}
		if (file.getPath().endsWith(".pdf") || file.getPath().endsWith(".PDF")
				&& (!file.getParentFile().equals(PDF))) {
			File destino = new File(PDF + file.getName());
			copy(file, destino, true);
			file.delete();
		}
		if (file.getPath().endsWith(".dwg") || file.getPath().endsWith(".DWG")
				&& (!file.getParentFile().equals(DWG))) {
			File destino = new File(DWG + file.getName());
			copy(file, destino, true);
			file.delete();
		}
		if (file.getPath().endsWith(".sql") || file.getPath().endsWith(".SQL")
				&& (!file.getParentFile().equals(TXT))) {
			File destino = new File(TXT + file.getName());
			copy(file, destino, true);
			file.delete();
		}
	}

	/**
	 * Copia arquivos de um local para o outro
	 * 
	 * @param origem
	 *            - Arquivo de origem
	 * @param destino
	 *            - Arquivo de destino
	 * @param overwrite
	 *            - Confirmaï¿½ï¿½o para sobrescrever os arquivos
	 * @throws IOException
	 */
	public static void copy(File origem, File destino, boolean overwrite)
			throws IOException {
		Date date = new Date();
		if (destino.exists() && !overwrite) {
			System.err
					.println(destino.getName() + " já existe, ignorando...");
			return;
		}
		FileInputStream fisOrigem = new FileInputStream(origem);
		FileOutputStream fisDestino = new FileOutputStream(destino);
		FileChannel fcOrigem = fisOrigem.getChannel();
		FileChannel fcDestino = fisDestino.getChannel();
		fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);
		fisOrigem.close();
		fisDestino.close();
		Long time = new Date().getTime() - date.getTime();
		System.out.println(time + " - Arquivo " + origem.getName()
				+ " copiado para destino.");
	}
	
	private HashMap<String, File> obterListaArquivos(File file){
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
}
