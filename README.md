# ReadKeyboard

ReadKeyboard is an application that records and stores keystroke events made by the user on the keyboard.

You can use the batch file to simplify the process of compiling and executing Java code through a script.

Important! 
- verify if the project have JNativeHook library
    - if not, add **jnativehook-2.1.0.jar** in the project
        **File -> Project Structure -> Modules -> Dependencies -> Add -> Jar or DIrectory -> jnativehook-2.1.0.jar**
- verify the location where the keystrokes are being saved
-     public class KeyLogger implements NativeKeyListener {
     //.....
         "public Path fileName = Path.of("**E:\\files.txt**");"
     //.....
     } 
