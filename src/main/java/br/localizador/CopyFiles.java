package br.localizador;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Date;


public class CopyFiles {

    public static void main(String[] args){
       
        String pathExemploOrigem = "C:/Imagem/Koala.jpg";
        String pathExemploDestinoCopiar = "C:/Imagem/Copy1/Koala.jpg";
        String pathExemploDestinoCopiar2 = "C:/Imagem/Copy2/Koala.jpg";
        String pathExemploDestinoRenomear = "C:/Imagem/Copy/Coala.jpg";
       
        File arquivoExemploOrigem = new File(pathExemploOrigem);
        File arquivoExemploDestinoCopiar = new File(pathExemploDestinoCopiar);
        File arquivoExemploDestinoCopiar2 = new File(pathExemploDestinoCopiar2);
        File arquivoExemploDestinoRenomear = new File(pathExemploDestinoRenomear);
       
        try {
           
            //Primeiro modo de copiar o arquivo de um local para outro
            copy(arquivoExemploOrigem, arquivoExemploDestinoCopiar);
           
            //Segundo modo de copiar o arquivo de um local para outro
            copy(arquivoExemploOrigem, arquivoExemploDestinoCopiar2, true);
           
            //Renomear ou mover um arquivo
            //Se não alterar a pasta, o sistema apenas renomeia
            //Se alterar a pasta, o sistema move o arquivo e renomeia
            arquivoExemploDestinoCopiar.renameTo(arquivoExemploDestinoRenomear);
           
            //Apagar um arquivo
            arquivoExemploDestinoCopiar2.delete();
           
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }
   
    /**
     * Copia arquivos de um local para o outro 
     * @param origem - Arquivo de origem 
     * @param destino - Arquivo de destino 
     * @param overwrite - Confirmação para sobrescrever os arquivos 
     * @throws IOException 
     */
    public static void copy(File origem, File destino) throws IOException {
        Date date = new Date();
        InputStream in = new FileInputStream(origem);
        OutputStream out = new FileOutputStream(destino);           
        // Transferindo bytes de entrada para saída
        byte[] buffer = new byte[1024];
        int lenght;
        while ((lenght= in.read(buffer)) > 0) {
            out.write(buffer, 0, lenght);
        }
        in.close();
        out.close();
        Long time = new Date().getTime() - date.getTime();
        System.out.println("Saiu copy"+time);
    }
   
    /** 
     * Copia arquivos de um local para o outro 
     * @param origem - Arquivo de origem 
     * @param destino - Arquivo de destino 
     * @param overwrite - Confirmação para sobrescrever os arquivos 
     * @throws IOException 
     */ 
    public static void copy(File origem, File destino, boolean overwrite) throws IOException{ 
        Date date = new Date();
       if (destino.exists() && !overwrite){ 
          System.err.println(destino.getName()+" já existe, ignorando..."); 
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
       System.out.println("Saiu copy"+time);
    }
    
    /**
	 * 
	 * @param file
	 * @throws IOException
	 */
	private static void verificarTipoDeArquivoETransferir(File file) throws IOException {
		if (file.getPath().endsWith(".txt")
				|| file.getPath().endsWith(".TXT")
				&& (!file.getParentFile().equals(TXT))) {
			File destino = new File(TXT + file.getName());
			copy(file, destino, true);
			file.delete();
		}
		if (file.getPath().endsWith(".doc")
				|| file.getPath().endsWith(".DOC")
				|| file.getPath().endsWith(".docx")
				|| file.getPath().endsWith(".DOCX")
				&& (!file.getParentFile().equals(DOC))) {
			File destino = new File(DOC + file.getName());
			copy(file, destino, true);
			file.delete();
		}
		if (file.getPath().endsWith(".xls")
				|| file.getPath().endsWith(".xlsx")
				|| file.getPath().endsWith(".XLS")
				|| file.getPath().endsWith(".XLSX")
				&& (!file.getParentFile().equals(XLS))) {
			File destino = new File(XLS + file.getName());
			copy(file, destino, true);
			file.delete();
		}
		if (file.getPath().endsWith(".pdf")
				|| file.getPath().endsWith(".PDF")
				&& (!file.getParentFile().equals(PDF))) {
			File destino = new File(PDF + file.getName());
			copy(file, destino, true);
			file.delete();
		}
		if (file.getPath().endsWith(".txt")
				|| file.getPath().endsWith(".TXT")
				&& (!file.getParentFile().equals(TXT))) {
			File destino = new File(TXT + file.getName());
			copy(file, destino, true);
			file.delete();
		}
		if (file.getPath().endsWith(".txt")
				|| file.getPath().endsWith(".TXT")
				&& (!file.getParentFile().equals(TXT))) {
			File destino = new File(TXT + file.getName());
			copy(file, destino, true);
			file.delete();
		}
	}
}