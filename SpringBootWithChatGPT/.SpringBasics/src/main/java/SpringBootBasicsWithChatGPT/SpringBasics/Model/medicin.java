package SpringBootBasicsWithChatGPT.SpringBasics.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "medicin_details")
public class medicin {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String manufacturingLocation;
    String palntType;
    double price;

    public medicin() {
    }

    public medicin(Long id, String manufacturingLocation, String palntType, double price) {
        this.id = id;
        this.manufacturingLocation = manufacturingLocation;
        this.palntType = palntType;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturingLocation() {
        return manufacturingLocation;
    }

    public void setManufacturingLocation(String manufacturingLocation) {
        this.manufacturingLocation = manufacturingLocation;
    }

    public String getPalntType() {
        return palntType;
    }

    public void setPalntType(String palntType) {
        this.palntType = palntType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "medicin{" +
                "id=" + id +
                ", manufacturingLocation='" + manufacturingLocation + '\'' +
                ", palntType='" + palntType + '\'' +
                ", price=" + price +
                '}';
    }
}
