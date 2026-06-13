package entity;

public class Student {
    private String name;
    private int phyMarks;
    private int chemMarks;
    private int mathMarks;
    private int histMarks;
    private int geoMarks;

    public Student(String name, int phyMarks, int chemMarks, int mathMarks, int histMarks, int geoMarks) {
        this.name = name;
        this.phyMarks = phyMarks;
        this.chemMarks = chemMarks;
        this.mathMarks = mathMarks;
        this.histMarks = histMarks;
        this.geoMarks = geoMarks;
    }

    public String toString(){
        return name + " " + phyMarks+" " + chemMarks+ " " + mathMarks+ " " + histMarks + " " + geoMarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhyMarks() {
        return phyMarks;
    }

    public void setPhyMarks(int phyMarks) {
        this.phyMarks = phyMarks;
    }

    public int getChemMarks() {
        return chemMarks;
    }

    public void setChemMarks(int chemMarks) {
        this.chemMarks = chemMarks;
    }

    public int getMathMarks() {
        return mathMarks;
    }

    public void setMathMarks(int mathMarks) {
        this.mathMarks = mathMarks;
    }

    public int getHistMarks() {
        return histMarks;
    }

    public void setHistMarks(int histMarks) {
        this.histMarks = histMarks;
    }

    public int getGeoMarks() {
        return geoMarks;
    }

    public void setGeoMarks(int geoMarks) {
        this.geoMarks = geoMarks;
    }
}
