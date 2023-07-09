import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        File src = new File("src/");
        src.mkdirs();
        File main = new File("src/main");
        main.mkdir();
        File test = new File("src/test");
        test.mkdir();
        File res = new File("res/");
        res.mkdirs();
        File drawables = new File("res/drawables");
        drawables.mkdir();
        File vectors = new File("res/vectors");
        vectors.mkdir();
        File icons = new File("res/icons");
        icons.mkdir();
        File savegames = new File("savegames/");
        savegames.mkdir();
        File temp = new File("temp/");
        temp.mkdir();

        File mainJava = new File("C://Programming//JAVA нетология//Main//Games//src//main//Main.java");
        try {
            mainJava.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File utilsJava = new File("C://Programming//JAVA нетология//Main//Games//src//main//Utils.java");
        try {
            utilsJava.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File tempTxt = new File("C://Programming//JAVA нетология//Main//Games//temp//temp.txt");
        try {
            tempTxt.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(src);
        sb.append(main);
        sb.append(test);
        sb.append(res);
        sb.append(temp);
        sb.append(drawables);
        sb.append(vectors);
        sb.append(icons);
        sb.append(mainJava);
        sb.append(utilsJava);
        sb.append(tempTxt);
        String text = sb.toString();

        try {
            FileWriter writer = new FileWriter("temp/temp.txt", false);
            writer.write(text);
            writer.append("\nВсе файлы были созданы успешно!");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        //Задание 2
        GameProgress gameProgress = new GameProgress(95, 10, 5, 300.42);
        savegame("C://Programming//JAVA нетология//Main//Games//savegames//save3.dat", gameProgress);
        zipFiles("C://Programming//JAVA нетология//Main//Games//savegames//GameProgress.zip", "C://Programming//JAVA нетология//Main//Games//savegames//save3.dat");
        deleteFile("C://Programming//JAVA нетология//Main//Games//savegames//save3.dat");
    }

    public static void savegame(String url, GameProgress gameProgress) {
        try(FileOutputStream fos = new FileOutputStream(url);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void zipFiles(String url, String file) {
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(url));
                FileInputStream fis = new FileInputStream(file)) {
            ZipEntry entry = new ZipEntry("packed_game.txt");
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteFile(String url) {
        File save = new File(url);
        save.delete();
    }
}
