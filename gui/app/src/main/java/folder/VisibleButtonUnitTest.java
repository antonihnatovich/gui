package folder;

public class VisibleButtonUnitTest implements ITest {

    @Override
    public long getCurrentMinutes() {
        return System.currentTimeMillis() / 60000;
    }

    @Override
    public boolean isCountOfMinutesEvenNumber() {
        long minutes = getCurrentMinutes();
        return minutes % 2 == 0;
    }

    @Override
    public String nameOfReadyState() {
        boolean isEven = isCountOfMinutesEvenNumber();
        return isEven ? "visible" : "invisible";
    }

}
