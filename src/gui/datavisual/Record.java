package gui.datavisual;

/**
 * Represents table record for visualization
 */
public class Record {
    String name;
    int year;
    double rating;
    int duration;


    public Record(String name, int year, double rating, int duration) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
    }

    String[] formattedRow(){
        return new String[]{
                name,
                String.valueOf(year),
                String.valueOf(rating),
                String.valueOf(duration)};
    }
}
