package org.avpa.fakehacking.colorprinter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ColorChain {
    public enum ANSI {
        RESET("\u001B[0m"),
        BLACK("\u001b[30;1m"),
        RED("\u001b[31;1m"),
        GREEN("\u001b[32;1m"),
        YELLOW("\u001b[33;1m"),
        BLUE("\u001b[34;1m"),
        MAGENTA("\u001b[35;1m"),
        CYAN("\u001b[36;1m"),
        GRAY("\u001b[37;1m"),
        BACKGROUND_BLACK("\u001b[40m"),
        BACKGROUND_RED("\u001b[41m"),
        BACKGROUND_GREEN("\u001b[42m"),
        BACKGROUND_YELLOW("\u001b[43m"),
        BACKGROUND_BLUE("\u001b[44m"),
        BACKGROUND_MAGENTA("\u001b[45m"),
        BACKGROUND_CYAN("\u001b[46m"),
        BACKGROUND_GRAY("\u001b[47m"),
        NO_STYLE(null),
        BOLD("\u001b[1m"),
        UNDERLINE("\u001b[4m");

        String value;
        ANSI(String value) {
            this.value = value;
        }
    }
    List<Map.Entry<ANSI, String>> currentColorChain;

    public ColorChain() {
        this.currentColorChain = new ArrayList<>();
    }

    private ColorChain(List<Map.Entry<ANSI, String>> currentColorChain) {
        this.currentColorChain = currentColorChain;
    }

    public ColorChain insert(ColorChain colorChain) {
        currentColorChain.add(Map.entry(ANSI.NO_STYLE, colorChain.currentColorChain.stream()
                .map(e -> String.format("%s%s", e.getKey().equals(ANSI.NO_STYLE) ? "" : e.getKey().value, e.getValue()))
                .reduce("", String::concat)));
        return new ColorChain(currentColorChain);
    }

    public ColorChain none(Object val) {
        currentColorChain.add(Map.entry(ANSI.NO_STYLE, val.toString()));
        return new ColorChain(currentColorChain);
    }

    public ColorChain black(Object val) {
        currentColorChain.add(Map.entry(ANSI.BLACK, val.toString()));
        return new ColorChain(currentColorChain);
    }

    public ColorChain red(Object val) {
        currentColorChain.add(Map.entry(ANSI.RED, val.toString()));
        return new ColorChain(currentColorChain);
    }

    public ColorChain green(Object val) {
        currentColorChain.add(Map.entry(ANSI.GREEN, val.toString()));
        return new ColorChain(currentColorChain);
    }

    public ColorChain yellow(Object val) {
        currentColorChain.add(Map.entry(ANSI.YELLOW, val.toString()));
        return new ColorChain(currentColorChain);
    }

    public ColorChain blue(Object val) {
        currentColorChain.add(Map.entry(ANSI.BLUE, val.toString()));
        return new ColorChain(currentColorChain);
    }

    public ColorChain magenta(Object val) {
        currentColorChain.add(Map.entry(ANSI.MAGENTA, val.toString()));
        return new ColorChain(currentColorChain);
    }

    public ColorChain cyan(Object val) {
        currentColorChain.add(Map.entry(ANSI.CYAN, val.toString()));
        return new ColorChain(currentColorChain);
    }

    public ColorChain gray(Object val) {
        currentColorChain.add(Map.entry(ANSI.GRAY, val.toString()));
        return new ColorChain(currentColorChain);
    }

    public ColorChain bold(ColorChain c) {
        currentColorChain.add(Map.entry(ANSI.BOLD, c.currentColorChain.stream()
                .map(e -> String.format("%s%s", e.getKey().equals(ANSI.NO_STYLE) ? "" : e.getKey().value, e.getValue()))
                .reduce("", String::concat)));
        return new ColorChain(currentColorChain);
    }

    public ColorChain underline(ColorChain c) {
        currentColorChain.add(Map.entry(ANSI.UNDERLINE, c.currentColorChain.stream()
                .map(e -> String.format("%s%s", e.getKey().equals(ANSI.NO_STYLE) ? "" : e.getKey().value, e.getValue()))
                .reduce("", String::concat)));
        return new ColorChain(currentColorChain);
    }

    public ColorChain s() {
        int index = currentColorChain.size() - 1;
        currentColorChain.add(Map.entry(index > 0 ? currentColorChain.get(index).getKey() : ANSI.NO_STYLE, " "));
        return new ColorChain(currentColorChain);
    }

    public ColorChain s(int spaces) {
        int index = currentColorChain.size() - 1;
        currentColorChain.add(Map.entry(index > 0 ? currentColorChain.get(index).getKey() : ANSI.NO_STYLE,
                " ".repeat(Math.max(0, spaces))));
        return new ColorChain(currentColorChain);
    }

    public ColorChain ln() {
        int index = currentColorChain.size() - 1;
        currentColorChain.add(Map.entry(index > 0 ? currentColorChain.get(index).getKey() : ANSI.NO_STYLE, "\r\n"));
        return new ColorChain(currentColorChain);
    }

    public void print() {
        for (Map.Entry<ANSI, String> key : currentColorChain) {
            try {
                System.out.write(String.format("%s%s%s", key.getKey().equals(ANSI.NO_STYLE) ? "" : key.getKey().value, key.getValue(), ANSI.RESET.value).getBytes(StandardCharsets.UTF_8));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void println() {
        print();
        System.out.write(0x0A);
    }

}
