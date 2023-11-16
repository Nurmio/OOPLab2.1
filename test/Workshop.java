public class Workshop<T extends Vehicle> {
    private final Loader loader;
    private final double vehicleLimit;

    public Workshop(double vehicleLimit) {
        this.vehicleLimit = vehicleLimit;
        this.loader = new Loader();
    }



    public void AddVehicle(T vehicle) {
        loader.LoadVehicle(vehicle);
    }


}
