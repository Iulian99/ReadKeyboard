import java.util.HashMap;
import java.util.Map;

public class KeyboardList {
    private int keyCode;
    public boolean isActivateCapsLk = false;
    public static boolean isActivateShift = false;
    Map<Integer, String> doubleBraceMap  = new HashMap<Integer, String>() {{
        put(27, "Esc");
        put(112, "F1");
        put(113, "F2");
        put(114, "F3");
        put(115, "F4");
        put(116, "F5");
        put(117, "F6");
        put(118, "F7");
        put(119, "F8");
        put(120, "F9");
        put(121, "F10");
        put(122, "F11");
        put(123, "F12");

        put(192, "`");
        put(182, "~");

        put(49, "1");
        put(50, "2");
        put(51, "3");
        put(52, "4");
        put(53, "5");
        put(54, "6");
        put(55, "7");
        put(56, "8");
        put(57, "9");
        put(48, "0");
        put(149, "!");
        put(150, "@");
        put(151, "#");
        put(152, "$");
        put(153, "%");
        put(154, "^");
        put(155, "&");
        put(156, "*");
        put(157, "(");
        put(148, ")");

        put(189, "-");
        put(179, "_");

        put(187, "=");
        put(177, "+");

        put(220, "\"");
        put(210, "|");

        put(8, " ");//Backspace
        put(9, "    ");//Tab

        put(65, "a");
        put(66, "b");
        put(67, "c");
        put(68, "d");
        put(69, "e");
        put(70, "f");
        put(71, "g");
        put(72, "h");
        put(73, "i");
        put(74, "j");
        put(75, "k");
        put(76, "l");
        put(77, "m");
        put(78, "n");
        put(79, "o");
        put(80, "p");
        put(81, "q");
        put(82, "r");
        put(83, "s");
        put(84, "t");
        put(85, "u");
        put(86, "v");
        put(87, "w");
        put(88, "x");
        put(89, "y");
        put(90, "z");
        put(265, "A");
        put(266, "B");
        put(267, "C");
        put(268, "D");
        put(269, "E");
        put(270, "F");
        put(271, "G");
        put(272, "H");
        put(273, "I");
        put(274, "J");
        put(275, "K");
        put(276, "L");
        put(277, "M");
        put(278, "N");
        put(279, "O");
        put(280, "P");
        put(281, "Q");
        put(282, "R");
        put(283, "S");
        put(284, "T");
        put(285, "U");
        put(286, "V");
        put(287, "W");
        put(288, "X");
        put(289, "Y");
        put(290, "Z");

        put(219, "[");
        put(209, "{");

        put(221, "]");
        put(211, "}");

        put(13, "\n");
        put(20, "");//CapsLock

        put(186, ";");
        put(176, ":");

        put(222, "'");
        put(212, "\"");

        put(160, "");//Shift

        put(188, ",");
        put(178, "<");

        put(190, ".");
        put(180, ">");

        put(191, "/");
        put(181, "?");

        put(161, "");//SHIFT
        put(162, "");//CTRL - left
        put(91, " Windows ");
        put(164, "");//ALT
        put(32, " ");//SPACE
        put(165, "");//ALT
        put(44, " PrtSc ");
        put(133, "");
        put(163, "");//CTRL - right

        put(38, "↑\n");
        put(40, "↓\n");
        put(39, "→\n");
        put(37, "←\n");

        put(46, " DEL ");
        put(144, " NUM ");
        put(111, "/");
        put(106, "*");
        put(109, "-");
        put(103, "7");
        put(104, "8");
        put(105, "9");
        put(107, "+");
        put(100, "4");
        put(101, "5");
        put(102, "6");
        put(97, "1");
        put(98, "2");
        put(99, "3");
        put(96, "0");
        put(110, ".");
    }};

    public KeyboardList(){
    }
    public void setKeyCode(int keyCode){
        this.keyCode = keyCode;
    }
    public String getKeyCode() {
        boolean isExists = doubleBraceMap.containsKey(keyCode);
        if (isExists) {
            activateKey();
            return doubleBraceMap.get(keyCode);
        }
        return "";
    }
    public void activateKey(){
//        check if the key from keyboard exists in the map
        if(isActivateShift) activateCodeShift();
        activateCapsLk();
    }
    public void activateCapsLk(){
        if(!isActivateCapsLk && keyCode == 20) isActivateCapsLk = true;
        else if(isActivateCapsLk && keyCode == 20)isActivateCapsLk = false;
        else if(isActivateCapsLk && (keyCode>=65 && keyCode<=90)){
            this.keyCode = 200 + this.keyCode;
        }
    }
    public void activateCodeShift(){
        if(keyCode>=65 && keyCode<=90){
            this.keyCode = 200 + this.keyCode;
        }else if(keyCode>=48 && keyCode<=57){
            this.keyCode = 100 + this.keyCode;
        }else if(keyCode==192 || keyCode==189 || keyCode==187 || keyCode==219 || keyCode==221 || keyCode==186 || keyCode==222 || keyCode==188 || keyCode==190 || keyCode==191 || keyCode==220){
            this.keyCode = this.keyCode - 10;
        }
    }
}
