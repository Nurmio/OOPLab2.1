import java.util.ArrayList;

public class Workshop<T extends Vehicle> {
    private final Loader loader;
    private final double vehicleLimit;

    public Workshop(double vehicleLimit) {
        this.vehicleLimit = vehicleLimit;
        this.loader = new Loader();
    }
    public ArrayList<Vehicle> getLoadList(){return loader.GetLoadList();
    }



    public void AddVehicle(T vehicle) {
        loader.LoadVehicle(vehicle);
    }

    public void RemoveVehicle() {loader.UnloadVehicle();}



}
