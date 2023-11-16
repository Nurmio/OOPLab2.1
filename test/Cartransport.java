import java.util.ArrayList;
public class Cartransport extends Truck {
    //private ArrayList<Vehicle> LoadList = new ArrayList<>();
    private final Loader loader;

    public Cartransport() {

        this.loader = new Loader();
    }

    private boolean RampIsUp = true;

    public void LowerRamp() {
        if (RampIsUp && getCurrentSpeed() == 0) {
            RampIsUp = false;
        }
    }

    public void RaiseRamp() {
        if (!RampIsUp) {
            RampIsUp = true;
        }
    }

    public boolean GetRampState() {
        return (RampIsUp);
    }

    public void LoadVehicle(Vehicle vehicle) {
        if (!(vehicle instanceof Cartransport)) {
            if (!RampIsUp && getDeltaPos(vehicle) <= 3) {
                loader.LoadVehicle(vehicle);
                vehicle.setPos(getPos()[0], getPos()[1]);
                vehicle.setDirection((getDirection()));
            }
        }

    }

    public void UnloadVehicle() {
        if (!RampIsUp) {
            loader.GetLoadList().getLast().setDirection(getOppsiteDirection());
            loader.GetLoadList().getLast().move();
            loader.GetLoadList().remove(loader.GetLoadList().getLast());
        }
    }

    private void updateLoadCarPos() {
        for (Vehicle v : loader.GetLoadList()) {
            v.move();
        }
    }

    @Override
    public void turnRight() {
        super.turnRight();
        for (Vehicle v : loader.GetLoadList()) {
            v.turnRight();
        }

    }

    @Override
    public void turnLeft() {
        super.turnLeft();
        for (Vehicle v : loader.GetLoadList()) {
            v.turnLeft();
        }

    }

    @Override
    public void move() {

        updateLoadCarPos();
        super.move();

    }
}
