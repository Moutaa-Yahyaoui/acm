import java.io.*;

public class EdgeConvertFileHandler {
   private EdgeConvertFileParser ecfp;
   private PrintWriter pw;

   public void writeSave(File saveFile, EdgeTable[] tables, EdgeField[] fields) {
      if (saveFile != null) {
         try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(saveFile, false)));
            //write the identification line
            pw.println(EdgeConvertFileParser.SAVE_ID);
            //write the tables
            pw.println("#Tables#");
            for (int i = 0; i < tables.length; i++) {
               pw.println(tables[i]);
            }
            //write the fields
            pw.println("#Fields#");
            for (int i = 0; i < fields.length; i++) {
               pw.println(fields[i]);
            }
            //close the file
            pw.close();
         } catch (IOException ioe) {
            System.out.println(ioe);
         }
      }
   }

   public void writeSQL(File outputFile, String output) {
      try {
         pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFile, false)));
         //write the SQL statements
         pw.println(output);
         //close the file
         pw.close();
      } catch (IOException ioe) {
         System.out.println(ioe);
      }
   }
}
