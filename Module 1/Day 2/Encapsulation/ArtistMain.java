package Encapsulation;

public class ArtistMain {
    public static void main(String[] args) {
        Artist a = new Artist();
        a.setName("Rahul");
        a.setArtStyle("dancer");
        a.setMedium("Dancing");
        a.getDetails();
        a.create();
    }

}
