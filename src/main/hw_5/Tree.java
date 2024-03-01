package main.hw_5;

import java.io.File;

public class Tree {
    public static void main(String[] args) {
        print(new File("."), "", true);
    }
    {
}

    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null)
                return;

            int subDirTotal = 0;
            int subFileTotal = 0;
            for (File f : files) {
                if (f.isDirectory()) {
                    subDirTotal++;
                } else {
                    subFileTotal++;
                }
            }

            int subCounter = 0;
            for (File f : files) {
                print(f, indent + (subDirTotal == ++subCounter ? "  " : "│ "), subDirTotal + subFileTotal == subCounter);
            }
        }
    }
}
