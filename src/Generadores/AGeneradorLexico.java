package Generadores;

import java.io.File;

/**
 *
 * @author Joaquin
 */
public class AGeneradorLexico 
{
    
    public static void main(String[] args) 
    {
        String path="src/Analizadores/Lexico.jflex";
        generarLexer(path);
    }    
    public static void generarLexer(String path)
    {
        File file=new File(path);
        jflex.Main.generate(file);
    } 
    
}