package logicaJogo;

import logicaJogo.Dados.DadosJogo;

import java.io.*;

public class Utils {

    public static int lancaDado(int min, int max)
    {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public static void gravarJogo(DadosJogo dadosJogo)
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream("savegame.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(dadosJogo);
            out.close();
            fileOut.close();
            System.out.printf("Jogo gravado em savegame.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    public static DadosJogo carregarJogo()
    {
        DadosJogo dj = null;

        try
        {
            FileInputStream fileIn = new FileInputStream("savegame.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            dj = (DadosJogo) in.readObject();
            in.close();
            fileIn.close();

            return dj;
        }catch(IOException i)
        {
            i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }

        return dj;
    }

}
