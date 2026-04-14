package com.ishaq.portfolio.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://mohamedishaq.netlify.app"
})
public class FileUploadController {

    // ✅ folder where images will be saved on your Mac
    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Create uploads folder if not exists
            File uploadFolder = new File(UPLOAD_DIR);
            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs();
            }

            // Save file with original name
            String cleanName = file.getOriginalFilename().replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
            String fileName = System.currentTimeMillis() + "_" + cleanName;
            Path filePath = Paths.get(UPLOAD_DIR + fileName);
            Files.write(filePath, file.getBytes());

            // Return the URL React will use to display the image
            // Using a relative path makes it work on both localhost and deployed servers
            String imageUrl = "/uploads/" + fileName;
            return ResponseEntity.ok(Map.of("url", imageUrl));

        } catch (IOException e) {
            return ResponseEntity.status(500)
                    .body(Map.of("error", "Upload failed: " + e.getMessage()));
        }
    }
}
