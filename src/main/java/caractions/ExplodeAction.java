package caractions;

public class ExplodeAction implements CarAction {
    @Override
    public String doAction(String carName) {
        String message = String.format("%s has been exploded.", carName);
        System.out.println(message);
        return message;
    }
}
