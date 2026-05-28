package proyecto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Beatmap {
    private General general;
    private Editor editor;
    private Metadata metadata;
    private ArrayList<Difficulty> difficulty;
    private transient ImageIcon icon; //aparte del gson
    public Beatmap(){
        general = new General();
        metadata = new Metadata();
        editor = new Editor();

        difficulty = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Difficulty d = new Difficulty();
            d.setHitObjects(new int[0][0]);
            difficulty.add(d);
        }
    }

    public General getGeneral() { return general; }
    public void setGeneral(General value) { this.general = value; }

    public Editor getEditor() { return editor; }
    public void setEditor(Editor value) { this.editor = value; }

    public Metadata getMetadata() { return metadata; }
    public void setMetadata(Metadata value) { this.metadata = value; }

    public ArrayList<Difficulty> getDifficulty() { return difficulty; }
    public void setDifficulty(ArrayList<Difficulty> value) { this.difficulty = value; }
    
    public ImageIcon getIcon(){ return icon; }
    public void setIcon(ImageIcon icon){ this.icon = icon; }
}

// General
class General {
    private String folderName;
    private String audioFileName;
    private String audioFilePath;
    private String iconFileName;
    private String iconFilePath;
    private int audioLeadIn;
    private String type;

    public String getFolderName() { return folderName; }
    public void setFolderName(String value) { this.folderName = value; }
    
    public String getAudioFileName() { return audioFileName; }
    public void setAudioFileName(String value) { this.audioFileName = value; }
    
    public String getAudioFilePath() { return audioFilePath; }
    public void setAudioFilePath(String value) { this.audioFilePath = value; }
    
    public String getIconFileName() { return iconFileName; }
    public void setIconFileName(String value) { this.iconFileName = value; }
    
    public String getIconFilePath() { return iconFilePath; }
    public void setIconFilePath(String value) { this.iconFilePath = value; }

    public int getAudioLeadIn() { return audioLeadIn; }
    public void setAudioLeadIn(int value) { this.audioLeadIn = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }
}
// Editor
class Editor {
    private long[] bookmarks;
    private long distanceSpacing;
    private long beatDivisor;
    private long timelineZoom;

    public long[] getBookmarks() { return bookmarks; }
    public void setBookmarks(long[] value) { this.bookmarks = value; }

    public long getDistanceSpacing() { return distanceSpacing; }
    public void setDistanceSpacing(long value) { this.distanceSpacing = value; }

    public long getBeatDivisor() { return beatDivisor; }
    public void setBeatDivisor(long value) { this.beatDivisor = value; }

    public long getTimelineZoom() { return timelineZoom; }
    public void setTimelineZoom(long value) { this.timelineZoom = value; }
}
// Metadata
class Metadata {
    private String title;
    private String artist;
    private String creator;
    private int duration;
    private int previewStart;
    private String status;
    private double BPM;

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public String getArtist() { return artist; }
    public void setArtist(String value) { this.artist = value; }

    public String getCreator() { return creator; }
    public void setCreator(String value) { this.creator = value; }

    public int getDuration() { return duration; }
    public void setDuration(int value) { this.duration = value; }

    public int getPreviewStart() { return previewStart; }
    public void setPreviewStart(int value) { this.previewStart = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }

    public double getBPM() { return BPM; }
    public void setBPM(double value) { this.BPM = value; }
}
// Difficulty
class Difficulty {
    private String difficulty;
    private int difficultyValue;
    private int hp;
    private int[][] hitObjects;

    public Difficulty() {
        this.difficulty = "";
        this.difficultyValue = 0;
        this.hp = 200;
    }
    
    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String value) { this.difficulty = value; }
    
    public int getDifficultyValue() { return difficultyValue; }
    public void setDifficultyValue(int value) { this.difficultyValue = value; }
    
    public int getHP() { return hp; }
    public void setHP(int value) { this.hp = value; }

    public int[][] getHitObjects() { return hitObjects; }
    public void setHitObjects(int[][] value) { this.hitObjects = value; }
}

class BeatmapLoader{
    public static Beatmap cargar(File folder){
        try{
            File jsonFile = new File(folder, "mapInfo.json");
            Reader reader = new FileReader(jsonFile);
            Gson gson = new Gson();
            Beatmap beatmap = gson.fromJson(reader, Beatmap.class);
            // cargar imagen
            String nombreIcon = beatmap.getGeneral().getIconFileName();
            File iconFile = new File(folder, nombreIcon);
            ImageIcon icon = new ImageIcon(iconFile.getAbsolutePath());
            beatmap.setIcon(icon);
            return beatmap;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static void guardar(Beatmap beatmap, String folder){
        try{
            File baseDir = new File("src/proyecto/canciones");
            File carpetaGuardar = new File(baseDir, folder);

            if (!carpetaGuardar.exists()) {
                carpetaGuardar.mkdirs();
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            File jsonFile = new File(carpetaGuardar, "mapInfo.json");
            FileWriter writer = new FileWriter(jsonFile);
            gson.toJson(beatmap, writer);
            //
            File audioSrc;
            if(beatmap.getGeneral().getAudioFilePath() == null || beatmap.getGeneral().getAudioFilePath().isEmpty())
                audioSrc = new File(carpetaGuardar,beatmap.getGeneral().getAudioFileName());
            else
                audioSrc = new File(beatmap.getGeneral().getAudioFilePath());
            File audioDst = new File(carpetaGuardar,beatmap.getGeneral().getAudioFileName());
            Files.copy(audioSrc.toPath(),audioDst.toPath(),StandardCopyOption.REPLACE_EXISTING);
            beatmap.getGeneral().setAudioFilePath(audioDst.getAbsolutePath());

            File iconSrc;
            if(beatmap.getGeneral().getIconFilePath() == null || beatmap.getGeneral().getIconFilePath().isEmpty())
                iconSrc = new File(carpetaGuardar,beatmap.getGeneral().getIconFileName());
            else
                iconSrc = new File(beatmap.getGeneral().getIconFilePath());
            File iconDst = new File(carpetaGuardar,beatmap.getGeneral().getIconFileName());
            Files.copy(iconSrc.toPath(),iconDst.toPath(),StandardCopyOption.REPLACE_EXISTING);
            beatmap.getGeneral().setIconFilePath(iconDst.getAbsolutePath());
            //
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}