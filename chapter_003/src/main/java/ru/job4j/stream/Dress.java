package ru.job4j.stream;

public class Dress {
    private String color;
    private byte size;
    private String pattern;
    private String length;
    private boolean hasLace;
    private String style;
    private boolean isForWork;

    static class Builder {
        private String color;
        private byte size;
        private String pattern;
        private String length;
        private boolean hasLace;
        private String style;
        private boolean isForWork;

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }
        Builder buildSize(byte size) {
            this.size = size;
            return this;
        }
        Builder buildPattern(String pattern) {
            this.pattern = pattern;
            return this;
        }
        Builder buildLength(String length) {
            this.length = length;
            return this;
        }
        Builder buildHasLace(boolean hasLace) {
            this.hasLace = hasLace;
            return this;
        }
        Builder buildStyle(String style) {
            this.style = style;
            return this;
        }
        Builder buildIsForWork(boolean isForWork) {
            this.isForWork = isForWork;
            return this;
        }

        Dress build() {
            Dress dress = new Dress();
            dress.color = color;
            dress.size = size;
            dress.pattern = pattern;
            dress.length = length;
            dress.hasLace = hasLace;
            dress.style = style;
            dress.isForWork = isForWork;
            return dress;
        }
    }

    @Override
    public String toString() {
        return "color = " + color + ", "
                + "size = " + size + ", "
                + "pattern = " + pattern + ", "
                + "length = " + length + ", "
                + "hasLace = " + hasLace + ", "
                + "style = " + style + ", "
                + "isForWork = " + isForWork + ", ";
    }

    public static void main(String[] args) {
        Dress dress = new Dress.Builder().buildColor("green")
                .buildSize((byte) 38)
                .buildPattern("Polka dots")
                .buildLength("mini")
                .buildHasLace(false)
                .buildStyle("party")
                .buildIsForWork(false)
                .build();
        System.out.println(dress);
    }
}
