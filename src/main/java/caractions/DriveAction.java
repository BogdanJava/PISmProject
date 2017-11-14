package caractions;

public class DriveAction implements CarAction {
    @Override
    public String doAction(String carName) {
        String message = String.format("Start driving of %s.", carName);
        System.out.println(message);
        return message;
    }
}
