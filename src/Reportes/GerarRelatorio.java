/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;
import Connectiondb.ConnectionJDBC;
import java.sql.Connection;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/*
 * @author vicente
 */
public class GerarRelatorio {
    
    private Connection conn;
    private String src;
    
    /**
     *
     * @param src "src" -> Representa o caminho e o nome do ficheiro
     * onde esta guardado.
     * Todos os ficheiro teram a descição de: nomeDoFicheiro.jasper
     */
    public GerarRelatorio(String sourceFileName)
    {
        conn = ConnectionJDBC.getConnection();
        this.src = sourceFileName;
    
    }
    
    /**
     * @return Método gerarRelatorio(): Gera relatório ou 
     * ficheiro do arquivo colocado no construtor GerarRelatorio
     */
    public void gerarRelatorio()
    {
        
        JasperPrint printDocument = null;
        
        try {
  
            printDocument = JasperFillManager.fillReport( src, null, conn);
            
           
           
            JasperViewer viewDocoment = new JasperViewer( printDocument, false );
            
            viewDocoment.setVisible( true );
                    
           } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel abrir o ficheiro \n"+ex
                    , "ERROR" , JOptionPane.ERROR_MESSAGE);
            
            
        } finally{
            ConnectionJDBC.closeConnection( conn );
           
        }
    
    }
    
    
    
    
   
    
    
    
    
      
        
        
        
        
    
    
    
    
}
