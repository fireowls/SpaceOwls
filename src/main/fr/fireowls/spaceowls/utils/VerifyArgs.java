package fr.fireowls.spaceowls.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class VerifyArgs {

    public static final String DEFAULT_SYS = "";

    public static String verifyArgument(String[] args) {
        String sys = "";
        if(args.length == 0){
            System.out.println("Pas d'argument. Chargement du system par default.");
            sys = VerifyArgs.DEFAULT_SYS;
        }else {
            if(!args[0].contains(".astro")){
                System.out.println("Arguement Pas un fichier .astro. Chargement du system par default.");
                sys = VerifyArgs.DEFAULT_SYS;
            }else {
                FileReader fr = null;
                BufferedReader br = null;
                try {
                    fr = new FileReader(args[0]);
                    br = new BufferedReader(fr);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Erreur de chargement. Chargement du systeme par default");
                    try{
                        fr.close();
                        br.close();
                    }catch(Exception e1){}
                    return VerifyArgs.DEFAULT_SYS;
                } finally {
                    try{
                        fr.close();
                        br.close();
                    }catch(Exception e1){}
                    System.out.println("Chargement du system passé en argument.");
                    sys = args[0];
                }

            }
        }
        return sys;
    }
  
}
