package main.hw_5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Backup {
    public static void main(String[] args) {
        createBackup(new File("."), "./backup");
    }

    static void createBackup(File sourceDir, String backupDirPath) {
        File backupDir = new File(backupDirPath);
        // Проверка наличия папки backup
        if (!backupDir.exists()) {
            boolean success = backupDir.mkdirs();
            if (!success) {
                System.err.println("Не удалось создать папку для резервной копии.");
                return;
            }
        }
        File[] sourceFiles = sourceDir.listFiles();
        if (sourceFiles == null) {
            System.err.println("Ошибка получения списка файлов в исходной директории.");
            return;
        }
        for (File sourceFile : sourceFiles) {
            if (sourceFile.isFile()) {
                try {
                    File backupFile = new File(backupDir, sourceFile.getName());
                    Files.copy(sourceFile.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Создана резервная копия файла: " + backupFile.getAbsolutePath());
                } catch (IOException e) {
                    System.err.println("Ошибка при копировании файла " + sourceFile.getName() + ": " + e.getMessage());
                }
            }
        }
    }
}